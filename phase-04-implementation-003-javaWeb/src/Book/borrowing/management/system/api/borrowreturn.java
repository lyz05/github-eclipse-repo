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
import Book.borrowing.management.system.model.MessageJSONModel;


/**
 * Servlet implementation class bookreturn
 */
@WebServlet("/book/api/borrowreturn")
public class borrowreturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowreturn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;

		HttpSession session = request.getSession(true);
		String bookNO = request.getParameter("bookno");
		String readerNO = session.getAttribute("username").toString();
		String sql = "update Borrow set returnDate=now() where readerNO=? and bookNO=? and returnDate is null";
		if (bookNO==null || session.getAttribute("username")==null) {
			//请求非法
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("602","请求内容或格式非法")));
			return;
		}
		
		if(BookDBCon.preparedupdateData(sql,readerNO,bookNO)) {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("200","还书成功")));
		} else {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("403","还书失败")));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("This Pages isn't support Post");
	}

}
