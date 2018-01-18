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
				<small id="userNameHelp" class="col-form-label"></small>
			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-1 col-form-label font-weight-bold">密码</label>
				<div class="col-sm-3">
					<input type="password" class="form-control " id="password" name="password"   placeholder="密码">
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-4">
					<input type="submit" class="form-control btn btn-success" id="sub" value="注册">
				</div>
			</div>
		</form>
   	</div>
  </body>
  <script type="text/javascript">
  	$(document).ready(function(){
  		$("#userName").change(function(){
  			$.post(
  				"user/check",
  				{userName:$("#userName").val()},
  				function(data){
  					var isUsed = parseInt(data);
  					if (isUsed == 0){
  						$("#userNameHelp").removeClass("text-danger");
  						$("#userNameHelp").addClass("text-success");
  						$("#userNameHelp").text("用户名可以使用！");
  						$("#sub").attr("disabled", false);
  					}
  					else if(isUsed == 1){
  						$("#userNameHelp").removeClass("text-success");
  						$("#userNameHelp").addClass("text-danger");
  						$("#userNameHelp").text("用户名已经被使用！");
  						$("#sub").attr("disabled", true);
  					} 
  				},"json"
  			);
  		});
  	});
  </script>
</html>
