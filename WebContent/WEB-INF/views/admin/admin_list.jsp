<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>관리자 메뉴</title>


<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!-- Google jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#btnAddAdmin").click(function(){
			location.href = "admin_add.do";
		})//btnAddAdmin
		
	})//ready
	
	function changeAuth(data){
		/* 로그인 계정의 권한 확인 과정 필요 */
		
		
		alert(data[0]);
		
	/* 	if( confirm("정말 "+data[0]+" 계정의 권한을 변경하시겠습니까?") ){
			$.ajax({
				url:"change_auth.do",
				type:"post",
				dataType:"json",
				data: data,
				error:function(xhr){
					console.log(xhr.status+"///"+xhr.statusText);
				},
				success:function(resultMsg){
					console.log("성공");
				}
			});
		}else{
			return;
		}//end else */
			
	}//changeAuth
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
    
    #body{border: 1px solid #bdc3c7; border-radius: 7px; width: 95%; margin-left: 30px; margin-top: 15px; min-height: 350px; overflow: hidden; margin-bottom: 20px;}
    
    .input-group{margin-left: 30px; margin-top: 30px;}
    .input-group-text{font-weight: 550; width: 140px; display: initial;}
    .input-group>.form-control{flex: initial; width: 250px;}
      
    #btn_account{margin-left: 30px;width: 200px;height: 80px;font-size: 20px;font-weight: 550;margin-top: 10px;}
            
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

      <h2>관리자 계정 목록</h2>
      
      	<button type="button" class="btn btn-outline-primary" style="width: 130px; height: 50px; font-size: 1.25rem;" id="btnAddAdmin">계정 추가</button>
      
		<div id="body">
		
		
			<div>
				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">아이디</th>
				      <th scope="col">권한</th>
				      <th scope="col">관리자명</th>
				      <th scope="col">생성일</th>
				      <th scope="col"></th>
				      <th scope="col"></th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:if test="${empty adminList }">
				  		<tr>
				  			<th colspan="6">등록된 관리자 계정이 없습니다.</th>
				  		</tr>
				  	</c:if>
				  	<c:if test="${not empty adminList }">
				  		<c:forEach var="al" items="${adminList }">
					    <tr>
					      <th scope="row">${al.admin_id }</th>
					      <td>${al.authority }</td>
					      <td>${al.name }</td>
					      <td>${al.inputdate }</td>
					      <td colspan="2">
						      <input type="button" class="btn btn-outline-success" onclick="javascript:changeAuth({'${al.admin_id}', '${al.authority}'})" value="권한 변경"/>
						      <input type="button" class="btn btn-outline-danger" onclick="javascript:rermoveAcco('${al.admin_id}')" value="계정 삭제"/>
					      </td>
					    </tr>
				  		</c:forEach>
				  	</c:if>
				  </tbody>
				</table>
			</div>
		
		</div>
		<button type="button" class="btn btn-outline-secondary" onclick="javascript:history.back();">뒤로 가기</button>
      
    </main>
  </div>
</div>
</body>
</html>