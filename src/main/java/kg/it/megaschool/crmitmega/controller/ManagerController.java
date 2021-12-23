package kg.it.megaschool.crmitmega.controller;

import kg.it.megaschool.crmitmega.model.entity.CourseType;
import kg.it.megaschool.crmitmega.model.entity.Mentor;
import kg.it.megaschool.crmitmega.repository.CourseTypeRepository;
import kg.it.megaschool.crmitmega.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller // Response to Requests
public class ManagerController {

    @Autowired
    CourseTypeRepository courseTypeRepository;

    @Autowired
    MentorRepository mentorRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "main-page-manager";
    }

    @RequestMapping("/api/v1/manager/save")
    public String save() {
        CourseType courseType = new CourseType();
        courseType.setTypeName("BOOTCAMP");
        courseType.setClassesPerMonth(20);
        courseType.setDurationInMonths(3.5);
        courseType.setDurationOfOneLesson(LocalTime.of(3, 0));
        courseTypeRepository.save(courseType);

        return "main-page-manager";
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String mainPage(HttpServletRequest request) {
//
//        System.out.println(request.getParameter("firstName").getClass());
//        System.out.println(request.getParameter("lastName").getClass());
//        System.out.println(request.getParameter("email").getClass());
//        System.out.println(request.getParameter("phoneNumber").getClass());
//        System.out.println(request.getParameter("dob").getClass());
//        System.out.println(request.getParameter("salary").getClass());
//
//        return "main-page-manager";
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String mainPage(HttpServletRequest request) {
        Mentor mentor = new Mentor();
        mentor.setFirstName(request.getParameter("firstName"));
        mentor.setLastName(request.getParameter("lastName"));
        mentor.setEmail(request.getParameter("email"));
        mentor.setPhoneNumber(request.getParameter("phoneNumber"));
        mentor.setDob(LocalDate.parse(request.getParameter("dob")));
        mentor.setSalary(new BigDecimal(request.getParameter("salary")));

        mentorRepository.save(mentor);
        return "main-page-manager";
    }

    @RequestMapping(value = "/add-mentor", method = RequestMethod.GET)
    public String addMentor() {
        return "add-mentor-form";
    }

}
