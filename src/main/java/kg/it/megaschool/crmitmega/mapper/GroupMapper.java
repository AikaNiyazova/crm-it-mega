package kg.it.megaschool.crmitmega.mapper;

import kg.it.megaschool.crmitmega.model.dto.GroupDto;
import kg.it.megaschool.crmitmega.model.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper extends BaseMapper<Group, GroupDto> {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);
}
