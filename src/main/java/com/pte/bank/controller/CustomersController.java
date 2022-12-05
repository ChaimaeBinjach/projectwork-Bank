/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pte.bank.controller;

import com.pte.bank.aspect.HasAuthorities;
import com.pte.bank.aspect.SecurityAuthorities;
import com.pte.bank.model.Customers;
import com.pte.bank.service.CustomersService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shayb
 */
@RestController
public class CustomersController {
    @Autowired
    private CustomersService service;
    @GetMapping("/customers")
    public List<Customers> list() {
    return service.listAll();
    
    }  
    @HasAuthorities(authorities={SecurityAuthorities.ADMIN})
    @GetMapping("/customers/{customer_id}")
    public ResponseEntity<Customers> get(@PathVariable Integer customer_id) {
        try {
            Customers customers = service.get(customer_id);
            return new ResponseEntity<Customers>(customers, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customers>(HttpStatus.NOT_FOUND);
        }  
   
    }
    
    @PostMapping("/customers")
    public void add(@RequestBody Customers customers) {
        service.save(customers);
    }
    @PutMapping("/customers/{customer_id}")
    public ResponseEntity<?> update(@RequestBody Customers customers, @PathVariable Integer customer_id) {
        try {
            service.editCustomerJpa(customers, customer_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    @DeleteMapping("/customers/{customer_id}")
    public void delete(@PathVariable Integer customer_id) {
    service.delete(customer_id);
}
    
    @PostMapping(value="/addCustomer/spq")
    public void addCustomerSpq(@RequestBody Customers c) {
        service.addCustomerSpq(c);
    }
    @PostMapping(value="/addCustomer/jpa")
       public void addCustomerJpa(@RequestBody Customers c) {
        service.addCustomerJpa(c);
       }
           @GetMapping(value ="/findCustomersByCustomerId/{customer_id}")
    public List<Customers>findCustomersByCustomerId(@PathVariable Integer customer_id){
            return service.findCustomersByCustomerId(customer_id);
}
  
    
    
}
