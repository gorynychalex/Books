package ru.popovich.books.dao;

import ru.popovich.books.model.Book;

import java.util.List;

//Определение основных методов для задания действий над списком книг

public interface BookDAO {
    public void addBook(Book book);
    public void updateBook(Book book);
    public void removeBook(int id);

    //Метод получения книги по идентификатору
    public Book getBookById(int id);

    //Метод вывода списка книг
    public List<Book> listBooks();
}
