<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>区域添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="${pageContext.request.contextPath}/admin/area/save" method="post">
			<div class="form-group row">
				<label for="name" class="col-sm-1 col-form-label font-weight-bold">名称</label>
				<div class="col-sm-3">
					<input type="hidden" class="form-control " id="areaId" name="areaId" placeholder="id"">
					<input type="text" class="form-control " id="areaName" name="areaName" placeholder="名称">
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-4">
					<input type="submit" class="form-control btn btn-success" value="添加">
				</div>
			</div>
		</form>
   	</div>
  </body>
</html>
