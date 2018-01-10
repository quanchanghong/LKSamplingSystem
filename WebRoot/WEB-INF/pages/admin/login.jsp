<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
  	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title>后台登录</title>
  </head>
  
  <body>
  	<div class="container">
  	<div>
  		<h2>亚翔采样分析系统后台</h2>
  	</div>
  	<div style="border: 1px solid #28A745; border-radius: 5px; margin-left: 25%; margin-top: 22%; width: 400px">
		<form action="${pageContext.request.contextPath}/admin/login" method="post">
			<div class="form-group row" style="margin-top: 10px;">
  				<label for="adminName" class="col-lg-3 col-form-label" style="margin-left: 10px">用户名:</label>
  				<div class="col-sm-8">
      				<input type="text" class="form-control" id="adminName" placeholder="用户名" name="adminName">
      				<small id="adminNameHelp" class="form-text text-muted">功能预留</small>
    			</div> 
  			</div>
  			<div class="form-group row" style="margin-top: 10px;">
  				<label for="adminPWD" class="col-lg-3 col-form-label" style="margin-left: 10px">密码:</label>
  				<div class="col-sm-8">
      				<input type="password" class="form-control" id="adminPWD" placeholder="密码" name="adminPWD">
    			</div> 
  			</div>
			<div class="form-group row">
				<input type="submit" class="btn btn-outline-success" value="登录" style="margin-left: 22px; width: 385px;">
			</div>
		</form>
	</div>
	</div>
  </body>
</html>
