package kg.it.megaschool.crmitmega.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseTypeDto {
    Long id;
    LocalDateTime dateCreated;
    String typeName;
    Integer classesPerMonth;
    Double durationInMonths;
    LocalTime durationOfOneLesson;
}
