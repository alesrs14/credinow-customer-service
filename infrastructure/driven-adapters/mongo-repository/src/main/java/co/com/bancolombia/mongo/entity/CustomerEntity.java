package co.com.bancolombia.mongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection="customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerEntity {
    @Id
    private String id;

    private String names;

    private String lastNames;

    private LocalDate birthDate;

    private String address;

    private String phone;

    private String email;

    private BigDecimal salary;
}
