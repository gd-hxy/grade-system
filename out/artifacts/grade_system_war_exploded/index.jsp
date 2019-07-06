<%--
  Created by IntelliJ IDEA.
  User: 13742
  Date: 2019/7/4
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <meta charset="utf-8">
  <title>高校学生成绩管理系统登录页面</title>

  <!-- CSS -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
  <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/form-elements.css">
  <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/css/style.css">

  <!-- Favicon and touch icons -->
  <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/assets/ico/favicon.png">
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.servletContext.contextPath}/assets/ico/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.servletContext.contextPath}/assets/ico/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.servletContext.contextPath}/assets/ico/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="${pageContext.servletContext.contextPath}/assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">

  <div class="inner-bg">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-sm-offset-2 text">
          <h1><strong>高校学生成绩管理系统</strong>登录页面</h1>
          <div class="description">
            <p>
              这是软工1704班的<a href="#"><strong>黄潇扬</strong></a>, 开发的高效学生成绩管理系统，学号是201706120102.
            </p>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-6 col-sm-offset-3 form-box">
          <div class="form-top">
            <div class="form-top-left">
              <h3>在这里输入你的用户名和密码！</h3>
              <p>如果你还没有开通过账户，先点击下方的注册按钮！</p>
            </div>
            <div class="form-top-right">
              <i class="fa fa-lock"></i>
            </div>
          </div>
          <div class="form-bottom">
            <form role="form" action="" method="post" class="login-form">
              <div class="form-group">
                <label class="sr-only" for="form-username">Username</label>
                <input type="text" name="form-username" placeholder="用户名..."
                       class="form-username form-control" id="form-username">
              </div>
              <div class="form-group">
                <label class="sr-only" for="form-password">Password</label>
                <input type="password" name="form-password" placeholder="密码..."
                       class="form-password form-control" id="form-password">
              </div>
              <div class="btn-block" style="display: flex;">
                <button type="button" class="btn" style="margin: 10px;" onclick="login()">登录</button>
                <button type="submit" class="btn" style="margin: 10px;">注册</button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-6 col-sm-offset-3 social-login">
          <h3>其他登录方式</h3>
          <div class="social-login-buttons">
            <a class="btn btn-link-2" href="#">
              <i class="glyphicon glyphicon-home"></i> 事业单位
            </a>
            <a class="btn btn-link-2" href="#">
              <i class="fa fa-weixin"></i> 微信登录
            </a>
            <a class="btn btn-link-2" href="#">
              <i class="fa fa-qq"></i> QQ登录
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>


<!-- Javascript -->
<script src="${pageContext.servletContext.contextPath}/assets/js/jquery-1.11.1.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/js/jquery.backstretch.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/js/scripts.js"></script>




<script>
    function login() {
        var username = document.getElementById("form-username").value;
        var password = document.getElementById("form-password").value;
        if (username === "admin" && password === "admin")
            window.location.href = "Hxy'sAdmin.html";
        else
            alert("您输入的账号或密码错误，请重新输入！");
    }
</script>
</body>

</html>
