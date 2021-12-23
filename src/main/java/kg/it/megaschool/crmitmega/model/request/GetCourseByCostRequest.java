package kg.it.megaschool.crmitmega.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class GetCourseByCostRequest {
    private BigDecimal from;
    private BigDecimal to;
}