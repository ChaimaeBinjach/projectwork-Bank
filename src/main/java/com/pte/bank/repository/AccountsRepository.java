/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pte.bank.repository;

import com.pte.bank.model.Accounts;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author shayb
 */
public interface AccountsRepository extends JpaRepository <Accounts, Integer> {
    @Query(value = "SELECT a FROM Accounts a WHERE a.accountName = :accountName")
    public List<Accounts> findAccountsByAccountname(@Param("accountName") String accountName);
    
     
    
}
