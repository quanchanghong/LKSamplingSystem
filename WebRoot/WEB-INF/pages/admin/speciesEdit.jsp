<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>物种添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="${pageContext.request.contextPath}/admin/species/save" method="post">
			<div class="form-group row">
				<label for="name" class="col-sm-1 col-form-label font-weight-bold">物种名称</label>
				<div class="col-sm-3">
					<input type="hidden" class="form-control " value="${species.speciesId}" id="speciesId" name="speciesId" placeholder="id"">
					<input type="text" class="form-control " value="${species.speciesName}" id="speciesName" name="speciesName" placeholder="物种名称">
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
