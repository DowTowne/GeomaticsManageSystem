<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link href="${ctx}/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/resource/css/style.css"/>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome.min.css" />
    <link href="${ctx}/resource/Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css" />
    <![endif]-->
    <script src="${ctx}/resource/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/resource/assets/js/bootstrap.min.js"></script>
    <title>添加产品分类</title>
</head>
<style>
    .form-label{width: 90px}
</style>
<body>
<div class="type_style">
    <div class="type_content">
        <form action="notice_update.do" method="post" class="form form-horizontal" id="form-user-add" >
            <input type="hidden" name="id" value="${bean.id}" />
            <div class="Operate_cont clearfix">
                <label class="form-label">标题：</label>
                <div class="formControls ">
                    <input type="text" class="input-text" value="${bean.name}" placeholder=""  name="name" id="name">
                </div>
            </div>
            <div class="Operate_cont clearfix">
                <label class="form-label">内容：</label>
                <div class="formControls ">
                    <textarea name="nr" id="nr" class="input-text">${bean.nr}</textarea>
                </div>
            </div>
            <div class="">
                <div class="" style=" text-align:center">
                    <input class="btn btn-primary radius" type="button" value="提交" onclick="sub()" >
                </div>
            </div>
        </form>
    </div>
</div>
</div>
<script type="text/javascript" src="${ctx}/resource/Widget/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="${ctx}/resource/assets/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/H-ui.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/H-ui.admin.js"></script>
<script type="text/javascript">
    function sub() {
        var name = $('#name').val();
        var nr = $('#nr').val();
        if (name == null || name == ""){
            msg("标题不正确");
            return false;
        } else if (nr == null || nr == ""){
            msg("请填写内容");
            return false;
        } else {
            $.ajax({
                cache: false,
                type: "post",
                url: "notice_update.do",
                data:$('#form-user-add').serialize(),// 你的formid
                async: false,
                success: function(data){
                    if (data.flag){
                        layer.msg('修改成功', {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            window.parent.location.reload();
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                            window.location.href = data.url;
                        });
                    }
                }
            });
        }
    }
</script>
<script>
    function msg(data) {
        layer.msg(data, {
            icon: 1,
            time: 2000 //2秒关闭（如果不配置，默认是3秒）
        }, function(){
        });
    }
</script>
</body>
</html>