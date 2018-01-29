<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>风险物种</title>
  </head>
  
  <body>
    	<div class="container">
    	<div class="row">
    		<div class="" style="margin-left: 100px;">
    			<div>
    				<span>
    					<button class="btn btn-success" id="btn_add">添加</button>
    					<button class="btn btn-danger" id="btn_del">删除</button>
    					<button class="btn btn-info" id="btn_query">查询风险系数</button>
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
								<th rowspan="3" ><input type="text" id="cb_1" class="form-control form-control-sm" placeholder="请输入业主名称"/></th>
								<th>
									<select class="form-control" id="areaId" name="area.areaId" >
										<c:forEach items="${addMap.areaList}" var="area">
											<option value="${area.areaId}">${area.areaName}</option>
										</c:forEach>
									</select>
								</th>
								<th>
									<select class="form-control" id="areaId" name="area.areaId" >
										<c:forEach items="${addMap.areaList}" var="area">
											<option value="${area.areaId}">${area.areaName}</option>
										</c:forEach>
									</select>
								</th>
								<th>
									<select class="form-control" id="areaId" name="area.areaId" >
										<c:forEach items="${addMap.areaList}" var="area">
											<option value="${area.areaId}">${area.areaName}</option>
										</c:forEach>
									</select>
								</th>
								<th><input type="number" id="spec_2" name="spec_2" class="form-control form-control-sm" placeholder="请输入浓度"/></th>
								<th><input type="number" id="perc_2" name="perc_2" class="form-control form-control-sm" placeholder="请输入浓度排名"/></th>
								<th><input type="number" id="perc_2" name="perc_2" class="form-control form-control-sm" placeholder="请输入处理日期"/></th>
								<th><input type="number" id="perc_2" name="perc_2" class="form-control form-control-sm" placeholder="请输入资料来源"/></th>
							</tr>
							<tr id="tr_2">
								<th><input type="checkbox" id="cb_2"/></th>
								<!-- <th>2</th> -->
								<th><input type="text" id="spec_2" name="spec_2" class="form-control form-control-sm" placeholder="请输入物种名称"/></th>
								
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
    	</div>
   	</div>
  </body>
</html>
