package co.com.bancolombia.api.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreateCustomerDTO(

        @NotNull(message = "El número de identificación no puede ser nulo")
        Long idNumber,

        @NotBlank(message = "El nombre no puede estar vacío")
        String names,

        @NotBlank(message = "El apellido no puede estar vacío")
        String lastNames,

        @Past(message = "La fecha de nacimiento debe estar en el pasado")
        LocalDate birthDate,

        @NotBlank(message = "La dirección no puede estar vacía")
        String address,

        @NotBlank(message = "El teléfono no puede estar vacío")
        String phone,

        @NotBlank(message = "El correo electrónico no puede estar vacío")
        @Email(message = "El correo electrónico no tiene un formato válido")
        //@UniqueEmail(message = "El correo electrónico ya está registrado")  // <-- validador personalizado
        String email,

        @NotNull(message = "El salario base no puede ser nulo")
        @Min(value = 0, message = "El salario base no puede ser menor a 0")
        @Max(value = 15000000, message = "El salario base no puede superar 15,000,000")
        Long salary

) {}