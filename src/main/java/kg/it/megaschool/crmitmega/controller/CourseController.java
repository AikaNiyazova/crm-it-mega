package kg.it.megaschool.crmitmega.controller;

import kg.it.megaschool.crmitmega.exceptions.CourseNotFoundException;
import kg.it.megaschool.crmitmega.exceptions.CourseTypeNotFoundException;
import kg.it.megaschool.crmitmega.model.dto.CourseDto;
import kg.it.megaschool.crmitmega.model.request.CreateCourseRequest;
import kg.it.megaschool.crmitmega.model.request.GetCourseByCostRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import kg.it.megaschool.crmitmega.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create") // save
    public ResponseEntity<?> createCourse(@RequestBody CreateCourseRequest request) {
        try {
            log.info("Creating course...");
            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(request));
        } catch (CourseTypeNotFoundException ex) {
            log.error("Course creation failed. Course type is not found for id=" + request.getCourseTypeId());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(ex.getMessage()));
        } /*catch (IllegalArgumentException ex) {

        }*/
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> readCourse(@PathVariable Long id) {
        try {
            log.info("Reading course with id=" + id);
            return ResponseEntity.ok(courseService.find(id));
        } catch (RuntimeException ex) {
            log.error("Reading failed. " + ex.getMessage());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
//        CourseDto courseDto = courseService.read(id);
//        return courseDto;
    }

    @GetMapping("/read-all")
    public ResponseEntity<?> readAllCourses() {
        try {
            return ResponseEntity.ok(courseService.readAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/read-all-course-names")
    public ResponseEntity<?> readAllCourseNames() {
        return ResponseEntity.ok(courseService.readAllCourseNames());
    }

    @GetMapping("/read-all-by-cost")
    public ResponseEntity<?> readAllByCost(@RequestBody GetCourseByCostRequest request) {
        return ResponseEntity.ok(courseService.readCoursesByMonthlyCostBetween(request));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestBody CourseDto courseDto) {
        try {
            log.info("Updating all course fields...");
            return ResponseEntity.ok(courseService.update(courseDto));
        } catch (CourseNotFoundException ex) {
            log.error(ex.getMessage() + " Check stack trace below.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(ex.getMessage()));
        }
    }
}