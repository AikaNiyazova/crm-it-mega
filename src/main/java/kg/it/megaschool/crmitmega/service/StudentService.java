package kg.it.megaschool.crmitmega.service;

import kg.it.megaschool.crmitmega.model.dto.StudentDto;
import kg.it.megaschool.crmitmega.model.request.CreateStudentRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    StudentDto create(CreateStudentRequest request);

    StudentDto read(Long id);

    List<StudentDto> readAll();

    MessageResponse delete(Long id);

}
