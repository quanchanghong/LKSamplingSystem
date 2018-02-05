<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>关系添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="${pageContext.request.contextPath}/admin/question/save" method="post" enctype="multipart/form-data">
   			<div class="row">
   			<div class="col-6">
			<div class="form-group row">
				<label for="customName" class="col-sm-2 col-form-label font-weight-bold">业主名称</label>
				<div class="col-sm-5">
					<input type="text" value="${globalPD.customName}" class="form-control " readonly="readonly" id="customName" name="customName" placeholder="业主名称">
				</div>
			</div>
			<div class="form-group row">
				<label for="riskValue" class="col-sm-2 col-form-label font-weight-bold">风险值</label>
				<div class="col-sm-5">
					<input type="text" value="${globalPD.riskValue}" class="form-control " id="riskValue" name="riskValue"  placeholder="风险值">
				</div>
			</div>
			<div class="form-group row">
				<label for="riskValue" class="col-sm-2 col-form-label font-weight-bold">产品问题</label>
				<div class="col-sm-5">
					<input type="text"  class="form-control " id="type" name="type"  placeholder="产品问题">
				</div>
			</div>
			<%-- <div class="form-group row">
				<label for="avg" class="col-sm-1 col-form-label font-weight-bold">平均值</label>
				<div class="col-sm-3">
					<input type="text" value="${globalPD.avg}" class="form-control " id="avg" name="avg"   placeholder="平均值">
				</div>
			</div>
			<div class="form-group row">
				<label for="std" class="col-sm-1 col-form-label font-weight-bold">标准差</label>
				<div class="col-sm-3">
					<input type="text" value="${globalPD.std}" class="form-control " id="std" name="std"  placeholder="标准差">
				</div>
			</div>
			<div class="form-group row">
				<label for="max" class="col-sm-1 col-form-label font-weight-bold">终值</label>
				<div class="col-sm-3">
					<input type="text" value="${globalPD.max}" class="form-control " id="max" name="max"  placeholder="终值">
				</div>
			</div>
			<div class="form-group row">
				<label for="max" class="col-sm-1 col-form-label font-weight-bold">最小值</label>
				<div class="col-sm-3">
					<input type="text" value="${globalPD.min}" class="form-control " id="min" name="min"  placeholder="最小值">
				</div>
			</div>
			<div class="form-group row">
				<label for="riskValue" class="col-sm-1 col-form-label font-weight-bold">风险值</label>
				<div class="col-sm-3">
					<input type="text" value="${globalPD.riskValue}" class="form-control " id="riskValue" name="riskValue"  placeholder="风险值">
				</div>
			</div> --%>
			</div>
			<div class="col-5">
				<img alt=""  class="img-thumbnail" src="" id="headerImg" name="headerImg" style="height: 200px;width: 400px" >
			</div>
			</div>
			<div class="form-group row">
				<label for="description" class="col-sm-1 col-form-label font-weight-bold">不良性状描述</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="description" name="description" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label for="reason" class="col-sm-1 col-form-label font-weight-bold">不良原因说明</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="reason" name="reason" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label for="imgurl" class="col-sm-1 col-form-label font-weight-bold">不良照片</label>
				<div class="col-sm-3">
					<input type="file" class="form-control" id="header" name="header" placeholder="头像" onchange="showPreHeaderImg(this)">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-4">
					<input type="submit" class="form-control btn btn-success" value="保存">
				</div>
			</div>
		</form>
   	</div>
   	<script type="text/javascript">
  	function showPreHeaderImg(source){
  		var file = source.files[0];
  		if (window.FileReader){
  			var fileReader = new FileReader();
  			fileReader.onloadend = function(e){
  				document.getElementById("headerImg").src = e.target.result;
  			};
  			fileReader.readAsDataURL(file);
  		}
  		else{
  			alert("你的浏览器不支持H5，请升级浏览器！");
  		}
  	}
  	
  </script>
  </body>
</html>
