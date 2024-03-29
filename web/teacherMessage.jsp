<%--
  Created by IntelliJ IDEA.
  User: 13742
  Date: 2019/7/7
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>个人信息查看</title>
  <meta name="keywords" content="">
  <meta name="description" content="">

  <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/font-awesome/css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="assets/css/form/animate.css" rel="stylesheet">
  <link href="assets/css/form/style.css?v=4.1.0" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/css/form/webuploader.css">
  <link rel="stylesheet" type="text/css" href="assets/css/form/webuploader-demo.css">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="ibox float-e-margins">
      <div class="ibox-title">
        <h5>教师个人信息查看</h5>
        <div class="ibox-tools">
          <a class="collapse-link">
            <i class="fa fa-chevron-up"></i>
          </a>
          <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
            <i class="fa fa-wrench"></i>
          </a>
          <a class="close-link">
            <i class="fa fa-times"></i>
          </a>
        </div>
      </div>
      <div class="ibox-content">
        <form class="form-horizontal m-t" id="signupForm" action="personalServlet.do" method="get">
          <div class="form-group">
            <label class="col-sm-3 control-label">教师编号：</label>
            <div class="col-sm-8">
              <h5>${teacher.getTno()}</h5>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">教师名字：</label>
            <div class="col-sm-8">
              <h5>${teacher.getTname()}</h5>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">性别：</label>
            <div class="col-sm-8">
              <h5>${teacher.getTgender()}</h5>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">年龄：</label>
            <div class="col-sm-8">
              <h5>${teacher.getTage()}</h5>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">职称：</label>
            <div class="col-sm-8">
              <h5>${teacher.getTtitle()}</h5>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">联系电话：</label>
            <div class="col-sm-8">
              <h5>${teacher.getTphone()}</h5>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-8 col-sm-offset-3">
              <button id="btn" class="btn btn-primary" type="submit">查询</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

</div>


<!-- 全局js -->
<script src="assets/js/form/jquery.min.js?v=2.1.4"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

<!-- 自定义js -->
<script src="assets/js/form/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="assets/js/form/messages_zh.min.js"></script>
<script src="assets/js/form/webuploader.min.js"></script>
<script>var BASE_URL = 'asserts/js/form';</script>
<script src="assets/js/form/webuploader-demo.js"></script>
</body>
</html>
