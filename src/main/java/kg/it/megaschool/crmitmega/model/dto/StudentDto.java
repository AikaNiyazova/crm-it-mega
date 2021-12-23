package kg.it.megaschool.crmitmega.model.dto;

import kg.it.megaschool.crmitmega.model.entity.Group;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {

    Long id;
    LocalDateTime dateCreated;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    LocalDate dob;
    List<GroupDto> groupDtoList;

}
