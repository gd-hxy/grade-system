<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13742
  Date: 2019/7/7
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">


  <title> - 表单验证 jQuery Validation</title>
  <meta name="keywords" content="">
  <meta name="description" content="">

  <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/font-awesome/css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="assets/css/form/animate.css" rel="stylesheet">
  <link href="assets/css/form/style.css?v=4.1.0" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="assets/css/form/webuploader.css">
  <link rel="stylesheet" type="text/css" href="assets/css/form/webuploader-demo.css">
  <script>
      $(function () {
          $("#signupForm").submit(function(event){
              const f=$(this)
              if(f[0].checkValidity()===false){
                  event.preventDefault()
                  event.stopPropagation()
              }
              f.addClass("was-validated")
          })

      })
  </script>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="ibox float-e-margins">
      <div class="ibox-title">
        <h5>课程成绩录入</h5>
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
      <c:choose>
        <c:when test="${flag == true}">
          <div id="myAlert" class="alert alert-success text-center">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>修改成功！</strong>
          </div>
        </c:when>
        <c:when test="${flag == false}">
          <div id="myAlert2" class="alert alert-warning text-center">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>修改失败！</strong>
          </div>
        </c:when>
        <c:otherwise></c:otherwise>
      </c:choose>
      <div class="ibox-content">
        <form class="form-horizontal m-t" id="signupForm" action="insertGradeServlet.do" method="post">
          <div class="form-group">
            <label class="col-sm-3 control-label">学号：</label>
            <div class="col-sm-8">
              <input id="Sno" name="Sno" class="form-control" type="text" required="required">
              <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>请输入学号</span>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">课程号：</label>
            <div class="col-sm-8">
              <input id="Cno" name="Cno" class="form-control" type="text" required="required">
              <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>请输入课程号</span>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">课程名：</label>
            <div class="col-sm-8">
              <input id="Cnanme" name="Cname" class="form-control" type="text" required="required">
              <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>请输入课程名</span>
            </div>
          </div>
          <div class="form-group">
              <label for="input-type">开课学期</label>
              <select
                  id="input-type"
                  class="form-control"
                  name="term"
                  title="请选择"
                  required
              >
                <option value="" name="term">请选择</option>
                <option value="2018_1" name="term">2018学年上学期</option>
                <option value="2018_2" name = "term">2018学年下学期</option>
                <option value="2019_1" name="term">2019学年上学期</option>
                <option value="2019_2" name = "term">2019学年下学期</option>
              </select>
          </div>
          <div class="form-group">
            <label class="col-sm-3 control-label">最终成绩：</label>
            <div class="col-sm-8">
              <input id="grade" name="grade" class="form-control" type="text" required="required">
              <span class="help-block m-b-none"><i class="fa fa-info-circle"></i>请输入最终成绩</span>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-8 col-sm-offset-3">
              <button class="btn btn-primary" type="submit">提交</button>
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
