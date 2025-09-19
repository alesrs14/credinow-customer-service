package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.CreateCustomerDTO;
import co.com.bancolombia.api.dto.CustomerDTO;
import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class HandlerV1 {
    @Autowired
    private  final CustomerUseCase customerUseCase;
    private final ObjectMapper objectMapper;
    private final Validator validator;
//private  final UseCase2 useCase2;



    public Mono<ServerResponse> listenSaveCustomer(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(CreateCustomerDTO.class)
                .flatMap(dto -> {
                    Set<ConstraintViolation<CreateCustomerDTO>> fieldError = validator.validate(dto);
                    if (!fieldError.isEmpty()) {
                        List<String> errors = fieldError.stream()
                                .map(ConstraintViolation::getMessage)
                                .toList();

                        return ServerResponse.badRequest()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(errors);
                    }

                    Customer customer = objectMapper.convertValue(dto, Customer.class);
                    return customerUseCase.saveCustomer(customer)
                            .flatMap(savedCustomer -> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(savedCustomer));
                });
    }



    public Mono<ServerResponse> listenAllCustomer(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerUseCase.findAllCustomers(), CustomerDTO.class);
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
