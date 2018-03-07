<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shior" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
  <head>
  	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/lk.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  </head>
  
  <body style="padding-top: 70px">
  	<header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/ais">亚翔采样分析系统</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
           	 <li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">采样系统管理</a>
        		<shior:hasRole name="admin">
        		<div class="dropdown-menu" aria-labelledby="navbarDropdown">
         		 	<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/area">区域管理</a>
          			<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/species">物种管理</a>
         		 	<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/industry">产业管理</a>
         		 	<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/ais">物种浓度管理</a>
         		 	<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/riskSpecies">业主物种管理</a>
         		 	<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/question">不良问题管理</a>
        		</div>
        		</shior:hasRole>
      		</li>
            <li class="nav-item">
              <a class="nav-link" href="#">系统预留功能</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#">系统预留功能</a>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  </body>
</html>
