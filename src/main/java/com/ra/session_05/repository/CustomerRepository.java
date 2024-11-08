package com.ra.session_05.repository;

import com.ra.session_05.model.entity.Customer;
import org.hibernate.sql.exec.spi.JdbcCallParameterExtractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Boolean existsCustomerByEmail(String email);
}
