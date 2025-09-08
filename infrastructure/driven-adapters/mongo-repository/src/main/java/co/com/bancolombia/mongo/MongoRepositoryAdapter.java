package co.com.bancolombia.mongo;

import co.com.bancolombia.model.customer.Customer;
import co.com.bancolombia.model.customer.gateways.CustomerRepository;
import co.com.bancolombia.mongo.entity.CustomerEntity;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Customer, CustomerEntity, String, MongoDBRepository> implements CustomerRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Customer.class/* change for domain model */));
    }

    @Override
    public Mono<Customer> saveCustomer(Customer customer) {
        return super.save(customer);
    }

    @Override
    public Flux<Customer> findAllCustomers() {
        return super.findAll();
    }
}
