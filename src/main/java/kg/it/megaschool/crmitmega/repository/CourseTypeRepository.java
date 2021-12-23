package kg.it.megaschool.crmitmega.repository;

import kg.it.megaschool.crmitmega.model.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, Long> {

    boolean existsByTypeName(String typeName);
    Optional<CourseType> findByTypeName(String typeName);
    Optional<CourseType> findByIdAndIsDeletedFalse(Long id);
    List<CourseType> findByDurationInMonths(Double durationInMonths);
    
}
