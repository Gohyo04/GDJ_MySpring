<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Region List</title>
    <c:import url="../temps/bootStrap_css.jsp"></c:import>
  </head>
<body>
	
	<c:import url="../temps/header.jsp"></c:import>
	
	<h1>Regions List</h1>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${dto.region_id}</td>
					<td><a href="./detail?region_id=${dto.region_id}">${dto.region_name}</a></td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
	<a href="./add" class="btn btn-success">Add</a>
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
	
</body>
</html>