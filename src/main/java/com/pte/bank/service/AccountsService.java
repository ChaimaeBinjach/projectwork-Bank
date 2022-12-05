/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pte.bank.service;


import com.pte.bank.model.Accounts;
import com.pte.bank.repository.AccountsRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import static org.eclipse.persistence.internal.sessions.coordination.corba.sun.CommandDataHelper.id;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author shayb
 */
@Service
@Transactional
public class AccountsService {
    @Autowired
    private AccountsRepository repo;
    
    //needed to inject a user
    @PersistenceContext
    //to manage or search data in relational databases
    public EntityManager em;
    //Get a list of all customers
    public List<Accounts> getAccountSpq() {
        //create stored procedure query to declare procedure from databases in java
        StoredProcedureQuery spq = em.createStoredProcedureQuery("getAccount");
        return spq.getResultList();
    }
     public void addAccountSpq(Accounts a) {
        //All parameters should get registered in your java application
        StoredProcedureQuery spq = em.createStoredProcedureQuery("addAccount");
        spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
        
        spq.setParameter("nameIN", a.getAccountName());
                
        spq.execute();
     }
    public void addAccountJpa(Accounts a){
    repo.save(a);
    }
    
    
    //to edit acccounts
         public void editAccountSpq(Accounts a, Integer id) {
        //All parameters should get registered in your java application
        StoredProcedureQuery spq = em.createStoredProcedureQuery("editCustomer");
        spq.registerStoredProcedureParameter("account_nameIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("account_typeIN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("balanceIN", Integer.class, ParameterMode.IN);
   

        
        spq.registerStoredProcedureParameter("account_idIN", Integer.class, ParameterMode.IN);

        
        
        
        spq.setParameter("account_nameIN",a.getAccountName());
        spq.setParameter("account_typeIN", a.getAccountTypeCode() );
        spq.setParameter("balanceIN",a.getBalance());
     
                
        spq.setParameter("account_idIN",id);
        spq.execute();
     }
         public Accounts getAccount(Integer id){
             return repo.findById(id).get();
         }
         
         public void editAccountJpa(Accounts a,Integer id) {
             Accounts existing =getAccount(id);
             existing.setAccountName(a.getAccountName());
             existing.setAccountTypeCode(a.getAccountTypeCode());
             existing.setBalance(a.getBalance());
             repo.save(existing);
             
            
   
         }
           public void deleteAccountsSpq(Integer id) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteAccount");
        
        spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("idIN", id);
        
        spq.execute();
    }
           public void deleteAccountsJpa(Integer id) {
        repo.deleteById(id);
    }
    
    
    
    
    
    
    public List<Accounts> listAll() {
        return repo.findAll();
    }
    
     
    public void save(Accounts accounts) {
        repo.save(accounts);
    }
     
    public Accounts get(Integer account_id) {
        return repo.findById(account_id).get();
    }
     
    public void delete(Integer account_id) {
        repo.deleteById(account_id);
    }
    
    public List<Accounts> findAccountsByAccountname(String accountName){
        List<Accounts> result = repo.findAccountsByAccountname(accountName);
        if (CollectionUtils.isEmpty(result)){
            throw new NoResultException();
        }else{
             return result;
        }
       
    }
    public List DifferentCurrencies (Integer account_id){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("DifferentCurrencies");
        
        spq.registerStoredProcedureParameter("account_idIN", Integer.class, ParameterMode.IN);
        spq.setParameter("account_idIN", account_id);
        List result = spq.getResultList();
        if(CollectionUtils.isEmpty(result)){
            throw new NoResultException();
        }else{
            return result;
        }
    }
  
    
}
