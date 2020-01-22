package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.NEW;

import Book.borrowing.management.system.BookDBCon;
import Book.borrowing.management.system.Util4Frm;
import Book.borrowing.management.system.model.MessageJSONModel;

/**
 * Servlet implementation class bookdelete
 */
@WebServlet("/book/api/bookdelete")
public class bookdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;

		String bookNO = request.getParameter("bookno");
		String sql = "select * from View_Book where ͼ����=?";
		if (BookDBCon.preparedqueryResult(sql,bookNO) == null) {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("701","�ñ�ͼ�鲻����")));
			return;
		}
		sql = "select * from View_Book where ͼ����=? and �ڿ�����=�������";
		if (BookDBCon.preparedqueryResult(sql,bookNO) == null)
		{
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("702","���ж���δ�黹�˱�ͼ�飬����޷�ɾ������")));
			return;
		}
		sql = "delete from Borrow where bookno=? and returnDate is not null";
        BookDBCon.preparedupdateData(sql,bookNO);
        sql = "delete from Book where bookNO=?";
        if (BookDBCon.preparedupdateData(sql,bookNO)) {
        	response.getWriter().append(JSON.toJSONString(new MessageJSONModel("200","ɾ��ͼ����Ϣ�ɹ�")));
		} else {
			response.getWriter().append(JSON.toJSONString(new MessageJSONModel("403","ɾ��ͼ����Ϣʧ��")));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("This Page isn't support POST");
	}

}
