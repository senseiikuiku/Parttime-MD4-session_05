package com.ra.session_05.controller.customer;

import com.ra.session_05.model.dto.customer.CustomerRequestDTO;
import com.ra.session_05.model.dto.customer.CustomerResponseDTO;
import com.ra.session_05.service.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<?> index() {

        List<CustomerResponseDTO> responseDTOS = customerService.findAll();
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        CustomerResponseDTO responseDTO = customerService.create(customerRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
