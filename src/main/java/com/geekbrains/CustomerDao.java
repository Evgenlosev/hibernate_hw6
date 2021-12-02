package com.geekbrains;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {
    Customer findById(Long id);
    List<Customer> findAll();
    void deleteById(Long id);
    List<Product> findProductsByCustomerId(Long id);

}
