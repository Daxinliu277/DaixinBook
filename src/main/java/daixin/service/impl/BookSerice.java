package daixin.service.impl;

import daixin.Bean.Book;
import daixin.Bean.Page;

import java.util.List;

public interface BookSerice<T> {
    void addBook(Book book);

   void deleteBook(int id);

    void updateBook(Book book);

    Book queryBookByid(int id);

    List<Book> queryBookByAll();

    Page<T> page(int pageNo, int pageSize);

    Page<Book> pageByprice(int pageNo, int pageSize, int min, int max);
}
