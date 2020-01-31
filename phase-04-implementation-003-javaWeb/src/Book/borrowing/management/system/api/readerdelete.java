package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.Util;
import Book.borrowing.management.system.model.MessageJSONModel;
import Book.borrowing.management.system.model.ReaderModel;

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
		Util.setRequestResponseAccess(request, response);
		if (!Util.judgeusername(request, response) || !Util.judgeadmin(request, response))
			return;

		ReaderModel readerinfo;
		readerinfo = new ReaderModel(Util.getlanguage(request),request.getParameter("readerno"));
		MessageJSONModel ret = readerinfo.delReader();
		response.getWriter().append(JSON.toJSONString(ret));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("This Page isn't support POST");
	}

}
