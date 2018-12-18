package com.yhtart.controller;

import com.yhtart.model.Customer;
import com.yhtart.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity askForPrice(@RequestBody Customer customer) {
        if (customer.getName().equals("") || customer.getPhoneNo().equals("") || customer.getProductUrl().equals(""))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if (emailService.sendMailByCustomer(customer))
            return ResponseEntity.ok(null);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
