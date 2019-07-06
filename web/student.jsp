<%--
  Created by IntelliJ IDEA.
  User: 13742
  Date: 2019/7/6
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title> Hxy's Admin</title>

  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
  <link href="assets/css/hxyAdmin/animate.css" rel="stylesheet">
  <link rel="stylesheet" href="assets/css/hxyAdmin/style.css">
</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">

<div id="wrapper">

  <!--左侧导航开始-->
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-spin fa-gear"></i>
                                        <strong class="font-bold">Hxy's Admin</strong>
                                    </span>
                                </span>
            </a>
          </div>
          <div class="logo-element">Hxy's Admin
          </div>
        </li>
        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
          <span class="ng-scope">查询功能</span>
        </li>
        <li>
          <a href="#">
            <i class="fa fa fa-edit"></i>
            <span class="nav-label">课程相关查询</span>
            <span class="fa arrow"></span>
          </a>
          <ul class="nav nav-second-level">
            <li>
              <a class="J_menuItem" href="form_validate.html">成绩及名次查询</a>
            </li>
            <li>
              <a class="J_menuItem" href="#">选修课程按学年查询</a>
            </li>
            <li>
              <a class="J_menuItem" href="#">全部选修课程查询</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">
            <i class="fa fa fa-edit"></i>
            <span class="nav-label">班级开课查询</span>
            <span class="fa arrow"></span>
          </a>
          <ul class="nav nav-second-level">
            <li>
              <a class="J_menuItem" href="#">按学年查询</a>
            </li>
          </ul>
        </li>
        <li class="line dk"></li>
        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
          <span class="ng-scope">用户相关</span>
        </li>
        <li>
          <a href="#"><i class="fa fa-key"></i> <span class="nav-label">修改密码</span>
            <span class="fa arrow"></span></a>
          <ul class="nav nav-second-level">
            <li><a class="J_menuItem" href="#">学生账户密码修改</a>
            </li>
            <li><a class="J_menuItem" href="#">个人信息查看</a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
  <!--左侧导航结束-->
  <!--右侧部分开始-->
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <ul class="nav navbar-top-links navbar-right">
          <li class="times">
            <p style="color: #1b6d85" id="logInfo"></p>
          </li>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
              <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user shadow animated--grow-in">
              <li><a href="#"><i class="fa fa-gear fa-fw"></i>设置</a>
              </li>
              <li class="divider"></li>
              <li><a href="index.html"><i class="fa fa-sign-out fa-fw"></i>注销</a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
    </div>
    <div class="row J_mainContent" id="content-main">
      <iframe id="J_iframe" width="100%" height="100%" src="rank.jsp" frameborder="0" data-id="index_v1.html" seamless></iframe>
    </div>
  </div>
  <!--右侧部分结束-->
</div>

<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/jquery.slimscroll.min.js"></script>
<script src="assets/js/layer.min.js"></script>
<script src="assets/js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="assets/js/index.js"></script>
<script>
    function getCurDate() {
        var d = new Date();
        var week;
        switch (d.getDay()) {
            case 1:
                week = "星期一";
                break;
            case 2:
                week = "星期二";
                break;
            case 3:
                week = "星期三";
                break;
            case 4:
                week = "星期四";
                break;
            case 5:
                week = "星期五";
                break;
            case 6:
                week = "星期六";
                break;
            default:
                week = "星期天";
        }
        var years = d.getFullYear();
        var month = add_zero(d.getMonth() + 1);
        var days = add_zero(d.getDate());
        var hours = add_zero(d.getHours());
        var minutes = add_zero(d.getMinutes());
        var seconds = add_zero(d.getSeconds());
        var ndate = years + "年" + month + "月" + days + "日 " + hours + ":" + minutes + ":" + seconds + " " + week;
        var divT = document.getElementById("logInfo");
        divT.innerHTML = ndate;
    }

    function add_zero(temp) {
        if (temp < 10) return "0" + temp;
        else return temp;
    }

    setInterval("getCurDate()", 100);
</script>
</body>
</html>
