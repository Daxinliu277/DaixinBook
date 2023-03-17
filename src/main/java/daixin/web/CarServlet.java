package daixin.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import daixin.Bean.Book;
import daixin.Bean.Car;
import daixin.Bean.CarItem;
import daixin.service.impl.BookSerice;
import daixin.service.impl.BookSericeImpl;
import daixin.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CarServlet extends BaseServlet {
    private BookSerice bookSerice = new BookSericeImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Book book = bookSerice.queryBookByid(id);


        CarItem carItem = new CarItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Car car = (Car) req.getSession().getAttribute("ShopCar");

        if(car==null){
             car = new Car();//通过session域与其使用一个同一个购物车类
            req.getSession().setAttribute("ShopCar",car);
        }

        car.addItem(carItem);
        System.out.println(car);

        req.getSession().setAttribute("LastBook",carItem.getName());//为index页面添加最近加入---什么什么书的效果
                                                // 每调用一次就都会获取当前添加进去的书 再次添加就会覆盖上一本添加的书
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Book book = bookSerice.queryBookByid(id);

        CarItem carItem = new CarItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Car car = (Car) req.getSession().getAttribute("ShopCar");

        if(car==null){
            car = new Car();//通过session域与其使用一个同一个购物车类
            req.getSession().setAttribute("ShopCar",car);
        }
        Gson gson = new Gson();
        car.addItem(carItem);
        System.out.println(car);
        Integer totalCount = car.getTotalCount();
        String name = carItem.getName();
        Map <String,Object> map=new HashMap<String,Object>();
        map.put("totalCount",totalCount);
        map.put("lastBook",name);
        String gson1 = gson.toJson(gson);
        resp.getWriter().write(gson1);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Car car = (Car) req.getSession().getAttribute("ShopCar");

        if(car!=null){
            car.delete(id);

            resp.sendRedirect(req.getHeader("Referer"));
        }



//        resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
    }

    protected void clearShopCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Car car = (Car) req.getSession().getAttribute("ShopCar");

        if(car!=null){
           car.clear();

            resp.sendRedirect(req.getHeader("Referer"));
        }



//        resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
    }

    protected void UpdateValue(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        int count = WebUtils.parseInt(req.getParameter("count"), 1);


        Car car = (Car) req.getSession().getAttribute("ShopCar");

        if(car!=null){
            car.updateCount(id,count);

            resp.sendRedirect(req.getHeader("Referer"));
        }



//        resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
    }
}
