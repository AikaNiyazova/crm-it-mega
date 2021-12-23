package kg.it.megaschool.crmitmega.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String s) {
        super(s);
    }
}
