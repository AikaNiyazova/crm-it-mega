package kg.it.megaschool.crmitmega.service.impl;

import kg.it.megaschool.crmitmega.mapper.GroupMapper;
import kg.it.megaschool.crmitmega.mapper.StudentMapper;
import kg.it.megaschool.crmitmega.model.dto.GroupDto;
import kg.it.megaschool.crmitmega.model.dto.StudentDto;
import kg.it.megaschool.crmitmega.model.entity.Student;
import kg.it.megaschool.crmitmega.model.request.CreateStudentRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import kg.it.megaschool.crmitmega.repository.StudentRepository;
import kg.it.megaschool.crmitmega.service.GroupService;
import kg.it.megaschool.crmitmega.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupService groupService;

    @Override
    public StudentDto create(CreateStudentRequest request) {
        List<GroupDto> groupDtoList = Arrays.asList(groupService.find(request.getGroupId()));


        Student student = Student
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dob(request.getDob())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .group(GroupMapper.INSTANCE.toEntityList(groupDtoList))
                .build();

        return StudentMapper.INSTANCE.toDto(studentRepository.save(student));

//        StudentDto studentDto = StudentDto
//                .builder()
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .dob(request.getDob())
//                .email(request.getEmail())
//                .phoneNumber(request.getPhoneNumber())
//                .groupDtoList(groupDtoList)
//                .build();
//
//        studentDto
//                .setId(studentRepository
//                        .save(StudentMapper.INSTANCE
//                                .toEntity(studentDto))
//                        .getId());
//
//        return studentDto;
    }

    @Override
    public StudentDto read(Long id) {
        return null;
    }

    @Override
    public List<StudentDto> readAll() {
        return null;
    }

    @Override
    public MessageResponse delete(Long id) {
        return null;
    }
}
