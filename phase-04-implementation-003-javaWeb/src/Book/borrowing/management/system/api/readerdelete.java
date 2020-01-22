package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.BookDBCon;
import Book.borrowing.management.system.Util4Frm;
import Book.borrowing.management.system.model.MessageJSONModel;

/**
 * Servlet implementation class readerdelete
 */
@WebServlet("/book/api/readerdelete")
public class readerdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public readerdelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request, response))
			return;

		String readerNO = request.getParameter("readerno");
		String sql = "select * from View_reader where 读者编号=?";
		if (BookDBCon.preparedqueryResult(sql, readerNO) == null) {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("801", "此位读者不存在")));
			return;
		}
		sql = "select * from View_reader where 读者编号=? and 未归还数量=0";
		if (BookDBCon.preparedqueryResult(sql, readerNO) == null) {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("802", "该读者还有未归还的图书，因此无法删除该读者")));
			return;
		}
		sql = "delete from Borrow where readerNO=? and returnDate is not null";
		BookDBCon.preparedupdateData(sql, readerNO);
		sql = "delete from reader where readerNO=?";
		if (BookDBCon.preparedupdateData(sql, readerNO)) {
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("200","删除读者信息成功")));
		} else {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("403","删除读者信息失败")));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
