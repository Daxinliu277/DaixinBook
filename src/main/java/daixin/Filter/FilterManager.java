package daixin.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FilterManager implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest servlet= (HttpServletRequest) servletRequest;
        Object wolcomeTo = servlet.getSession().getAttribute("wolcomeTo");

        if(wolcomeTo== null){
            servlet.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
