/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filtersec.dao;

import com.mycompany.filtersec.model.Book;
import jakarta.ejb.Stateless;

@Stateless
public class BookDao extends AbstractDao<Book,Long> {
    public BookDao() {
        super(Book.class);
    } 
}
