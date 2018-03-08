<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/frontHeader.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>雷达图</title>
  </head>
  
  <body>
  
    <div class="container_fulid">
    
    	<div class="row">
    		<div class="" style="margin-left: 100px;">
    			<div>
    				<span>
    					<!-- <button class="btn btn-info" id="btn_query">查询风险系数</button> -->
    					<!-- <button class="btn btn-info" id="btn_test">测试</button> -->
    					<!-- <span class="text-danger" id="txt_risk_value"></span> -->
    				</span>
    			</div>
    		</div>
    	</div>
    	
    	<div class="row" style="margin-left: 88px;margin-right: 88px;">
    		<table class="table table-bordered">
    			<tr>
    				<td><h3><span class="badge badge-secondary">区域</span></h3></td>
    				<td>
    					<c:forEach items="${areaIndustrySpeciesMap.areaList}" var="area" varStatus="status">
							<input type="radio" id="area${status.count}" name="area" value="${area.areaId}" style="margin: 10px;">${area.areaName}
						</c:forEach>
    				</td>
    			</tr>
    			<tr>
    				<td><h3><span class="badge badge-secondary">产业</span></h3></td>
    				<td>
    					<c:forEach items="${areaIndustrySpeciesMap.industryList}" var="industry" varStatus="status">
							<input type="radio" id="industry${status.count}" name="industry" value="${industry.industryId}" style="margin: 10px;">${industry.industryName}
						</c:forEach>
    				</td>
    			</tr>
    			<tr>
    				<td><h3><span class="badge badge-secondary">物种</span></h3></td>
    				<td>
    					<c:forEach items="${areaIndustrySpeciesMap.speciesList}" var="species" varStatus="status">
							<input type="checkbox" id="species${status.count}" name="${species.speciesName}" value="${species.speciesId}" onclick="getSelect(this)" style="margin: 10px;">${species.speciesName}
						</c:forEach>
    				</td>
    			</tr>
    			<tr>
    				<td><h3><span class="badge badge-info">操作</span></h3></td>
    				<td>
    					<button class="btn btn-info" id="btn_radar">生成雷达图</button>
    					<button class="btn btn-danger" id="btn_query">查询风险系数</button>
    					<span class="text-danger" id="txt_risk_value"></span>
    				</td>
    			</tr>
    		</table>
    	</div>
    	
    	<div class="row">
    		<div class="" style="margin-left: 100px;">
    			<div>
    				
    			</div>
    			<div class="" style="width: 450px;">
    				<form action="">
					<table class="table table-bordered table-sm" id="table_species">
						<thead>
							<tr>
								<th scope="col">物种</th>
								<th scope="col" width='45%'>浓度</th>
							</tr>
						</thead>
						<tbody>
							
						</tbody>
					</table>
					</form>
				</div>
    		</div>
    		<div class="">
				<div class="right_container" id="radar" style="height: 60%; width: 60%;">
				</div>
			</div>
    	</div>
   	</div>
  </body>
  
  <script type="text/javascript">
  
  	var speciesArray = new Array();
  	var speciesIds = new Array();
  	
  	function calculatePercent(obj){
  		var suffTrId = $(obj).attr("id").toString().substring(4);
  		var areaId = $("input:radio[name='area']:checked").val();
   		var industryId = $("input:radio[name='industry']:checked").val();
   		var speciesId = $("#spec_" + suffTrId + "").attr("name");
   		var concentration = $(obj).prop("value");
   		
   		$.ajax({
   				url:"/concentration/calculate",
   				type:"post",
   				/* dataType:"json", */
   				data:{"areaId":areaId,"speciesId":speciesId,"industryId":industryId,"concentration":concentration},
   				success:function(data){
   					var obj = eval('(' + data + ')');
   					if (obj.msgType == 1){
   						$("#perc_" + suffTrId).val(parseFloat(obj.percent));
   					}else{
   						//$("#perc_" + idx).val("查询排名失败!");
   						alert("你所选的物种查询浓度排名失败!");
   					}
   				}
   			});
  	}
  
  	function getSelect(obj){
  	
  		var isChecked = $(obj).prop("checked");
  		var isAreaChecked = $("input:radio[name='area']:checked").val();
  		var isIndustryChecked = $("input:radio[name='industry']:checked").val();
  		
  		if (isAreaChecked == null || isIndustryChecked == null){
  			alert("请先选择区域和产业别!");
  			$(obj).prop("checked", false);
  			return;
  		}
  		
  		if (isChecked == true){
  		
  			speciesArray.push($(obj).attr("name"));
  			speciesIds.push($(obj).attr("value"));
  			
  			$("#table_species > tbody").append("<tr id='tr_" + $(obj).attr("value") + "'>"
  			+ "<td><input id='spec_" + $(obj).attr("value") + "' name='" + $(obj).attr("value") + "' value='"+$(obj).attr("name")+"' type='text' class='form-control form-control-sm' placeholder='请输入物种名称'/></td>" 
  			+ "<td width='45%'><input id='con_" + $(obj).attr("value") + "' name='" + $(obj).attr("value") + "' onblur='calculatePercent(this)'  type='number' class='form-control form-control-sm' placeholder='请输入浓度值'/>"
  			+ 				  "<input id='perc_" + $(obj).attr("value") + "' value='' type='hidden'/>"
  			+ "</td>" 
  			+ "</tr>");
  			
  		}else if (isChecked == false){
  			for (var i = 0; i < speciesArray.length; i++){
  				if (speciesArray[i] == $(obj).attr("name")){
  				
  					speciesArray.splice(i,1);
  					speciesIds.splice(i,1);
  					
  					$("#tr_" + $(obj).attr("value") + "").remove();
  					
  					break;
  				}
  			}
  		} 
  	}
  
  </script>
  
<script type="text/javascript">
  	//var dom = $("#radar");
  	var myRadar = echarts.init(document.getElementById("radar"));
  	var option = {
    title: {
        text: '风险雷达图',
        subtext:'',
        top:'',
        left:''
    },
    tooltip: {
    	show:false
    },
    legend: {
        data: []
    },
    radar: {
        splitNumber: 10,
        name: {
        	fontSize:20,
            textStyle: {
                color: '',
                backgroundColor: '',
                borderRadius: 3,
                padding: [3, 5]
           }
        },
        axisLabel:{
        	show:true,
        	showMinLabel:false
        },
        indicator: [
           { text: '', max: 100},
           { text: '', max: 100},
           { text: '', max: 100},
           { text: '', max: 100},
           { text: '', max: 100}
        ]
    },
    series: [{
        name: '物种',
        type: 'radar',
        // areaStyle: {normal: {}},
        data : [
            {
                value : [0,0,0,0,0],
                name : '物种'
            }
        ]
    }]
};
	myRadar.setOption(option);
	
	function getinitDataFromServcer(){
		$.ajax({
  			url: "concentration/initRadarRandSpecies",//随机获取20个物种值
  			dataType: 'json',
  			data:{},
  			success: function(data){
  				var initOp = {
  					radar: {
        				indicator: []
   					},
   					series: [{
   						/* itemStyle: {normal: {areaStyle: {type: ''}}}, */
   						data:[{
   							value:[]
   						}]
   					}]
  				};
  				$.each(data, function(i, obj){
  					if (i == 20){
  						return false;
  					}
  					initOp.radar.indicator.push({name:obj.speciesName, max:100});
  					initOp.series[0].data[0].value.push(Math.random()*100);
  				});
  				
  				myRadar.setOption(initOp);
  				
  			}
  		});
	}
	
	
  </script> 
  <script type="text/javascript">
  
  	var globalTimer = -1;
  	
	$(document).ready(function(){
	
		var globalId = $("input[type=checkbox]").length;
		
		getinitDataFromServcer();
		
		globalTimer = setInterval(function(){
  					getinitDataFromServcer();
  				}, 3000);
  				
  		$("#btn_query").on("click", function(){
  			var trArray = $("#table_species > tbody > tr").toArray();
  			var jsonArray = new Array();
  			var queryContinue = true;
  			
  			if ($("#txt_risk_value").html().length > 0){
  				$("#txt_risk_value").show();
  				return;
  			}
  			
  			if (trArray.length < 3){
  				alert("至少需要输入三组物种才能计算风险值！");
  				return;
  			}
  			
  			$.each(trArray, function(index, value){
  			var suffTrId = $(value).attr("id").toString().substring(3);
  			var species = $("#spec_" + suffTrId + "").val();
  			var percent = $("#perc_" + suffTrId + "").val();
  			var obj = new Object();
  			obj.species = species;
  			obj.percent = parseFloat(percent);
  			if (obj.percent < 0.0){
  				alert("浓度值计算错误！无法生成雷达图。物种名称为————》" + $("#spec_" + suffTrId + "").prop("value"));
  				queryContinue = false;
  				return false;
  			}
  			jsonArray.push(obj);
  			//alert(jsonArray);
  		});
  		
  		$.post(
  			"concentration/risk",
  			{jsonStr:JSON.stringify(jsonArray)},
  			function(data){
  				$("#txt_risk_value").html(data.riskValue);
  			},"json"
  		);
  	});
  				
  		$("#btn_radar").on("click", function(){
  		//alert($("tbody > tr").toArray());
  		
  		clearInterval(globalTimer);//清除随机显示
  		
  		var trArray = $("#table_species > tbody > tr").toArray();
  		var jsonArray = new Array();
  		var queryContinue = true;
  		
  		if (trArray.length < 3){
  			alert("至少需要输入三组物种才能生成雷达图！");
  			return;
  		}
  		
  		$.each(trArray, function(index, value){
  			var suffTrId = $(value).attr("id").toString().substring(3);
  			var species = $("#spec_" + suffTrId + "").val();
  			var percent = $("#perc_" + suffTrId + "").val();
  			
  			var obj = new Object();
  			obj.species = species;
  			obj.percent = parseFloat(percent);
  			if (obj.percent < 0.0){
  				alert("浓度值计算错误！无法生成雷达图。物种名称为————》" + $("#spec_" + suffTrId + "").prop("value"));
  				queryContinue = false;
  				return false;
  			}
  			jsonArray.push(obj);
  			//alert(jsonArray);
  		});
  		
  		if(!queryContinue){
  			return false;
  		}
  		
  		$.post(
  			"concentration/risk",
  			{jsonStr:JSON.stringify(jsonArray)},
  			function(data){
  				//var obj = eval('(' + data12 + ')');
  				//alert(JSON.stringify(data12).spList[0]);
  				//alert(data.spList[0].percent);
  				
  				var op1 = {
  					toolbox : {
						feature : {
							//restore: {},
							saveAsImage : {}
						}
					},
  					radar: {
        				indicator: []
   					},
   					series: [{
   						itemStyle: {normal: {areaStyle: {type: 'default'}}},
   						data:[{
   							value:[]
   						}]
   					}]
  				};
  				
  				$("#txt_risk_value").html(data.riskValue);
  				$("#txt_risk_value").hide();
  				
  				$.each(data.spList, function(i, obj){
  					op1.radar.indicator.push({ name: obj.species, max: 100});
  					op1.series[0].data[0].value.push(obj.percent);
  				});
  				myRadar.setOption(op1);
  			},"json"
  		);
  	});
		
  	});
  </script>
</html>
