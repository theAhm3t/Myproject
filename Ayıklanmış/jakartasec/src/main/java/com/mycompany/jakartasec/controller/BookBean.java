/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jakartasec.controller;

import com.mycompany.jakartasec.model.Book;
import java.io.Serializable;
import java.util.List;

import com.mycompany.jakartasec.service.BookService;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class BookBean implements Serializable {    
    @EJB
    private BookService bookService;
    
    private Book newBook = new Book();

    public List<Book> getBooks() {
        return bookService.findAll();
    }
    
    public void onRemoveBook(Book b) {
        bookService.remove(b.getId());
    }

    public void onBookAdd() {
        newBook = new Book();
    }
    
    public void onBookAdded() {
        bookService.save(newBook);
        PrimeFaces.current().executeScript("PF('BookDlg').hide()");
    }  

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }   
}
