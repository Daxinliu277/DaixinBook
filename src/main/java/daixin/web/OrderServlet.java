package daixin.web;

import daixin.Bean.Car;
import daixin.Bean.Users;
import daixin.pojo.User;
import daixin.service.impl.OrderSeriverImpl;
import daixin.service.impl.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
    private OrderService orderService=new OrderSeriverImpl();

        protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Car shopCar = (Car) req.getSession().getAttribute("ShopCar");

           Users user= (Users) req.getSession().getAttribute("wolcomeTo");;
           if(user==null){
               req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
               return;
           }
            int id =user.getId();//sql未知问题  先用1替代
//            shopCar.getItemList().get();
            String s = orderService.create(shopCar, id);

            req.getSession().setAttribute("order",s);
            System.out.println(id);

//                req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
        }
}
