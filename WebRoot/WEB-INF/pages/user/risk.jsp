<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/frontHeader.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>关系添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="#" method="post">
   			<div class="row">
   			<div class="col-6">
   			<div class="form-group row">
				<label for="type" class="col-sm-2 col-form-label font-weight-bold">风险值</label>
				<div class="col-sm-5">
					<input type="text" class="form-control " id="type" name="type" placeholder="请输入要对比的风险值">
				</div>
			</div>
			<div class="form-group row">
				<label for="type" class="col-sm-2 col-form-label font-weight-bold">问题种类</label>
				<div class="col-sm-5">
					<select class="form-control form-control-sm" id="pdType" name="pdType">
						<c:forEach items="${productQuestionList}" var="pd">
							<option value="${pd.pdId}">${pd.type}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="description" class="col-sm-2 col-form-label font-weight-bold">性状描述</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="description" name="description" rows="3">${productQuestionList[0].description}</textarea>
				</div>
			</div>
			<div class="form-group row">
				<label for="reason" class="col-sm-2 col-form-label font-weight-bold">原因说明</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="reason" name="reason" rows="3">${productQuestionList[0].reason}</textarea>
				</div>
			</div>
			</div>
			<div class="col-5">
				<img alt="不良照片"  class="img-thumbnail" src="${productQuestionList[0].imgurl}" id="pdImg" name="pdImg" style="height: 320px;width: 400px" >
			</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-6">
					<input type="submit" class="form-control btn btn-success" value="风险值对比">
				</div>
			</div>
		</form>
   	</div>
   	<script type="text/javascript">
   		$(document).ready(function(){
   			
   			$("#pdType").on("change", function(){
   				var pdId = $("#pdType").val();
   				$.ajax({
  					url: "risk/onepd",//随机获取20个物种值
  					dataType: 'json',
  					data:{pdId:pdId},
  					success: function(data){
  						//alert(data.type);
  						$("#pdImg").attr("src", data.imgurl);
  						$("#reason").text(data.reason);
  						$("#description").text(data.description);
  					}
  				});
   			});
   		});
   	</script>
  </body>
</html>
