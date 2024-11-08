package com.ra.session_05.service.customer;

import com.ra.session_05.model.dto.customer.CustomerRequestDTO;
import com.ra.session_05.model.dto.customer.CustomerResponseDTO;
import com.ra.session_05.model.entity.Customer;
import com.ra.session_05.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerResponseDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
//        Convert entity -> DTO
        List<CustomerResponseDTO> customerResponseDTOs = new ArrayList<>();
        customers.forEach(customer -> customerResponseDTOs.add(CustomerResponseDTO
                .builder().id(customer.getId())
                        .fullName(customer.getFullName())
                        .email(customer.getEmail())
                        .birthday(customer.getBirthday())
                        .build()));
        return customerResponseDTOs;
    }

    @Override
    public CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO) {
        Customer customer = Customer.builder()
                .fullName(customerRequestDTO.getFullName())
                .email(customerRequestDTO.getEmail())
                .birthday(customerRequestDTO.getBirthday())
                .build();
        Customer customerNew = customerRepository.save(customer);
        return CustomerResponseDTO.builder()
                .id(customerNew.getId())
                .fullName(customerNew.getFullName())
                .email(customerNew.getEmail())
                .birthday(customerNew.getBirthday())
                .build();
    }
}
