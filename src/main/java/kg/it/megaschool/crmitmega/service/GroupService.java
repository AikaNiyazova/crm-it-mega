package kg.it.megaschool.crmitmega.service;

import kg.it.megaschool.crmitmega.model.dto.GroupDto;
import kg.it.megaschool.crmitmega.model.request.CreateGroupRequest;
import org.springframework.stereotype.Service;

@Service
public interface GroupService {

    GroupDto find(Long id);

    GroupDto create(CreateGroupRequest request);

}
