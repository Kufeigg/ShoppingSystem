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
        <label class="layui-form-label required">商品名</label>
        <div class="layui-input-block">
            <input type="text" name="gname" lay-verify="required" lay-reqtext="商品名不能为空" placeholder="请输入商品名" value="" class="layui-input">
            <tip>填写商品名</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品分类</label>
        <div class="layui-input-block">
            <input type="text" id="goodstypeid" name="goodstypeid" lay-verify="required" lay-reqtext="商品分类不能为空" placeholder="请选择商品分类" value="" class="layui-input">
            <tip>选择商品分类</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品原价（单位：元，只保留两位小数）</label>
        <div class="layui-input-block">
            <input type="text" name="goprice" lay-verify="required" lay-reqtext="商品原价不能为空" placeholder="请输入商品原价" value="" class="layui-input">
            <tip>填写商品原价</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品现价（单位：元，只保留两位小数）</label>
        <div class="layui-input-block">
            <input type="text" name="grprice" lay-verify="required" lay-reqtext="商品现价不能为空" placeholder="请输入商品现价" value="" class="layui-input">
            <tip>填写商品现价</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品现价（单位：元，只保留两位小数）</label>
        <div class="layui-input-block">
            <input type="text" name="gstore" lay-verify="required" lay-reqtext="商品库存不能为空" placeholder="请输入商品库存" value="" class="layui-input">
            <tip>填写商品库存</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品现价（单位：元，只保留两位小数）</label>
        <div class="layui-input-block">
            <div id="gpicture" class="zyupload"></div>
<%--            <input type="text" name="gpicture" lay-verify="required" lay-reqtext="商品库存不能为空" placeholder="请输入商品库存" value="" class="layui-input">--%>
            <tip>上传商品图片</tip>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/statics/layui/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>

    layui.use(['table', 'form', 'tableSelect'], function () {
        var form = layui.form,
            layer = layui.layer,
            table = layui.table,
            $ = layui.jquery,
            tableSelect = layui.tableSelect;

        //下拉菜单
        tableSelect.render({
            elem: '#goodstypeid',
            checkedKey: 'id',
            table: {
                url: '${pageContext.request.contextPath}/admin/goodstype/list',
                cols: [[
                    { type: 'radio' },
                    { field: 'id', title: 'ID' },
                    { field: 'typename', title: '商品类型' }
                ]]
            },
            done: function (elem, data) {
                var NEWJSON = []
                console.log(data);
                layui.each(data.data, function (index, item) {
                    NEWJSON.push(item.username)
                })
                elem.val(NEWJSON.join(","))
            }
        })

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var index = layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            }, function () {

                // 关闭弹出层
                layer.close(index);

                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);

            });

            return false;
        });

    });
</script>
</body>
</html>