<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link href="${ctx}/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/resource/css/style.css"/>
    <link href="${ctx}/resource/assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/resource/font/css/font-awesome.min.css" />
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->
    <script src="${ctx}/resource/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript" ></script>
    <script src="${ctx}/resource/assets/laydate/laydate.js" type="text/javascript"></script>
    <script src="${ctx}/resource/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/resource/assets/js/typeahead-bs2.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="${ctx}/resource/AJAX.js"></script>

    <title>个人信息管理</title>
</head>

<body>
<form action="bean_update.do" method="post" class="form form-horizontal" id="form-bean-add" >
    <input type="hidden" name="id" value="${bean.id}"/>
<div class="xinxi" style="margin-top: 20px">
    <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">用户名：</label>
        <div class="col-sm-9"><input type="text" name="realName" id="website-title" value="${bean.realName}" class="col-xs-7 text_info" disabled="disabled">
            &nbsp;&nbsp;&nbsp;<a href="javascript:ovid()" onclick="change_Password()" class="btn btn-warning btn-xs">修改密码</a></div>
    </div>
    <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">学号或职教号： </label>
        <div class="col-sm-9"><input type="text" name="number" id="website-title" value="${bean.number}" class="col-xs-7 text_info" disabled="disabled"></div>
    </div>
    <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">移动电话： </label>
        <div class="col-sm-9"><input type="text" name="phone" id="website-title" value="${bean.phone}" class="col-xs-7 text_info" disabled="disabled"></div>
    </div>
    <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">学院： </label>
        <div class="col-sm-9"><input type="text" name="xy" id="website-title" value="${bean.xy}" class="col-xs-7 text_info" disabled="disabled"></div>
    </div>
    <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">班级： </label>
        <div class="col-sm-9"><input type="text" name="bj" id="website-title" value="${bean.bj}" class="col-xs-7 text_info" disabled="disabled"> </div>
    </div>
    <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">权限： </label>
        <div class="col-sm-9" style="margin-top: 12px">${bean.role.name}</div>
    </div>
    <div class="form-group"><label class="col-sm-3 control-label no-padding-right" for="form-field-1">注册时间： </label>
        <div class="col-sm-9" style="margin-top: 12px"> <span>${bean.time}</span></div>
    </div>
    <div class="Button_operation clearfix">
        <button onclick="modify();" class="btn btn-danger radius" type="button">修改信息</button>
        <button onclick="save_info();" class="btn btn-success radius" type="button">保存修改</button>
    </div>
</div>

<!--修改密码样式-->
<div class="change_Pass_style" id="change_Pass">
    <ul class="xg_style">
        <li><label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><input name="pass" type="password" class="" id="Nes_pas"></li>
        <li><label class="label_name">确认密码</label><input name="再次确认密码" type="password" class="" id="c_mew_pas"></li>

    </ul>
    <!--       <div class="center"> <button class="btn btn-primary" type="button" id="submit">确认修改</button></div>-->
</div>
        </div>
    </div>
    </form>
</body>
</html>
<script>

    //按钮点击事件
    function modify(){
        $('.text_info').attr("disabled", false);
        $('.text_info').addClass("add");
        $('#Personal').find('.xinxi').addClass("hover");
        $('#Personal').find('.btn-success').css({'display':'block'});
    };

    function save_info(){
        var num=0;
        var str="";
        $(".xinxi input[type$='text']").each(function(n){
            if($(this).val()==""){

                layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                    title: '提示框',
                    icon:0,
                });
                num++;
                return false;
            }
        });
        if(num>0){  return false;}
        else{
            AJAX("user_update.do", "修改成功", "form-bean-add");
            $('#Personal').find('.xinxi').removeClass("hover");
            $('#Personal').find('.text_info').removeClass("add").attr("disabled", true);
            $('#Personal').find('.btn-success').css({'display':'none'});
        }
    };
    //初始化宽度、高度
    $(".admin_modify_style").height($(window).height());
    $(".recording_style").width($(window).width()-400);
    //当文档窗口发生改变时 触发
    $(window).resize(function(){
        $(".admin_modify_style").height($(window).height());
        $(".recording_style").width($(window).width()-400);
    });
    //修改密码
    function change_Password(){
        layer.open({
            type: 1,
            title:'修改密码',
            area: ['300px','300px'],
            shadeClose: true,
            content: $('#change_Pass'),
            btn:['确认修改'],
            yes:function(index, layero){
                if ($("#Nes_pas").val()==""){
                    layer.alert('新密码不能为空!',{
                        title: '提示框',
                        icon:0,

                    });
                    return false;
                }

                if ($("#c_mew_pas").val()==""){
                    layer.alert('确认新密码不能为空!',{
                        title: '提示框',
                        icon:0,

                    });
                    return false;
                }
                if(!$("#c_mew_pas").val || $("#c_mew_pas").val() != $("#Nes_pas").val() )
                {
                    layer.alert('密码不一致!',{
                        title: '提示框',
                        icon:0,

                    });
                    return false;
                }
                else{
                    layer.alert('修改成功！',{
                        title: '提示框',
                        icon:1,
                    });
                    layer.close(index);
                }
            }
        });
    }
</script>
<script>
    jQuery(function($) {
        var oTable1 = $('#sample-table').dataTable( {
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0,2,3,4,5,6]}// 制定列不参与排序
            ] } );


        $('table th input:checkbox').on('click' , function(){
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                    .each(function(){
                        this.checked = that.checked;
                        $(this).closest('tr').toggleClass('selected');
                    });

        });
    });

    function shuaxin() {
        window.parent.location.reload();
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }
</script>
