<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="frontHeader.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>用户注册</title>
  </head>
  
  <body>
    <div class="container">
   		<form action="${pageContext.request.contextPath}/user/regist" method="post">
			<div class="form-group row">
				<label for="userName" class="col-sm-1 col-form-label font-weight-bold">用户名</label>
				<div class="col-sm-3">
					<input type="text" class="form-control " id="userName" name="userName" placeholder="用户名">
				</div>
			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-1 col-form-label font-weight-bold">密码</label>
				<div class="col-sm-3">
					<input type="password" class="form-control " id="password" name="password"   placeholder="密码">
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-4">
					<input type="submit" class="form-control btn btn-success" value="注册">
				</div>
			</div>
		</form>
   	</div>
  </body>
</html>
