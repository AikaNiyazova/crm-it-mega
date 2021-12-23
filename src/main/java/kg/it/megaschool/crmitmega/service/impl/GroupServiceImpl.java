package kg.it.megaschool.crmitmega.service.impl;

import kg.it.megaschool.crmitmega.exceptions.GroupNotFoundException;
import kg.it.megaschool.crmitmega.mapper.CourseMapper;
import kg.it.megaschool.crmitmega.mapper.GroupMapper;
import kg.it.megaschool.crmitmega.mapper.MentorMapper;
import kg.it.megaschool.crmitmega.model.dto.CourseDto;
import kg.it.megaschool.crmitmega.model.dto.GroupDto;
import kg.it.megaschool.crmitmega.model.dto.MentorDto;
import kg.it.megaschool.crmitmega.model.entity.Group;
import kg.it.megaschool.crmitmega.model.request.CreateGroupRequest;
import kg.it.megaschool.crmitmega.repository.GroupRepository;
import kg.it.megaschool.crmitmega.service.CourseService;
import kg.it.megaschool.crmitmega.service.GroupService;
import kg.it.megaschool.crmitmega.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private MentorService mentorService;
    private CourseService courseService;

    @Override
    public GroupDto find(Long id) {
        return GroupMapper.INSTANCE
                .toDto(groupRepository.findByIdAndIsDeletedFalse(id)
                        .orElseThrow(() -> new GroupNotFoundException("Group with id=" + id + " is not found.")));

    }

    @Override
    public GroupDto create(CreateGroupRequest request) {
        MentorDto mentorDto = mentorService.find(request.getMentorId());
        CourseDto courseDto = courseService.find(request.getCourseId());

        Group group = Group
                .builder()
                .groupName(request.getGroupName())
                .classTime(request.getClassTime())
                .course(CourseMapper.INSTANCE.toEntity(courseDto))
                .mentor(MentorMapper.INSTANCE.toEntity(mentorDto))
                .build();

        return GroupMapper.INSTANCE.toDto(groupRepository.save(group));
    }


}
