package kg.it.megaschool.crmitmega.service;

import kg.it.megaschool.crmitmega.model.dto.CourseTypeDto;
import kg.it.megaschool.crmitmega.model.request.CreateCourseTypeRequest;
import kg.it.megaschool.crmitmega.model.request.GetCourseTypeByDurationRequest;
import kg.it.megaschool.crmitmega.model.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseTypeService {

    CourseTypeDto create(CreateCourseTypeRequest request);

    CourseTypeDto find(Long id);

    List<CourseTypeDto> readAll();

    MessageResponse delete(Long id);

    List<CourseTypeDto> readCourseTypeByDurationInMonths(GetCourseTypeByDurationRequest request);

}
