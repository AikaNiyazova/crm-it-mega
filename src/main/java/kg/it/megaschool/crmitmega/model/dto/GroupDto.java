package kg.it.megaschool.crmitmega.model.dto;

import kg.it.megaschool.crmitmega.model.entity.Course;
import kg.it.megaschool.crmitmega.model.entity.Mentor;
import kg.it.megaschool.crmitmega.model.entity.Student;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupDto {

    Long id;
    LocalDateTime dateCreated;
    String groupName;
    CourseDto course;
    MentorDto mentor;
    Student[] students;
    LocalTime classTime;

}
