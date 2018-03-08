<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>产业添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="${pageContext.request.contextPath}/admin/industry/save" method="post" onsubmit="return checkBeforeSave()">
			<div class="form-group row">
				<label for="name" class="col-sm-1 col-form-label font-weight-bold">产业名称</label>
				<div class="col-sm-3">
					<input type="hidden" class="form-control " value="${industry.industryId }" id="industryId" name="industryId" placeholder="id"">
					<input type="text" class="form-control " value="${industry.industryName }" id="industryName" name="industryName" placeholder="产业名称">
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
  <script type="text/javascript">
  
  function checkBeforeSave(){
  		var industryName = $("#industryName").val();
		var canSumbit = true;
		
  		 $.ajax({
   			url:"/admin/industry/checkBeforeSave",
   			async:false,
   			type:"post",
   			data:{"industryName":industryName},
   			success:function(data){
   				
   				if (data > 0){
   					canSumbit = false;
   					alert("你所添加的产业在后台已经存在，无法添加，只能修改！");
   				}
   			}
   		}); 
  	return canSumbit;
  }
  </script>
</html>
