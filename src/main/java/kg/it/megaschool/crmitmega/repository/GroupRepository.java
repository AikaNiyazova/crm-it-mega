package kg.it.megaschool.crmitmega.repository;

import kg.it.megaschool.crmitmega.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findByIdAndIsDeletedFalse(Long id);

}
