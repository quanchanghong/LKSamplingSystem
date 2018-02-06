<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>产品不良问题列表</title>
  </head>
  <body>
  	<div class="container_fulid" style="margin-left: 40px; margin-right: 40px;">
  		<div>
  			<a class="btn btn-success" href="${pageContext.request.contextPath}/admin/question/add">添加</a>
  		</div>
  		<div>
  			<table class="table table-bordered ">
			<thead>
				<tr>
					<th scope="col">序号</th>
					<th scope="col">问题种类</th>
					<th scope="col">平均值</th>
					<th scope="col">最大值</th>
					<th scope="col">最小值</th>
					<th scope="col">标准差</th>
					<th scope="col">不良描述</th>
					<th scope="col">不良原因</th>
					<th scope="col">不良图片</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questionPage.list}" var="pd" varStatus="status">
  					<tr>
  						<th scope="row">${status.count + (questionPage.currentPage - 1)*questionPage.pageSize}</th>
  						<td>${pd.type}</td>
  						<td>${pd.avg}</td>
  						<td>${pd.max}</td>
  						<td>${pd.min}</td>
  						<td>${pd.std}</td>
  						<td style="width: 15%;">${pd.description}</td>
  						<td style="width: 15%;">${pd.reason}</td>
  						<td style="width: 10%">
  							<img alt="不良照片"  class="img-thumbnail" src="${pd.imgurl}" id="pdImg" name="pdImg">
  						</td>
  						<td style="width: 5%;">
  							<%-- <a  class="btn btn-success " title="123" href="${pageContext.request.contextPath }/admin/question/look?pdId=${pd.pdId}" style="height: 30px; padding-top: 1px;">查看</a> --%>
  							<a  class="btn btn-danger "  href="${pageContext.request.contextPath }/admin/question/delete?pdId=${pd.pdId}"  style="height: 30px; padding-top: 1px;">删除</a>
  						</td>
  					</tr>
  				</c:forEach>
			</tbody>
		</table>
  		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:if test="${questionPage.currentPage > 1 }">
					<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/question?currentPage=${questionPage.currentPage - 1}">上一页</a></li>
				</c:if>
				<c:if test="${questionPage.pageCount < 100}">
					<c:forEach begin="1" end="${questionPage.pageCount }" step="1" var="i">
						<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/question?currentPage=${i}">${i }</a></li>
					</c:forEach>
				</c:if>
				<li class="page-item"><span class="btn btn-success">当前页:${questionPage.currentPage}/${questionPage.pageCount}</span></li>
				<c:if test="${questionPage.currentPage < questionPage.pageCount }">
					<li class="page-item"><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/question?currentPage=${questionPage.currentPage + 1}">下一页</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
  </body>
</html>
