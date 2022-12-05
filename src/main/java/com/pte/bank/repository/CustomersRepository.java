/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pte.bank.repository;

import com.pte.bank.model.Customers;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author shayb
 */
public interface CustomersRepository extends JpaRepository <Customers, Integer>{
         @Query(value = "SELECT c FROM Customers c WHERE c.customerId = :customerId")
    public List<Customers> findCustomersByCustomerId(@Param("customerId") Integer customerId);
    
}
