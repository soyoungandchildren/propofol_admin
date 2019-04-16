<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>노양심 디자인</title>


<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>



    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
      
      .navbar{height: 50px;}
      #nav{ position:fixed; padding-top:57px; height:100%;}
      #main{ padding-top:57px;}
      
      .nav-item>a{color : #57606f; font-size: 15px; margin-top: 20px;}
      .nav-item>a:hover{color : #007bff; font-size: 15px; margin-top: 20px;}
      
      
      /* 내가 수정한 부분 */
      .btn{background-color: #0000FF;}
      
     </style>
    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
  <style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}
/* ---------------------------------------------------------- */
	#th1{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 120px;text-align: center;}
	#th2{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 420px;text-align: center;}
	#th3{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 120px;text-align: center;}
	#th4{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 120px;text-align: center;}
	#th5{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 120px;text-align: center;}
	#contentsList{ text-align: center;}



</style>
</head>
<body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">프로포폴 관리자</a>
  <ul class="navbar-nav px-3">
    <li class="text-nowrap">
      <a class="nav-link" href="#void">Sign out</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar" id="nav">
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          
          <li class="nav-item">
            <a class="nav-link" href="#">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
              공지사항
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
              문의사항
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" 
              fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users">
              <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
              <circle cx="9" cy="7" r="4"></circle>
              <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
              <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
              </svg>
              회원관리
            </a>
          </li> 
          <li class="nav-item"> 
            <a class="nav-link" href="#">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
              관리자 메뉴
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
              후기관리
            </a>
          </li>
        </ul>
        
      </div>
      
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4" id="main">
    <div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; 
    bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
	    <div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;
	   		overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
		    <div style="position:absolute;width:200%;height:200%;left:0; top:0">
		    </div>
	    </div>
    </div>

      <h2>후&nbsp;기</h2>
      
      <div class="content_div">
      
        <table border="1" >
      		  <tr>
						<th id="th1">No</th>
						<th id="th2">제목</th>
						<th id="th3">아이디</th>
						<th id="th4">작성날짜</th>
						<th id="th5">조회수</th>
				</tr>
						<%
							for(int i=0; i<10;i++){
						%>
						<tr>
							<td id="contentsList">1</td>
							<td id="contentsList">2</td>
							<td id="contentsList">3</td>
							<td id="contentsList">4</td>
							<td id="contentsList">5</td>
						</tr>
						<%
							}
						%>
					</table>
				
				</div><br/>
				<div style="text-align: center; max-width: 900px;">
				<%for(int i=1; i<11;i++){
				%>
					<a href="#void"><%=i %></a>
					<%} %>
				</div>
				
				<br/>
					<div id="div_bottom">
						<table border="1" >
							<tr>
								<td style="width: 450px; height:10px">No:</td>
								<td style="width: 450px; height:10px">날짜</td>
							
							</tr>
							<tr>
								<td style="width: 370px; height:10px">제목</td>
								<td>작성자</td>
							</tr>
							<tr>
								<td colspan="2" style="min-height: 100px">내용:</td>
							</tr>
							<tr>
								<td colspan="2" style="width: 740px; height:10px; text-align:center;">
									<input type="submit" value="삭제"class="btn">&nbsp;&nbsp;&nbsp;
									<input type="submit" value="답변"class="btn">
								</td>
							</tr>
       		 </table>
        
      </div>
      
    </main>
  </div>
</div>
</body>
</html>