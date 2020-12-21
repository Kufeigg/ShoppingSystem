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
        <label class="layui-form-label required">商品名</label>
        <div class="layui-input-block">
            <input type="hidden" id="dataId" name="id" value="" class="layui-input">
            <input type="text" id="gname" name="gName" lay-verify="required" lay-reqtext="商品名不能为空" placeholder="请输入商品名" value="" class="layui-input">
            <tip>填写商品名</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品分类</label>
        <div class="layui-input-block">
            <input type="text" id="goodstypeName" lay-verify="required" lay-reqtext="商品分类不能为空" placeholder="请选择商品分类" value="" class="layui-input">
            <input type="hidden" id="goodstypeid" name="goodstypeid" lay-reqtext="商品分类不能为空" placeholder="请选择商品分类" value="" class="layui-input">
            <tip>选择商品分类</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品原价（单位：元，只保留两位小数）</label>
        <div class="layui-input-block">
            <input type="text" id="goprice" name="gOprice" lay-verify="required" lay-reqtext="商品原价不能为空" placeholder="请输入商品原价" value="" class="layui-input">
            <tip>填写商品原价</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品现价（单位：元，只保留两位小数）</label>
        <div class="layui-input-block">
            <input type="text" id="grprice" name="gRprice" lay-verify="required" lay-reqtext="商品现价不能为空" placeholder="请输入商品现价" value="" class="layui-input">
            <tip>填写商品现价</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品现价（单位：元，只保留两位小数）</label>
        <div class="layui-input-block">
            <input type="text" id="gstore" name="gStore" lay-verify="required" lay-reqtext="商品库存不能为空" placeholder="请输入商品库存" value="" class="layui-input">
            <tip>填写商品库存</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">商品图片</label>
        <div class="layui-input-block">
            <div id="picShow"></div>
            <div id="zyupload" class="zyupload"></div>
            <input type="hidden"  id = "gPic" name="gPic" value="" class="layui-input">
            <tip>上传商品图片</tip>
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
        var ngoodstypeid = 0;
        if (dataId) {
            $.ajax({
                type : "POST", //提交方式
                url : "${pageContext.request.contextPath}/admin/goods/findById",//路径
                data : {
                    "id" : dataId
                },//数据，这里使用的是Json格式进行传输
                success : function(result) {//返回数据根据结果进行相应的处理
                    console.log(result);
                    ngoodstypeid = result.data.goodstypeid;
                    let ngname = result.data.gname;
                    let ngoprice = result.data.goprice;
                    let ngrprice = result.data.grprice;
                    let ngstore = result.data.gstore;
                    let ngpic = result.data.gpic;
                    console.log(ngoodstypeid)
                    console.log(ngname)
                    console.log(ngoprice)
                    console.log(ngrprice)
                    console.log(ngstore)
                    console.log(ngpic)

                    $('#dataId').val(dataId);
                    $('#gname').val(ngname);
                    $('#goprice').val(ngoprice);
                    $('#grprice').val(ngrprice);
                    $('#gstore').val(ngstore);
                    $('#picShow').html('<img name="gPic" src='+ngpic+' width="100"></img>');
                    $('#goodstypeName').attr("ts-selected", ngoodstypeid);

                    form.render(); //更新全部
                    form.render('select'); //刷新select选择框渲染
                }
            });
        }

        //下拉菜单
        tableSelect.render({
            elem: '#goodstypeName',
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
                // ngoodstypeid
                var NEWJSON = [];
                console.log(data);
                layui.each(data.data, function (index, item) {
                    console.log(item);
                    NEWJSON.push(item.typename);
                    $('#goodstypeid').val(item.id);
                })
                elem.val(NEWJSON.join(","))
            }
        })

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            console.log(data);
            data = data.field;
            delete data["fileselect[0]"];

            var index = layer.alert(JSON.stringify(data), {
                title: '最终的提交信息'
            }, function () {
                if (dataId) {
                    console.log(data);
                    $.ajax({
                        type : "POST", //提交方式
                        url : "${pageContext.request.contextPath}/admin/goods/update",//路径
                        data : data,//数据，这里使用的是Json格式进行传输
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
                } else {
                    console.log(data);
                    delete data["id"];

                    console.log(data);
                    $.ajax({
                        type : "POST", //提交方式
                        url : "${pageContext.request.contextPath}/admin/goods/insert",//路径
                        data : data,//数据，这里使用的是Json格式进行传输
                        success : function(result) {//返回数据根据结果进行相应的处理
                            console.log(result);
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
                }
            });
            return false;
        });

        // 初始化插件
        $(".zyupload").zyUpload({
            width: "650px",                 // 宽度
            height: "400px",                 // 宽度
            itemWidth: "140px",                 // 文件项的宽度
            itemHeight: "115px",                 // 文件项的高度
            url: "${pageContext.request.contextPath}/files/upload",  // 上传文件的路径
            fileType: ["jpg", "png", "txt", "js", "exe"],// 上传文件的类型
            fileSize: 51200000,                // 上传文件的大小
            multiple: false,                    // 是否可以多个文件上传
            dragDrop: true,                    // 是否可以拖动上传文件
            tailor: true,                    // 是否可以裁剪图片
            del: true,                    // 是否可以删除文件
            finishDel: false,  				  // 是否在上传文件完成后删除预览
            /* 外部获得的回调接口 */
            onSelect: function (selectFiles, allFiles) {    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
                console.info("当前选择了以下文件：");
                console.info(selectFiles);
            },
            onDelete: function (file, files) {              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
                console.info("当前删除了此文件：");
                console.info(file.name);
            },
            onSuccess: function (file, response) {          // 文件上传成功的回调方法
                console.info("此文件上传成功：");
                console.info(file.name);
                console.info("此文件上传到服务器地址：");
                response = JSON.parse(response)
                console.info(response.data);
                console.info(response.data.file);
                $("#uploadInf").append("上传成功，文件地址是：" + response.data.file + "");
                $("#gPic").val(response.data.file);
            },
            onFailure: function (file, response) {          // 文件上传失败的回调方法
                console.info("此文件上传失败：");
                console.info(file.name);
            },
            onComplete: function (response) {           	  // 上传完成的回调方法
                console.info("文件上传完成");
                console.info(response);
            }
        });

    });
</script>
</body>
</html>