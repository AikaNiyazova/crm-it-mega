package kg.it.megaschool.crmitmega.controller;

import kg.it.megaschool.crmitmega.model.dto.CourseTypeDto;
import kg.it.megaschool.crmitmega.model.request.CreateCourseTypeRequest;
import kg.it.megaschool.crmitmega.model.request.GetCourseTypeByDurationRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import kg.it.megaschool.crmitmega.service.CourseTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course-type")
public class CourseTypeController {

//    @Autowired
    private final CourseTypeService courseTypeService; // = new CourseTypeServiceImpl();

    @PostMapping("/create")
    public ResponseEntity<?> createCourseType(@RequestBody CreateCourseTypeRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(courseTypeService.create(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> readCourseType(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseTypeService.find(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/read-all")
    public ResponseEntity<?> readAllCourseTypes() {
        try {
            return ResponseEntity.ok(courseTypeService.readAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourseType(@PathVariable Long id) {
        try {
            log.info("Deleting course type with id=" + id);
            return ResponseEntity.ok(courseTypeService.delete(id));
        } catch (RuntimeException ex) {
            log.error("Deleting failed. " + ex.getMessage() + ". For more details check stack trace.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(ex.getMessage()));
        }
    }

    @GetMapping("/read-all-by-duration-in-months")
    public ResponseEntity<?> readAllByDurationInMonths(@RequestBody GetCourseTypeByDurationRequest request) {
        return ResponseEntity.ok(courseTypeService.readCourseTypeByDurationInMonths(request));
    }


    @GetMapping("/add-new") // localhost:8080/course-type/add-new
    public String addCourseType() {
        return "add-course-type-form";
    }

    @PostMapping("/check-data")
    public String checkData(HttpServletRequest request, Model model) { // Model - map
        CreateCourseTypeRequest courseTypeRequest = new CreateCourseTypeRequest();
        courseTypeRequest.setTypeName(request.getParameter("typeName")); // аттрибуты
        courseTypeRequest.setClassesPerMonth(Integer.parseInt(request.getParameter("classesPerMonth")));
        courseTypeRequest.setDurationInMonths(Double.parseDouble(request.getParameter("durationInMonth")));
        courseTypeRequest.setDurationOfOneLesson(LocalTime.parse(request.getParameter("durationOfOneLesson")));

        CourseTypeDto courseTypeDto = courseTypeService.create(courseTypeRequest); // то, что сохранили, обратно вытаскиваем в виде dto и обратно передаем на проверку созданный объект

        model.addAttribute("id", courseTypeDto.getId());
        model.addAttribute("typeName", courseTypeDto.getTypeName());
        model.addAttribute("classesPerMonth", courseTypeDto.getClassesPerMonth());
        model.addAttribute("durationInMonth", courseTypeDto.getDurationInMonths());
        model.addAttribute("durationOfOneLesson", courseTypeDto.getDurationOfOneLesson());
        model.addAttribute("dateCreated", courseTypeDto.getDateCreated());
        return "check-course-type-data-form";
    }
}
