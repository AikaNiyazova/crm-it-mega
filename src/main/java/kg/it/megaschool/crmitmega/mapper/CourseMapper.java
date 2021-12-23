package kg.it.megaschool.crmitmega.mapper;

import kg.it.megaschool.crmitmega.model.dto.CourseDto;
import kg.it.megaschool.crmitmega.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper extends BaseMapper<Course, CourseDto> {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
}
