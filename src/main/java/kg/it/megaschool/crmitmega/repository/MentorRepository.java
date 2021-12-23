package kg.it.megaschool.crmitmega.repository;

import kg.it.megaschool.crmitmega.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
