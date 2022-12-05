/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pte.bank.controller;

import com.pte.bank.model.Accounts;
import com.pte.bank.service.AccountsService;
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
public class AccountsController {
    @Autowired
    private AccountsService service;
    @GetMapping(value = "/accounts/spq")
       public List<Accounts> getAccountSqp() {
        return service.getAccountSpq();
    }
    
    
    @GetMapping("/accounts")
    public List<Accounts> list() {
        return service.listAll();
    
    }   
    @GetMapping("/accounts/{account_id}")
    public ResponseEntity<Accounts> get(@PathVariable Integer account_id) {
        try {
            Accounts accounts = service.get(account_id);
            return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Accounts>(HttpStatus.NOT_FOUND);
        }  
   
    }
    
    @PostMapping("/accounts")
    public void add(@RequestBody Accounts accounts) {
        service.save(accounts);
    }
    @PutMapping("/accounts/{account_id}")
    public ResponseEntity<?> update(@RequestBody Accounts accounts, @PathVariable Integer account_id) {
        try {
            service.editAccountJpa(accounts,account_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    @DeleteMapping("/accounts/{account_id}")
    public void delete(@PathVariable Integer account_id) {
    service.delete(account_id);
}
    
    @GetMapping(value ="/findAccountsByAccountname/{accountName}")
    public List<Accounts>findAccountsByAccountname(@PathVariable String accountName){
            return service.findAccountsByAccountname(accountName);
}
    @GetMapping(value = "/DifferentCurrencies/{account_id}")
    public List DifferentCurrencies(@PathVariable Integer account_id){
        return service.DifferentCurrencies(account_id);
    }
    
}
