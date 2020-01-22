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
 * Servlet implementation class readerresetpwd
 */
@WebServlet("/book/api/readerresetpwd")
public class readerresetpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readerresetpwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;
		String readerno = request.getParameter("readerno");
        if (BookDBCon.preparedupdateData("update Reader set password='' where readerNo=?",readerno)) {
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("200","÷ÿ÷√√‹¬Î≥…π¶")));
        } else {
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("403","÷ÿ÷√√‹¬Î ß∞‹")));
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
