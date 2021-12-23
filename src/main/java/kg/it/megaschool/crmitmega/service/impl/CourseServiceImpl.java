package kg.it.megaschool.crmitmega.service.impl;

import kg.it.megaschool.crmitmega.exceptions.CourseNotFoundException;
import kg.it.megaschool.crmitmega.mapper.CourseMapper;
import kg.it.megaschool.crmitmega.mapper.CourseTypeMapper;
import kg.it.megaschool.crmitmega.model.dto.CourseDto;
import kg.it.megaschool.crmitmega.model.dto.CourseTypeDto;
import kg.it.megaschool.crmitmega.model.entity.Course;
import kg.it.megaschool.crmitmega.model.request.CreateCourseRequest;
import kg.it.megaschool.crmitmega.model.request.GetCourseByCostRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import kg.it.megaschool.crmitmega.repository.CourseRepository;
import kg.it.megaschool.crmitmega.service.CourseService;
import kg.it.megaschool.crmitmega.service.CourseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseTypeService courseTypeService;

    @Override
    public CourseDto create(CreateCourseRequest request) {
        CourseTypeDto courseTypeDto = courseTypeService.find(request.getCourseTypeId());

        Course course = Course
                .builder()
                .courseName(request.getCourseName())
                .monthlyCost(request.getMonthlyCost())
                .courseType(CourseTypeMapper.INSTANCE.toEntity(courseTypeDto))
                .build();

        return CourseMapper.INSTANCE.toDto(courseRepository.save(course));

//        courseRepository.save(course);
//
//        return CourseDto
//                .builder()
//                .id(course.getId())
//                .courseName(course.getCourseName())
//                .monthlyCost(course.getMonthlyCost())
//                .courseType(courseTypeDto)
//                .build();
    }

    @Override
    public CourseDto find(Long id) {
        return CourseMapper.INSTANCE
                .toDto(courseRepository.findByIdAndIsDeletedFalse(id)
                        .orElseThrow(() -> new CourseNotFoundException("Course with id=" + id + " is not found.")));
//        Course course = courseRepository
//                .findById(id)
//                .orElseThrow(() -> new RuntimeException("Course with id=" + id + " is not found."));
//        CourseTypeDto courseTypeDto = CourseTypeMapper.INSTANCE.toDto(course.getCourseType());
//
//        return CourseDto.builder()
//                .id(course.getId())
//                .dateCreated(course.getDateCreated())
//                .courseName(course.getCourseName())
//                .courseType(courseTypeDto)
//                .monthlyCost(course.getMonthlyCost())
//                .build();
    }

    @Override
    public List<CourseDto> readAll() {
        List<Course> courseList = courseRepository.findAll();
        if (courseList.isEmpty()) {
            throw new RuntimeException("Table for Course is empty.");
        }
        return CourseMapper.INSTANCE.toDtoList(courseList);
    }

    @Override
    public CourseDto update(CourseDto courseDto) {
        return courseRepository.findById(courseDto.getId()).map(course -> {
            course.setCourseName(courseDto.getCourseName());
            course.setMonthlyCost(courseDto.getMonthlyCost());
            courseRepository.save(course);

            return CourseMapper.INSTANCE.toDto(course);
        }).orElseThrow(() -> new CourseNotFoundException("Course with id=" + courseDto.getId() + " not found."));
    }

    public List<String> readAllCourseNames() {
        return courseRepository.findAllCourseNames();
    }

    @Override
    public List<CourseDto> readCoursesByMonthlyCostBetween(GetCourseByCostRequest request) {
        List<CourseDto> courseDtoList = CourseMapper.INSTANCE.
                toDtoList(courseRepository.findByMonthlyCostBetween(request.getFrom(), request.getTo()));

        if (courseDtoList.isEmpty()) {
            throw new RuntimeException("Empty data set");
        }
        return courseDtoList;
    }

    @Override
    public MessageResponse delete(Long id) {
        return null;
    }

}
