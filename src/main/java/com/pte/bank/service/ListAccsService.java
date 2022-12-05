/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pte.bank.service;


import com.pte.bank.model.Customers;
import com.pte.bank.model.ListAccs;

import com.pte.bank.repository.ListAccsRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author shayb
 */
@Service
@Transactional
public class ListAccsService {
        @Autowired
        
    private ListAccsRepository repo;
        
        
        
      //needed to inject a user
    @PersistenceContext
    //to manage or search data in relational databases
    public EntityManager em;
    //Get a list of all accounts in bank
    public List<ListAccs> getListAccsSpq() {
        //create stored procedure query to declare procedure from databases in java
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getListAccs");
        return spq.getResultList();
    }
//      public void addCustomerSpq(Customers c) {
//        //All parameters should get registered in your java application
//        StoredProcedureQuery spq = em.createStoredProcedureQuery("addCustomer");
//        spq.registerStoredProcedureParameter("first_nameIN", String.class, ParameterMode.IN);
//        spq.registerStoredProcedureParameter("last_nameIN", String.class, ParameterMode.IN);
//        spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
//        spq.registerStoredProcedureParameter("phoneIN", Integer.class, ParameterMode.IN);
// 
//
//        
//
//        
//        
//                spq.setParameter("first_nameIN",c.getFirstName());
//                spq.setParameter("last_IN", c.getLastName());
//                spq.setParameter("emailIN",c.getCustomerEmail());
//                spq.setParameter("phoneIN",c.getCustomerPhone());
//                
//                spq.execute();
//     }
//    public void addCustomerJpa(Customers c){
//    repo.save(c);
//    }
    public List<ListAccs> listAll() {
        return repo.findAll();
    }
     
    public void save(ListAccs list_accs) {
        repo.save(list_accs);
    }
     
    public ListAccs get(Integer bank_id) {
        return repo.findById(bank_id).get();
    }
     
    public void delete(Integer bank_id) {
        repo.deleteById(bank_id);
    }
      public List<ListAccs> findListAccsByListAccsID(Integer bankId){
        List<ListAccs> result = repo.findListAccsByListAccsID(bankId);
        if (CollectionUtils.isEmpty(result)){
            throw new NoResultException();
        }else{
             return result;
        }
       
    }
        
    
    
}

   
