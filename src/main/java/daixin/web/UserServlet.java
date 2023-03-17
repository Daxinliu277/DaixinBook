package daixin.web;

import com.google.gson.Gson;
import daixin.Bean.Users;
import daixin.service.impl.UserService;
import daixin.service.impl.UserService2;
import daixin.service.impl.UserServiceImpl;
import daixin.service.impl.UserServiceImpl2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class UserServlet extends BaseServlet {
    private UserService2 userService2 = new UserServiceImpl2();
    private UserService User = new UserServiceImpl();

    private void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
    private void Judge(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean b = User.existUsername(username);
        Map<String, Object> map = new HashMap<>();

        map.put("exist", b);

        Gson gson = new Gson();

        String s = gson.toJson(map);//转换为json对象

        resp.getWriter().write(s);
    }

        private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Users users = userService2.QueryforPasswordAndUsername(username, password);
        if (users == null) {
            System.out.println("用户不存在");
            req.setAttribute("loginmsg", "用户名或密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
             req.getSession().setAttribute("wolcomeTo",users);
//             req.getSession().setAttribute("Orderid",users.getId());
            System.out.println("登陆成功");

            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }

   private  void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String  coded= (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
       req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
       String username = req.getParameter("username");
       String password = req.getParameter("password");
       String email = req.getParameter("email");
       String code = req.getParameter("code");

        if (coded.equalsIgnoreCase(code) && code!=null) {
            if (User.existUsername(username)) {
                System.out.println("用户已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.setAttribute("msg", "用户已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);


            } else {

                System.out.println("登录成功");
                req.setAttribute("user",username);
                User.registUser(new Users(null,username, password, email));
                resp.sendRedirect(req.getContextPath()+"/pages/user/regist_success.jsp");//x
            }
        } else {
            System.out.println("验证码有误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

                req.setAttribute("msg", "验证码有误");



            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//
//        try {
//            Method declaredMethod = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
////实例：   java中实例就是对象，是某个类的一个对象。类只是一个抽象的东西，对象才是实在的东东，所以叫实例。比如使用new Persion()创建的一个对象，也称为一个实例
//            declaredMethod.invoke(this,req,resp);//这里的this 就代表对象的实例  比如就是action得到的值是regist  那这里的this就会调用 这个regist这个方法
//
//
//        } catch (Exception e) {
//      e.printStackTrace();
//
//    }
}
