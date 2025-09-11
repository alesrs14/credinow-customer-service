package co.com.bancolombia.r2dbc.entity;


import org.springframework.data.annotation.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Table("customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CustomerEntity {
    @Id
    private Long id;
    private Long idNumber;
    private String names;
    private String lastNames;
    private LocalDate birthDate;
    private String address;
    private String phone;
    private String email;
    private Integer salary;
}
