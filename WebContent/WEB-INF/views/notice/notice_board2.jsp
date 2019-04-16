<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

<style type="text/css">
	#wrap{margin: 0px auto; width:1000px;}
	/* header, container, footer는 상위 wrap이 같은 width를 가지므로 별로도 선언안해도 사이즈가 정해진다. */
	#header{position: relative; height: 120px; background-color: #353b48; border-bottom: 1px solid #FFF;}
	#headerTitle{font-family: HY견고딕, 고딕; font-size: 35px; font-weight: bold; margin-left: 20px;
		position:absolute; left:0; top:50%; width:100%; transform:translateY(-50%)}
	#container{position:relative; width:100%; overflow:hidden; }
	#footer{width:100%; height: 130px; background-color: #353b48; border-top: 1px solid #FFF;}
	#footerTitle{float: left; font-size: 15px; padding-left: 5px;}
	
	#nav{/* float: left; */ position:absolute; top:0; left:0; width: 200px; background-color: #636e72; height: 100%; 
		border-right: 1px solid #FFF;}
	#content{float: right; width: 800px; height: 100%; min-height: 600px; background-color: #636e72;}
	
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
					
	.btn{margin-bottom: 20px; font-weight: 500; font-size: 1.5rem; color: #FFF; border-color: #FFF; width: 170px;}
	/* 선택자:hover - 마우스가 올라갔을 때 CSS에 변화를 줌 */
	.btn:hover{ color: white; border: 1px solid #FFF; background-color: #2f3640; box-shadow:0 0 6px #FFF;}
	/* 선택자:active - 마우스 왼쪽 버튼을 꾹 누르고 있는 동안 CSS에 변화를 줌 */
	.btn:active{ color: #4cd137 !important; border: 1px solid #2b6f43 !important; background-color: #2f3640 !important;}
</style>
<script type="text/javascript">
</script>
</head>
<body>
aaaaaaaaSADFSDAFaffsasafsafasfafsagfhvvvvvdfdfsdfsdfsfsdfsfsdfsdfsfdfdfddfdfdfdf66436463436fd
<div style="background-color: #f5f5f5">
	<div id="wrap">
		<div id="header">
		
			<div id="headerTitle">로고</div>
		</div>
		<div id="container">
			
			<div id="nav">
				<div style="width:200px; margin-top: 150px; text-align:center;">
					<button class="btn btn-outline-success" type="button">공지사항</button>
					<button class="btn btn-outline-success" type="button">문의사항</button>
					<button class="btn btn-outline-success" type="button">회원관리</button>
					<button class="btn btn-outline-success" type="button">관리자 메뉴</button>
					<button class="btn btn-outline-success" type="button">후기관리</button>
				</div>
					
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
						<input type="button" value="버튼" style="height: 30px;" class="btn"/>
					</div>
					
				</div>
				
						
			</div>
		</div>
		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved.</div>
		</div>
	</div>
</div>

</body>

</html>