<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.background {
	background: url(/static/imgs/pic002.jpg) no-repeat padding-box content-box;
	background-color: #000000;
	background-size: cover;
}
</style>
<script>
	function run(clickedObj) {
		var h = document.documentElement.clientHeight || document.body.clientHeight;
		var w = document.documentElement.clientWidth || document.body.clientWidth;
		//获取浏览器显示界面高度宽度
		$("#firstline").fadeOut('slow');
		$('#intr')[0].pause();
		$('#poem')[0].play();
		$('#poem-txt').fadeIn('slow');
		$(clickedObj).animate({
			width : '10px',
			opacity : '0.2',
			left : w-20,
			top : '20px'
		}, 15000);
		var o = $("#poem-txt");
		//alert(o.width());
		//alert(o.height());
		//获取诗词控件对象
		o.animate({
			left : w-o.width(),
			top : h-o.height()-10,
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
<title>The Wandering Earth</title>
<script src="/static/jquery.min.js"></script>
</head>
<body class="background">
	<audio id="intr" controls="controls"
		src="/static/audio/introduction.mp3" autoplay="autoplay"></audio>
	<audio id="poem" src="/static/audio/poem.mp3"
		preload="auto"></audio>
    <span id="firstline" style="font-size: 22px; color: white">大家好，我与这学期学习“软件工程导论”的学生们准备设计和实现一个“<span
		style="font-size: 38px; color: red">流浪地球</span>”的模拟工程！ 欢迎大家观赏,谢谢！点击屏幕左下角的地球，可以开始悲壮的流浪！！
	</span>
	<audio id="waiting" src="/static/audio/alwayswithme.mp3" preload="auto" onended="onWaitingAudioEnd();"></audio>
	<div id="poem-txt"
		style="display: none; font-size: 18px; color: red; position:absolute; left :10px;top:100px" >
		《南陵别儿童入京》<br /> <span style="font-size: 18px; color: grey">
			[唐] 李白 </span><br /> <br /> 白酒新熟山中归，黄鸡啄黍秋正肥。 <br /> 呼童烹鸡酌白酒，儿女嬉笑牵人衣。 <br /> 高歌取醉欲自慰，起舞落日争光辉。 <br /> 游说万乘苦不早，著鞭跨马涉远道。 <br /> 会稽愚妇轻买臣，余亦辞家西入秦。 <br /> 仰天大笑出门去，我辈岂是蓬蒿人。
	</div>
	<img src="/static/imgs/earth1.png"
		style="position: absolute; left: 10px; bottom: 10px; width: 150px"
		onclick="run(this);return false" 
		title="点击后，开始流浪 ！"
		/>
	<div id="moviebox" style="margin-top: 100px; display: none"
		align="center">
		<!--  
			<iframe src="//player.bilibili.com/player.html?aid=37343342&cid=65633682&page=1" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true" onended="onVideoEnd();" id="movie" height="300px" width="25%" > </iframe>
		-->
		<video id="movie" height="300px" controls="controls"
			src="/static/video/movie1.mp4" onended="onVideoEnd();" />
	</div>
	<div id="hornor" style="display:none;position:absolute;left:10x; bottom:10px;color:white;font-size:24px" align="center">2019年发生了很多大事，谨以此向<span style="color:red">《流浪地球》</span>和<span style="color:orange">华为公司</span>表示致敬 !  <br/>本网页未来将放在以下网站 sdlc.huaku-2019.xyz (华为公司的云服务器) <br/> huaku-2019, 2019 年，《流浪地球》 和华为很酷！ <br/>也许华为的崛起意味着，在人类未来需要流浪地球时，东方大国将作出巨大的贡献 ！</div>
</body>
</html>