<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="utf-8">
    <title>Region Detail</title>
    <c:import url="../temps/bootStrap_css.jsp"></c:import>
 </head>
  <body>
 
    <c:import url="../temps/header.jsp"></c:import>
    
    <section class="container-fluid">
    	<div>
	    	<c:if test="${dto != null}">
	    		<h3>${dto.region_id}</h3>
	    		<div>${dto.region_name}</div>
	    		<div>
	    			<h2>File</h2>
	    			<a href="/resources/upload/regions/${dto.regionFileDTO.fileName}">${dto.regionFileDTO.oriName}</a>
	    		</div>
	    	</c:if>
	    	<c:if test="${empty dto}">
	    		<h3>없는 번호 입니다.</h3>
	    	</c:if>
    	</div>
    	<a href="">Update</a>
		<button id="up" data-region-id="${dto.region_id}">Update</button>
    	<button id="del">Delete</button>
    	<form id="frm" action="./delete" method="post">
    		<input type="hidden" name="region_id" value="${dto.region_id}">
    	</form>
    </section>
	 
	 <c:import url="../temps/bootStrap_js.jsp"></c:import>
	<!-- /regions/ -->
	<script src="../resources/js/regionDetail.js"></script>
  </body>
</html>