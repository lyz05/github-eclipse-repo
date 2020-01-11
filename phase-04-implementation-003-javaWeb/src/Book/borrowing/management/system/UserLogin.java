package Book.borrowing.management.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/book/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // 设置相应内容类型
        response.setContentType("text/json;charset=utf-8");
        // 实例化输出流对象
        PrintWriter out = response.getWriter();
        //连接数据库，获取数据
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        Vector<String> name = new Vector<String>();
        BookDBCon.queryVector2("select 图书编号,图书名称,作者,出版社,借书时间,应归还日期,归还日期 from View_Borrow", data, name);
        //建立json对象
        out.println(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
