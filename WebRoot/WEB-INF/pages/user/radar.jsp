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
    					<button class="btn btn-success" id="btn_add">添加</button>
    					<button class="btn btn-danger" id="btn_del">删除</button>
    					<button class="btn btn-info" id="btn_query">查询风险值</button>
    					<button class="btn btn-info" id="btn_test">测试</button>
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
								<th><input type="text" id="perc_1" name="perc_1" class="form-control form-control-sm" placeholder="请输入浓度排名"/></th>
							</tr>
							<tr id="tr_2">
								<th><input type="checkbox" id="cb_2"/></th>
								<!-- <th>2</th> -->
								<th><input type="text" id="spec_2" name="spec_2" class="form-control form-control-sm" placeholder="请输入物种名称"/></th>
								<th><input type="text" id="perc_2" name="perc_2" class="form-control form-control-sm" placeholder="请输入浓度排名"/></th>
							</tr>
							<tr id="tr_3">
								<th><input type="checkbox" id="cb_3"/></th>
								<!-- <th>3</th> -->
								<th><input type="text" id="spec_3" name="spec_3" class="form-control form-control-sm" placeholder="请输入物种名称"/></th>
								<th><input type="text" id="perc_3" name="perc_3" class="form-control form-control-sm" placeholder="请输入浓度排名"/></th>
							</tr>
						</tbody>
					</table>
					</form>
				</div>
    		</div>
    		<div class="col" style="margin-right: 100px">
				<div class="right_container" id="radar" style="height: 500px;">
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
        text: '风险雷达图'
    },
    tooltip: {},
    legend: {
        data: ['物种', '物种']
    },
    radar: {
        // shape: 'circle',
        name: {
            textStyle: {
                color: '#fff',
                backgroundColor: '#999',
                borderRadius: 3,
                padding: [3, 5]
           }
        },
        indicator: [
           { name: '物种', max: 6500},
           { name: '物种', max: 16000},
           { name: '物种', max: 30000},
           { name: '物种', max: 38000},
           { name: '物种', max: 52000},
           { name: '物种', max: 25000}
        ]
    },
    series: [{
        name: '物种',
        type: 'radar',
        // areaStyle: {normal: {}},
        data : [
            {
                value : [4300, 10000, 28000, 35000, 50000, 19000],
                name : '物种'
            }
        ]
    }]
};
	myRadar.setOption(option);
	
	$(document).ready(function(){
	
		var globalId = $("input[type=checkbox]").length;
	
  		$("#btn_add").on("click", function(){
  			globalId = globalId + 1;
  			var idx = globalId;
  			$("#table > tbody").append("<tr id='tr_" + idx + "'>"
  			+ "<th><input type='checkbox' "+ "id='cb_" + (idx) + "'/></th>" 
  			/* + "<th>"+ idx +"</th>" */
  			+ "<th><input id='spec_" + idx + "' name='spec_" + idx + "' type='text' class='form-control form-control-sm' placeholder='请输入物种名称'/></th>" 
  			+ "<th><input id='perc_" + idx + "' name='perc_" + idx + "' type='text' class='form-control form-control-sm' placeholder='请输入浓度排名'/></th>" 
  			+ "</tr>");
  		});
  	});
  	
  	$("#btn_del").on("click", function(){
  		var id = $("input:checked").attr("id").toString().substring(3);
  		var cbArray = $("input:checked").toArray();
  		$.each(cbArray, function(index, value){
  			var cbId = $(value).attr("id").toString().substring(3);
  			$("#tr_" + cbId + "").remove();
  		});
  		
  	});
  	
  	$("#btn_query").on("click", function(){
  		//alert($("tbody > tr").toArray());
  		
  		var trArray = $("tbody > tr").toArray();
  		var jsonArray = new Array();
  		
  		$.each(trArray, function(index, value){
  			var suffTrId = $(value).attr("id").toString().substring(3);
  			var species = $("#spec_" + suffTrId + "").val();
  			var percent = $("#perc_" + suffTrId + "").val();
  			var obj = new Object();
  			obj.species = species;
  			obj.percent = percent;
  			jsonArray.push(obj);
  			//alert(jsonArray);
  		});
  		
		var jsonObj = $("form").serializeArray();		
  		$.post(
  			"concentration/risk",
  			{jsonStr:JSON.stringify(jsonArray)},
  			function(data){
  				//var obj = eval('(' + data12 + ')');
  				//alert(JSON.stringify(data12).spList[0]);
  				//alert(data.spList[0].percent);
  				
  				var op1 = {
  					radar: {
        				indicator: []
   					},
   					series: [{
   						data:[{
   							value:[]
   						}]
   					}]
  				};
  				$.each(data.spList, function(i, obj){
  					op1.radar.indicator.push({ text: obj.species, max: 100});
  					op1.series[0].data[0].value.push(obj.percent);
  				});
  				myRadar.setOption(op1);
  			},"json"
  		);
  	});
	
  </script>
  <script type="text/javascript">
  var option1 = {
    
    radar: {
        // shape: 'circle',
        name: {
            textStyle: {
                color: '#fff',
                backgroundColor: '#999',
                borderRadius: 3,
                padding: [3, 5]
           }
        },
        indicator: [
           { name: '销售（sales）', max: 100},
           { name: '管理（Administration）', max: 100},
           { name: '信息技术（Information Techology）', max: 100},
           { name: '客服（Customer Support）', max: 100},
           { name: '研发（Development）', max: 100},
           { name: '市场（Marketing）', max: 100}
        ]
    },
    series: [{
        name: '预算 vs 开销（Budget vs spending）',
        type: 'radar',
        // areaStyle: {normal: {}},
        data : [
            {
                value : [10, 20, 30, 40, 50, 60],
                name : '预算分配（Allocated Budget）'
            }
        ]
    }]
};
  	$("#btn_test").on("click", function(){
  	
  		myRadar.setOption(option1);
  	});
  </script>
</html>
