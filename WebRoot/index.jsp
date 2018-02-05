<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
  	 <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <title>亚翔采样分析系统</title>
     <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
  </head>
  
  <body>
    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="${pageContext.request.contextPath}">亚翔采样分析系统</a>
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
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-top: 0px">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="first-slide" src="${pageContext.request.contextPath}/images/bg2.jpg" alt="第一" style="height: 500px; width: 100%;">
            <div class="container">
              <div class="carousel-caption text-left">
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="${pageContext.request.contextPath}/images/bg1.jpg" alt="第二" style="height: 500px; width: 100%;">
            <div class="">
              <div class="carousel-caption">
                <h1>介绍1.</h1>
                <p>介绍1</p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="${pageContext.request.contextPath}/images/bg3.jpg" alt="第三" style="height: 500px; width: 100%;">
            <div class="container">
              <div class="carousel-caption text-right">
                <h1>第三</h1>
                <p>介绍三</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    	<div id="content" style="margin: 50px;">
    		<div class="card-deck">
    			<div class="card border-success" style="height: 300px">
    				<div class="card-header bg-success text-white">浓度排名</div>
  					<div class="card-body">
    					<p class="card-text" style="height: 150px">浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍浓度介绍</p>
    					<a href="${pageContext.request.contextPath}/concentration" class="btn btn-success" style="width: 100%">查询</a>
  					</div>
				</div>
				<div class="card text-center border-danger" style="height: 300px">
					<div class="card-header bg-danger text-white">风险值</div>
  					<div class="card-body">
    					<p class="card-text" style="height: 150px">风险值风险值风险值风险值风险值风险值风险值风险值风险值风险值风险值风险值风险值风险值介绍</p>
    					<a href="#" class="btn btn-danger" style="width: 100%">查询</a>
  					</div>
				</div>
				<div class="card text-center border-warning" style="height: 300px">
					<div class="card-header bg-warning text-white">功能预留</div>
  					<div class="card-body">
    					<p class="card-text" style="height: 150px">功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留</p>
    					<a href="#" class="btn btn-warning" style="width: 100%">查询</a>
  					</div>
				</div>
				<div class="card text-center border-info" style="height: 300px">
					<div class="card-header bg-info text-white">功能预留</div>
  					<div class="card-body">
    					<p class="card-text" style="height: 150px">功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留功能预留</p>
    					<a href="#" class="btn btn-info" style="width: 100%">查询</a>
  					</div>
				</div>
				<div class="card text-center border-secondary" style="height: 300px">
					<div class="card-header bg-secondary text-white">雷达图</div>
  					<div class="card-body">
    					<p class="card-text" style="height: 150px">雷达图雷达图雷达图雷达图雷达图雷达图雷达图雷达图雷达图雷达图雷达图雷达图雷达图雷达图介绍</p>
    					<a href="${pageContext.request.contextPath}/radar" class="btn btn-secondary" style="width: 100%">查询</a>
  					</div>
				</div>
    		</div>
    	</div>
    	<div id="foot">
    		<footer>
    			<%@include file="/WEB-INF/pages/footer.jsp" %>
    		</footer>
    	</div>
   
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  </body>
</html>
