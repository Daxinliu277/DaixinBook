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

public class ClientBookServlet extends BaseServlet{

    private BookSerice bookSerice = new BookSericeImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("PageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("PageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookSerice.page(pageNo, pageSize);
        page.setUrl("client/bookSer?action=page");

        req.setAttribute("pages",page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    private void pageByPrice (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("PageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("PageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        StringBuilder stringBuilder = new StringBuilder("client/bookSer?action=pageByPrice");

        if(req.getParameter("min")!=null){//如果获取到了这个min的参数就把他追加到 这个StirngBuilder中
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }

        Page<Book> page = bookSerice.pageByprice(pageNo, pageSize,min,max);
        page.setUrl(stringBuilder.toString());
//        page.setUrl("client/bookSer?action=pageByPrice&min="+req.getParameter("min")+"&max="+req.getParameter("max"));

        req.setAttribute("pages",page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
