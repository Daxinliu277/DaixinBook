package daixin.web;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        try {//匹配指定名称和参数的类的方法，此方法返回的Method对象
            Method declaredMethod = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//实例：   java中实例就是对象，是某个类的一个对象。类只是一个抽象的东西，对象才是实在的东东，所以叫实例。比如使用new Persion()创建的一个对象，也称为一个实例
            declaredMethod.setAccessible(true);

            declaredMethod.invoke(this, req, resp);//这里的this 就代表对象的实例  比如就是action得到的值是regist  那这里的this就会调用 这个regist这个方法

        } catch (Exception e) {
//            e.printStackTrace();
            throw new RuntimeException(e);//让filter接收到异常
        }

    }}

