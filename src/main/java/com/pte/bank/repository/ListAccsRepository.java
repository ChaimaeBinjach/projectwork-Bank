/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pte.bank.repository;


import com.pte.bank.model.ListAccs;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author shayb
 */
public interface ListAccsRepository extends JpaRepository <ListAccs, Integer>{
     @Query(value = "SELECT l FROM ListAccs l WHERE l.bankId = :bankId")
    public List<ListAccs> findListAccsByListAccsID(@Param("bankId") Integer bankId);
    
}
