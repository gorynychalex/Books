package ru.popovich.books.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.popovich.books.dao.BookDAO;
import ru.popovich.books.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookDAO bookDAO;

    @Transactional
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Transactional
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Transactional
    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    @Transactional
    public void removeBook(int id) {
        this.bookDAO.removeBook(id);
    }

    @Transactional
    public Book getBookById(int id) {

        return this.bookDAO.getBookById(id);
    }

    @Transactional
    public List<Book> listBooks() {
        return this.bookDAO.listBooks();
    }
}
