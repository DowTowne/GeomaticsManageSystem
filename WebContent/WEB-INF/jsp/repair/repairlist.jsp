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
    <script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.js"></script>
    <script type="text/javascript" src="${ctx}/resource/js/H-ui.admin.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript" ></script>
    <script src="${ctx}/resource/assets/laydate/laydate.js" type="text/javascript"></script>
    <script src="${ctx}/resource/AJAX.js" type="text/javascript"></script>
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
            <form method="post" action="repair_repairlist.do">
            <div class="search_style">
                <ul class="search_content clearfix">
                    <li><label class="l_f">设备型号</label><input name="xh" type="text" value="${bean.xh}" class="text_add"  style=" width:200px"/></li>
                    <li><label class="l_f">设备制造商</label><input name="zzs" type="text" value="${bean.zzs}" class="text_add"  style=" width:200px"/></li>
                    <li><label class="l_f">设备序列号</label><input name="sbxlh" type="text" value="${bean.sbxlh}" class="text_add"  style=" width:200px"/></li>
                    <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>查询</button></li>
                </ul>
            </div>
                </form>

            <div class="table_menu_list">
                <table class="table table-striped table-bordered table-hover" id="sample-table">
                    <thead>
                    <tr>
                        <th width="100">设备型号</th>
                        <th width="120">设备价格</th>
                        <th width="120">设备制造商</th>
                        <th width="120">设备序列号</th>
                        <th width="120">是否维修</th>
                        <th width="250">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${pagers3.datas}" var="c" varStatus="l">
                        <tr>
                        <td>${c.xh}</td>
                        <td>${c.jg}</td>
                        <td>${c.zzs}</td>
                        <td>${c.sbxlh}</td>
                        <td>
                            <c:if test="${c.isBx == 0}"><span class="label label-success radius">正常</span></c:if>
                            <c:if test="${c.isBx == 1}"><span class="label label-defaunt radius">维修中</span></c:if>
                        </td>
                        <td class="td-manage">
                            <c:if test="${c.isBx == 0}"><a title="保修" onclick="bx(${c.id})" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a></c:if>
                            <c:if test="${c.isBx == 1}"><a title="恢复使用" href="javascript:;"  onclick="hf(${c.id})" class="btn btn-xs btn-success" ><i class="icon-check bigger-120"></i></a>
                            </c:if>

                        </td>
                    </tr>
                          </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- 分页开始 -->
    <div class="pagelist">
        <pg:pager url="${ctx}/repair_repairlist.do" maxIndexPages="5" items="${pagers3.total}" maxPageItems="15"
                  export="curPage=pageNumber">
            <pg:param name="xh" value="${bean.xh}"/>
            <pg:param name="zzs" value="${bean.zzs}"/>
            <pg:param name="sbxlh" value="${bean.sbxlh}"/>
            <pg:last>
                共${pagers3.total}记录,共${pageNumber}页,
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
<form action="repair_repair.do" method="post" class="form form-horizontal" id="form-user-add" >
    <input type="hidden" name="equipmentId" id="equipmentId" value=""/>
    <div class="add_menber" id="add_menber_style" style="display:none">
        <ul>
            <li><label class="label_name" style="width: 130px">报修标题：</label>
                <span class="add_name">
                <input value="" name="repairLog.title" type="text" id="报修标题" class="text_add"/>
            </span>
            </li>
            <li>
                <label class="label_name"style="width: 130px">报修原因：</label>
                <span class="add_name">
            <input name="repairLog.bz" type="text" id="报修原因" class="text_add"/>
        </span>
            </li>
            <li class="adderss"><label class="label_name" style="width: 130px">设备位置：</label>
                <span class="add_name">
                <input name="repairLog.wz" type="text" id="设备位置" class="text_add" style=" width:350px"/>
            </span>
            </li>
            <li>
                <label class="label_name"style="width: 130px">设备编号：</label>
                <span class="add_name">
                <select name="repairLog.equipment.id" style="width: 165px; margin-left: 10px" class="text_add">
                    <option value="" id="设备型号">请选择</option>
                    <c:forEach items="${pagers3.datas}" var="b" varStatus="l">
                        <option value="${b.id}">${b.xh}</option>
                    </c:forEach>
                </select>
        </span>
            </li>
        </ul>
    </div>
</form>
</body>
</html>
<script>

    function bx(id) {
        $('#equipmentId').val(id);
        layer.open({
            type: 1,
            title: '添加维修信息',
            maxmin: true,
            scrollbar: false,
            shadeClose: true, //点击遮罩关闭层
            area : ['900px' , '300px'],
            content:$('#add_menber_style'),
            btn:['提交','取消'],
            yes:function(index,layero){
                var num=0;
                var str="";
                $(".add_menber input[type$='file']").each(function(n){
                    if($(this).val()==""){
                        layer.alert(str+=""+$(this).attr("class"),{
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
                        cache: false,
                        type: "post",
                        url: 'repair_repair.do',
                        data:$('#form-user-add').serialize(),// 你的formid
                        async: false,
                        success: function(data){
                            if (data.flag){
                                layer.msg("成功保修", {
                                    icon: 1,
                                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                                }, function(){
                                    shuaxin2();
                                    window.location.href = data.url;
                                });
                            }
                        }
                    });

                }
            }
        });
    }

    function shuaxin2() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }

    function hf(id) {
        $.ajax({
            cache: false,
            type: "post",
            url: 'repair_repairHf.do',
            data:{equipmentId: id},// 你的formid
            async: false,
            success: function(data){
                if (data.flag){
                    layer.msg("恢复使用成功", {
                        icon: 1,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        shuaxin2();
                        window.location.href = data.url;
                    });
                }
            }
        });
    }

    laydate({
        elem: '#start',
        event: 'focus'
    });

</script>