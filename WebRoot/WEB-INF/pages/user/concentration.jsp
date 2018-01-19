<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/frontHeader.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>浓度</title>
  </head>
  
  <body>
    <div class="container">
    	<div class="row">
    		<div class="col" style="margin-top: 40px;">
   				<form action="${pageContext.request.contextPath}/#" method="post">
					<div class="form-group row">
						<label for="areaId" class="col-sm-2 col-form-label font-weight-bold">区域</label>
						<div class="col-sm-3">
							<input type="hidden" class="form-control " id="areaIdHelp" name="areaIdHelp" value="${aisMap.ais.area.areaId}" placeholder="区域">
							<select class="form-control" id="areaId" name="areaId" style="width: 250px;">
								<c:forEach items="${aisMap.areaList}" var="area">
									<option value="${area.areaId}">${area.areaName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="speciesId" class="col-sm-2 col-form-label font-weight-bold">物种</label>
						<div class="col-sm-3">
							<input type="hidden" class="form-control " id="speciesIdHelp" name="speciesIdHelp" value="${aisMap.ais.species.speciesId}" placeholder="物种">
							<select class="form-control" id="speciesId" name="speciesId" style="width: 250px;">
								<c:forEach items="${aisMap.speciesList}" var="species">
									<option value="${species.speciesId}">${species.speciesName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="industryId" class="col-sm-2 col-form-label font-weight-bold">产业</label>
						<div class="col-sm-3">
							<input type="hidden" class="form-control " id="industryIdHelp" name="industryIdHelp" value="${aisMap.ais.industry.industryId }" placeholder="产业">
							<select class="form-control" id="industryId" name="industryId" style="width: 250px;">
								<c:forEach items="${aisMap.industryList}" var="industry">
									<option value="${industry.industryId}">${industry.industryName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="concentration" class="col-sm-2 col-form-label font-weight-bold">浓度值</label>
						<div class="col-sm-3">
							<input type="text" class="form-control " id="concentration" name="concentration" style="width: 250px;" placeholder="请输入对应浓度值">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-4">
							<input type="submit" class="form-control btn btn-success" value="查询" style="width: 340px;">
						</div>
					</div>
				</form>
			</div>
			<div class="col" id="pie" style="height: 350px; width: 350px; ">
			</div>
		</div>
   	</div>
  </body>
  <script type="text/javascript">
			var myPie = echarts.init(document.getElementById("pie"));
			var option = {
    tooltip : {
       formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        feature: {
            //restore: {},
            saveAsImage: {}
        }
    },
    series: [
        {
            name: '浓度排名',
            type: 'gauge',
            detail: {formatter:'{value}%'},
            data: [{value: 53.12, name: '百分比'}]
        }
    ]
};
			myPie.setOption(option);
			
		</script>
</html>
