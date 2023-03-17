package daixin.web;

import daixin.Bean.Users;
import daixin.service.impl.UserService;
import daixin.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserRegist extends HttpServlet {
    private UserService User = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abcde".equalsIgnoreCase(code)) {

            if (User.existUsername(username)) {
                System.out.println("用户已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.setAttribute("msg", "用户已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);


            } else {

                System.out.println("chengg");
                User.registUser(new Users(null,username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);//x
            }
        } else {
            System.out.println("验证码有误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.setAttribute("msg", "验证码有误");


            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);


        }
    }
}
