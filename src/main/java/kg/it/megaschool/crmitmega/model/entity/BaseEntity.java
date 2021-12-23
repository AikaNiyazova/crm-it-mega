package kg.it.megaschool.crmitmega.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data // Getters // Setters // ToString // EqualsAndHashcode
@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // columnDefinition = "BIGSERIAL"
    @Column(name = "id", nullable = false, unique = true)
    Long id;

    @Column(name = "is_deleted", nullable = false)
    Boolean isDeleted;

    @CreationTimestamp
    @Column(name = "date_created", nullable = false)
    LocalDateTime dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated", nullable = true)
    LocalDateTime dateUpdated;

    @PrePersist
    private void onCreate() {
        isDeleted = false;
    }

}
