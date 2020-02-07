package cc.home999.book.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter{

    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        if (session.getAttribute("user")==null && !uri.endsWith("index.html")) {
        	response.sendRedirect(request.getContextPath()+"/index.html");
        } else {
        	chain.doFilter(request, response);
		}
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

}

