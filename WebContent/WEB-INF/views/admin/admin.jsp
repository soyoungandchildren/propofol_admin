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
    <title>관리자 추가</title>


<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!-- Google jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btnAccount").click(function(){
			location.href="admin_list.do";
		})//btnAccount
		
		$("#btnModifyAdminInfo").click(function(){
			
			var frm = document.frmInfo;
			var inputPass = frm.password.value;
			var inputConfirmPass = frm.confirmPassword.value;
			var inputName = frm.name.value;
			
			if(""==inputName && ""==inputPass && ""==inputConfirmPass){
				alert("변경할 부분을 입력해주세요.");
				return;
			}//end if
			
			if(inputName == null && inputPass == null && inputConfirmPass == null){
				alert("변경할 부분을 입력해주세요.");
				return;
			}//end if 
			
			if(inputPass!=inputConfirmPass){
				alert("작성하신 비밀번호가 서로 다릅니다. 다시 확인해주세요.");
				frm.password.value = "";
				frm.confirmPassword.value = "";
				frm.password.focus();
				return;
			}//end if
			
			if(inputName!=""){
				if(inputName.replace(/ /g, "").length == 0){
					alert("이름을 입력해주세요.")
					frm.name.focus();
					return;
				}//end if
			}//end if
			
			if(inputPass.indexOf(" ") != -1){
				alert("비밀번호는 공백이 들어갈 수 없습니다.");
				frm.password.value = "";
				frm.confirmPassword.value = "";
				frm.password.focus();
				return;
			}//end if
			
			
			$.ajax({
				url:"modify_admin_info.do",
				type:"post",
				dataType:"json",
				data:$("[name='frmInfo']").serialize(),
				error:function(xhr){
					console.log(xhr.status+"///"+xhr.statusText)
				},
				success:function(jsonObj){
					alert(jsonObj.resultMsg);
					location.replace("admin.do");
				}
			})//ajax
			
		})//btnModifyAdminInfo
		
	})//ready
	
	
	
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
      
    #btnAccount{margin-left: 30px;width: 200px;height: 80px;font-size: 20px;font-weight: 550;margin-top: 10px;}
            
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

      <h2>관리자 메뉴</h2>
      
		<div id="body">
		
		<form name = "frmInfo">
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="basic-addon3">비밀번호</span>
			  </div>
			  <input type="password" class="form-control"  name="password" aria-describedby="basic-addon3">
			</div>
			
			<div class="input-group mb-3" style="margin-top: 15px;">
			  <div class="input-group-prepend">
			    <span class="input-group-text">비밀번호 확인</span>
			  </div>
			  <input type="password" class="form-control" aria-describedby="basic-addon3" name="confirmPassword">
			</div>
			
			<div class="input-group mb-3" style="margin-top: 15px;">
			  <div class="input-group-prepend">
			    <span class="input-group-text">관리자 이름</span>
			  </div>
			  <input type="text" class="form-control"  name="name" aria-describedby="basic-addon3">
			</div>
		</form>
			
			<div>
				<button type="button" class="btn btn-outline-primary" style="width: 90px; margin-left: 328px;" id="btnModifyAdminInfo">변경</button>
			</div>
			
			<div>
				<button type="button" class="btn btn-outline-info" id="btnAccount">관리자 계정 관리</button>
			</div>
			
		</div>
      
    </main>
  </div>
</div>
</body>
</html>