package kg.it.megaschool.crmitmega.controller;

import kg.it.megaschool.crmitmega.model.request.CreateStudentRequest;
import kg.it.megaschool.crmitmega.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody @Valid CreateStudentRequest request) {
        try {
            log.info("Creating student...");
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(request));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
