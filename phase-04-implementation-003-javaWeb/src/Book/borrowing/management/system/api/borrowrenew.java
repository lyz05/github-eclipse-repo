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
 * Servlet implementation class bookrenew
 */
@WebServlet("/book/api/borrowrenew")
public class borrowrenew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowrenew() {
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
		String sql = "update Borrow set shouldDate=date_add(NOW(), interval 1 MONTH) where readerNO=? and bookNO=? and returnDate is null";
		if (bookNO==null || session.getAttribute("username")==null) {
			//请求非法
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("602","请求非法")));
			return;
		}
		if(BookDBCon.preparedupdateData(sql,readerNO,bookNO)) {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("200","续借成功")));
		} else {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("200","续借失败")));
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
