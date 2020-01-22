package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.*;
import Book.borrowing.management.system.model.MessageJSONModel;

/**
 * Servlet implementation class login
 */
@WebServlet("/book/api/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("This Pages isn't support GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("application/json;charset=utf-8");
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        pwd = Util4Frm.encodeInp(pwd);
		//System.out.println(username+"\t"+pwd);
		
        if (BookDBCon.preparedqueryResult("select readerNO from Reader where readerNo=? and password=?", username,pwd) != null) {
        	session.setAttribute("username", username);
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("603","读者登录成功")));
        } else if (BookDBCon.preparedqueryResult("select username from AdminUsers where username=? and password=?", username,pwd) != null){
        	session.setAttribute("username", username);
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("604","管理员登录成功")));
        	//进入到管理员选择界面后跳转到指定页面
        } else response.getWriter().append(JSON.toJSONString(new MessageJSONModel("403","用户名或密码错误")));
	}

}
