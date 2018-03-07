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
    					<button class="btn btn-success" id="btn_add">添加old</button>
    					<button class="btn btn-danger" id="btn_del">删除</button>
    					<button class="btn btn-info" id="btn_query">查询风险系数</button>
    					<!-- <button class="btn btn-info" id="btn_test">测试</button> -->
    					<span class="text-danger" id="txt_risk_value"></span>
    				</span>
    			</div>
    			<div class="" style="width: 400px;">
    				<form action="">
					<table class="table table-bordered table-sm" id="table">
						<thead>
							<tr>
								<th scope="col"><!-- <input type="checkbox"/> --></th>
								<!-- <th scope="col">序号</th> -->
								<th scope="col">物种</th>
								<th scope="col">浓度排名</th>
							</tr>
						</thead>
						<tbody>
							<tr id="tr_1">
								<th><input type="checkbox" id="cb_1"/></th>
								<!-- <th>1</th> -->
								<th><input type="text" id="spec_1" name="spec_1" class="form-control form-control-sm" placeholder="请输入物种名称"/></th>
								<th><input type="number" id="perc_1" name="perc_1" class="form-control form-control-sm" placeholder="请输入浓度排名"/></th>
							</tr>
							<tr id="tr_2">
								<th><input type="checkbox" id="cb_2"/></th>
								<!-- <th>2</th> -->
								<th><input type="text" id="spec_2" name="spec_2" class="form-control form-control-sm" placeholder="请输入物种名称"/></th>
								<th><input type="number" id="perc_2" name="perc_2" class="form-control form-control-sm" placeholder="请输入浓度排名"/></th>
							</tr>
							<tr id="tr_3">
								<th><input type="checkbox" id="cb_3"/></th>
								<!-- <th>3</th> -->
								<th><input type="text" id="spec_3" name="spec_3" class="form-control form-control-sm" placeholder="请输入物种名称"/></th>
								<th><input type="number" id="perc_3" name="perc_3" class="form-control form-control-sm" placeholder="请输入浓度排名"/></th>
							</tr>
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
        // shape: 'circle',
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
		
  		$("#btn_add").on("click", function(){
  			globalId = globalId + 1;
  			var idx = globalId;
  			$("#table > tbody").append("<tr id='tr_" + idx + "'>"
  			+ "<th><input type='checkbox' "+ "id='cb_" + (idx) + "'/></th>" 
  			/* + "<th>"+ idx +"</th>" */
  			+ "<th><input id='spec_" + idx + "' name='spec_" + idx + "' type='text' class='form-control form-control-sm' placeholder='请输入物种名称'/></th>" 
  			+ "<th><input id='perc_" + idx + "' name='perc_" + idx + "' type='number' class='form-control form-control-sm' placeholder='请输入浓度排名'/></th>" 
  			+ "</tr>");
  		});
  	});
  	
  	$("#btn_del").on("click", function(){
  		var id = $("input:checked").attr("id").toString().substring(3);
  		var cbArray = $("input:checked").toArray();
  		$.each(cbArray, function(index, value){
  			if ($("input[type='checkbox']").length <= 3){
  				alert("不能删除!至少需要三组数据");
  				return;
  			}
  			var cbId = $(value).attr("id").toString().substring(3);
  			$("#tr_" + cbId + "").remove();
  		});
  		
  	});
  	
  	$("#btn_query").on("click", function(){
  		//alert($("tbody > tr").toArray());
  		
  		clearInterval(globalTimer);//清除随机显示
  		
  		var trArray = $("tbody > tr").toArray();
  		var jsonArray = new Array();
  		var queryContinue = true;
  		
  		$.each(trArray, function(index, value){
  			var suffTrId = $(value).attr("id").toString().substring(3);
  			var species = $("#spec_" + suffTrId + "").val();
  			var percent = $("#perc_" + suffTrId + "").val();
  			var obj = new Object();
  			obj.species = species;
  			obj.percent = parseFloat(percent * 100);
  			if ((obj.percent > 100) || (obj.percent == 0.0)){
  				alert("浓度排名输入错误！不能超过100%,不能为空！");
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
  				
  				$.each(data.spList, function(i, obj){
  					op1.radar.indicator.push({ name: obj.species, max: 100});
  					op1.series[0].data[0].value.push(obj.percent);
  				});
  				myRadar.setOption(op1);
  			},"json"
  		);
  		
  	});
  </script>
</html>
