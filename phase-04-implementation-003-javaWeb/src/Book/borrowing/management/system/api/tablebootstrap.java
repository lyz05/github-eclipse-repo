package Book.borrowing.management.system.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import Book.borrowing.management.system.Util4Frm;
import Book.borrowing.management.system.model.BookModel;
import Book.borrowing.management.system.model.BorrowBookModel;
import Book.borrowing.management.system.model.ReaderModel;
import Book.borrowing.management.system.model.TableBootstrapModel;

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
		response.getWriter().append("This Page isn't support GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!Util4Frm.judgeusername(request,response)) return;
		
		String username = request.getSession().getAttribute("username").toString();
		String tableName = request.getParameter("table");
		//where处理
		String querysql=new String();
		if (tableName.equals("View_Book_Admin")) {
			BookModel bookinfo = new BookModel(Util4Frm.getlanguage(request),request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("price"),request.getParameter("publishdate"),request.getParameter("shopnum"));
			querysql = bookinfo.getSqlQueryString1();
		} else if (tableName.equals("View_Reader")) {
			ReaderModel readerinfo = new ReaderModel(Util4Frm.getlanguage(request),request.getParameter("readerno"),request.getParameter("readername"),request.getParameter("sex"),request.getParameter("idnum"),request.getParameter("workunit"));
			querysql = readerinfo.getSqlQueryString();
		} else if (tableName.equals("View_Book")) {
			boolean check;
			if ("on".equals(request.getParameter("check"))) check=true; else check=false;
			BorrowBookModel bookinfo = new BorrowBookModel(request.getParameter("bookno"),request.getParameter("bookname"),request.getParameter("author"),request.getParameter("press"),request.getParameter("publishdate_1"),request.getParameter("publishdate_2"),check,username);
			querysql = bookinfo.sqlQueryString();
		}
		//各种视图与表处理
		if (tableName.equals("Borrow")) {
			TableBootstrapModel BorrowTable = new TableBootstrapModel("select 图书编号,图书名称,作者,出版社,借书时间,应归还日期,归还日期 from View_Borrow where 读者编号='"+ username + "' and 归还日期 is null",tableName);
			response.getWriter().append(JSON.toJSONString(BorrowTable));
		} else if (tableName.equals("BorrowHistory")) {
			TableBootstrapModel BorrowHistoryTable = new TableBootstrapModel("select 图书编号,图书名称,作者,出版社,借书时间,应归还日期,归还日期 from View_Borrow where 读者编号='"+ username + "' and 归还日期 is not null",tableName);
			response.getWriter().append(JSON.toJSONString(BorrowHistoryTable));
		} else {
			TableBootstrapModel BookTable = new TableBootstrapModel("select * from "+tableName+querysql,tableName);
			response.getWriter().append(JSON.toJSONString(BookTable));
		}
	}
}
