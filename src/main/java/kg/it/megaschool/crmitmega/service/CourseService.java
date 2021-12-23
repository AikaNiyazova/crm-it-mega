package kg.it.megaschool.crmitmega.service;

import kg.it.megaschool.crmitmega.model.dto.CourseDto;
import kg.it.megaschool.crmitmega.model.request.CreateCourseRequest;
import kg.it.megaschool.crmitmega.model.request.GetCourseByCostRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    CourseDto create(CreateCourseRequest request);

    CourseDto find(Long id);

    List<CourseDto> readAll();

    CourseDto update(CourseDto courseDto);

    MessageResponse /*void*/ delete(Long id);

    List<String> readAllCourseNames();

    List<CourseDto> readCoursesByMonthlyCostBetween(GetCourseByCostRequest request);

}
