package daixin.Filter;


import daixin.utils.jdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class FilterTransaction implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest, servletResponse);
            jdbcUtils.CloseAndCommit();
        } catch (Exception e) {
            jdbcUtils.CloseAndRollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
