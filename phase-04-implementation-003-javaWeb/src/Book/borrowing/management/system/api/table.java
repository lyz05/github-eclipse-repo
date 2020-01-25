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
import Book.borrowing.management.system.model.BorrowBookModel;
import Book.borrowing.management.system.model.BookModel;
import Book.borrowing.management.system.model.ReaderModel;
import Book.borrowing.management.system.model.TableModel;

/**
 * Servlet implementation class table
 */
@WebServlet("/book/api/table")
public class table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public table() {
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
		
		TableModel BookTable = new TableModel("select * from "+request.getParameter("table"),username,readername);
		response.getWriter().append(JSON.toJSONString(BookTable));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;
		
		String tableName = request.getParameter("table");
		//获取用户名
		HttpSession session = request.getSession(true);
		String username = session.getAttribute("username").toString();
		//获取读者姓名
		String readername = BookDBCon.preparedqueryResult("select readerName from Reader where readerNO=?",username);
		//where处理
		String querysql=new String();
		if (tableName.equals("View_Book_Admin")) {
			BookModel bookinfo = new BookModel(request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("price"),request.getParameter("publishdate"),request.getParameter("shopnum"));
			querysql = bookinfo.getSqlQueryString1();
		} else if (tableName.equals("View_Reader")) {
			ReaderModel readerinfo = new ReaderModel(request.getParameter("readerno"),request.getParameter("readername"),request.getParameter("sex"),request.getParameter("idnum"),request.getParameter("workunit"));
			querysql = readerinfo.getSqlQueryString();
		} else if (tableName.equals("View_Book")) {
			boolean check;
			if ("on".equals(request.getParameter("check"))) check=true; else check=false;
			BorrowBookModel bookinfo = new BorrowBookModel(request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("publishdate_1"),request.getParameter("publishdate_2"),check,username);
			querysql = bookinfo.getSqlQueryString();
		}
		//order by处理
		String orderby=new String("");
		String ordersql = new String("");
		if (request.getParameter("orderby")!=null) {
			orderby = request.getParameter("orderby");
			if (session.getAttribute("sort")==null || session.getAttribute("sort").toString().equals(""))
			{
				session.setAttribute("sort", "desc");
			} else session.setAttribute("sort", "");
			ordersql = " order by "+orderby+" "+session.getAttribute("sort");
		}
		//各种视图与表处理
		if (tableName.equals("Borrow")) {
			TableModel BorrowTable = new TableModel("select 图书编号,图书名称,作者,出版社,借书时间,应归还日期,归还日期 from View_Borrow where 读者编号='"+ username + "' and 归还日期 is null"+ordersql, username, readername);
			response.getWriter().append(JSON.toJSONString(BorrowTable));
		} else if (tableName.equals("BorrowHistory")) {
			TableModel BorrowHistoryTable = new TableModel("select 图书编号,图书名称,作者,出版社,借书时间,应归还日期,归还日期 from View_Borrow where 读者编号='"+ username + "' and 归还日期 is not null"+ordersql, username, readername);
			response.getWriter().append(JSON.toJSONString(BorrowHistoryTable));
		} else {
			TableModel BookTable = new TableModel("select * from "+tableName+querysql+ordersql,username, readername);
			response.getWriter().append(JSON.toJSONString(BookTable));
		}
	}

}
