package com.ra.session_05.service.customer;

import com.ra.session_05.model.dto.customer.CustomerRequestDTO;
import com.ra.session_05.model.dto.customer.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDTO> findAll();
    CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO);
}
