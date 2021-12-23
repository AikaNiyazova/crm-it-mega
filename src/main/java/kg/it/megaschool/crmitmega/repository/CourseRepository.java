package kg.it.megaschool.crmitmega.repository;

import kg.it.megaschool.crmitmega.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByIdAndIsDeletedFalse(Long id);

    @Query(value = "SELECT c.course_name FROM tb_course as c WHERE c.is_deleted=false", nativeQuery = true)
    List<String> findAllCourseNames();

    List<Course> findByMonthlyCostBetween(BigDecimal from, BigDecimal to);

}
