/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Book.borrowing.management.system;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 *
 * @author congcong
 * 数据库连接层
 */
public class BookDBCon {
    private static String DBdriver;
    private static String DBURL;
    private static String DBUSER;
    private static String DBPASS;
    private BookDBCon() {} //禁止实例化
    
    /**
     * 加载数据库配置文件
     */
    private static void loadConfig() {
    	ResourceBundle resource = ResourceBundle.getBundle("dbconfig");
    	DBdriver = resource.getString("jdbc.driverClass");
    	DBURL = resource.getString("jdbc.book.jdbcUrl");
    	DBUSER = System.getenv("MYSQL_USER");
    	DBPASS = System.getenv("MYSQL_PASS");
	}
    
    /**
     * 加载数据库驱动程序，以jdbc的方式连接数据库
     * @return 返回连接信息
     */
    private static Connection JdbcCon(){
    	loadConfig();
        try{
            //--2 加载数据库驱动程序
            Class.forName(DBdriver);
            //--3 创建连接
            Connection conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
            //System.out.println("数据库连接成功");
            return conn ;//返回创建的数据库连接对象
        }catch(ClassNotFoundException ex){//捕获驱动程序找不到异常
            ex.printStackTrace();
            System.out.println("数据库驱动程序加载失败");
            return null;
        }catch(SQLException ex){//捕获数据库连接失败异常
            ex.printStackTrace();
            System.out.println("数据库连接失败");
            return null;
        }
    }
    

    /** 
    * 查询数据库表的完整信息<br>
    * 主要用于jTable显示查询结果<br>
    * @param sql 查询对应的sql语句 
    * @param data 查询得到的每一条记录
    * @param name 查询得到的字段名
    */ 
    public static void queryVector2(String sql,Vector<Vector<String>> data,Vector<String> name){
        System.out.println(sql);
        data.clear();
        name.clear();
        Connection conn=JdbcCon();
        Statement stmt; //会话对象
        ResultSet rs; //结果集
        ResultSetMetaData metaData;  //列集
        try{
        	stmt=conn.createStatement();            //创建会话对象
            rs=stmt.executeQuery(sql);                  //执行SQL语句
            metaData = rs.getMetaData();            //获取列集
            int columnCount = metaData.getColumnCount(); //获取列的数量
            for (int i=1;i<=columnCount;i ++) 
                name.add(metaData.getColumnName(i));        //获取字段名
            // Vector ret=new Vector();
            //循环遍历
            while(rs.next()){
                Vector<String> line=new Vector<String>();
                for (int i=1;i<=columnCount;i ++)  {
                    String item = String.valueOf(rs.getString(i)).trim();
                    line.add(item);                       //添加一条数据并过滤首尾空格
                }
                data.add(line);   
            }
            //释放资源
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("查询数据失败");
            data = null;
            name = null;
        }
    }
    
    /** 
    * 预查询数据库表的完整信息<br>
    * 主要用于jTable显示查询结果<br>
    * @param presql 查询对应的sql语句 
    * @param data 查询得到的每一条记录
    * @param name 查询得到的字段名
    * @param content 查询参数
    */ 
    public static void preparedqueryVector2(String presql,Vector<Vector<String>> data,Vector<String> name,int... content){
        System.out.println(presql);
        data.clear();
        name.clear();
        Connection conn=JdbcCon();
        PreparedStatement pstmt; //预编译会话对象
        ResultSet rs; //结果集
        ResultSetMetaData metaData;  //列集
        try{
        	pstmt=conn.prepareStatement(presql);            //创建会话对象
            //设置参数
            for (int i=0;i<content.length;i ++)
            {
                pstmt.setInt(i+1, content[i]);
            }
            rs=pstmt.executeQuery();                  //执行SQL语句
            metaData = rs.getMetaData();            //获取列集
            int columnCount = metaData.getColumnCount(); //获取列的数量
            for (int i=1;i<=columnCount;i ++) 
                name.add(metaData.getColumnName(i));        //获取字段名
            // Vector ret=new Vector();
            //循环遍历
            while(rs.next()){
                Vector<String> line=new Vector<String>();
                for (int i=1;i<=columnCount;i ++)  {
                    String item = String.valueOf(rs.getString(i)).trim();
                    line.add(item);                       //添加一条数据并过滤首尾空格
                }
                data.add(line);   
            }
            //释放资源
            rs.close();
            pstmt.close();
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("查询数据失败");
            data = null;
            name = null;
        }
    }
    
    /**
     * 预编译查询数据的方法，查询数据库第一行第一个数据
     * @param presql 预编译sql语句
     * @param content 设置预编译sql语句参数，该参数为可变参数
     * @return 返回找到的结果，null表示没有结果 
     */
    public static String preparedqueryResult(String presql,String... content){
        System.out.println(presql);
        Connection conn=JdbcCon(); //连接数据库
        PreparedStatement pstmt; //预编译会话对象
        ResultSet rs;//结果集
        String ret;//返回结果
        try{
            //创建预编译会话对象
            pstmt=conn.prepareStatement(presql);
            //设置参数
            for (int i=0;i<content.length;i ++)
            {
                pstmt.setString(i+1, content[i]);
            }
           //执行SQL语句
            rs=pstmt.executeQuery();
            //跳转到第一行
            if(!rs.next()) return null;
            //获取第一列数据
            ret = rs.getString(1);
            //System.out.println(ret);
            //释放资源
            rs.close();
            pstmt.close();
            conn.close();
            return ret;
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("查询数据失败");
            return null;
        }
    }
    
    /**
     * 预编译执行数据添加、修改、删除数据方法
     * @param presql 预编译sql语句
     * @param content 设置预编译sql语句参数，该参数为可变参数
     * @return 是否成功执行sql语句
     */
    public static boolean preparedupdateData(String presql,String... content){
        System.out.println(presql);
        Connection conn=JdbcCon(); //连接数据库
        PreparedStatement pstmt; //会话对象
        try{
            //创建预编译会话对象
            pstmt=conn.prepareStatement(presql);
            //设置参数
            for (int i=0;i<content.length;i ++)
            {
                pstmt.setString(i+1, content[i]);
            }
            //执行SQL语句,数据表中受影响的行数
            int r=pstmt.executeUpdate(); //针对于insert,update和delete三种SQL语句
            //释放资源
            pstmt.close();
            conn.close();

            if(r>0){ //执行成功
                return true;
            }else{ //执行失败
                return false;
            }
           
        }catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null,"数据库抛出异常:"+ex.toString(),"数据库提示",JOptionPane.ERROR_MESSAGE);
            System.out.println("更新数据失败");
            return false;
        }
    }
}
