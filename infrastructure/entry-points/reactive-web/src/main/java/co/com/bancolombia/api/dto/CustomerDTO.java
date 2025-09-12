package co.com.bancolombia.api.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

public record CustomerDTO(Long idNumber, String names , String lastNames, LocalDate birthDate, String address , String phone , String email , Long salary) {
}
