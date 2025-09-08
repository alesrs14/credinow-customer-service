package co.com.bancolombia.api.dto;

import java.math.BigInteger;
import java.util.Date;

public record CreateCustomerDTO(String idNumber, String names , String lastNames, Date birthDate, String address , String phone , String email , BigInteger salary) {
}
