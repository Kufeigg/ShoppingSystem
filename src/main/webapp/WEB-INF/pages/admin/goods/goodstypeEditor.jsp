<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/jq-module/zyupload/zyupload-1.0.0.min.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">

    <div class="layui-form-item">
        <label class="layui-form-label required">类型名称</label>
        <div class="layui-input-block">
            <input type="hidden" id="dataId" name="id" value="" class="layui-input">
            <input type="text" id="typename" name="typename" lay-verify="required" lay-reqtext="类型名称不能为空" placeholder="请输入类型名称" value="" class="layui-input">
            <tip>填写类型名称</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/layui/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/statics/layui/lib/jq-module/zyupload/zyupload-1.0.0.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/statics/config.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/statics/layui/js/lay-config.js?v=1.0.4" charset="utf-8"></script>

<script>

    layui.use(['table', 'form', 'tableSelect'], function () {
        var form = layui.form,
            layer = layui.layer,
            table = layui.table,
            $ = layui.jquery,
            tableSelect = layui.tableSelect;



        var dataId = getQueryVariable("id");
        console.log(dataId)
        $.ajax({
            type : "POST", //提交方式
            url : "${pageContext.request.contextPath}/admin/goodstype/getById",//路径
            data : {
                "id" : dataId
            },//数据，这里使用的是Json格式进行传输
            success : function(result) {//返回数据根据结果进行相应的处理
                console.log(result);
                let typename = result.data.typename;


                $('#dataId').val(dataId);
                $('#typename').val(typename);

                form.render(); //更新全部
                form.render('select'); //刷新select选择框渲染
            }
        });


        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var method="insert"
            console.log(data);
            if (data.field.id==""){
               delete data.field.id
               method="insert"
            }else {
                method="update"
            }
            console.log(data.field)
            var index = layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            }, function () {
                $.ajax({
                    type : "POST", //提交方式
                    url : "${pageContext.request.contextPath}/admin/goodstype/"+method,//路径
                    data : data.field,//数据，这里使用的是Json格式进行传输
                    success : function(result) {//返回数据根据结果进行相应的处理
                        let res = JSON.parse(result);
                        if (res.success) {
                            layer.msg("操作成功");
                        } else {
                            layer.msg("操作异常");
                        }
                        // 关闭弹出层
                        layer.close(index);
                        var iframeIndex = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(iframeIndex);
                    }
                });


            });
            return false;
        });

    });
</script>
</body>
</html>