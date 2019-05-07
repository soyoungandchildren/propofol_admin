<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>공지사항</title>


<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!-- Google jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

	$(function() {
		$("#btnWrite").click(function(){
			location.href = "notice_write.do";
		})//click
	})


	function moveIndex(i){
		var move = document.page;
		if(move.bigPage.value==null || move.bigPage.value==""){
			move.bigPage.value = 0;
		}
		
		move.selectedPageIndex.value = i;
		move.method = "post";
		move.action = "notice.do";
		move.submit();
	}
	
	function moveBigPage(i){
		var move = document.page;
		if(move.selectedPageIndex.value==null || move.selectedPageIndex.value==""){
			move.selectedPageIndex.value = 1;
		}
		
		move.bigPage.value = i;
		move.method = "post";
		move.action = "notice.do";
		move.submit();
	}
</script>

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
      
      
    /* 수정한 부분 */
	.navbar{height: 50px;}
	#nav{ position:fixed; padding-top:57px; height:100%;}
	#main{ padding-top:57px;}
	
	.nav-item>a{color : #57606f; font-size: 15px; margin-top: 20px;}
	.nav-item>a:hover{color : #007bff; font-size: 15px; margin-top: 20px;}
      
    #btnWrite{margin-top: 10px; margin-right: 10px; float: right;}
    #btn_search{height: 27px; line-height: 1.0;}
    
    #body{border: 1px solid #bdc3c7; border-radius: 7px; width: 95%; margin-left: 30px; margin-top: 15px; min-height: 500px; overflow: hidden; margin-bottom: 50px;}
	#body>table{width:90%; margin-left: 5%; margin-top: 30px;}
	thead>tr>td{ text-align: center; font-size: 16px; font-family: 맑은 고딕; font-weight: bold;}
	tbody>tr{height: 35px;}
	tbody>tr>td{ text-align: center; font-size: 15px; font-family: 맑은 고딕;}
	
	#table_notice>thead>tr{border-bottom: 2px solid #333;}
	#table_notice>tbody>tr{border-bottom: 1px solid #b2bec3;}
      
            
     </style>
    <!-- Custom styles for this template -->
  <style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}
</style>

</head>
<body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">프로포폴 관리자</a>
  <ul class="navbar-nav px-3">
    <li class="text-nowrap">
      <a class="nav-link" href="#">Sign out</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <nav class="col-md-2 d-none d-md-block bg-light sidebar" id="nav">
      <div class="sidebar-sticky">
        <ul class="nav flex-column">
          
          <li class="nav-item">
            <a class="nav-link" href="notice.do">
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
            <a class="nav-link" href="member_list.do">
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
            <a class="nav-link" href="admin.do">
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

      <h2>공지사항</h2>
      
				<div id="body">
					<table id="table_notice">
						<thead>
							<tr style="height: 45px;">
								<td style="width: 10%;">글 번호</td>
								<td>글 제목</td>
								<td style="width: 15%">작성자</td>
								<td style="width: 15%">게시일</td>
								<td style="width: 10%">조회수</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="nl" items="${ requestScope.noticeList}">
								<tr>
									<td class="notice_no"><c:out value="${nl.notice_no }"/></td>
									<td class="notice_title"><a href="notice_read.do?num=${nl.notice_no }"><c:out value="${nl.title }"/></a></td>
									<td class="notice_writer"><c:out value="${nl.admin_id }"/></td>
									<td class="notice_date"><c:out value="${nl.inputdate }"/></td>
									<td class="view"><c:out value="${nl.view_count }"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<div style="width: 100%; padding-bottom: 20px; display: block;">
					<input type="button" class="btn btn-outline-primary" id="btnWrite" value="공지 작성"/>
					</div>
					
					
					<div style="margin-top: 50px;">
						<nav aria-label="Page navigation example">
						  <ul class="pagination justify-content-center">
						    <li class="page-item ${requestScope.bigPage != 0 ?'':'disabled'}">
						      <a class="page-link" href="javascript:moveBigPage(${param.bigPage-1 });"  tabindex="-1" aria-disabled="true">Previous</a>
						    </li>
						    <%
						    	int totalIdx = ((Integer)request.getAttribute("pageIdx")).intValue();
						    	int bigPage = ((Integer)request.getAttribute("bigPage")).intValue();
						    	for(int i = 1; i<=10; i++){
						    		if(bigPage*10+i<=totalIdx){
						    %>
			  <li class='page-item'>
			  	<a class="page-link" 
			  	href='javascript:moveIndex(<%=i+(bigPage*10)%>)'><%=i+(bigPage*10)%></a>
			  </li>
						    <%
						    		}//end if
						    	}//end for
						    %>
						    <%-- <c:out value="${ requestScope.pageIdx }" escapeXml="false"/> --%>
						    <li class="page-item ${requestScope.maxBigPage == requestScope.bigPage ?'disabled':''}">
						      <a class="page-link" href="javascript:moveBigPage(${param.bigPage+1 });">Next</a>
						    </li>
						  </ul>
						</nav>
					</div>
					
					<form name="page">
						<input type="hidden" name="selectedPageIndex" value="${param.selectedPageIndex}"/>
						<input type="hidden" name="bigPage" value="${param.bigPage}"/>
					</form>
					
					
					<div style="text-align: center; padding-bottom: 40px;">
						<select style="height: 30px;">
							<option>글 제목</option>
							<option>작성자</option>
						</select>
						<input type="text" style="height: 25px;"/>
						<input type="button" class="btn btn-outline-secondary" id="btn_search" value="검색"/>
					</div>
					
				</div>
				
      
    </main>
  </div>
</div>
</body>
</html>