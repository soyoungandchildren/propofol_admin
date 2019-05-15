<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>문의 사항</title>


<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">



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
	#th1{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#th2{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 400px}
	#th3{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#th4{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#th5{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#th6{background-color: #A2A099;border: 1px solid #ccc; float: center; width: 100px}
	#contentsList{padding:1px; text-align: center; height: 12px; word-break:break-all;}
  
	th{text-align: center; background-color: #2f3542; color: #ffffff;}
	
	.mine_th{width: 11%;}
	

</style>
</head>
<body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">프로포폴 관리자</a>
  <div style="color: #FFFFFF;">${admin} 님 환영합니다.</div>
  <ul class="navbar-nav px-3">
    <li class="text-nowrap">
      <a class="nav-link" href="logout.do">Sign out</a>
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
            <a class="nav-link" href="inquiry_board.do">
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
            <a class="nav-link" href="review.do">
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

      <h2>문의사항</h2>
      
      <div class="content_div">
      
       <table border="1" class="table table-striped" style="max-width: 1000px">
					  <thead>
					    <tr >
					      <th style="width: 80px" >No</th>
					      <th style="width: 300px" >제목</th>
					      <th style="width: 60px" >아이디</th>
					      <th style="width: 100px" >작성날짜</th>
					      <th style="width: 40px" >답변</th>
					      <th style="width: 60px" >조회수</th>
					    </tr>
					  </thead>
					  <tbody>
						<c:if test="${ not empty e }">
				                     <tr>
				                        <td colspan="5">서비스가 원활하지 못한 점 죄송합니다.</td>
				                     </tr>
				        </c:if>	
				         <c:if test="${ empty inquiryList }">
				                     <tr>
				                        <td colspan="7">이벤트가 존재하지 않습니다.<a href="#">이벤트 작성</a></td>
				                     </tr>
				         </c:if>
				          <c:if test="${not empty inquiryList }">
				        
		                   <c:forEach var="data" items="${ inquiryList }">
		                     <c:set var="i" value="${ i + 1 }" />
		                     <tr>
		                        <td class="center"><c:out value="${ data.num}" /></td>
 		                        <td class="center"><a href="bbs_read.do?num=${data.num }"><c:out value="${ data.subject }" /></a></td>
		             
		                     <%--     <td><c:out value="${ data.subject }" /></td> --%>
		                        <td class="center"><c:out value="${data.user_id }" /></td>
		                        <td class="center"><c:out value="${data.w_date  }" /></td> 
		                        <td class="center"><c:out value="${data.status  }" /></td> 
		                        <td class="center"><c:out value="${data.views  }" /></td> 
		                     </tr>
		                  </c:forEach>
		                  </c:if>				  
					  </tbody>
					</table>
				
				</div><br/>
				<div style="text-align: center; max-width: 900px;">
					<nav aria-label="Page navigation example">
					  <ul class="pagination justify-content-center" >
					  <c:if test="${bigPage>9 ? true :false }">
				      <li class="page-item"><a class="page-link" href="inquiry_board.do?currentPage=${bigPage }&bigPage=${bigPage-10}">Previous</a></li>
				      </c:if>
							<c:forEach  begin="1" end="10">
							<c:set var="j" value="${j+1 }"/>
							
							 <c:if test="${j le requestScope.totalPage-bigPage}"> 
				 			   <li class="page-item"><a class="page-link" href="inquiry_board.do?currentPage=<c:out value="${bigPage+j }"/>&bigPage=${bigPage}"><c:out value="${bigPage+j }"/></a></li>
				 		 	   </c:if>
				 		 	    
							</c:forEach>
					<c:if test="${totalPage>bigPage ? true: false }">
					<c:if test="${bigPage<totalPage && totalPage<bigPage+10 ? false: true }">
					
				    <li class="page-item"><a class="page-link" href="inquiry_board.do?currentPage=${bigPage+1 }&bigPage=${bigPage+10}">Next</a></li>
				    </c:if>
				    </c:if>
				  </ul>
				</nav>
				
					
				</div>
	
    </main>
  </div>
</div>
</body>
</html>