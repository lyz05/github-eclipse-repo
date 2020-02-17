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

import cc.home999.book.bean.User;

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
        User user = (User) session.getAttribute("user");
        if (user==null && !uri.endsWith("index.html")) {
        	//用户未登录(白名单)
        	response.sendRedirect(request.getContextPath()+"/index.html");
        	return;
        }
        if (user!=null) {
        	//读者访问管理员页面(黑名单)
        	if (user.getRole().equals("reader") && (uri.endsWith("readerinformation.html") || uri.endsWith("bookmanager.html"))) {
        		response.sendError(403);
        		return;
        	}
        	//管理员访问读者页面(黑名单)
        	if (user.getRole().equals("admin") && uri.endsWith("borrowinformation.html")) {
        		response.sendError(403);
        		return;
        	}
		}
    	chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

}

