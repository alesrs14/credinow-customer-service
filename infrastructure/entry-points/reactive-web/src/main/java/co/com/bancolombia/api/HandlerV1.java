package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.CreateCustomerDTO;
import co.com.bancolombia.api.dto.CustomerDTO;
import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.usecase.customer.CustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
@RequiredArgsConstructor
public class HandlerV1 {

    private  final CustomerUseCase customerUseCase;
    private final ObjectMapper objectMapper;

//private  final UseCase2 useCase2;


    public Mono<ServerResponse> listenSaveCustomer(ServerRequest serverRequest){
        return serverRequest.bodyToMono(CreateCustomerDTO.class)
                .map(customer -> objectMapper.convertValue(customer, Customer.class))
                .flatMap(customerUseCase::saveCustomer)
                .flatMap(savedCustomer -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(savedCustomer));
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
