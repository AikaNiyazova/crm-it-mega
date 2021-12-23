package kg.it.megaschool.crmitmega.service;

import kg.it.megaschool.crmitmega.model.dto.MentorDto;
import kg.it.megaschool.crmitmega.model.request.CreateMentorRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;

import java.util.List;

public interface MentorService {

    MentorDto create(CreateMentorRequest request);

    MentorDto find(Long id);

    List<MentorDto> readAll();

    MessageResponse delete(Long id);

}
