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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
	});
</script>
</head>
<body>
   <div id="wrap">
      <div id="header">
         <div id="headerTitle">SIST Class4</div>
      </div>
      <div id="container">
        
        성공
      name=  <c:out value="${userinfo.name }"/> <br/>
   	   권한= <c:out value="${userinfo.authority }"/><br/> 
   	   새션 <c:out value="${sessionscope.name }"/>      <br/>
   	   		<c:out value="${sessionscope.auth }"/><br/>
               
   	   새션== ${sessionScope.name }      <br/>
   	   		${sessionScope.auth }<br/>
               
      </div>
      
      <div id="footer">
         <div id="footerTitle">copyright&copy; all right reserve class 4</div>
      </div>
   </div>
</body>
</html>