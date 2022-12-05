/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pte.bank.controller;

import com.pte.bank.model.Customers;
import com.pte.bank.model.ListAccs;

import com.pte.bank.service.ListAccsService;
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
public class ListAccsController {
     @Autowired
    private ListAccsService service;
    @GetMapping("/list_accs")
    public List<ListAccs> list() {
    return service.listAll();
    
    }   
    @GetMapping("/list_accs/{bank_id}")
    public ResponseEntity<ListAccs> get(@PathVariable Integer bank_id) {
        try {
            ListAccs list_accs = service.get(bank_id);
            return new ResponseEntity<ListAccs>(list_accs, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ListAccs>(HttpStatus.NOT_FOUND);
        }  
   
    }
    
    @PostMapping("/list_accs")
    public void add(@RequestBody ListAccs list_accs) {
        service.save(list_accs);
    }
    @PutMapping("/list_accs/{bank_id}")
    public ResponseEntity<?> update(@RequestBody ListAccs list_accs, @PathVariable Integer bank_id) {
        try {
            ListAccs existListAccs = service.get(bank_id);
            service.save(list_accs);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    @DeleteMapping("/list_accs/{bank_id}")
    public void delete(@PathVariable Integer bank_id) {
    service.delete(bank_id);
}
       @GetMapping(value ="/findListAccsByListAccsID/{bankId}")
    public List<ListAccs>findListAccsByListAccsID(@PathVariable Integer bankId){
            return service.findListAccsByListAccsID(bankId);
}
    
}
