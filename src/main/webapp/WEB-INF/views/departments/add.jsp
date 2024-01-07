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

	
	<section id="contents" class="container-fluid">
		<div class="row mt-4">
			<form action="add" method="post">
			  <div class="mb-3">
			    <label for="departmentId" class="form-label">DepartmentID</label>
			    <input type="text" name="department_id" class="form-control" id="departmentId" aria-describedby="emailHelp">
			    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
			  </div>
			  <div class="mb-3">
			    <label for="departmentName" class="form-label">DepartmentName</label>
			    <input type="text" name="department_name" class="form-control" id="departmentName">
			  </div><div class="mb-3">
			    <label for="managerId" class="form-label">ManagerId</label>
			    <input type="text" name="manager_id" class="form-control" id="managerId">
			  </div><div class="mb-3">
			    <label for="locationId" class="form-label">LocationId</label>
			    <input type="text" name="location_id" class="form-control" id="locationId">
			  </div>
			  <button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
		
	</section>
	
	
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>