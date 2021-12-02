package com.geekbrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.geekbrains");
        ProductCustomerServise servise = context.getBean(ProductCustomerServise.class);

        System.out.println(servise.findProductsByCustomerId(1L));
        System.out.println(servise.findCustomersByProductId(2L));


    }
}
