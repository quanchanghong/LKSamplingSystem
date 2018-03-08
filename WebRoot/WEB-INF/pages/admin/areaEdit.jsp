<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>区域添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="${pageContext.request.contextPath}/admin/area/save" method="post" onsubmit="return checkBeforeSave()">
			<div class="form-group row">
				<label for="name" class="col-sm-1 col-form-label font-weight-bold">名称</label>
				<div class="col-sm-3">
					<input type="hidden" class="form-control " value="${area.areaId}" id="areaId" name="areaId" placeholder="id"">
					<input type="text" class="form-control " value="${area.areaName}" id="areaName" name="areaName" placeholder="名称">
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
  		var areaName = $("#areaName").val();
		var canSumbit = true;
		
  		$.ajax({
   			url:"/admin/area/checkBeforeSave",
   			async:false,
   			type:"post",
   			data:{"areaName":areaName},
   			success:function(data){
   				
   				if (data > 0){
   					canSumbit = false;
   					alert("你所添加的区域在后台已经存在，无法添加，只能修改！");
   				}
   			}
   		});
  	return canSumbit;
  }
  </script>
</html>
