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
    		<div class="col" style="margin-top: 30px;">
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
							<input type="number" class="form-control " id="concentration" name="concentration" style="width: 250px;" placeholder="请输入对应浓度值">
						</div>
					</div>
					<div class="form-group row">
						<label for="percent" class="col-sm-2 col-form-label font-weight-bold">浓度排名</label>
						<div class="col-sm-3" id="div_percent">
							<!-- <input type="text" readonly  class="form-control-plaintext " id="percent" name="percent" style="width: 250px;">--> 
							<span id="percent" class="form-control-plaintext" style="width: 250px;">点击查询获取排名</span> 
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-4">
							<button id="btn_calculate" class="form-control btn btn-success" value="查询" style="width: 340px;">查询</button>
							<!-- <input type="submit" class="form-control btn btn-success" value="查询" style="width: 340px;"> -->
						</div>
					</div>
				</form>
			</div>
			<div class="col" id="pie" style="height: 350px; width: 350px; ">
			</div>
		</div>
   	</div>
  </body>
  <!-- <script type="text/javascript">
  	$(document).ready(function(){
  	
  		$("#btn_calculate").on("click", function(){
  			
			var areaId = $("#areaId").val();
			var speciesId = $("#speciesId").val();
			var industryId = $("#industryId").val();
			var concentration = $("#concentration").val();
			
			$.post(
				"concentration/calculate",
				{"areaId":areaId,"speciesId":speciesId,"industryId":industryId,"concentration":concentration},
				function(data1){
				alert(data1);
					myPie.setOption({
						series: [{value:data1}]
					});
				}
			);
			
  			return false;
  		});
  	});
  </script> -->
  <script type="text/javascript">
			var myPie = echarts.init(document.getElementById("pie"));
			
			var option = {
				tooltip : {
					formatter : "{a} <br/>{b} : {c}%"
				},
				toolbox : {
					feature : {
						//restore: {},
						saveAsImage : {}
					}
				},
				series : [ {
					name : '浓度排名',
					type : 'gauge',
					detail : {
						formatter : '{value}%'
					},
					data : [ {
						value : 0.0,
						name : '百分比'
					} ]
				} ]
			};
			myPie.setOption(option);
			$(document).ready(function(){
  	
  		$("#btn_calculate").on("click", function(){
  			
			var areaId = $("#areaId").val();
			var speciesId = $("#speciesId").val();
			var industryId = $("#industryId").val();
			var concentration = $("#concentration").val();
			
			$.post(
				"concentration/calculate",
				{"areaId":areaId,"speciesId":speciesId,"industryId":industryId,"concentration":concentration},
				function(objStr){
					var obj = eval('(' + objStr + ')');
					//alert(objStr);
					if (obj.msgType == 1){//成功
						//alert(obj.percent);
						$("#percent").html("<a class='text-success' href='#'>查询成功！付款查看排名</a>");
						var percentOpt = {
							series : [ {
								/* name : '浓度排名',
								type : 'gauge',
								detail : {
									formatter : '{value}%'
								}, */
								data : [ {
									value : 0.0,
									name : '百分比'
								} ]
							} ]
						};
						percentOpt.series[0].data[0].value = obj.percent;
						myPie.setOption(percentOpt);
						/* myPie.setOption({
							series: [{data:obj.percent}]
						}); */
					}
					else{
						//失败
						$("#percent").html("<font class='text-danger'>查询失败!</font>");
					}
					
				}
			);
			
  			return false;
  		});
  	});
		</script>
</html>
