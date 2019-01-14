package com.yhtart.service;

import com.yhtart.model.Customer;
import com.yhtart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Page<Customer> findAll(int pageNo, int pageSize) {
        Page<Customer> customers = customerRepository.findAll(PageRequest.of(pageNo, pageSize));
        return customers;
    }

    public Customer findByID(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public boolean exists(long id) {
        return customerRepository.existsById(id);
    }

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void delete(long id) {
        customerRepository.deleteById(id);
    }
}
