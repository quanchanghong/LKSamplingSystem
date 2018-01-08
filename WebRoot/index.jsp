<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
  	 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <title>亚翔采样分析系统</title>
     <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
     <!--  <link href="${pageContext.request.contextPath}/css/carousel.css" rel="stylesheet">-->
  </head>
  
  <body>
    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">亚翔采样分析系统</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#">Disabled</a>
            </li>
          </ul>
          <form class="form-inline mt-2 mt-md-0">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">登录</button>
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">注册</button>
          </form>
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
            <img class="first-slide" src="${pageContext.request.contextPath}/images/bg2.jpg" alt="第一" style="height: 600px">
            <div class="container">
              <div class="carousel-caption text-left">
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="${pageContext.request.contextPath}/images/bg1.jpg" alt="第二" style="height: 600px">
            <div class="">
              <div class="carousel-caption">
                <h1>介绍1.</h1>
                <p>介绍1</p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="${pageContext.request.contextPath}/images/bg3.jpg" alt="第三" style="height: 600px">
            <div class="container">
              <div class="carousel-caption text-right">
                <h1>第三</h1>
                <p>介绍三</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    	<div id="content">
    	
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
