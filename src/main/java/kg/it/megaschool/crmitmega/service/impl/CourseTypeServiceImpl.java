package kg.it.megaschool.crmitmega.service.impl;

import kg.it.megaschool.crmitmega.exceptions.CourseTypeNotFoundException;
import kg.it.megaschool.crmitmega.mapper.CourseTypeMapper;
import kg.it.megaschool.crmitmega.model.dto.CourseTypeDto;
import kg.it.megaschool.crmitmega.model.entity.CourseType;
import kg.it.megaschool.crmitmega.model.request.CreateCourseTypeRequest;
import kg.it.megaschool.crmitmega.model.request.GetCourseTypeByDurationRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import kg.it.megaschool.crmitmega.repository.CourseTypeRepository;
import kg.it.megaschool.crmitmega.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeRepository courseTypeRepository; // прикрепляем репозиторий

    @Override
    public CourseTypeDto create(CreateCourseTypeRequest request) { // приняли данные request в нужном формате

        if (courseTypeRepository.existsByTypeName(request.getTypeName())) {
            CourseType courseType = courseTypeRepository
                    .findByTypeName(request.getTypeName())
                    .map(courseType1 -> {
                        courseType1.setIsDeleted(false);
                        courseType1.setClassesPerMonth(request.getClassesPerMonth());
                        courseType1.setDurationOfOneLesson(request.getDurationOfOneLesson());
                        courseType1.setClassesPerMonth(request.getClassesPerMonth());
                        return courseTypeRepository.save(courseType1);
                    }).get();
            return CourseTypeMapper.INSTANCE.toDto(courseType);
        }

        if (request.getTypeName() == null || request.getTypeName().equals("")) {
            throw new RuntimeException("TypeName should not be empty.");
        }

        if (request.getClassesPerMonth() <= 0 || request.getClassesPerMonth() > 30) {
            throw new RuntimeException("Invalid number of classes for classesPerMonth=" + request.getClassesPerMonth());
        }

        CourseType courseType = new CourseType(); // на основе request создаем и передаем данные в entity; id, dateCreated уже есть
        courseType.setTypeName(request.getTypeName());
        courseType.setClassesPerMonth(request.getClassesPerMonth());
        courseType.setDurationInMonths(request.getDurationInMonths());
        courseType.setDurationOfOneLesson(request.getDurationOfOneLesson());
        courseTypeRepository.save(courseType); // сохраняем entity

        return CourseTypeDto
                .builder() // as setters
                .id(courseType.getId())
                .typeName(courseType.getTypeName())
                .classesPerMonth(courseType.getClassesPerMonth())
                .durationInMonths(courseType.getDurationInMonths())
                .durationOfOneLesson(courseType.getDurationOfOneLesson())
                .dateCreated(courseType.getDateCreated())
                .build();
    }

    @Override
    public CourseTypeDto find(Long id) {
        CourseType courseType = courseTypeRepository
                .findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CourseTypeNotFoundException("Course Type with id=" + id + " is not found."));

        return CourseTypeMapper.INSTANCE.toDto(courseType);
    }

    @Override
    public List<CourseTypeDto> readAll() {
        List<CourseType> courseTypeList = courseTypeRepository.findAll();
        if (courseTypeList.isEmpty()) {
            throw new RuntimeException("Table for Course Type is empty.");
        }
        return CourseTypeMapper.INSTANCE.toDtoList(courseTypeList);
    }

    @Override
    public MessageResponse delete(Long id) {
        return courseTypeRepository
            .findById(id)
            .map(courseType -> {
                courseType.setIsDeleted(true);
                courseTypeRepository.save(courseType);
                return new MessageResponse("Course Type with id=" + id + " is deleted.");
            })
            .orElseThrow(() -> new CourseTypeNotFoundException("Course Type with id=" + id + " is not found."));
    }

    @Override
    public List<CourseTypeDto> readCourseTypeByDurationInMonths(GetCourseTypeByDurationRequest request) {
        List<CourseTypeDto> courseTypeDtoList = CourseTypeMapper.INSTANCE.
                toDtoList(courseTypeRepository.findByDurationInMonths(request.getDurationInMonths()));

        if (courseTypeDtoList.isEmpty()) {
            throw new RuntimeException("Empty data set");
        }
        return courseTypeDtoList;
    }

}
