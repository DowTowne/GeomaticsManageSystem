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
            <input type="hidden" name="id" value="${bean.id}" />
            <div class="Operate_cont clearfix">
                <label class="form-label">标题：</label>
                <div class="formControls ">
                    <p>${bean.name}</p>
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
                    <input class="btn btn-primary radius" type="button" value="关闭" onclick="gb()" >
                </div>
            </div>
    </div>
</div>
</div>
<script type="text/javascript" src="${ctx}/resource/Widget/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="${ctx}/resource/assets/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/H-ui.js"></script>
<script type="text/javascript" src="${ctx}/resource/js/H-ui.admin.js"></script>
<script type="text/javascript">
    function gb() {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    }
</script>
</body>
</html>