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
	    // ������Ӧ��������
        response.setContentType("text/json;charset=utf-8");
        // ʵ�������������
        PrintWriter out = response.getWriter();
        //�������ݿ⣬��ȡ����
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        Vector<String> name = new Vector<String>();
        BookDBCon.queryVector2("select ͼ����,ͼ������,����,������,����ʱ��,Ӧ�黹����,�黹���� from View_Borrow", data, name);
        //����json����
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
