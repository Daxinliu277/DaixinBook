package daixin.dao.impl;

import daixin.Bean.Book;
import daixin.Bean.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {
    private BookDao book=new BookDaoimpl();
    @Test
    public void addBook() {
        book.addBook(new Book(null,"daixin的程序员之路","刘代鑫",new BigDecimal(99999),500,500,null));
    }

    @Test
    public void deleteBook() {

        book.deleteBook(20);

    }

    @Test
    public void updateBook() {
        String sql="update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";

        int i = book.updateBook(new Book(20,"人月神话", "代鑫", new BigDecimal(9999), 500, 0, null));

    }

    @Test
    public void queryBookByid() {
        Book book1 = book.queryBookByid(20);
        System.out.println(book1);
    }

    @Test
    public void queryBookByAll() {
        List<Book> books = book.queryBookByAll();

        books.forEach(System.out::println);
    }
    @Test
    public void querypagecount() {
        System.out.println(book.queryforPageCount());
    }
    @Test
    public void querypagecountbyprice() {
        System.out.println(book.queryforPageCountByprice(10,50));
    }
    @Test
    public void queryforitems() {
        List<Book> books = book.queryforItems(1, 4);
        books.forEach(System.out::println);

    }
    @Test
    public void queryforitemsbyprice() {
        List<Book> books = book.queryforItemsByPrice(0, 4,10,50);
        books.forEach(System.out::println);

    }


}