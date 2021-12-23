package kg.it.megaschool.crmitmega.controller;

import kg.it.megaschool.crmitmega.exceptions.MentorNotFoundException;
import kg.it.megaschool.crmitmega.model.request.CreateMentorRequest;
import kg.it.megaschool.crmitmega.service.MentorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentor")
public class MentorController {

    private final MentorService mentorService;

    @PostMapping("/create")
    public ResponseEntity<?> createMentor(@RequestBody CreateMentorRequest request) {
        try {
            log.info("Creating mentor...");
            return ResponseEntity.status(HttpStatus.CREATED).body(mentorService.create(request));
        } catch (MentorNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
