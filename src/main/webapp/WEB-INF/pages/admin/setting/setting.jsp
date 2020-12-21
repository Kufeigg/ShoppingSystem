<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>系统设置</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/css/layui.css"
          media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/public.css" media="all">
    <style>
        .layui-form-item .layui-input-company {
            width: auto;
            padding-right: 10px;
            line-height: 38px;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="layui-form layuimini-form">
            <div class="layui-form-item">
                <label class="layui-form-label required">网站名称</label>
                <div class="layui-input-block">
                    <input type="text" name="sitename" lay-verify="required" lay-reqtext="网站域名不能为空"
                           placeholder="请输入网站名称" value="购物商城" class="layui-input">
                    <tip>输入网站名称</tip>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label required">网站域名</label>
                <div class="layui-input-block">
                    <input type="text" name="domain" lay-verify="required" lay-reqtext="网站域名不能为空" placeholder="请输入网站域名"
                           value="http://layuimini.99php.cn" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label required">首页标题</label>
                <div class="layui-input-block">
                    <textarea name="title" class="layui-textarea">购物商城主页</textarea>
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label required">版权信息</label>
                <div class="layui-input-block">
                    <textarea name="copyright" class="layui-textarea">© 2019 layuimini.99php.cn MIT license</textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="setting">确认保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form
            , layer = layui.layer;

        //监听提交
        form.on('submit(setting)', function (data) {
            parent.layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            return false;
        });

    });
</script>
</body>
</html>