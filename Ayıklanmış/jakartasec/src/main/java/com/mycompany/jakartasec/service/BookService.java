package com.mycompany.jakartasec.service;

import com.mycompany.jakartasec.dao.BookDao;
import com.mycompany.jakartasec.model.Book;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;


/**
 * Service layer, may contain additional logic, in this case only forwards to BookDao.
 */
@Stateless
public class BookService {
    @EJB
    private BookDao bookDao;

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @RolesAllowed({"ROLE_USER"})
    public void save(Book book) {
        bookDao.save(book);
    }

    @RolesAllowed({"ROLE_USER"})
    public void remove(Long bookId) {
        bookDao.remove(bookId);
    }
}
