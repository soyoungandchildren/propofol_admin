<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	#wrap{margin: 0px auto; width:1000px; }
	/* header, container, footer는 상위 wrap이 같은 width를 가지므로 별로도 선언안해도 사이즈가 정해진다. */
	#header{background-color:aqua;position: relative; height: 120px;}
	#headerTitle{font-family: HY견고딕, 고딕; font-size: 35px; font-weight: bold; margin-left: 20px;
		position:absolute; left:0; top:50%; width:100%; transform:translateY(-50%)}
	#container{position:relative; width:100%; overflow:hidden; }
	#footer{width:100%; height: 130px; background-color: maroon;}
	#footerTitle{float: left; font-size: 15px; padding-left: 5px;}
	
	#nav{/* float: left; */ position:absolute; top:0; left:0; width: 200px; background-color: green; height: 100%;}
	#content{float: right; width: 800px; height: 100%; min-height: 500px;}
	
	#contentTitle{font-size: 30px; padding-left: 20px;}
	#body{border: 1px solid #FF0000; width: 740px; margin-left: 30px; margin-top: 15px; min-height: 500px; overflow: hidden; margin-bottom: 50px;}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>

	<div id="wrap">
		<div id="header">
		
			<div id="headerTitle">로고</div>
		</div>
		<div id="container">
		
			<div id="nav">
				<ul>
					<li><a href="">공지사항</a></li>
					<li><a href="">문의사항</a></li>
					<li><a href="">회원관리</a></li>
					<li><a href="">관리자 메뉴</a></li>
					<li><a href="">후기 관리</a></li>
				</ul>
			</div>	
			<div id="content"><span id="contentTitle">공지사항</span>
			
				<div id="body">
				
				
				</div>
				
			</div>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved.</div>
		</div>
	</div>

</body>

</html>