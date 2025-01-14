/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.task1;

import java.math.BigDecimal;

/**
 *
 * @author m
 */
public class Account {
    private Long id;
    private String name;
    private String address;
    private BigDecimal balance;
    
    public Account(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.balance = new BigDecimal(0);
    }

    public Account(Long id, String name, String address, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name=" + name + ", address=" + address + ", balance=" + balance + '}';
    }
    
}
