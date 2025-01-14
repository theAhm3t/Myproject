/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.task2;

import com.mycompany.task2.model.Account;
import com.mycompany.task2.repository.AccountRepositoryImpl;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankImplTest {
    
    private BankImpl bank;
    private AccountRepositoryImpl accountRepository;
    
    public BankImplTest() {
    }

    @BeforeEach // invoked before each method with @Test annotation
    public void beforeTestMethod() {
        accountRepository = new AccountRepositoryImpl();
        bank = new BankImpl(accountRepository);
    }

    @AfterEach
    public void afterTestMethod() {
        for (Account a : accountRepository.findAll()) {
            accountRepository.delete(a.getId());
        }
    }
    
    @Test
    public void createAccountTest() {
        Long id1 = bank.createAccount("name1", "address1");
        assert id1 != null;
        Long id2 = bank.createAccount("name2", "address2");
        assert id2 != null;
    }
    
    @Test
    public void depositTest1() { 
        Assertions.assertThrows(
            Bank.AccountIdException.class,
            ()->{
                bank.deposit(1L, new BigDecimal(0));
            }
        ); 
    }
    
}
