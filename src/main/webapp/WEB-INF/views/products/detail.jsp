<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../temps/header.jsp"></c:import>
	
	    <section class="container-fluid">
    	<div>
	    	<c:if test="${dto != null}">
	    		<h3>${dto.no}</h3>
	    		<div>${dto.title}</div>
	    		<div>${dto.writer}</div>
	    		<div>${dto.day}</div>
	    	</c:if>
	    	<c:if test="${empty dto}">
	    		<h3>없는 번호 입니다.</h3>
	    	</c:if>
    	</div>
    	<a href="">Update</a>
    </section>
	
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>