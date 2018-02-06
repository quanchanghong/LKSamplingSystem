<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>风险物种添加</title>
  </head>
  
  <body>
    	<div class="container">
    	<div class="row">
    		<div class="" style="margin-left: 100px;">
    			<div style="margin-top: 100px;">
    				<span>
    					<!-- <button class="btn btn-success" id="btn_add">添加</button>
    					<button class="btn btn-danger" id="btn_del">删除</button>
    					<button class="btn btn-info" id="btn_save">保存</button> -->
    					<!-- <button class="btn btn-info" id="btn_test">测试</button> -->
    					<!-- <span class="text-danger" id="txt_risk_value"></span> -->
    				</span>
    			</div>
    			<div class="" >
    				<form action="">
					<table class="table table-bordered " id="table">
						<thead>
							<tr>
								<th scope="col">业主名称</th>
								<th scope="col">问题种类</th>
								<th scope="col">处理日期</th>
								<th scope="col">资料来源</th>
								<th scope="col">风险值</th>
								<!-- <th scope="col">处理日期</th>
								<th scope="col">资料来源</th> -->
							</tr>
						</thead>
						<tbody>
							<tr id="tr_1" >
								<th>
									<input type="text" id="custom_1" readonly="readonly" class="form-control-plaintext form-control-sm" placeholder="请输入业主名称" value="${baseSpecies.customName}"/>
								</th>
								<th>
									<input type="text" id="custom_1" readonly="readonly" class="form-control-plaintext form-control-sm" placeholder="" value="${baseSpecies.productQuestion.type}"/>
								</th>
								<th>
									<input type="text" id="custom_1" readonly="readonly" class="form-control-plaintext form-control-sm" placeholder="" value="${baseSpecies.date}"/>
								</th>
								<th>
									<input type="text" id="custom_1" readonly="readonly" class="form-control-plaintext form-control-sm" placeholder="" value="${baseSpecies.source}"/>
								</th>
								<th>
									<input type="text" id="custom_1" readonly="readonly" class="form-control-plaintext form-control-sm" placeholder="" value="${baseSpecies.riskValue}"/>
								</th>
							</tr>
							<tr id="tr_2">
								<th scope="col">物种</th>
								<th scope="col">区域</th>
								<th scope="col">产业</th>
								<th scope="col">浓度</th>
								<th scope="col">浓度排名</th>
							</tr>
							<c:forEach items="${baseSpecies.AISCPSet}" var="ascp">
								<tr>
									<th>
										<input type="text" readonly="readonly" class="form-control-plaintext form-control-sm" value="${ascp.species.speciesName}"/>
									</th>
									<th>
										<input type="text" readonly="readonly" class="form-control-plaintext form-control-sm" value="${ascp.area.areaName}"/>
									</th>
									<th>
										<input type="text" readonly="readonly" class="form-control-plaintext form-control-sm" value="${ascp.industry.industryName}"/>
									</th>
									<th>
										<input type="text" readonly="readonly" class="form-control-plaintext form-control-sm" value="${ascp.concentrationValue}"/>
									</th>
									<th>
										<input type="text" readonly="readonly" class="form-control-plaintext form-control-sm" value="${ascp.percent}"/>
									</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
    		</div>
    	</div>
   	</div>
   	<script type="text/javascript">
   	
   		var globalId = -1;
   	
   		function addOneRow(){
   			globalId = globalId + 1;
   			var idx = globalId;
   			//alert(idx);
   			$("#table > tbody").append("<tr id='tr_" + idx + "'>"
   				+ "<th><input type='checkbox' "+ "id='cb_" + (idx) + "'/></th>" 
   				+ "<th>"
   				+ "<select class='form-control form-control-sm' id='speciesId_" + idx + "' name='speciesId_" + idx + "' >"
   				+ "<c:forEach items='${areaIndustrySpeciesMap.speciesList}' var='species'>"
   				+ "<option value='${species.speciesId}'>${species.speciesName}</option>"
   				+ "</c:forEach>"
   				+ "</select>"
   				+ "</th>"
   				+ "<th>"
   				+ "<select class='form-control form-control-sm' id='areaId_" + idx + "' name='areaId_" + idx + "' >"
   				+ "<c:forEach items='${areaIndustrySpeciesMap.areaList}' var='area'>"
   				+ "<option value='${area.areaId}'>${area.areaName}</option>"
   				+ "</c:forEach>"
   				+ "</select>"
   				+ "</th>"
   				+ "<th>"
   				+ "<select class='form-control form-control-sm' id='industryId_" + idx + "' name='industryId_" + idx + "' >"
   				+ "<c:forEach items='${areaIndustrySpeciesMap.industryList}' var='industry'>"
   				+ "<option value='${industry.industryId}'>${industry.industryName}</option>"
   				+ "</c:forEach>"
   				+ "</select>"
   				+ "</th>"
   				+ "<th>"
   				+ "<input type='number' onblur='calculatePercent(this.id)' id='con_" + idx + "' name='con_" + idx + "' class='form-control form-control-sm' placeholder='请输入浓度'/>"
   				+ "</th>"
   				+ "<th>"
   				+ "<input type='text' id='perc_" + idx + "' name='perc_" + idx + "' class='form-control form-control-sm' placeholder='输入浓度自动计算'/>"
   				+ "</th>"
   				/* + "<th>"
   				+ "<input type='date' id='date_" + idx + "' name='date_" + idx + "' class='form-control form-control-sm' placeholder='请输入处理日期'/>"
   				+ "</th>"
   				+ "<th>"
   				+ "<input type='text' id='source_" + idx + "' name='source_" + idx + "' class='form-control form-control-sm' placeholder='请输入资料来源'/>"
   				+ "</th>" */
   				+ "</tr>" 
   			);
   		}
   		
   		function deleteOneRow(){
   			var cbArray = $("input:checked").toArray();
   			$.each(cbArray, function(i, obj){
   				var cbId = $(obj).attr("id").toString().substring(3);
   				$("#tr_" + cbId + "").remove();
   			});
   		}
   		
   		function calculatePercent(id){
   			var idx = id.substring(4);
   			var areaId = $("#areaId_" + idx + "").val();
   			var industryId = $("#industryId_" + idx + "").val();
   			var speciesId = $("#speciesId_" + idx + "").val();
   			var concentration = $("#con_" + idx + "").val();
   			
   			$.ajax({
   				url:"/sampling/concentration/calculate",
   				type:"post",
   				/* dataType:"json", */
   				data:{"areaId":areaId,"speciesId":speciesId,"industryId":industryId,"concentration":concentration},
   				success:function(data){
   					var obj = eval('(' + data + ')');
   					if (obj.msgType == 1){
   						$("#perc_" + idx).val(parseFloat(obj.percent));
   					}else{
   						$("#perc_" + idx).val("查询排名失败!");
   					}
   				}
   			});
   		}
   		function saveData(){
   			var trArray = $("tbody > tr").toArray();
   			var jsonArray = new Array();
   			var customName = $("#custom_1").val();
   			var date = $("#date_1").val();
   			var source = $("#source_1").val();
   			var pdId = $("#pdType").val();
   			
   			$.each(trArray, function(i, obj){
   				var suffId = $(obj).attr("id").substring(3);
   				var object = new Object();
   				/* object.customName = customName;
   				object.date = $("#date_" + suffId + "").val();
   				object.source = $("#source_" + suffId + "").val(); */
   				object.speciesId = $("#speciesId_" + suffId + "").val();
   				object.areaId = $("#areaId_" + suffId + "").val();
   				object.industryId = $("#industryId_" + suffId + "").val();
   				object.concentrationValue = $("#con_" + suffId + "").val();
   				object.percent = $("#perc_" + suffId + "").val();
   				
   				jsonArray.push(object);
   			});
   			
   			$.ajax({
   				url:"save",
   				type:"post",
   				dataType:"json",//, date:date, customName:customName, source:source, pdType:pdType
   				data:{jsonStr:JSON.stringify(jsonArray),date:date,customName:customName,source:source,pdId:pdId},
   				success:function(data){
   					if (data == 1){//成功
   						window.location.assign("${pageContext.request.contextPath}/admin/riskSpecies");
   					}else{
   						alert("添加失败!");
   					}
   				}
   			});
   		}
   		
   		$(document).ready(function(){
   			globalId = parseInt($("tr:last").attr("id").substring(3));
   			
   			$("#btn_add").on("click", function(){
   				addOneRow();
   			});
   			
   			$("#btn_del").on("click", function(){
   				deleteOneRow();
   			});
   			
   			$("#btn_save").on("click", function(){
   				saveData();
   			});
   		});
   	</script>
  </body>
</html>
