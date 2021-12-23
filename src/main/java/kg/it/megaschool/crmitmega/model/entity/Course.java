package kg.it.megaschool.crmitmega.model.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_course")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course extends BaseEntity {

    @Column(name = "course_name", nullable = false)
    String courseName;

    @Column(name = "monthly_cost", nullable = false)
    BigDecimal monthlyCost;

    @ManyToOne
    @JoinColumn(name = "course_type_id", referencedColumnName = "id", nullable = false)
    CourseType courseType;

}
