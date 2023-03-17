package daixin.web;

import daixin.service.impl.UserService2;
import daixin.service.impl.UserServiceImpl2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLogin extends HttpServlet {
    private UserService2 userService2 = new UserServiceImpl2();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService2.QueryforPasswordAndUsername(username, password) == null) {
            System.out.println("用户不存在");
            req.setAttribute("loginmsg","用户名或密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            System.out.println("登陆成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
}
