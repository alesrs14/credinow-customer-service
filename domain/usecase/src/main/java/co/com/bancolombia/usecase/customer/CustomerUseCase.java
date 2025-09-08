package co.com.bancolombia.usecase.customer;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CustomerUseCase {
    private final CustomerRepository customerRepository;
    public Mono<Customer> saveCustomer(Customer customer){
        return customerRepository.saveCustomer(customer);
    }
    public Flux<Customer> findAllCustomers(){
        return customerRepository.findAllCustomers();
    }
}
