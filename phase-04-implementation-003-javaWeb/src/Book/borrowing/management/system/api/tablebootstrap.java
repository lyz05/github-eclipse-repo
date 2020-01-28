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
import Book.borrowing.management.system.Util4Frm;
import Book.borrowing.management.system.model.TableBootstrapModel;
import Book.borrowing.management.system.model.TableModel;

/**
 * Servlet implementation class tablebootstrap
 */
@WebServlet("/book/api/tablebootstrap")
public class tablebootstrap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tablebootstrap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;
		
		//获取用户名
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		//获取读者姓名
		String readername = BookDBCon.preparedqueryResult("select readerName from Reader where readerNO=?",username);
		
		TableBootstrapModel BookTable = new TableBootstrapModel("select * from View_Book_Admin");
		response.getWriter().append(JSON.toJSONString(BookTable));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
