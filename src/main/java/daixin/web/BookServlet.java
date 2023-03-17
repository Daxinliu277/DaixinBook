package daixin.web;

import daixin.Bean.Book;
import daixin.Bean.Page;
import daixin.service.impl.BookSerice;
import daixin.service.impl.BookSericeImpl;
import daixin.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookSerice bookSerice = new BookSericeImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("PageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("PageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookSerice.page(pageNo, pageSize);

        page.setUrl("manager/bookSer?action=page");

        req.setAttribute("pages",page);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book maptobean = WebUtils.Maptobean(req.getParameterMap(), new Book());

        bookSerice.addBook(maptobean);

        resp.sendRedirect(req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/"
                + req.getContextPath() +"/manager/bookSer?action=page&PageNo="+req.getParameter("pageNo"));

    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = WebUtils.parseInt(req.getParameter("id"), 0);

        bookSerice.deleteBook(i);

        resp.sendRedirect(req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
                + "/" + req.getContextPath() +"/manager/bookSer?action=page&PageNo="+req.getParameter("PageNo"));

    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = WebUtils.parseInt(req.getParameter("id"), 0);

        Book book = bookSerice.queryBookByid(i);

        req.setAttribute("book",book);

        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book maptobean = WebUtils.Maptobean(req.getParameterMap(), new Book());

        bookSerice.updateBook(maptobean);

        resp.sendRedirect(req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +
                "/" + req.getContextPath()+"/manager/bookSer?action=page&PageNo="+req.getParameter("pageNo"));
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookSerice.queryBookByAll();

        req.setAttribute("book",books);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

}
