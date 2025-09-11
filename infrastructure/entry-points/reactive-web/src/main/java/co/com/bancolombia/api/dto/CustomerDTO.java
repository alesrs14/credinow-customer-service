package co.com.bancolombia.api.dto;

import java.math.BigInteger;
import java.util.Date;

public record CustomerDTO(Long idNumber, String names , String lastNames, String birthDate, String address , String phone , String email , String salary) {
}
