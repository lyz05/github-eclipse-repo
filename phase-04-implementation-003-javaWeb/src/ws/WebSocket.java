package ws;
 
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.text.SimpleDateFormat; 
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
 
/**
 * @ServerEndpoint 注解标识该类是websocket类
 */
@ServerEndpoint("/WebSocket")
public class WebSocket {
	
	//初始在线人数
    private static int online_num = 0;
    //线程安全的socket集合
    private static ArrayList<WebSocket> sockets = new ArrayList<WebSocket>();
    //会话
    private Session session;
    //服务器时间线程
    ServerThread theard = new ServerThread();
    
	/**
	 *
	 * 
	 * @param session
	 * 当有客户端与服务器建立连接时调用
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		online_num ++;
		sockets.add(this);
		System.out.println("Hello Connect:"+session);
		theard.start();
		theard.exit=false;
	}
 
	/**
	 *与服务器连接关闭时调用
	 */
	@OnClose
	public void onClose() {
		theard.exit = false;
		online_num --;
		sockets.remove(this);
		System.out.println("Session:"+session+",Connection close.");
	}
 
	/**
	 *
	 * 
	 * @param message 
	 * @param session
	 * 收到来自客户端的消息时调用，session保存发送消息的客户端信息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		
		System.out.println("Resive Message:"+message);
		System.out.println("Resive Session:"+session);
	}
 
	/**
	 *发生错误时调用
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
	}
 
	public void sendMessage(String message) {
		session.getAsyncRemote().sendText(message);
	}
	
	class ServerThread extends Thread {
		public volatile boolean exit = false; 
		@Override
		public void run() {
			try {
				while (!exit)
				{
					Date now = new Date(); 
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
					String time = dateFormat.format( now );
					sendMessage("当前在线人数："+online_num+"\n服务器当前时间:"+time);
					System.out.println("Session:"+session);
					TimeUnit.MILLISECONDS.sleep(1000);//MILLISECONDS表示以毫秒为单位延时
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Interrupted");
			}
			
		}
	}
}
