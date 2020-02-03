package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import Book.borrowing.management.system.BookDBCon;
import Book.borrowing.management.system.Util;
import Book.borrowing.management.system.model.Msg;

/**
 * Servlet implementation class psdalter
 */
@WebServlet("/book/api/psdalter")
public class psdalter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public psdalter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.getWriter().append("This Page isn't support GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Util.setRequestResponseAccess(request, response);
		if (!Util.judgeusername(request,response)) return;
		
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String newpwd = request.getParameter("newpwd");
        String newpwd2 = request.getParameter("newpwd2");
        pwd = Util.encodeInp(pwd);
        newpwd = Util.encodeInp(newpwd);
        newpwd2 = Util.encodeInp(newpwd2);
        
        if (!newpwd.equals(newpwd2))
        {
        	response.getWriter().append(JSON.toJSONString(new Msg("403","confirmpwdfail",Util.getlanguage(request))));
            return;
        }
        if (BookDBCon.preparedqueryResult("select readerNO from Reader where readerNo=? and password=?", username,pwd) != null) {
            if (BookDBCon.preparedupdateData("update Reader set password=? where readerNo=?",newpwd,username)) {
            	response.getWriter().append(JSON.toJSONString(new Msg("200","alterpwdok",Util.getlanguage(request))));
            } else{
            	response.getWriter().append(JSON.toJSONString(new Msg("403","alterpwdfail",Util.getlanguage(request))));
            }
        } else {
        	response.getWriter().append(JSON.toJSONString(new Msg("403","loginerror",Util.getlanguage(request))));
        }
	}

}
