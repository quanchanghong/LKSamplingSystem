<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>问题添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="${pageContext.request.contextPath}/admin/question/save" method="post" enctype="multipart/form-data" onsubmit="return checkBeforeSave()">
   			<div class="row">
   			<div class="col-6">
			<div class="form-group row">
				<label for="type" class="col-sm-2 col-form-label font-weight-bold">问题种类</label>
				<div class="col-sm-5">
					<input type="text" class="form-control " id="type" name="type" placeholder="请输入问题种类">
				</div>
			</div>
			<div class="form-group row">
				<label for="max" class="col-sm-2 col-form-label font-weight-bold">最大值</label>
				<div class="col-sm-5">
					<input type="number" class="form-control " id="max" name="max"  placeholder="请输入最大值,默认为0">
				</div>
			</div>
			<div class="form-group row">
				<label for="min" class="col-sm-2 col-form-label font-weight-bold">最小值</label>
				<div class="col-sm-5">
					<input type="number"  class="form-control " id="min" name="min"  placeholder="请输入最小值,默认为0">
				</div>
			</div>
			<div class="form-group row">
				<label for="avg" class="col-sm-2 col-form-label font-weight-bold">平均值</label>
				<div class="col-sm-5">
					<input type="number"  class="form-control " id="avg" name="avg"  placeholder="请输入平均值,默认为0">
				</div>
			</div>
			<div class="form-group row">
				<label for="std" class="col-sm-2 col-form-label font-weight-bold">标准差</label>
				<div class="col-sm-5">
					<input type="number"  class="form-control " id="std" name="std"  placeholder="请输入标准差值,默认为0">
				</div>
			</div>
			</div>
			<div class="col-5">
				<img alt=""  class="img-thumbnail" src="" id="pdImg" name="pdImg" style="height: 260px;width: 400px" >
			</div>
			</div>
			<div class="form-group row">
				<label for="description" class="col-sm-1 col-form-label font-weight-bold">性状描述</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="description" name="description" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label for="reason" class="col-sm-1 col-form-label font-weight-bold">原因说明</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="reason" name="reason" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label for="imgurl" class="col-sm-1 col-form-label font-weight-bold">不良照片</label>
				<div class="col-sm-3">
					<input type="file" class="form-control" id="questionImg" name="questionImg" placeholder="不良图片" onchange="showPrepdImg(this)">
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
  	function showPrepdImg(source){
  		var file = source.files[0];
  		if (window.FileReader){
  			var fileReader = new FileReader();
  			fileReader.onloadend = function(e){
  				document.getElementById("pdImg").src = e.target.result;
  			};
  			fileReader.readAsDataURL(file);
  		}
  		else{
  			alert("你的浏览器不支持H5，请升级浏览器！");
  		}
  	}
  	
  </script>
  </body>
  <script type="text/javascript">
  
  function checkBeforeSave(){
  		var type = $("#type").val();
		var canSumbit = true;
		
  		 $.ajax({
   			url:"/sampling/admin/question/checkBeforeSave",
   			async:false,
   			type:"post",
   			data:{"type":type},
   			success:function(data){
   				
   				if (data > 0){
   					canSumbit = false;
   					alert("你所添加的问题种类在后台已经存在，无法添加，只能修改！");
   				}
   			}
   		}); 
  	return canSumbit;
  }
  </script>
</html>
