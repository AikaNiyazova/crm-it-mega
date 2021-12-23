package kg.it.megaschool.crmitmega.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCourseTypeRequest {
    String typeName;
    Integer classesPerMonth;
    Double durationInMonths;
    LocalTime durationOfOneLesson;
}
