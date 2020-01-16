package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Book.borrowing.management.system.BookDBCon;
import Book.borrowing.management.system.Util4Frm;

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
        	Util4Frm.showMessageDialogAndReturn(response,"÷ÿ÷√√‹¬Î≥…π¶","../readerinformation.jsp");
        } else {
        	Util4Frm.showMessageDialogAndReturn(response,"÷ÿ÷√√‹¬Î ß∞‹","../readerinformation.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
