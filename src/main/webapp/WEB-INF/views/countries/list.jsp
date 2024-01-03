<%@page import="java.util.List"%>
<%@page import="com.winter.app.countries.CountryDAO"%>
<%@page import="com.winter.app.countries.CountryDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- jstl을 사용하기위해 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Countries List</title>
</head>
<body>
	<h1>Countries List</h1>
	<table>
		<thead>
			<tr>
				<th>Country_id</th>
				<th>Country_name</th>
				<th>Region_id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="requestScope.list", var="dto">
				<tr>
					<td>${pageScope.country_id}</td>
					<td>${pageScope.country_name}</td>
					<td>${pageScope.region_id}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>