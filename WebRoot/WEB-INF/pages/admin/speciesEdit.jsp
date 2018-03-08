<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>物种添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="${pageContext.request.contextPath}/admin/species/save" method="post" onsubmit="return checkBeforeSave()">
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
  <script type="text/javascript">
  
  function checkBeforeSave(){
  		var speciesName = $("#speciesName").val();
		var canSumbit = true;
		
  		 $.ajax({
   			url:"/admin/species/checkBeforeSave",
   			async:false,
   			type:"post",
   			data:{"speciesName":speciesName},
   			success:function(data){
   				
   				if (data > 0){
   					canSumbit = false;
   					alert("你所添加的物种在后台已经存在，无法添加，只能修改！");
   				}
   			}
   		}); 
  	return canSumbit;
  }
  </script>
</html>
