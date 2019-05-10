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
    <title>문의사항</title>


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
     /*  .btn{background-color: #0000FF;} */
      
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
	#contentsList{ text-align: center;}

	th{text-align: center; background-color:#A2A099; }
	
	.mine_th{width: 11%;}
	#write{display: none;}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btlist").click(function(){
			location.href="inquiry_board.do";
			
		});
		
		$("#deleteuserbtn").click(function(){
			var number = $("#usernum").val();
			var queryString="num="+number;
			
			if(confirm(number+"삭제 합니다")){
				alert("asdfadsf");
				 $.ajax({
					url : "deleteuserinquiry.do",
					data : queryString,
					type:"get",
			        dataType:"json",
					error:function(xhr){
			              alert("작성 실패");
			              console.log(xhr.status+" / "+xhr.statusText);
			           }, // error
			           success:function( json ){
			        	   alert("삭제 완료");
			        	   location.href="inquiry_board.do";
			           }
				}); 
			} //if
			else{
				alert("취소");
			}
		});
		$("#btbt").click(function(){
			
	           var txt = $("#replyView").text();
	         if(txt == "댓글 열기"){
	            $("#replyView").text("댓글 접기")
	         } else {
	            $("#replyView").text("댓글 열기")
	         } // end else 
	         $("#write").slideToggle(500); 
	      });  
	
	
	$("#btnsave").click(function(){
      
        var reply = $("#contents").val();
        var numnum= $("#number").val();
        if( reply == "" ){
           alert("내용은  필수 입력!!!");
           $("#contents").focus();
           return;
        } // end if
        
        var queryString="num="+numnum+"&admin_id="+$("#admin").val()+"&r_contents="+reply
      	alert(queryString);
         $.ajax({
           url:"add_reply.do",
           data:queryString,
           type:"get",
           dataType:"json",
           error:function(xhr){
              alert("작성 실패");
              console.log(xhr.status+" / "+xhr.statusText);
           }, // error
           success:function( json ){
              if( json.result ){
                 // <div>의 자식 노드로 작성한 값을 추가(append)
                 // 자식 노드 전에 추가 (prepend())
        /*          var date=new Date();
                
                 $("#reply").prepend(output);
                 $("[name='writer']").val(""); 
                  $("[name='reply']").val("");  */
                 
                 alert("댓글이 정상적으로 등록되었습니다.");
              } // end if
           } // success
        }); // AJAX 
        
     }); // click
	
	});
</script>
</head>
<body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">프로포폴 관리자</a>
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

      <h2>문의사항</h2><br/>
      
      <div class="content_div">
	
				<form >
					  <div class="form-group" style="max-width:1000px; border: 1px solid gold">
					    <label >제&nbsp;&nbsp;&nbsp;목</label>
					    <input type="text" class="form-control" id="" value="${selectinquiry.subject }" maxlength="30" style="max-width: 445px; display:inline-block;" disabled="disabled">
					    <label >작성자</label>
					    <input type="text" class="form-control" id="" value="${selectinquiry.user_id }" style="max-width: 445px; display:inline-block;" disabled="disabled"><br/>
					    <label >글번호</label>
					    <input type="text" class="form-control" id="usernum" value="${selectinquiry.num }" style="max-width: 445px; display:inline-block;" disabled="disabled">
					    <label >작성일</label>
					    <input type="text" class="form-control" id="" value="${selectinquiry.w_date }" style="max-width: 440px; display:inline-block;" disabled="disabled">
					     
					  </div> 
					  <div class="input-group"> 
						  <div class="input-group-prepend" >
						    <span class="input-group-text">내&nbsp;용</span>
						  </div>
						  <textarea class="form-control"  style="max-width:945px; min-height: 300px" disabled="disabled"><c:out value="${selectinquiry.user_contents }" /> ss</textarea>
						</div>  
						<br/>
					  <div style="text-align: center; max-width: 1000px;">
						  <input type="button" id="btlist" class="btn btn-outline-primary" value="리스트"  >
						  <input type="button" id="deleteuserbtn" class="btn btn-outline-primary" value="삭&nbsp;&nbsp;제"  >
						  <input type="button" id="btbt" class="btn btn-outline-primary" value="답변쓰기" >
						
					  </div>   
					</form>
				   
		</div><br/>
		
		<div id="write">
			<form >
					  <div class="form-group" style="max-width:1000px; border: 1px solid gold">
					    <label >제&nbsp;&nbsp;&nbsp;목</label>
					    <input type="text" class="form-control" id="" value="${selectinquiry.subject }" maxlength="30" style="max-width: 445px; display:inline-block;" disabled="disabled">
					    <label >작성자</label>
					    <input type="text" class="form-control" id="admin" value="${adminid }" style="max-width: 445px; display:inline-block;" disabled="disabled"><br/>
					    <label >글번호</label>
					    <input type="text" class="form-control" id="number" value="${selectinquiry.num}" style="max-width: 445px; display:inline-block;" disabled="disabled">
					    <label >작성일</label>
					    <input type="text" class="form-control" id="" value="${readreply.r_date }" style="max-width: 440px; display:inline-block;" disabled="disabled">
					     
					  </div> 
					  <div class="input-group"> 
						  <div class="input-group-prepend" >
						    <span class="input-group-text">내&nbsp;용</span>
						  </div>
						  <textarea class="form-control" id="contents" name="contents" style="max-width:945px; min-height: 300px"><c:out value="${readreply.r_contents }"/></textarea>
						</div>  
						<br/>
					  <div style="text-align: center; max-width: 1000px;">
						  <input type="button"  class="btn btn-outline-primary" value="삭&nbsp;&nbsp;제" />
						  <input type="button" id="btnsave" class="btn btn-outline-primary " value="답변저장" /><br/>
					  </div>
			</form>
		<br/>
		
		</div>
      
    </main>
  </div>
</div>
</body>
</html>