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
          <h5>班级开课情况查询表</h5>
        </div>
        <div class="ibox-content">
          <div style="text-align: right;margin: 0px auto 0px auto;">
            <form role="form" class="form-inline" action="classSearchServlet.do" method="post">
              <div class="form-group">
                <label for="input-type">开课学年</label>
                <select
                    id="input-type"
                    class="form-control"
                    name="term"
                    title="请选择"
                    required
                >
                  <option value="2018_1" name="term">2018学年上学期</option>
                  <option value="2018_2" name="term">2018学年下学期</option>
                  <option value="2019_1" name="term">2019学年上学期</option>
                  <option value="2019_2" name="term">2019学年下学期</option>
                </select>
              </div>
              <button type="submit" class="btn btn-primary">查询</button>
            </form>
          </div>
          <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
              <th>班级编号</th>
              <th>班级名次</th>
              <th>课程编号</th>
              <th>课程名次</th>
              <th>开课学期</th>
              <th>学时</th>
              <th>学分</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${classCourseArrayList}" var="classes">
              <tr>
                <td>${classes.getClassNo()}</td>
                <td>${classes.getClassName()}</td>
                <td>${classes.getCno()}</td>
                <td>${classes.getCname()}</td>
                <td>${classes.getTerm()}</td>
                <td>${classes.getCperiod()}</td>
                <td>${classes.getCredit()}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
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

