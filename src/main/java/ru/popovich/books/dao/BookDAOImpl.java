package ru.popovich.books.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.popovich.books.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

    //Создание фабрики сессий для соединиения с БД (сущность для создания сессий)
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addBook(Book book) {
        //получаем текущую сессию
        Session session = sessionFactory.getCurrentSession();
        //сохранение кники
        session.persist(book);

        logger.info("Информация о книге сохранена. Подробности: " + book);
    }

    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Информация о книге изменена. Подробности: " + book);
    }

    public void removeBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        if(book != null){
            session.delete(book);
        }
        logger.info("Информация о книге удалена: " + book);
    }

    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Информация о книге загружена. Подробности: " + book);
        return book;
    }

    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = sessionFactory.getCurrentSession();

        //ЗАМЕНИТЬ!!!!
        List<Book> bookList;
//        bookList = new ArrayList<Book>();
//        Book book1 = new Book();
//        book1.setId(0);
//        book1.setBookAuthor("Pushkin");
//        book1.setBookTitle("Onegin");
//        book1.setPrice(10);
//        bookList.add(book1);
//
//        Book book2 = new Book();
//        book2.setId(1);
//        book2.setBookAuthor("Lermontov");
//        book2.setBookTitle("Mtsiry");
//        book2.setPrice(11);
//        bookList.add(book2);
        bookList = session.createQuery("from Book").list();
//        Query query = session.createQuery("FROM Books");
//        bookList = query.list();

        for(Book book: bookList){
            logger.info("Book list: " + book);
        }
        return bookList;
    }
}
