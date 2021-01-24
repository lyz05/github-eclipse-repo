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
     *
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
        //return true;
        //复杂请求跨域预指令不会携带cookies需要白名单放行
        if (request.getMethod().equals("OPTIONS"))
            return true;
        boolean flag = false;
        //黑名单机制
        if (user == null) {
            flag |= requestfilter(request, "Reader");
            flag |= requestfilter(request, "Table");
        } else if (user.hasRole("reader")) {
            flag |= requestfilter(request, "Book");
            flag |= requestfilter(request, "Reader");
            flag |= requestfilter(request, "User", "resetpwd");
        } else if (user.hasRole("admin")) {
            flag |= requestfilter(request, "Borrow");
        }

        if (flag) {
            //没有认证过
            if (user == null) response.setStatus(401);
            //认证过，但没有相应的权限
            else response.setStatus(403);
        }
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