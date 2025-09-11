package co.com.bancolombia.model.customer;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Customer {
    private Long idNumber;
    private String names;
    private String lastNames;
    private LocalDate birthDate;
    private String address;
    private String phone;
    private String email;
    private Integer salary;
}
