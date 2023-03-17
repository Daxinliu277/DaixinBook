package daixin.dao.impl;

import daixin.Bean.Book;

import java.util.List;

public class BookDaoimpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book( name , author , price , sales , stock , img_path ) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBook(int id) {
        String sql = "delete from t_book where id=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookByid(int id) {

        String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgpath from t_book where id=?";
        return queryforOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBookByAll() {
        String sql = "select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` imgpath from t_book";
        return queryforList(Book.class, sql);
    }

    @Override
    public int queryforPageCount() {
        String sql="select count(*) from t_book";
        Number num= (Number) queryforValue(sql);

        return num.intValue();

    }
    @Override
    public List<Book> queryforItems(int begin, int pageSize) {
        String sql="select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book limit ?,?";
        return queryforList(Book.class,sql,begin,pageSize);
    }

    @Override
    public int queryforPageCountByprice(int min, int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number num= (Number) queryforValue(sql,min,max);

        return num.intValue();
    }

    @Override//价格区间内的当前页面的数据
    public List<Book> queryforItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select id,`name` , `author` , `price` , `sales` , `stock`" +
                " , `img_path`  from t_book where price between ? and ? order by price limit ? ,?";
        return queryforList(Book.class,sql,min,max,begin,pageSize);
    }
}
