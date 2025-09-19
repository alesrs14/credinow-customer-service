package com.credinow.customerservice.service;

import com.credinow.customerservice.model.Customer;
import com.credinow.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void createCustomer_Success() {
        // Given
        Customer customer = new Customer("Test", "User", "test@example.com", "password123");

        // When
        Customer savedCustomer = customerService.createCustomer(customer);

        // Then
        assertNotNull(savedCustomer.getId());
        assertEquals("Test", savedCustomer.getFirstName());
        assertEquals("User", savedCustomer.getLastName());
        assertEquals("test@example.com", savedCustomer.getEmail());
        assertTrue(savedCustomer.isActive());
        // Password should be encrypted
        assertNotEquals("password123", savedCustomer.getPassword());
    }

    @Test
    void authenticateCustomer_Success() {
        // Given
        Customer customer = new Customer("Test", "User", "auth@example.com", "password123");
        customerService.createCustomer(customer);

        // When
        boolean authenticated = customerService.authenticateCustomer("auth@example.com", "password123");

        // Then
        assertTrue(authenticated);
    }

    @Test
    void authenticateCustomer_WrongPassword() {
        // Given
        Customer customer = new Customer("Test", "User", "auth2@example.com", "password123");
        customerService.createCustomer(customer);

        // When
        boolean authenticated = customerService.authenticateCustomer("auth2@example.com", "wrongpassword");

        // Then
        assertFalse(authenticated);
    }
}