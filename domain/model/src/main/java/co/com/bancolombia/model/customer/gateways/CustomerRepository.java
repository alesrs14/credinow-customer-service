package co.com.bancolombia.model.customer.gateways;

import co.com.bancolombia.model.customer.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository {
    Mono<Customer> saveCustomer(Customer customer);
    Flux<Customer> findAllCustomers();

}
