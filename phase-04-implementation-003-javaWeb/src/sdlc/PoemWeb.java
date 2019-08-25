package sdlc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PoemWeb {
	/*
	public  String poemTest="《南陵别儿童入京》<br /> <span style=\"font-size: 18px; color: grey\">\r\n" + 
    		"			[唐] 李白 </span><br /> \r\n" + 
    		"			<br /> 白酒新熟山中归，黄鸡啄黍秋正肥。 \r\n" + 
    		"			<br /> 呼童烹鸡酌白酒，儿女嬉笑牵人衣。\r\n" +
    		"           <br /> 高歌取醉欲自慰，起舞落日争光辉。\r\n" +
    		"           <br /> 游说万乘苦不早，著鞭跨马涉远道。\r\n" +
    		"           <br /> 会稽愚妇轻买臣，余亦辞家西入秦。\r\n" +
    		"           <br /> 仰天大笑出门去，我辈岂是蓬蒿人。";
    */
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/sdlc?useSSL=false&serverTimezone=UTC";
 
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "";
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PoemWeb poem=new PoemWeb();
	    //String poemText=poem.getPoemContent();
		PoemWeb poem=new PoemWeb();
		String poemText=poem.getPoemContent(1);
		System.out.print(poemText);
	}
    public String getPoemContent(int num) {
    	Connection conn = null;
        Statement stmt = null;
        String poemTest = "";
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, content FROM poem";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 展开结果集数据库
            int cnt = 0;
            while(rs.next()){
            	cnt ++;
                // 通过字段检索
                int id  = rs.getInt("id");
                String content = rs.getString("content");
    
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", content: " + content);
                System.out.print("\n");
                
                //读出诗词到变量
                if (cnt == num)
                {
                	poemTest = content;
                }
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    	return poemTest;
    }
}
//INSERT INTO `poem` VALUES ('1', '《南陵别儿童入京》<br /> <span style=\"font-size: 18px; color: grey\">[唐] 李白 </span><br /> <br /> 白酒新熟山中归，黄鸡啄黍秋正肥。<br /> 呼童烹鸡酌白酒，儿女嬉笑牵人衣。<br /> 高歌取醉欲自慰，起舞落日争光辉。<br /> 游说万乘苦不早，著鞭跨马涉远道。<br /> 会稽愚妇轻买臣，余亦辞家西入秦。<br /> 仰天大笑出门去，我辈岂是蓬蒿人。');
//INSERT INTO `poem` VALUES ('2', '《诗词版\"流浪地球\"》<br /> <span style=\"font-size: 18px; color: grey\">-郭鹏 </span><br /> <br /> 西风吹皱东方河，万年地球白发多。 <br /> 流浪星际家何去，满船清梦出银河。');