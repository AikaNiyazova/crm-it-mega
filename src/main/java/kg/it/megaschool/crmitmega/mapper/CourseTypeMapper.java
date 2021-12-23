package kg.it.megaschool.crmitmega.mapper;

import kg.it.megaschool.crmitmega.model.dto.CourseTypeDto;
import kg.it.megaschool.crmitmega.model.entity.CourseType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseTypeMapper extends BaseMapper<CourseType, CourseTypeDto> {
    CourseTypeMapper INSTANCE = Mappers.getMapper(CourseTypeMapper.class);
}
