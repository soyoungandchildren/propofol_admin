<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v190130.css" />
<style type="text/css">
   #wrap{ margin: 0px auto; width:800px; height:860px;  }
   #header{ mwidth:800px; height:140px; background:#FFF url('http://localhost:8080/jsp_prj/common/images/header_bg.png'); position:relative; }
   #headerTitle{ font-family: HY견고딕, 고딕; font-size: 35px; font-weight:bold; text-align:center; position:absolute; left:300px; top:30px; }
   #container{ width:800px; }
   #footer{ width:800px; height:120px; }
    #footerTitle{ float:right; font-size:15px; padding-top:20px; padding-right: 20px;}
   
   body {
  background-color:#fff;
  -webkit-font-smoothing: antialiased;
  font: normal 14px Roboto,arial,sans-serif;
}

.container {
    padding-top: 100px;
    position: fixed;
}

.form-login {
    background-color: #EDEDED;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 5px;
    box-shadow:0 1px 0 #cfcfcf;
    margin: 0 auto;
    width: 400px;
    height: 300px;
}

h4 { 
 border:0 solid #fff; 
 border-bottom-width:1px;
 padding-bottom:10px;
 font-size:30px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
    width: 200px;
    height: 30px;
    margin: 0 auto;
    
}

.wrapper {
    text-align: center;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var id=$("#userName").val();
		$(".btn").click(function(){
			alert(id);
		});
		
	});
</script>
</head>
<body>
   <div id="wrap">
      <div id="header">
      </div>
      <div id="container">
      
        <div class="col-md-offset-5 col-md-3" style="padding-top: 100px">
        
        <form action="loginform.do" method="post">
            <div class="form-login">
           	 <h4>가즈아~~~~</h4>
           	 <div style="padding-top: 70px; text-align: center;">
          		 <input type="text" name="userID" class="form-control" placeholder="ID" />
           		 <br/>
           		 <input type="text" name="Password" class="form-control" placeholder="password" />
          	 	 <br/>
          	  </div><br/>
          		  <div class="wrapper">
         	 	
         	 		  <input type="submit" value="LOGIN" class="btn"/>    
            	 	   <!-- <a href="#" class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i></a> -->
         			  
          		  </div>
            </div>
        	</form>
        </div>
        
               
               
      </div>
      
      <div id="footer">
         <div id="footerTitle">copyright&copy; all right reserve class 4</div>
      </div>
   </div>
</body>
</html>