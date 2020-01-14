package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Book.borrowing.management.system.*;

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
		HttpSession session = request.getSession(true);
		response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        pwd = Util4Frm.encodeInp(pwd);
		//System.out.println(username+"\t"+pwd);
		
        if (BookDBCon.preparedqueryResult("select readerNO from Reader where readerNo=? and password=?", username,pwd) != null) {
        	session.setAttribute("username", username);
        	//进入到主界面
        	response.sendRedirect("../borrowinformation.jsp");
        }else if (BookDBCon.preparedqueryResult("select username from AdminUsers where username=? and password=?", username,pwd) != null){
        	session.setAttribute("username", username);
        	//进入到管理员选择界面后跳转到指定页面
            response.getWriter().print("<script>var res=confirm('您好，管理员\\n确定 进入图书管理界面\\n取消 进入读者管理界面');\nif(res==true)\nwindow.location.href='../bookmanager.jsp';\n else window.location.href='../readerinformation.jsp';</script>");
        } else response.getWriter().append("<script>alert('用户名或密码错误');window.location.href='../index.jsp'</script>");
	}

}
