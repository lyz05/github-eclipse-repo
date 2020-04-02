<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="sdlc.*"%>
<%
    String titleZH = "流浪地球";
	String titleEN = "The Wandering Earth";
	PoemWeb poem=new PoemWeb();
    String poemText = poem.getPoemContent(1);
%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			.background {
				background: url(static/imgs/pic002.jpg) no-repeat padding-box content-box;
				background-color: #000000;
				background-size: cover;
			}    
	        html{height:100%;}
	        body{min-height:100%;margin:0;padding:0;position:relative;}
	
	        .footer{
	        	position:absolute;
	        	bottom:0;
	        	width:100%;
	        	height:50px;
	        	text-align:center;
	        	font-size:16px;
	        	color: white;
	        	
	        }
		</style>
		<script src="static/jquery.min.js"></script>
		<script src="static/js/websocket.js"></script>
		<script>
			function run(clickedObj) {
				//隐藏inputinformation,link,firstline
				$('#inputinformation').hide();
				$('#link').fadeOut('slow');
				$("#firstline").fadeOut('slow');
				//获取浏览器显示界面高度宽度
				var h = document.documentElement.clientHeight || document.body.clientHeight;
				var w = document.documentElement.clientWidth || document.body.clientWidth;
				
				$('#intr')[0].pause();
				$('#poem')[0].play();
				$('#poem-txt').fadeIn('slow');
				$(clickedObj).animate({
					width : '10px',
					opacity : '0.2',
					left : w-20,
					top : '20px'
				}, 15000);
				var obj = $("#poem-txt");			//获取诗词控件对象
				obj.animate({
					left : w-obj.width(),
					top : h-obj.height()-10,
				}, 15000);
				//alert(w);
				//$('#waiting')[0].play();
				$("#moviebox").show('slow');
				$("#movie")[0].play();
			}
			function onVideoEnd(){
				$("#moviebox").fadeOut('slow');
				$("#hornor").fadeIn('slow');
				$("#hornor").animate({
					fontSize : '30px',
				    top:  '25%',
				    left: '50px'
				}, 3000);
				$('#poem-txt').fadeOut('slow');	
				$('#poem-txt').animate({
					bottom : '100px',
					right : '100px'
				}, 18000);
		
				$('#waiting')[0].play();
			}
			function onWaitingAudioEnd(){
				$('#intr')[0].play();	
			}
	</script>
	<meta charset="UTF-8">
	<title><%=titleEN %></title>
</head>

<body class="background" onload="connect();">
	<audio id="intr" controls="controls"
		src="static/audio/introduction.mp3" autoplay="autoplay">
	</audio>
	<audio id="poem" src="static/audio/poem.mp3"
		preload="auto">
	</audio>
	
	<div id="link" style="display:block;color:white;">
	<p>	<a href="hello.jsp" style="font-size:20px" >跳转hello JSP</a> <br>
	 	<a href="WanderingServlet" style="font-size:20px" >跳转WanderingServlet</a> <br>
	 	<a href="chat" style="font-size:20px" >跳转聊天室</a> <br>
	 	<a href="book" style="font-size:20px" >跳转图书借阅系统</a><br>
	</p>
	</div>
    
    <span id="firstline" style="font-size: 22px; color: white">大家好，我与这学期学习“软件工程导论”的学生们准备设计和实现一个“<span
		style="font-size: 38px; color: red"><%=titleZH %></span>”的模拟工程！ 欢迎大家观赏,谢谢！点击屏幕左下角的地球，可以开始悲壮的流浪！！
	</span>
	
	<div id="inputinformation" style="display:block;color:white;">
		<jsp:include page = "inputinformation.jsp" />
	</div>

	<audio id="waiting" src="static/audio/alwayswithme.mp3" preload="auto" onended="onWaitingAudioEnd();"></audio>
	
	<div id="poem-txt"
		style="display: none; font-size: 18px; color: red; position:absolute; left :10px;top:100px" >
		<%=poemText%>
	</div>
	
	<img src="static/imgs/earth1.png"
		style="position: absolute; left: 10px; bottom: 10px; width: 150px"
		onclick="run(this);return false" 
		title="点击后，开始流浪 ！"
		/>
	
	<div id="moviebox" style="margin-top: 200px; display: none"
		align="center">
		<!--  
			<iframe src="//player.bilibili.com/player.html?aid=37343342&cid=65633682&page=1" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true" onended="onVideoEnd();" id="movie" height="300px" width="25%" > </iframe>
		-->
		<video id="movie" height="300px" controls="controls"
			src="static/video/movie1.mp4" onended="onVideoEnd();" >
		</video>
	</div>
	
	<div id="hornor" style="display:none;position:absolute;left:10x; bottom:10px;color:white;font-size:24px" align="center">2019年发生了很多大事，谨以此向<span style="color:red">《流浪地球》</span>和<span style="color:orange">华为公司</span>表示致敬 !  <br/>本网页未来将放在以下网站 sdlc.huaku-2019.xyz (华为公司的云服务器) <br/> huaku-2019, 2019 年，《流浪地球》 和华为很酷！ <br/>也许华为的崛起意味着，在人类未来需要流浪地球时，东方大国将作出巨大的贡献 ！</div>
<!-- 显示服务器时间及在线人数信息 -->
<div class="footer" id="footer"></div>
</body>
</html>
