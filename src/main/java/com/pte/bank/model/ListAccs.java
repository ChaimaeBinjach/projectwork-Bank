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
@Table(name = "list_accs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListAccs.findAll", query = "SELECT l FROM ListAccs l"),
    @NamedQuery(name = "ListAccs.findByBankId", query = "SELECT l FROM ListAccs l WHERE l.bankId = :bankId"),
    @NamedQuery(name = "ListAccs.findByCustomersId", query = "SELECT l FROM ListAccs l WHERE l.customersId = :customersId"),
    @NamedQuery(name = "ListAccs.findByAccountsId", query = "SELECT l FROM ListAccs l WHERE l.accountsId = :accountsId")})
public class ListAccs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bank_id")
    private Integer bankId;
    @Basic(optional = false)
    @Column(name = "customers_id")
    private int customersId;
    @Basic(optional = false)
    @Column(name = "accounts_id")
    private int accountsId;

    public ListAccs() {
    }

    public ListAccs(Integer bankId) {
        this.bankId = bankId;
    }

    public ListAccs(Integer bankId, int customersId, int accountsId) {
        this.bankId = bankId;
        this.customersId = customersId;
        this.accountsId = accountsId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public int getCustomersId() {
        return customersId;
    }

    public void setCustomersId(int customersId) {
        this.customersId = customersId;
    }

    public int getAccountsId() {
        return accountsId;
    }

    public void setAccountsId(int accountsId) {
        this.accountsId = accountsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankId != null ? bankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListAccs)) {
            return false;
        }
        ListAccs other = (ListAccs) object;
        if ((this.bankId == null && other.bankId != null) || (this.bankId != null && !this.bankId.equals(other.bankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pte.bank.model.ListAccs[ bankId=" + bankId + " ]";
    }
    
}
