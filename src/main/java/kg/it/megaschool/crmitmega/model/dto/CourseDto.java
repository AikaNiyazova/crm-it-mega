package kg.it.megaschool.crmitmega.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDto {

    Long id;
    LocalDateTime dateCreated;
    String courseName;
    BigDecimal monthlyCost;
    Integer classesPerMonth;
    Integer durationInMonth;
    Integer durationOfOneLesson;
    CourseTypeDto courseType;

}
