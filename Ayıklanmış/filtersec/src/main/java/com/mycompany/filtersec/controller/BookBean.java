/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filtersec.controller;

import com.mycompany.filtersec.dao.BookDao;
import com.mycompany.filtersec.model.Book;
import java.io.Serializable;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class BookBean implements Serializable {    
    @EJB
    private BookDao dao;
    
    private Book newBook = new Book();

    public List<Book> getBooks() {
        return dao.findAll();
    }
    
    public void onRemoveBook(Book b) {
        dao.remove(b.getId());
    }

    public void onBookAdd() {
        newBook = new Book();
    }
    
    public void onBookAdded() {
        dao.save(newBook);
        PrimeFaces.current().executeScript("PF('BookDlg').hide()");
    }  

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }   
}
