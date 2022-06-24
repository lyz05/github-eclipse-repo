package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.BookDBCon;
import Book.borrowing.management.system.Util;
import Book.borrowing.management.system.model.UserModel;

/**
 * Servlet implementation class userinfo
 */
@WebServlet("/book/api/userinfo")
public class userinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Util.setRequestResponseAccess(request, response);
		if (!Util.judgeusername(request,response)) return;
		
		//获取用户名
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		//获取读者姓名
		String readername = BookDBCon.preparedqueryResult("select readerName from Reader where readerNO=?",username);
		UserModel userinfo = new UserModel(username,readername);
		response.getWriter().append(JSON.toJSONString(userinfo));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("This Page isn't support POST");
	}

}
