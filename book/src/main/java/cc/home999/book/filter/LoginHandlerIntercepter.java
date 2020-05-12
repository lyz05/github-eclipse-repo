package cc.home999.book.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.home999.book.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandlerIntercepter implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    /**
     * 后端接口权限认证
     * @param request
     * @param response
     * @param arg2
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String requestURI = request.getRequestURI();
        System.out.println("MVC:" + requestURI);
        //System.out.println("MVC Context Path:" + request.getContextPath());
        boolean flag = false;
        if (user == null) {
            flag |= requestfilter(request, "Book");
            flag |= requestfilter(request, "Borrow");
            flag |= requestfilter(request, "Reader");
            flag |= requestfilter(request, "Table");
            flag |= requestfilter(request, "User","psdalter");
            flag |= requestfilter(request, "User","userinfo");
            flag |= requestfilter(request, "User","resetpwd");
        } else if (user.hasRole("reader")) {
            flag |= requestfilter(request, "Book");
            flag |= requestfilter(request, "Reader");
            flag |= requestfilter(request, "Table" , "bookadmins");
            flag |= requestfilter(request, "Table" , "readeradmins");
            flag |= requestfilter(request, "User","resetpwd");
        } else if (user.hasRole("admin")) {
            flag |= requestfilter(request, "Borrow");
            flag |= requestfilter(request, "User","resetpwd");
        }
        if (flag) response.sendError(403,"Permission denied");
        return !flag;
    }

    private boolean requestfilter(HttpServletRequest request, String... args) {
        String URI = request.getRequestURI();
        String str = request.getContextPath();
        for (String arg : args) {
            str += "/" + arg;
        }
        return URI.startsWith(str);
    }
}