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
	#header{position: relative; height: 120px;}
	#headerTitle{font-family: HY견고딕, 고딕; font-size: 35px; font-weight: bold; margin-left: 20px;
		position:absolute; left:0; top:50%; width:100%; transform:translateY(-50%)}
	#container{position:relative; width:100%; overflow:hidden; }
	#footer{width:100%; height: 130px; background-color: maroon;}
	#footerTitle{float: left; font-size: 15px; padding-left: 5px;}
	
	#nav{/* float: left; */ position:absolute; top:0; left:0; width: 200px; background-color: green; height: 100%;}
	#content{float: right; width: 800px; height: 100%; min-height: 600px; background-color: gray;}
	
	#contentTitle{font-size: 30px; padding-left: 20px;}
	
	#body{border: 1px solid #FF0000; width: 740px; margin-left: 30px; margin-top: 15px; min-height: 500px; overflow: hidden; margin-bottom: 50px;}
	#body>table{width:90%; margin-left: 5%; margin-top: 30px;}
	thead>tr>td{ text-align: center; font-size: 16px; font-family: 맑은 고딕; font-weight: bold;}
	tbody>tr{height: 35px;}
	tbody>tr>td{ text-align: center; font-size: 15px; font-family: 맑은 고딕;}
	
	.notice_no{width:6%; font-size: 6px;}
	.notice_title{width:50%; text-align: left;}
	.notice_writer{width:21%;font-size: 15px;}
	.notice_date{width:15%;}
	.view{width:8%;}
	#btnWrite{margin-top: 10px; margin-right: 10px; width: 130px; height: 40px; border-radius: 7px; font-size: 20px; float: right;
					border: none;}
					
	
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
			<div id="content">
				<span id="contentTitle">공지사항</span>
				
				<div id="body">
					<table border="1">
						<thead>
							<tr style="height: 45px;">
								<td></td>
								<td>글 제목</td>
								<td>작성자</td>
								<td>게시일</td>
								<td>조회수</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
							<tr>
								<td class="notice_no">93984</td>
								<td class="notice_title">가제목</td>
								<td class="notice_writer">가작ㄴㅇ성자</td>
								<td class="notice_date">2000-88-88</td>
								<td class="view">999</td>
							</tr>
						</tbody>
						
					</table>
					
					<div style="float: right; width: 100%; padding-bottom: 20px;">
					<input id="btnWrite" type="button" value="공지 작성"/>
					</div>
					
					<div style="text-align: center; padding-bottom: 35px;">
						<span id="pageIndex">◁ 1 2 3 4 5 6 7 8 9 10 ▶</span>
					</div>
					
					
					<div style="text-align: center; padding-bottom: 40px;">
						<select style="height: 30px;">
							<option>글 제목</option>
							<option>작성자</option>
							<option>내용</option>
						</select>
						<input type="text" style="height: 25px;"/>
						<input type="button" value="버튼" style="height: 30px;"/>
					</div>
					
				</div>
						
			</div>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved.</div>
		</div>
	</div>

</body>

</html>