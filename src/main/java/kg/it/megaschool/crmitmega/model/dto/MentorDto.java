package kg.it.megaschool.crmitmega.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MentorDto {

    Long id;
    LocalDateTime dateCreated;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    LocalDate dob;
    BigDecimal salary;

}
