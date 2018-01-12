<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>区域管理</title>
  </head>
  <body>
  	<div class="container">
  		<div>
  			<a class="btn btn-success" href="${pageContext.request.contextPath}/admin/area/add">添加</a>
  		</div>
  		<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">序号</th>
					<th scope="col">区域名称</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${onePage.list}" var="area" varStatus="status">
  					<tr>
  						<th scope="row">${status.count + (onePage.currentPage - 1)*onePage.pageSize}</th>
  						<td>${area.areaName}</td>
  						<td width="20%">
  							<a  class="btn btn-success "  href="${pageContext.request.contextPath }/admin/area/edit?areaId=${area.areaId}" style="height: 30px; padding-top: 1px;">编辑</a>
  							<a  class="btn btn-danger "  href="${pageContext.request.contextPath }/admin/area/delete?areaId=${area.areaId}"  style="height: 30px; padding-top: 1px;">删除</a>
  						</td>
  					</tr>
  				</c:forEach>
			</tbody>
		</table>
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:if test="${onePage.currentPage > 1 }">
					<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/area?currentPage=${onePage.currentPage - 1}">上一页</a></li>
				</c:if>
				<c:if test="${onePage.pageCount < 100}">
					<c:forEach begin="1" end="${onePage.pageCount }" step="1" var="i">
						<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/area?currentPage=${i}">${i }</a></li>
					</c:forEach>
				</c:if>
				<li class="page-item"><span class="btn btn-success">当前页:${onePage.currentPage}/${onePage.pageCount}</span></li>
				<c:if test="${onePage.currentPage < onePage.pageCount }">
					<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/area?currentPage=${onePage.currentPage + 1}">下一页</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
  </body>
</html>
