/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pte.bank.service;

import com.pte.bank.model.Accounts;
import com.pte.bank.model.Customers;
import com.pte.bank.repository.CustomersRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author shayb
 */
@Service
@Transactional
public class CustomersService {
    @Autowired
    private CustomersRepository repo;
    
      //needed to inject a user
    @PersistenceContext
    //to manage or search data in relational databases
    public EntityManager em;
    //Get a list of all customers
    public List<Customers> getCustomerSpq() {
        //create stored procedure query to declare procedure from databases in java
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getCustomer");
        return spq.getResultList();
    }
     public void addCustomerSpq(Customers c) {
        //All parameters should get registered in your java application
        StoredProcedureQuery spq = em.createStoredProcedureQuery("addCustomer");
        spq.registerStoredProcedureParameter("first_nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("last_nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("phoneIN", Integer.class, ParameterMode.IN);
 

        

        
        
                spq.setParameter("first_nameIN",c.getFirstName());
                spq.setParameter("last_IN", c.getLastName());
                spq.setParameter("emailIN",c.getCustomerEmail());
                spq.setParameter("phoneIN",c.getCustomerPhone());
                
                spq.execute();
     }
    public void addCustomerJpa(Customers c){
    repo.save(c);
    }
    // to edit customer
         public void editCustomerSpq(Customers c, Integer id) {
        //All parameters should get registered in your java application
        StoredProcedureQuery spq = em.createStoredProcedureQuery("editCustomer");
        spq.registerStoredProcedureParameter("first_nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("last_nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("phoneIN", Integer.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("checkingIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("savingsIN", String.class, ParameterMode.IN);

        
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);

        
        
        
        spq.setParameter("first_nameIN",c.getFirstName());
        spq.setParameter("last_IN", c.getLastName());
        spq.setParameter("emailIN",c.getCustomerEmail());
        spq.setParameter("phoneIN",c.getCustomerPhone());
        spq.setParameter("checkingIN", c.getCheckingAccount());
        spq.setParameter("savingsIN", c.getSavingsAccount());
                
        spq.setParameter("idIN",id);
        spq.execute();
     }
         public Customers getCustomer(Integer id){
             return repo.findById(id).get();
         }
         
         public void editCustomerJpa(Customers c,Integer id) {
             Customers existing = getCustomer(id);
             existing.setFirstName(c.getFirstName());
             existing.setLastName(c.getLastName());
             existing.setCustomerEmail(c.getCustomerEmail());
             existing.setCustomerPhone(c.getCustomerPhone());
             existing.setCheckingAccount(c.getCustomerEmail());
             existing.setSavingsAccount(c.getSavingsAccount());
             
             repo.save(existing);
             
         }

      //Delete a customer
    public void deleteCustomerSpq(Integer id) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteCustomer");
        
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);
        
        spq.execute();
    }
    
    
    public void deleteCustomersJpa(Integer id) {
        repo.deleteById(id);
    }
    
    
   
    
    //////////////////////////////////////////
    
    
    
    public List<Customers> listAll() {
        return repo.findAll();
    }
     
    public void save(Customers customers) {
        repo.save(customers);
    }
     
    public Customers get(Integer customer_id) {
        return repo.findById(customer_id).get();
    }
     
    public void delete(Integer customer_id) {
        repo.deleteById(customer_id);
    }
          public List<Customers> findCustomersByCustomerId(Integer customer_id){
        List<Customers> result = repo.findCustomersByCustomerId(customer_id);
        if (CollectionUtils.isEmpty(result)){
            throw new NoResultException();
        }else{
             return result;
        }
       
    }
    
    
}
