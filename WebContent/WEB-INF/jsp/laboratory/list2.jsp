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
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css" />
    <![endif]-->
    <script src="${ctx}/resource/assets/js/jquery.min.js"></script>

    <!-- <![endif]-->

    <!--[if IE]>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <![endif]-->

    <!--[if !IE]> -->

    <script type="text/javascript">
        window.jQuery || document.write("<script src='${ctx}/resource/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
    </script>

    <!-- <![endif]-->

    <!--[if IE]>
    <script type="text/javascript">
        window.jQuery || document.write("<script src='${ctx}/resource/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
    </script>
    <![endif]-->

    <script src="${ctx}/resource/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/resource/assets/js/typeahead-bs2.min.js"></script>
    <!-- page specific plugin scripts -->
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
            <form method="post" action="laboratory_list2.do">
            <div class="search_style">
                <ul class="search_content clearfix">
                    <li><label class="l_f">实验室名称</label><input name="name" type="text" value="${laboratory.name}" class="text_add"  style=" width:200px"/></li>
                    <li><label class="l_f">负责人</label><input name="fzr" type="text" value="${laboratory.fzr}" class="text_add"  style=" width:200px"/></li>
                    <li style="width:90px;"><button type="submit" class="btn_search"><i class="icon-search"></i>查询</button></li>
                </ul>
            </div>
                </form>
            <div class="table_menu_list">
                <table class="table table-striped table-bordered table-hover" id="sample-table">
                    <thead>
                    <tr>
                        <th width="100">实验室名称</th>
                        <th width="80">负责人</th>
                        <th width="120">负责人电话</th>
                        <th width="120">地点</th>
                        <th width="120">是否预约</th>
                        <th width="120">预约人</th>
                        <th width="250">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${pagers.datas}" var="c" varStatus="l">
                        <tr>
                        <td><u style="cursor:pointer" class="text-primary">${c.name}</u></td>
                        <td>${c.fzr}</td>
                        <td>${c.fzrDh}</td>
                        <td>${c.address}</td>
                        <td>
                            <c:if test="${c.isYy == 0}"><span class="label label-success radius">可预约</span></c:if>
                            <c:if test="${c.isYy == 1}"><span class="label label-defaunt radius">已预约</span></c:if>
                        </td>
                            <td>${c.user.realName}</td>
                            <td class="td-manage">
                                <c:if test="${c.isYy == 0}">
                          <a onClick="yy(${c.id})"  href="javascript:;" title="预约"  class="btn btn-xs btn-success">预约</a>
                                </c:if>
                                    <a onClick="qx(${c.id})"  href="javascript:;" title="取消预约"  class="btn btn-xs btn-success">取消预约</a>
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
        <pg:pager url="${ctx}/laboratory_list2.do" maxIndexPages="5" items="${pagers.total}" maxPageItems="15"
                  export="curPage=pageNumber">
            <pg:param name="name" value="${laboratory.name}"/>
            <pg:param name="fzr" value="${laboratory.fzr}"/>
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
    function yy(id) {
        updateId("laboratory_yy.do", "预约成功", id);
    }

    function qx(id) {
        $.ajax({
            cache: false,
            type: "post",
            url: "laboratory_qx.do",
            data:{id: id},// 你的formid
            async: false,
            success: function(data){
                if (data.flag){
                    layer.msg("取消成功", {
                        icon: 1,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        shuaxin2();
                        window.location.href = data.url;
                    });
                } else {
                    layer.msg("请租用人归还操作", {
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
</script>