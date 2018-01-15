<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>关系添加</title>
  </head>
  
  <body>
   	<div class="container">
   		<form action="${pageContext.request.contextPath}/admin/ais/save" method="post">
			<div class="form-group row">
				<label for="name" class="col-sm-1 col-form-label font-weight-bold">名称</label>
				<div class="col-sm-3">
					
					<input type="text" class="form-control " id="name" name="name" placeholder="名称">
				</div>
			</div>
			<div class="form-group row">
				<label for="avg" class="col-sm-1 col-form-label font-weight-bold">平均值</label>
				<div class="col-sm-3">
					<input type="text" class="form-control " id="avg" name="avg"   placeholder="平均值">
				</div>
			</div>
			<div class="form-group row">
				<label for="std" class="col-sm-1 col-form-label font-weight-bold">方差值</label>
				<div class="col-sm-3">
					<input type="text" class="form-control " id="std" name="std"  placeholder="方差值">
				</div>
			</div>
			<div class="form-group row">
				<label for="finalValue" class="col-sm-1 col-form-label font-weight-bold">终值</label>
				<div class="col-sm-3">
					<input type="text" class="form-control " id="finalValue" name="finalValue"  placeholder="终值">
				</div>
			</div>
			<div class="form-group row">
				<label for="areaId" class="col-sm-1 col-form-label font-weight-bold">区域</label>
				<div class="col-sm-3">
					<input type="hidden" class="form-control " id="areaIdHelp" name="areaIdHelp" value="${addMap.ais.area.areaId}" placeholder="区域">
					<select class="form-control" id="areaId" name="area.areaId" >
						<c:forEach items="${addMap.areaList}" var="area">
							<option value="${area.areaId}">${area.areaName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="speciesId" class="col-sm-1 col-form-label font-weight-bold">物种</label>
				<div class="col-sm-3">
					<input type="hidden" class="form-control " id="speciesIdHelp" name="speciesIdHelp" value="${addMap.ais.species.speciesId}" placeholder="物种">
					<select class="form-control" id="speciesId" name="species.speciesId" >
						<c:forEach items="${addMap.speciesList}" var="species">
							<option value="${species.speciesId}">${species.speciesName}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="industryId" class="col-sm-1 col-form-label font-weight-bold">产业</label>
				<div class="col-sm-3">
					<input type="hidden" class="form-control " id="industryIdHelp" name="industryIdHelp" value="${addMap.ais.industry.industryId }" placeholder="产业">
					<select class="form-control" id="industryId" name="industry.industryId" >
						<c:forEach items="${addMap.industryList}" var="industry">
							<option value="${industry.industryId}">${industry.industryName}</option>
						</c:forEach>
					</select>
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
