<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>产业管理</title>
  </head>
  <body>
  	<div class="container">
  		<div>
  			<nav class="navbar navbar-light bg-light justify-content-between">
  				<a class="btn btn-success" href="${pageContext.request.contextPath}/admin/industry/add">添加</a>
  				<form class="form-inline" action="${pageContext.request.contextPath}/admin/industry/search" method="post">
    				<input class="form-control mr-sm-2" type="search" id="industryName" name="industryName" placeholder="请输入产业名称" aria-label="搜索">
    				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
  				</form>
			</nav>
  		</div>
  		<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">序号</th>
					<th scope="col">产业名称</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${onePage.list}" var="industry" varStatus="status">
  					<tr>
  						<th scope="row">${status.count + (onePage.currentPage - 1)*onePage.pageSize}</th>
  						<td>${industry.industryName}</td>
  						<td width="20%">
  							<a  class="btn btn-success "  href="${pageContext.request.contextPath }/admin/industry/edit?industryId=${industry.industryId}" style="height: 30px; padding-top: 1px;">编辑</a>
  							<a  class="btn btn-danger "  href="${pageContext.request.contextPath }/admin/industry/delete?industryId=${industry.industryId}"  style="height: 30px; padding-top: 1px;">删除</a>
  						</td>
  					</tr>
  				</c:forEach>
			</tbody>
		</table>
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:if test="${onePage.currentPage > 1 }">
					<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/industry?currentPage=${onePage.currentPage - 1}">上一页</a></li>
				</c:if>
				<c:if test="${onePage.pageCount < 100}">
					<c:forEach begin="1" end="${onePage.pageCount }" step="1" var="i">
						<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/industry?currentPage=${i}">${i }</a></li>
					</c:forEach>
				</c:if>
				<li class="page-item"><span class="btn btn-success">当前页:${onePage.currentPage}/${onePage.pageCount}</span></li>
				<c:if test="${onePage.currentPage < onePage.pageCount }">
					<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/industry?currentPage=${onePage.currentPage + 1}">下一页</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
  </body>
</html>
