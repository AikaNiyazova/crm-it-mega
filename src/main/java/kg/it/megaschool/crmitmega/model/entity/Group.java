package kg.it.megaschool.crmitmega.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_group")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group extends BaseEntity {

    @Column(name = "group_name", nullable = false, unique = true)
    String groupName;

    @ManyToOne // many groups to one course
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)
    Course course;

    @ManyToOne // many groups to one mentor
    @JoinColumn(name = "mentor_id", referencedColumnName = "id", nullable = false)
    Mentor mentor;

    @ManyToMany // many groups to many students
    @JoinTable(name = "group_has_student",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    List<Student> students;

    @Column(name = "class_time", nullable = false)
    LocalTime classTime;

}
