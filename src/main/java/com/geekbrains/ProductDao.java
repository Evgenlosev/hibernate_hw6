package com.geekbrains;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao {
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    List<Customer> findCustomersByProductId(Long id);

}
