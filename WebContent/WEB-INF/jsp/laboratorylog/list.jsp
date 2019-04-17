<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${ctx}/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/resource/css/style.css"/>
    <link href="${ctx}/resource/assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome-ie7.min.css" />
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css" />
    <script src="${ctx}/resource/assets/js/jquery.min.js"></script>
    <script src="${ctx}/resource/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/resource/assets/js/typeahead-bs2.min.js"></script>
    <!-- page specific plugin scripts -->
    <script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.admin.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript" ></script>
    <script src="${ctx}/resource/assets/laydate/laydate.js" type="text/javascript"></script>
    <title>实验室列表</title>
    <script>
        $(function () {
            if (${login} == 1){
                top.location = 'login_login.do';
            }
        })
    </script>
</head>

<body>
<div class="page-content clearfix">
    <div id="Member_Ratings">
        <div class="d_Confirm_Order_style">
            <form method="post" action="laboratorylog_list.do">
            <div class="search_style">
                <ul class="search_content clearfix">
                    <li><label class="l_f">实验室名称</label><input name="laboratory.name" type="text" value="${laboratoryLog.laboratory.name}" class="text_add"  style=" width:200px"/></li>
                    <li><label class="l_f">预约人</label><input name="user.name" type="text" value="${laboratoryLog.user.name}" class="text_add"  style=" width:200px"/></li>
                    <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>查询</button></li>
                </ul>
            </div>
                </form>
            <div class="table_menu_list">
                <table class="table table-striped table-bordered table-hover" id="sample-table">
                    <thead>
                    <tr>
                        <th width="100">实验室名称</th>
                        <th width="80">预约人</th>
                        <th width="120">预约时间</th>
                        <th width="120">结束预约时间</th>
                        <th width="120">操作人</th>
                    </tr>

                    </thead>
                    <tbody>
                      <c:forEach items="${pagers.datas}" var="c" varStatus="l">
                        <tr>
                        <td>${c.laboratory.name}</td>
                        <td>${c.user.name}</td>
                        <td>${c.time}</td>
                        <td>${c.endTime}</td>
                        <td>${c.qx.name}</td>
                    </tr>
                          </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- 分页开始 -->
    <div class="pagelist">
        <pg:pager url="${ctx}/laboratorylog_list.do" maxIndexPages="5" items="${pagers.total}" maxPageItems="15"
                  export="curPage=pageNumber">
            <pg:param name="laboratory.name" value="${laboratoryLog.laboratory.name}"/>
            <pg:param name="user.name" value="${laboratoryLog.user.name}"/>
            <pg:last>
                共${pagers.total}记录,共${pageNumber}页,
            </pg:last>
            当前第${curPage}页
            <pg:first>
                <a href="${pageUrl}">首页</a>
            </pg:first>
            <pg:prev>
                <a href="${pageUrl}">上一页</a>
            </pg:prev>
            <pg:pages>
                <c:choose>
                    <c:when test="${curPage eq pageNumber}">
                        <font color="red"><span class="current">${pageNumber }</span></font>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageUrl}">${pageNumber}</a>
                    </c:otherwise>
                </c:choose>
            </pg:pages>
            <pg:next>
                <a href="${pageUrl}">下一页</a>
            </pg:next>
            <pg:last>
                <c:choose>
                    <c:when test="${curPage eq pageNumber}">
                        <a href="##">尾页</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageUrl}">尾页</a>
                    </c:otherwise>
                </c:choose>

            </pg:last>
        </pg:pager>
    </div>
    <!-- 分页结束 -->
</div>
</body>
</html>
<script>
    /*用户-添加*/
    $('#member_add').on('click', function(){
        layer.open({
            type: 1,
            title: '添加用户',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area : ['800px' , '400px'],
            content:$('#add_menber_style'),
            btn:['提交','取消'],
            yes:function(index,layero){
                var num=0;
                var str="";
                $(".add_menber input[type$='text']").each(function(n){
                    if($(this).val()==""){
                        layer.alert(str+=""+$(this).attr("id")+"不能为空！\r\n",{
                            title: '提示框',
                            icon:0,
                        });
                        num++;
                        return false;
                    }
                });
                if(num>0){
                    return false;
                }else{
                    $.ajax({
                        cache: true,
                        type: "post",
                        url: "laboratory_save.do",
                        data:$('#form-user-add').serialize(),// 你的formid
                        async: false,
                        success: function(data){
                            if (data.flag){
                                layer.msg('添加成功', {
                                    icon: 1,
                                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                                }, function(){
                                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//                                    parent.layer.close(index); //再执行关闭
                                    layer.close(index);
                                    window.location.href = data.url;
                                });
                            }
                        }
                    });
                }
            }
        });
    });
    /*用户-查看*/
    function member_show(title,url,id,w,h){
        layer_show(title,url+'#?='+id,w,h);
    }

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }

    /*用户-启用*/
    function member_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!',{icon: 6,time:1000});
        });
    }

    function edit(id) {
        layer.open({
            type: 2,
            area: ['910px', '500px'],
            content: ['laboratory_edit.do?laboratoryId=' + id, 'no']  //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
    }

//    /*用户-编辑*/
//    function member_edit(id){
//        $.post('laboratory_edit.do?laboratoryId=' + id, {}, function(str){
//            layer.open({
//                type: 1,
//                title: '修改用户信息',
//                maxmin: true,
//                shadeClose:false, //点击遮罩关闭层
//                area : ['800px' , ''],
//                content:$('#add_menber_update'),
//                btn:['提交','取消'],
//                yes:function(index,layero){
//                    alert(index)
//                    alert(layero)
//                    var num=0;
//                    var str="";
//                    $(".add_menber input[type$='text']").each(function(n){
//                        if($(this).val()==""){
//                            layer.alert(str+=""+$(this).attr("id")+"不能为空！\r\n",{
//                                title: '提示框',
//                                icon:0,
//                            });
//                            num++;
//                            return false;
//                        }
//                    });
//                    if(num>0){
//                        return false;
//                    }else{
//                        $.ajax({
//                            cache: true,
//                            type: "post",
//                            url: "laboratory_update.do",
//                            data:$('#form-user-update').serialize(),// 你的formid
//                            async: false,
//                            success: function(data){
//                                if (data.flag){
//                                    layer.msg('修改成功', {
//                                        icon: 1,
//                                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
//                                    }, function(){
//                                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
////                                    parent.layer.close(index); //再执行关闭
//                                        layer.close(index);
//                                        window.location.href = data.url;
//                                    });
//                                }
//                            }
//                        });
//                    }
//                }
//            });
//        });
//
//    }
    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }
    laydate({
        elem: '#start',
        event: 'focus'
    });

</script>