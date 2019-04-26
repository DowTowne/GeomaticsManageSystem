<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resource/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/resource/css/style.css" />
<link href="${ctx}/resource/assets/css/codemirror.css" rel="stylesheet">
	<link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css" />
	<link rel="stylesheet"
		href="${ctx}/resource/assets/css/font-awesome.min.css" />
	<link rel="stylesheet"
		href="${ctx}/resource/assets/css/font-awesome-ie7.min.css" />
	<link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css" />
	<script src="${ctx}/resource/assets/js/jquery.min.js"></script>

	<script src="${ctx}/resource/assets/js/bootstrap.min.js"></script>
	<script src="${ctx}/resource/assets/js/typeahead-bs2.min.js"></script>
	<script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="${ctx}/resource/js/H-ui.js"></script>
	<script type="text/javascript" src="${ctx}/resource/js/H-ui.admin.js"></script>
	<script src="${ctx}/resource/assets/layer/layer.js"
		type="text/javascript"></script>
	<script src="${ctx}/resource/assets/laydate/laydate.js"
		type="text/javascript"></script>
	<script src="${ctx}/resource/AJAX.js" type="text/javascript"></script>
	<title>实验室列表</title> <script>
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
				<form method="post" action="equipment_list.do">
					<div class="search_style">
						<ul class="search_content clearfix">
							<li><label class="l_f">设备型号</label><input name="xh"
								type="text" value="${bean.xh}" class="text_add"
								style="width: 200px" /></li>
							<li><label class="l_f">设备制造商</label><input name="zzs"
								type="text" value="${bean.zzs}" class="text_add"
								style="width: 200px" /></li>
							<li><label class="l_f">设备序列号</label><input name="sbxlh"
								type="text" value="${bean.sbxlh}" class="text_add"
								style="width: 200px" /></li>
							<li style="width: 90px;"><button type="submit"
									class="btn_search">
									<i class="icon-search"></i>查询
								</button></li>
						</ul>
					</div>
				</form>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <a href="javascript:ovid()"
						id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加设备</a>
					</span>
				</div>
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th width="100">设备型号</th>
								<th width="130">设备价格</th>
								<th width="120">设备制造商</th>
								<th width="120">设备序列号</th>
								<th width="120">设备备注</th>
								<th width="250">操作</th>
								<th width="80">实验室</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pagers.datas}" var="c" varStatus="l">
								<tr>
									<td>${c.xh}</td>
									<td>${c.jg}</td>
									<td>${c.zzs}</td>
									<td>${c.sbxlh}</td>
									<td>${c.bz}</td>
									<td class="td-manage">
										<%--<a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a>--%>
										<a title="编辑" onclick="edit(${c.id})" href="javascript:;"
										class="btn btn-xs btn-info"><i
											class="icon-edit bigger-120"></i></a> <a title="删除"
										href="javascript:;" onclick="member_del(this,${c.id})"
										class="btn btn-xs btn-warning"><i
											class="icon-trash  bigger-120"></i></a>
									</td>
									<td>${c.laboratory.name}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- 分页开始 -->
		<div class="pagelist">
			<pg:pager url="${ctx}/equipment_list.do" maxIndexPages="5"
				items="${pagers.total}" maxPageItems="15"
				export="curPage=pageNumber">
				<pg:param name="xh" value="${bean.xh}" />
				<pg:param name="zzs" value="${bean.zzs}" />
				<pg:param name="sbxlh" value="${bean.sbxlh}" />
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
	<!--添加设备图层-->
	<form action="equipment_save.do" method="post"
		class="form form-horizontal" id="form-equipment-add">
		<div class="add_menber" id="add_menber_style" style="display: none">
			<ul>
				<li><label class="label_name" style="width: 130px">设备型号：</label>
					<span class="add_name"> <input value="" name="xh"
						type="text" id="设备型号" class="text_add" />
				</span></li>
				<li><label class="label_name" style="width: 130px">设备价格：</label>
					<span class="add_name"> <input name="jg" type="text"
						id="设备价格" class="text_add" />
				</span></li>

				<li><label class="label_name" style="width: 130px">所属实验室：</label>
					<span class="add_name"> 
					<select name="laboratory.id"
						style="width: 165px; margin-left: 10px" class="text_add">
							<option value="" id="所属实验室">请选择</option>
							<c:forEach items="${pagers2.datas}" var="b" varStatus="l">
								<option value="${b.id}">${b.name}</option>
							</c:forEach>
					</select>
				</span></li>
				
				<li><label class="label_name" style="width: 130px">设备状态：</label>
					<span class="add_name"> 
					<select name="equipmentstatus.id"
						style="width: 165px; margin-left: 10px" class="text_add">
							<option value="" id="设备状态">请选择</option>
							<c:forEach items="${equipmentStatusPagers.datas}" var="b" varStatus="l">
								<option value="${b.id}">${b.name}</option>
							</c:forEach>
					</select>
				</span></li>

				<li><label class="label_name" style="width: 130px">设备制造商：</label>
					<span class="add_name"> <input name="zzs" type="text"
						id="设备制造商" class="text_add" />
				</span>
					<div class="prompt r_f"></div></li>
				<li class="adderss"><label class="label_name"
					style="width: 130px">设备序列号：</label> <span class="add_name">
						<input name="sbxlh" type="text" id="设备序列号" class="text_add"
						style="width: 350px" />
				</span></li>
				<li class="adderss"><label class="label_name"
					style="width: 130px">设备用途说明：</label> <span class="add_name">
						<input name="bz" type="text" id="设备备注" class="text_add"
						style="width: 350px" />
				</span></li>
			</ul>
		</div>
	</form>
</body>
</html>
<script>
    /*设备-添加*/
    $('#member_add').on('click', function(){
        layer.open({
            type: 1,
            title: '添加设备',
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
                    AJAX("equipment_save.do", "添加成功", "form-equipment-add", 2);
                }
            }
        });
    });

    function edit(id) {
        layer.open({
            type: 2,
            area: ['910px', '500px'],
            content: ['equipment_edit.do?id=' + id, 'no']  //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
    }
    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
           updateId("equipment_delete.do", "删除成功", id)
        });
    }
    laydate({
        elem: '#start',
        event: 'focus'
    });

</script>