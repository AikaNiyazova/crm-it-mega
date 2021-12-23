package kg.it.megaschool.crmitmega.mapper;

import kg.it.megaschool.crmitmega.model.dto.MentorDto;
import kg.it.megaschool.crmitmega.model.entity.Mentor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MentorMapper extends BaseMapper<Mentor, MentorDto> {
    MentorMapper INSTANCE = Mappers.getMapper(MentorMapper.class);
}
