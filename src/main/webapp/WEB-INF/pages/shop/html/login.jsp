<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/res/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/res/layui/css/layui.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/statics/res/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="${pageContext.request.contextPath}/shop/index">首页</a>
      </p>
      <div class="sn-quick-menu">
        <div class="login"><a href="login.jsp">登录</a></div>
        <div class="sp-cart"><a href="shopcart.html">购物车</a><span>2</span></div>
      </div>
    </div>
  </div>



  <div class="header">
    <div class="headerLayout w1200">
      <div class="headerCon">
        <h1 class="mallLogo">
          <a href="#" title="母婴商城">
            <img src="${pageContext.request.contextPath}/statics/res/static/img/logo.png">
          </a>
        </h1>
        <div class="mallSearch">
          <form action="" class="layui-form" novalidate>
            <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="content content-nav-base  login-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="commodity.html" class="active">所有商品</a>
            <a href="buytoday.html">今日团购</a>
            <a href="information.html">母婴资讯</a>
            <a href="about.jsp">关于我们</a>
          </div>
        </div>
      </div>
    </div>
    <div class="login-bg">
      <div class="login-cont w1200">
        <div class="form-box">
          <form class="layui-form" action="">
            <legend>邮箱登录</legend>
            <div class="layui-form-item">
              <div class="layui-inline">
                <div class="layui-input-inline">
                  <input type="email" name="bemail" id="bemail" lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-inline veri-code">
                <div class="layui-input-inline">
                  <input id="password" type="text" name="bpwd" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
              </div>
            </div>
            <div class="layui-form-item login-btn">
              <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="login">登录</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

  <div class="footer">
    <div class="ng-promise-box">
      <div class="ng-promise w1200">
        <p class="text">
          <a class="icon1" href="javascript:;">7天无理由退换货</a>
          <a class="icon2" href="javascript:;">满99元全场免邮</a>
          <a class="icon3" style="margin-right: 0" href="javascript:;">100%品质保证</a>
        </p>
      </div>
    </div>
    <div class="mod_help w1200">                                     
      <p>
        <a href="javascript:;">关于我们</a>
        <span>|</span>
        <a href="javascript:;">帮助中心</a>
        <span>|</span>
        <a href="javascript:;">售后服务</a>
        <span>|</span>
        <a href="javascript:;">母婴资讯</a>
        <span>|</span>
        <a href="javascript:;">关于货源</a>
      </p>
      <p class="coty">母婴商城版权所有 &copy; 2012-2020</p>
    </div>
  </div>
  <script type="text/javascript">
    layui.use(['form','jquery','layer'], function () {
      var $ = layui.jquery,
              form = layui.form,
              layer = layui.layer;

      // 登录过期的时候，跳出ifram框架
      if (top.location != self.location) top.location = self.location;

      $('.bind-password').on('click', function () {
        if ($(this).hasClass('icon-5')) {
          $(this).removeClass('icon-5');
          $("input[name='password']").attr('type', 'password');
        } else {
          $(this).addClass('icon-5');
          $("input[name='password']").attr('type', 'text');
        }
      });

      $('.icon-nocheck').on('click', function () {
        if ($(this).hasClass('icon-check')) {
          $(this).removeClass('icon-check');
        } else {
          $(this).addClass('icon-check');
        }
      });

      // 登录操作
      form.on('submit(login)', function (data) {
        console.log(data.field);
        $.post("/ShoppingSystem_war/shop/login",data.field,function (result) {
          if(result.success){
            location.href="/ShoppingSystem_war/shop/index";
          }else {
            layer.msg("用户名或密码错误");
          }
        },"json");
        return false;
      });
    });
  </script>

</body>
</html>