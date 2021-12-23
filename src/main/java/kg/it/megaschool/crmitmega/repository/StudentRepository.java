package kg.it.megaschool.crmitmega.repository;

import kg.it.megaschool.crmitmega.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Database
public interface StudentRepository extends JpaRepository<Student, Long> {
}
