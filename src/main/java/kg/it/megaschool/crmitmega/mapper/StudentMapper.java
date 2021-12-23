package kg.it.megaschool.crmitmega.mapper;

import kg.it.megaschool.crmitmega.model.dto.StudentDto;
import kg.it.megaschool.crmitmega.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper extends BaseMapper<Student, StudentDto> {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
}
