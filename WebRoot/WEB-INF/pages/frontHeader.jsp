<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
  <head>
  	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/lk.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
  </head>
  
  <body style="padding-top: 70px">
  	<header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <%-- <a class="navbar-brand" href="${pageContext.request.contextPath}">亚翔采样分析系统</a> --%>
        <a class="navbar-brand" href="http://gcms.lkeng.com.cn:8096">亚翔采样分析系统</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">功能预留 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">功能</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#">功能</a>
            </li>
          </ul>
          <c:if test="${empty user.userName}">
          <form class="form-inline mt-2 mt-md-0">
            <a class="btn btn-outline-success my-2 my-sm-0" href="${pageContext.request.contextPath}/login">登录</a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="${pageContext.request.contextPath}/regist">注册</a>
          </form>
          </c:if>
          <c:if test="${! empty user.userName}">
          	<label class="btn btn-outline-success my-2 my-sm-0">欢迎:${user.userName}</label>
            <a class="btn btn-outline-success my-2 my-sm-0" href="${pageContext.request.contextPath}/loginOut">退出</a>
          </c:if>
        </div>
      </nav>
    </header>
  </body>
</html>
