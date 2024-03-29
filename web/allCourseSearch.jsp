<%--
  Created by IntelliJ IDEA.
  User: 13742
  Date: 2019/7/7
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">


  <title> - 数据表格</title>
  <meta name="keywords" content="">
  <meta name="description" content="">

  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">

  <!-- Data Tables -->
  <link href="assets/css/tables/dataTables.bootstrap.css" rel="stylesheet">

  <link href="assets/css/tables/animate.css" rel="stylesheet">
  <link href="assets/css/tables/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <h5>总课程及总学分查询表</h5>
        </div>
        <div class="ibox-content">
          <div class="row" style="text-align: right;margin: 0px auto 0px auto;">
            <p class="col-lg-2">总学分为<span class="right red-bg disabled" id="creditSumAll">${creditSumAll}</span></p>
            <form role="form" class="form-inline" action="courseSearchServlet.do" method="get">
              <input class="hidden" type="text" name="hide" id="hide">
              <button type="submit" class="btn btn-primary" onclick="$('#creditSumAll').removeClass('disabled');">查询
              </button>
            </form>
          </div>
          <c:choose>
          <c:when test="${not empty rankList}">
          <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
              <th>学号</th>
              <th>课程名</th>
              <th>开课学期</th>
              <th>学分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${rankList}" var="rank">
              <tr>
                <td>${rank.getSno()}</td>
                <td>${rank.getCname()}</td>
                <td>${rank.getTerm()}</td>
                <td>${rank.getCredit()}</td
              </tr>
            </c:forEach>
            </tbody>
          </table>
          </c:when>
          <c:otherwise>
            <div class="lead text-gray-800 text-center">暂无课程信息</div>
          </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- 全局js -->
<script src="assets/js/tables/jquery.min.js?v=2.1.4"></script>
<script src="assets/bootstrap/js/bootstrap.min.js?v=3.3.6"></script>


<script src="assets/js/tables/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="assets/js/tables/jquery.dataTables.js"></script>
<script src="assets/js/tables/dataTables.bootstrap.js"></script>

<!-- 自定义js -->
<script src="assets/js/tables/content.js?v=1.0.0"></script>

</body>

</html>
