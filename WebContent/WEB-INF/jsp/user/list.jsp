<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link href="${ctx}/resource/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${ctx}/resource/css/style.css"/>
    <link href="${ctx}/resource/assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${ctx}/resource/font/css/font-awesome.min.css"/>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css"/>
    <![endif]-->
    <script src="${ctx}/resource/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/resource/assets/js/bootstrap.min.js"></script>
    <script src="${ctx}/resource/assets/js/typeahead-bs2.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript"></script>
    <script src="${ctx}/resource/assets/laydate/laydate.js" type="text/javascript"></script>
    <title>管理权限</title>
    <script>
        $(function () {
            if (${login} == 1
            )
            {
                top.location = 'login_login.do';
            }
        })
    </script>
</head>
<body>
<div class="page-content clearfix">
    <div id="Member_Ratings">
        <div class="d_Confirm_Order_style">
            <form method="post" action="user_list.do">
                <div class="search_style" style="margin-left: 20px">
                    <ul class="search_content clearfix">
                        <li><label class="l_f">登录帐号</label><input name="name" type="text" value="${bean.name}"
                                                                   class="text_add" style=" width:200px"/></li>
                        <li><label class="l_f">学号/教师号</label><input name="number" type="text" value="${bean.number}"
                                                                 class="text_add" style=" width:200px"/></li>
                        <li><label class="l_f">手机号码</label><input name="phone" type="text" value="${bean.phone}"
                                                                    class="text_add" style=" width:200px"/></li>
                        <li><label class="l_f">班级</label><input name="bj" type="text" value="${bean.bj}"
                                                                    class="text_add" style=" width:200px"/></li>
                        <li><label class="l_f">真实姓名</label><input name="realName" type="text" value="${bean.realName}"
                                                                    class="text_add" style=" width:200px"/></li>
                        <li style="width:90px;">
                            <button type="submit" class="btn_search"><i class="icon-search"></i>查询</button>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
<c:if test="${role.enName == 'admin'}">
        <div class="border clearfix">
       <span class="l_f">
        <button type="submit" id="member_add" class="btn btn-warning" onclick="add()"><i class="icon-plus"></i>添加用户</button>
       </span>
        </div>
    </c:if>
    <div class="margin clearfix">
        <div class="compete_list">
            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>权限名称</th>
                    <th>登陆账号</th>
                    <th>用户名称</th>
                    <th>学院</th>
                    <th>班级</th>
                    <th>手机号码</th>
                    <th>是否审核</th>
                    <th class="hidden-480">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pagers.datas}" var="c" varStatus="l">
                    <tr>
                        <td>${c.role.name}</td>
                        <td>${c.name}</td>
                        <td class="hidden-480">${c.realName}</td>
                        <td class="hidden-480">${c.xy}</td>
                        <td class="hidden-480">${c.bj}</td>
                        <td class="hidden-480">${c.phone}</td>
                        <td class="hidden-480">
                            <c:if test="${c.isSh == 0}"><span style="color: red">未审核</span></c:if>
                            <c:if test="${c.isSh == 1}"><span style="color: blue">已审核</span></c:if>
                        </td>
                        <td>
                            <c:if test="${c.isSh == 0}">
                                <a title="审核" onclick="sh(${c.id})" href="javascript:;"
                                   class="btn btn-xs btn-info" style="background-color: #00B83F"><i
                                        class="fa fa-book"></i></a>
                            </c:if>
                            <a title="编辑" onclick="edit(${c.id})" href="javascript:;"
                               class="btn btn-xs btn-info"><i class="fa fa-edit bigger-120"></i></a>
                            <c:if test="${role.enName == 'admin'}">
                                <a title="删除" href="javascript:;" onclick="Competence_del(${c.id})"
                                   class="btn btn-xs btn-warning"><i class="fa fa-trash  bigger-120"></i></a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- 分页开始 -->
        <div class="pagelist">
            <pg:pager url="${ctx}/user_list.do" maxIndexPages="5" items="${pagers.total}" maxPageItems="15"
                      export="curPage=pageNumber">
                <pg:param name="name" value="${bean.name}"/>
                <pg:param name="number" value="${bean.number}"/>
                <pg:param name="phone" value="${bean.phone}"/>
                <pg:param name="bj" value="${bean.bj}"/>
                <pg:param name="realName" value="${bean.realName}"/>
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
<script type="text/javascript">
    function edit(id) {
        layer.open({
            type: 2,
            area: ['910px', '500px'],
            content: ['user_edit.do?userId=' + id, 'no']  //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });

    }

    function add() {
        layer.open({
            type: 2,
            area: ['710px', '600px'],
            content: ['user_add.do', 'no']  //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });

    }

    function sh(id) {
        $.ajax({
            cache: false,
            type: "post",
            url: "user_updateSh.do",
            data: {id: id},// 你的formid
            async: false,
            success: function (data) {
                if (data.flag) {
                    layer.msg('审核成功', {
                        icon: 1,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function () {
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        window.location.href = data.url;
                    });
                }
            }
        });
    }

    (function () {
        $('#Personal').css("width", "700pxpx");
    })
    /*权限-删除*/
    function Competence_del(id) {
        layer.confirm('确认要删除吗？', function () {
            $.ajax({
                cache: true,
                type: "post",
                url: "user_delete.do",
                data: {userId: id},// 你的formid
                async: false,
                success: function (data) {
                    if (data.flag) {
                        layer.msg('删除成功', {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function () {
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                            window.location.href = data.url;
                        });
                    } else {
                        layer.msg('删除失败', {
                            icon: 1,
                            time: 2000
                        });
                    }
                }
            });
        });
    }
    /*修改权限*/
    function Competence_modify(id) {
        window.location.href = "Competence.html?=" + id;
    }
    ;
    /*字数限制*/
    function checkLength(which) {
        var maxChars = 200; //
        if (which.value.length > maxChars) {
            layer.open({
                icon: 2,
                title: '提示框',
                content: '您出入的字数超多限制!',
            });
            // 超过限制的字数了就将 文本框中的内容按规定的字数 截取
            which.value = which.value.substring(0, maxChars);
            return false;
        } else {
            var curr = maxChars - which.value.length; //250 减去 当前输入的
            document.getElementById("sy").innerHTML = curr.toString();
            return true;
        }
    }
    ;
    //面包屑返回值
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.iframeAuto(index);
    $('.Order_form ,#Competence_add').on('click', function () {
        var cname = $(this).attr("title");
        var cnames = parent.$('.Current_page').html();
        var herf = parent.$("#iframe").attr("src");
        parent.$('#parentIframe span').html(cname);
        parent.$('#parentIframe').css("display", "inline-block");
        parent.$('.Current_page').attr("name", herf).css({"color": "#4c8fbd", "cursor": "pointer"});
        //parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+">" + cnames + "</a>");
        parent.layer.close(index);

    });
</script>