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
		Util.setRequestResponseAccess(request, response);
		
		HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        String language = request.getParameter("language");
        pwd = Util.encodeInp(pwd);
        
        //����session
    	session.setAttribute("username", username);
    	session.setAttribute("language", language);
        if (BookDBCon.preparedqueryResult("select readerNO from Reader where readerNo=? and password=?", username,pwd) != null) {
        	session.setAttribute("role", "reader");
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("603","���ߵ�¼�ɹ�")));
        } else if (BookDBCon.preparedqueryResult("select username from AdminUsers where username=? and password=?", username,pwd) != null){
        	session.setAttribute("role", "admin");
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("604","����Ա��¼�ɹ�")));
        	//���뵽����Աѡ��������ת��ָ��ҳ��
        } else {
        	session.setAttribute("username", null);
        	session.setAttribute("language", null);
        	session.setAttribute("role", null);
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("403","loginerror",language)));
        }
	}

}
