package org.gradle.demo.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * A Servlet filter is an object that can intercept HTTP requests targeted at your web application.
 *
 * A servlet filter can intercept requests both for servlets, JSP's, HTML files or other static content.
 *
 * http://tutorials.jenkov.com/java-servlets/servlet-filters.html
 */
public class SimpleServletFilter implements Filter {
    protected String myParam = null;
    /**
     * When the servlet filter is loaded the first time, its init() method is called, just like with servlets.
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.myParam = filterConfig.getInitParameter("filterInitParam");
        System.out.println(this.myParam);
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        String myParam = request.getParameter("block");

        if(!"true".equals(myParam)){
            filterChain.doFilter(request, response);
            return;
        }

        response.getWriter().write("a different response... e.g in HTML");
    }

    public void destroy() {
    }
}

