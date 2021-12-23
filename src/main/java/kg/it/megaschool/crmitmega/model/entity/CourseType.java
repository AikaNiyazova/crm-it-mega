package kg.it.megaschool.crmitmega.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_course_type")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseType extends BaseEntity {

    @Column(name = "type_name", nullable = false, unique = true)
    String typeName;

    @Column(name = "classes_per_month", nullable = false)
    Integer classesPerMonth;

    @Column(name = "duration_in_month", nullable = false)
    Double durationInMonths;

    @Column(name = "duration_of_one_lesson", nullable = false)
    LocalTime durationOfOneLesson;
}
