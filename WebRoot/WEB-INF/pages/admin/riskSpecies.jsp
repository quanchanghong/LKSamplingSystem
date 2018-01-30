<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>风险物种添加</title>
  </head>
  
  <body>
    	<div class="container_fulid">
    	<div class="row">
    		<div class="" style="margin-left: 100px;">
    			<div>
    				<span>
    					<button class="btn btn-success" id="btn_add">添加</button>
    					<button class="btn btn-danger" id="btn_del">删除</button>
    					<button class="btn btn-info" id="btn_save">保存</button>
    					<!-- <button class="btn btn-info" id="btn_test">测试</button> -->
    					<span class="text-danger" id="txt_risk_value"></span>
    				</span>
    			</div>
    			<div class="" >
    				<form action="">
					<table class="table table-bordered table-sm" id="table">
						<thead>
							<tr>
								<th scope="col">业主名称</th>
								<th scope="col">物种</th>
								<th scope="col">区域</th>
								<th scope="col">产业</th>
								<th scope="col">浓度</th>
								<th scope="col">浓度排名</th>
								<th scope="col">处理日期</th>
								<th scope="col">资料来源</th>
							</tr>
						</thead>
						<tbody>
							<tr id="tr_1" >
								<th rowspan="3" ><input type="text" id="custom_1" class="form-control form-control-sm" placeholder="请输入业主名称"/></th>
								<th>
									<select class="form-control form-control-sm" id="speciesId_1" name="speciesId_1" >
										<c:forEach items="${areaIndustrySpeciesMap.speciesList}" var="species">
											<option value="${species.speciesId}">${species.speciesName}</option>
										</c:forEach>
									</select>
								</th>
								<th>
									<select class="form-control form-control-sm" id="areaId_1" name="areaId_1" >
										<c:forEach items="${areaIndustrySpeciesMap.areaList}" var="area">
											<option value="${area.areaId}">${area.areaName}</option>
										</c:forEach>
									</select>
								</th>
								<th>
									<select class="form-control form-control-sm" id="industryId_1" name="industryId_1" >
										<c:forEach items="${areaIndustrySpeciesMap.industryList}" var="industry">
											<option value="${industry.industryId}">${industry.industryName}</option>
										</c:forEach>
									</select>
								</th>
								<th><input type="number" onblur="calculatePercent(this.id)" id="con_1" name="con_1" class="form-control form-control-sm" placeholder="请输入浓度"/></th>
								<th><input type="text" id="perc_1" name="perc_1" class="form-control form-control-sm" placeholder="输入浓度自动计算"/></th>
								<th><input type="date" id="date_1" name="date_1" class="form-control form-control-sm" placeholder="请输入处理日期"/></th>
								<th><input type="text" id="source_1" name="source_1" class="form-control form-control-sm" placeholder="请输入资料来源"/></th>
							</tr>
							<tr id="tr_2">
								<th>
									<select class="form-control form-control-sm" id="speciesId_2" name="speciesId_2" >
										<c:forEach items="${areaIndustrySpeciesMap.speciesList}" var="species">
											<option value="${species.speciesId}">${species.speciesName}</option>
										</c:forEach>
									</select>
								</th>
								<th>
									<select class="form-control form-control-sm" id="areaId_2" name="areaId_2" >
										<c:forEach items="${areaIndustrySpeciesMap.areaList}" var="area">
											<option value="${area.areaId}">${area.areaName}</option>
										</c:forEach>
									</select>
								</th>
								<th>
									<select class="form-control form-control-sm" id="industryId_2" name="industryId_2" >
										<c:forEach items="${areaIndustrySpeciesMap.industryList}" var="industry">
											<option value="${industry.industryId}">${industry.industryName}</option>
										</c:forEach>
									</select>
								</th>
								<th><input type="number" onblur="calculatePercent(this.id)" id="con_2" name="con_2" class="form-control form-control-sm" placeholder="请输入浓度"/></th>
								<th><input type="text" id="perc_2" name="perc_2" class="form-control form-control-sm" placeholder="输入浓度自动计算"/></th>
								<th><input type="date" id="date_2" name="date_2" class="form-control form-control-sm" placeholder="请输入处理日期"/></th>
								<th><input type="text" id="source_2" name="source_2" class="form-control form-control-sm" placeholder="请输入资料来源"/></th>
							</tr>
							<tr id="tr_3">
								<th>
									<select class="form-control form-control-sm" id="speciesId_3" name="speciesId_3" >
										<c:forEach items="${areaIndustrySpeciesMap.speciesList}" var="species">
											<option value="${species.speciesId}">${species.speciesName}</option>
										</c:forEach>
									</select>
								</th>
								<th>
									<select class="form-control form-control-sm" id="areaId_3" name="areaId_3" >
										<c:forEach items="${areaIndustrySpeciesMap.areaList}" var="area">
											<option value="${area.areaId}">${area.areaName}</option>
										</c:forEach>
									</select>
								</th>
								<th>
									<select class="form-control form-control-sm" id="industryId_3" name="industryId_3" >
										<c:forEach items="${areaIndustrySpeciesMap.industryList}" var="industry">
											<option value="${industry.industryId}">${industry.industryName}</option>
										</c:forEach>
									</select>
								</th>
								<th><input type="number" onblur="calculatePercent(this.id)" id="con_3" name="con_3" class="form-control form-control-sm" placeholder="请输入浓度"/></th>
								<th><input type="text" id="perc_3" name="perc_3" class="form-control form-control-sm" placeholder="输入浓度自动计算"/></th>
								<th><input type="date" id="date_3" name="date_3" class="form-control form-control-sm" placeholder="请输入处理日期"/></th>
								<th><input type="text" id="source_3" name="source_3" class="form-control form-control-sm" placeholder="请输入资料来源"/></th>
							</tr>
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
   				+ "<th>"
   				+ "<input type='date' id='date_" + idx + "' name='date_" + idx + "' class='form-control form-control-sm' placeholder='请输入处理日期'/>"
   				+ "</th>"
   				+ "<th>"
   				+ "<input type='text' id='source_" + idx + "' name='source_" + idx + "' class='form-control form-control-sm' placeholder='请输入资料来源'/>"
   				+ "</th>"
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
   			
   			$.each(trArray, function(i, obj){
   				var suffId = $(obj).attr("id").substring(3);
   				var object = new Object();
   				object.customName = customName;
   				object.date = $("#date_" + suffId + "").val();
   				object.source = $("#source_" + suffId + "").val();
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
   				dataType:"json",
   				data:{jsonStr:JSON.stringify(jsonArray)},
   				success:function(data){
   					alert(data);
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
