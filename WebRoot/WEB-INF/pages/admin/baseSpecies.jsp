<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>风险物种管理</title>
  </head>
  <body>
  	<div class="container">
  		<div>
  			<a class="btn btn-success" href="${pageContext.request.contextPath}/admin/riskSpecies/add">添加</a>
  		</div>
  		<div>
  			<table class="table table-bordered ">
			<thead>
				<tr>
					<th scope="col">序号</th>
					<th scope="col">业主名称</th>
					<th scope="col">问题类型</th>
					<th scope="col">风险值</th>
					<!--<th scope="col">产业</th>
					<th scope="col">浓度</th>
					<th scope="col">浓度排名</th> -->
					<th scope="col">处理日期</th>
					<th scope="col">资料来源</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${baseSpeciesPage.list}" var="baseSpecies" varStatus="status">
  					<tr>
  						<th scope="row">${status.count + (baseSpeciesPage.currentPage - 1)*baseSpeciesPage.pageSize}</th>
  						<td>${baseSpecies.customName}</td>
  						<td>${baseSpecies.productQuestion.type}</td>
  						<td>${baseSpecies.riskValue}</td>
  						<%-- <td>${baseSpecies.industry.industryName}</td>
  						<td>${baseSpecies.concentrationValue}</td>
  						<td>${baseSpecies.percent}</td> --%>
  						<td>${baseSpecies.date}</td>
  						<td>${baseSpecies.source}</td>
  						
  						<td>
  							<a  class="btn btn-success " title="123" href="${pageContext.request.contextPath }/admin/riskSpecies/look?id=${baseSpecies.id}" style="height: 30px; padding-top: 1px;">查看</a> 
  							<%-- <a  class="btn btn-danger "  href="${pageContext.request.contextPath }/admin/riskSpecies/delete?id=${baseSpecies.id}"  style="height: 30px; padding-top: 1px;">删除</a>--%>
  						</td>
  					</tr>
  				</c:forEach>
			</tbody>
		</table>
  		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:if test="${baseSpeciesPage.currentPage > 1 }">
					<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/riskSpecies?currentPage=${baseSpeciesPage.currentPage - 1}">上一页</a></li>
				</c:if>
				<c:if test="${baseSpeciesPage.pageCount < 100}">
					<c:forEach begin="1" end="${baseSpeciesPage.pageCount }" step="1" var="i">
						<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/riskSpecies?currentPage=${i}">${i }</a></li>
					</c:forEach>
				</c:if>
				<li class="page-item"><span class="btn btn-success">当前页:${baseSpeciesPage.currentPage}/${baseSpeciesPage.pageCount}</span></li>
				<c:if test="${baseSpeciesPage.currentPage < baseSpeciesPage.pageCount }">
					<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/riskSpecies?currentPage=${baseSpeciesPage.currentPage + 1}">下一页</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
  </body>
</html>
