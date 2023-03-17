package daixin.dao.impl;

import daixin.Bean.Book;

import java.util.List;

public interface BookDao {
       int addBook(Book book);

       int deleteBook(int id);

       int updateBook(Book book);

       Book queryBookByid(int id);

       List<Book> queryBookByAll();

       int queryforPageCount();


       List<Book> queryforItems(int begin, int pageSize);

    int queryforPageCountByprice(int min,int max);

       List<Book> queryforItemsByPrice(int begin, int pageSize, int min, int max);
}
