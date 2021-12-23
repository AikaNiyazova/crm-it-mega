package kg.it.megaschool.crmitmega.service.impl;

import kg.it.megaschool.crmitmega.mapper.MentorMapper;
import kg.it.megaschool.crmitmega.model.dto.MentorDto;
import kg.it.megaschool.crmitmega.model.entity.Mentor;
import kg.it.megaschool.crmitmega.model.request.CreateMentorRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import kg.it.megaschool.crmitmega.repository.MentorRepository;
import kg.it.megaschool.crmitmega.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;

    @Override
    public MentorDto create(CreateMentorRequest request) {
        Mentor mentor = Mentor
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();

//        mentorRepository.save(mentor);

        return MentorMapper.INSTANCE.toDto(mentorRepository.save(mentor));
    }

    @Override
    public MentorDto find(Long id) {
        return null;
    }

    @Override
    public List<MentorDto> readAll() {
        return null;
    }

    @Override
    public MessageResponse delete(Long id) {
        return null;
    }
}
