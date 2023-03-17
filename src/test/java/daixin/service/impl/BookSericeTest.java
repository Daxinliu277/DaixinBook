package daixin.service.impl;

import daixin.Bean.Book;
import daixin.Bean.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookSericeTest {
BookSerice bookSerice=new BookSericeImpl();
    @Test
    public void addBook() {
        bookSerice.addBook(new Book( null,"pengqiang的life","强子",new BigDecimal(5000),500,0,null));
    }

    @Test
    public void deleteBook() {
        bookSerice.deleteBook(26);
    }

    @Test
    public void updateBook() {
        bookSerice.updateBook(new Book(24,"强子的life","强子",new BigDecimal(5000),500,0,null));
    }

    @Test
    public void queryBookByid() {

        Book book = bookSerice.queryBookByid(24);
        System.out.println(book);
    }

    @Test
    public void queryBookByAll() {
        List<Book> books = bookSerice.queryBookByAll();
        books.forEach(System.out::println);
    }
    @Test
    public void page() {
        System.out.println(      bookSerice.page(8
                , Page.PAGE_SIZE));
    }
    @Test
    public void pageByprice() {
        System.out.println(      bookSerice.pageByprice(1,4,10,50));
    }

}