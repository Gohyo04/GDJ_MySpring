<%@page import="java.util.List"%>
<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <c:import url="../temps/bootStrap_css.jsp"></c:import>
  </head>
<body>
<c:import url="../temps/header.jsp"></c:import>

	<h1>Department List</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Department_id</th>
				<th>Department_name</th>
				<th>Manager_id</th>
				<th>Location_id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${dto.department_id}</td>
					<td><a href="./detail?department_id=${dto.department_id}">${dto.department_name}</a></td>
					<td>${dto.manager_id}</td>
					<td>${dto.location_id}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
		</tfoot>
	</table>
	<a href="./add" class="btn btn-success">Add</a>
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>