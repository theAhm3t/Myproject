/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.task2;

import com.mycompany.task2.model.Account;
import java.math.BigDecimal;
import java.util.List;
import com.mycompany.task2.repository.AccountRepository;

public class BankImpl implements Bank {
    
    private AccountRepository accountRepository;

    public BankImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Long createAccount(String name, String address) {
        Account a = accountRepository.findByNameAndAddress(name, address);
        if (a == null) {
            a = new Account(name, address, BigDecimal.ZERO);
            accountRepository.save(a);
        }
        return a.getId();
    }

    @Override
    public Long findAccount(String name, String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deposit(Long id, BigDecimal amount) {
        Account a = accountRepository.findById(id);
        if (a == null) {
            throw new AccountIdException();
        }
    }

    @Override
    public BigDecimal getBalance(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void withdraw(Long id, BigDecimal amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transfer(Long idSource, Long idDestination, BigDecimal amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }


    
}
