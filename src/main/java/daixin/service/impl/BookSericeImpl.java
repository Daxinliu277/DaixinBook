package daixin.service.impl;

import daixin.Bean.Book;
import daixin.Bean.Page;
import daixin.dao.impl.BookDao;
import daixin.dao.impl.BookDaoimpl;

import java.util.List;

public class BookSericeImpl implements BookSerice {
    private BookDao bookDao = new BookDaoimpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookByid(int id) {
        return bookDao.queryBookByid(id);
    }

    @Override
    public List<Book> queryBookByAll() {
        return bookDao.queryBookByAll();
    }

    @Override
    public Page page(int pageNo, int pageSize) {
        Page<Book> pages = new Page<Book>();

//每页显示多少页
        pages.setPageSize(pageSize);
//获取数据的存在的数量
        int PageCount = bookDao.queryforPageCount();
        pages.setPageCount(PageCount);
//页面的数量
        int PageTotal = PageCount / pageSize;
        if (PageCount / pageSize > 0) {
            PageTotal++;
        }
        pages.setPageTotal(PageTotal);
        //获取在多少页
        pages.setPageNo(pageNo);

        int begin = (pages.getPageNo() - 1) * pages.PAGE_SIZE;//每页的获取跟req。getDisRequest息息相关
        //查询本页显示的数据  每进入一次就会计算一次这个本页显示的数据       当pageNo=3时 将会进入这边的公式 (3-1)x4=8  limit=8,4
        List<Book> items = bookDao.queryforItems(begin, pageSize);

        pages.setItems(items);

        return pages;
    }

    @Override
    public Page<Book> pageByprice(int pageNo, int pageSize, int min, int max) {
        Page<Book> pages = new Page<Book>();

//获取每页显示数量
        pages.setPageSize(pageSize);
//获取在这个大小范围内的总页数
        int PageCount = bookDao.queryforPageCountByprice(min, max);
        pages.setPageCount(PageCount);

//设置总页码  总页数/每页显示的页数=每显示4页的个数
        int PageTotal = PageCount / pageSize;
        if (PageCount / pageSize > 0) {//当页面除不净时 就代表还有数据在其他页面
            PageTotal++;
        }
        pages.setPageTotal(PageTotal);
        //获取在多少页 这个写pageTotal后面的原因是  为了后面越界做准备 因为需要用到pageTotal这个参数
        pages.setPageNo(pageNo);

        int begin = (pages.getPageNo() - 1) * pages.PAGE_SIZE;
        //查询本页显示的数据
        List<Book> items = bookDao.queryforItemsByPrice(begin, pageSize, min, max);

        pages.setItems(items);

        return pages;
    }
}
