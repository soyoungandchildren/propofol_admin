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
  
  	.container {
  height: 100px;
  text-align: center;
  margin-top: 200px;
}

.circle {
  margin: 20px;
  height: 50px;
  width: 50px;
  border-radius: 50%;
  display: inline-block;
  transform: scale(0);
  animation: bulge 2s infinite ease-in-out;
}

.circle::after {
  position: absolute;
  display: inline-block;
  content: '';
  height: 100%;
  width: 100%;
  border-radius: 50%;
  background-color: inherit;
  top: 0;
  left: 0;
  z-index: -1;
  transform: scale(1);
  animation: blow 2s infinite ease-in-out;
}

.circle:nth-child(1) {
  background-color: #4695B8;
  animation-delay: 0s;
}

.circle:nth-child(2) {
  background-color: #67A142;
  animation-delay: .25s;
}

.circle:nth-child(3) {
  background-color: #8FC0A7;
  animation-delay: .50s;
}


@keyframes bulge {
  50% {
    transform: scale(1);
  }
}


@keyframes blow {
  25% {
    opacity: 0.5;
  }
  50% {
    opacity: 0.5;
  }
  90% {
    opacity: 0;
  }
  100% {
    transform: scale(2);
    opacity: 0;
  }
}
</style>
<script type="text/javascript">
setTimeout(gogo, 5000);
function gogo() {
	location.href="inquiry_board.do";
}
</script>



<div class="container">
				  <div class="circle"></div>
				  <div class="circle"></div>
				  <div class="circle"></div>
				</div>

   