package kg.it.megaschool.crmitmega.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetCourseTypeByDurationRequest {
    private Double durationInMonths;
}
