<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id="기미긱";
   		 pageContext.setAttribute("idid", id); 
    %>
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
	
	#th1{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#th2{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 400px}
	#th3{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#th4{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#th5{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#th6{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#contents{ text-align: center;}
	/* ------------- */
	#div_bottom{background-color: #A2A099}
	
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
			<form>
				<div id="content"><span id="contentTitle">문의사항</span>
				
					<div id="body">
					<div id="div_top">
						<table border="1">
							<tr>
							<th id="th1">no</th>
							<th id="th2">제목</th>
							<th id="th3">아이디</th>
							<th id="th4">작성날짜</th>
							<th id="th5">상태</th>
							<th id="th6">조회수</th>
							</tr>
							<%
								for(int i=0; i<10;i++){
							%>
							<tr>
								<td id="contents">1</td>
								<td id="contents">2</td>
								<td id="contents">3</td>
								<td id="contents">4</td>
								<td id="contents">5</td>
								<td id="contents">6</td>
							</tr>
							<%
								}
							%>
						</table>
					
					</div>
					
					<br/><br/><br/>
					<div id="div_bottom">
						<table border="1"style="width: 740px; height: 400px">
					
							<tr>
								<td style="width: 400px; height: 10px">번호:<c:out value="${id}"/></td>
								<td style="width: 330px; height: 10px">작성날짜</td>
							</tr>
							<tr>
								<td style="width: 400px; height: 10px">제목</td>
								<td style="width: 330px; height: 10px">작성자</td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="button" value="삭제"class="btn"/>
								<input type="button" value="답변"class="btn"/>
								</td>
							</tr>
						</table>
					</div>
					
	
					</div>
					
				</div>
			</form>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved.</div>
		</div>
	</div>

</body>

</html>