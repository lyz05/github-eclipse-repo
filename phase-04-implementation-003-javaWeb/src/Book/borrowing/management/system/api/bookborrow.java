package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Book.borrowing.management.system.BookDBCon;

/**
 * Servlet implementation class bookborrow
 */
@WebServlet("/book/api/bookborrow")
public class bookborrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookborrow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String bookNO = request.getParameter("bookno");
		String readerNO = session.getAttribute("username").toString();
		String sql = "insert Borrow values(?,?,getdate(),dateadd(mm,1,getdate()),null)";
		if (bookNO==null || session.getAttribute("username")==null) {
			//����Ƿ�
			response.sendRedirect("../borrowinformation.jsp");
		}
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        if (Integer.parseInt(BookDBCon.preparedqueryResult("select �ڿ����� from View_Book where ͼ����=?",bookNO)) <= 0) {
        	response.getWriter().append("<script>alert('�Ȿ���Ѿ��������');window.location.href='../borrowinformation.jsp#tabs-3'</script>");
            return;
        }
        if (BookDBCon.preparedqueryResult("select readerNO from Borrow where readerNO=? and bookNO=? and returnDate is null",readerNO,bookNO) != null){
        	response.getWriter().append("<script>alert('�Ȿ�����Ѿ������');window.location.href='../borrowinformation.jsp#tabs-3'</script>");
            return;
        }
		if(BookDBCon.preparedupdateData(sql,readerNO,bookNO)) {
			response.getWriter().append("<script>alert('����ɹ�');window.location.href='../borrowinformation.jsp#tabs-3'</script>");
		} else {
			response.getWriter().append("<script>alert('����ʧ��');window.location.href='../borrowinformation.jsp#tabs-3'</script>");
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
