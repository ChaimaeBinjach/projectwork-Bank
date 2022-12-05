/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pte.bank.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shayb
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByCustomerId", query = "SELECT c FROM Customers c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customers.findByLastName", query = "SELECT c FROM Customers c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customers.findByFirstName", query = "SELECT c FROM Customers c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customers.findByCustomerPhone", query = "SELECT c FROM Customers c WHERE c.customerPhone = :customerPhone"),
    @NamedQuery(name = "Customers.findByCustomerEmail", query = "SELECT c FROM Customers c WHERE c.customerEmail = :customerEmail"),
    @NamedQuery(name = "Customers.findByCheckingAccount", query = "SELECT c FROM Customers c WHERE c.checkingAccount = :checkingAccount"),
    @NamedQuery(name = "Customers.findBySavingsAccount", query = "SELECT c FROM Customers c WHERE c.savingsAccount = :savingsAccount")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "customer_phone")
    private int customerPhone;
    @Basic(optional = false)
    @Column(name = "customer_email")
    private String customerEmail;
    @Basic(optional = false)
    @Column(name = "checking_account")
    private String checkingAccount;
    @Basic(optional = false)
    @Column(name = "savings_account")
    private String savingsAccount;

    public Customers() {
    }

    public Customers(Integer customerId) {
        this.customerId = customerId;
    }

    public Customers(Integer customerId, String lastName, String firstName, int customerPhone, String customerEmail, String checkingAccount, String savingsAccount) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(String checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public String getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(String savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pte.bank.model.Customers[ customerId=" + customerId + " ]";
    }
    
}
