package com.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCustomerServise {
    private ProductDao productDao;
    private CustomerDao customerDao;

    @Autowired
    public ProductCustomerServise(ProductDao productDao, CustomerDao customerDao) {
        this.productDao = productDao;
        this.customerDao = customerDao;
    }

    public List<Customer> findCustomersByProductId(Long id) {
        return productDao.findCustomersByProductId(id);
    }

    public List<Product> findProductsByCustomerId(Long id) {
        return customerDao.findProductsByCustomerId(id);
    }
}
