<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello world</title>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
<script src="<%=request.getContextPath()%>/layer/layer.js"></script>
<script type="text/javascript">
	function deleteFunction(depaid){
		if(confirm("确认要删除部门编号为"+depaid+"的部门？")){
			$.ajax({
				type:"GET",
				url:"<%=request.getContextPath()%>/deleteDepaForId/"+depaid,
				success:function(data){
					if("success"==data.mark){
						alert("删除成功");
						window.location.reload();
					}
				}
			})
		}
	}
	
	function updateFunction(depaid){
	    $.ajax({
			type:"GET",
			url:"<%=request.getContextPath()%>/queryOneDepartment/"+depaid,
			success:function(data){
				if("success"==data.mark){
					var departmentName = data.department.departmentName;
					$("#update_departmentName").val(departmentName);
					layer.open({
			            type: 1,
			            shade: false,
			            title: '修改部门',
			            btn: ['修改','取消'],
			            content: $('#update_div'), //捕获的元素
			            area: ['420px', '240px'],
			            yes: function(index){
			                var name = $("#update_departmentName").val();
						    $.ajax({
							type:"GET",
							url:"<%=request.getContextPath()%>/updateDepaForId/"+depaid,
							data:{
							    name : name
							},
							success:function(data){
								if("success"==data.mark){
									alert("修改成功");
									window.location.reload();
								}
							}
						});
			            },btn2:function(index){
			                 layer.close(index);
			            }
                   });
				}
			}
		})
	}
	function addDepa(){
	    layer.open({
            type: 1,
            shade: false,
            title: '添加部门',
            btn: ['添加','取消'],
            content: $('#add_div'), //捕获的元素
            area: ['420px', '240px'],
            yes: function(index){
                var name = $("#add_departmentName").val();
			    $.ajax({
					type:"GET",
					url:"<%=request.getContextPath()%>/addDepa/"+name,
					success:function(data){
						if("success"==data.mark){
							alert("添加成功");
							window.location.reload();
						}
					}
				})
            },btn2:function(index){
                 layer.close(index);
            }
        });
	}
</script>
</head>
<body>
	<div align="center">
		<div align="right" style="width: 70%">
			<button onclick="addDepa();">添加</button>
		</div>
		<table border="1" style="width: 80%">

			<tr>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>

			<c:forEach items="${list}" var="i">
				<tr>
					<td>${i.depaid }</td>
					<td>${i.departmentName }</td>
					<td align="center">
						<input type="button" onclick="updateFunction(${i.depaid});" value="修改"/>&nbsp;||&nbsp;
						<input type="button" onclick="deleteFunction(${i.depaid});" value="删除"/>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="add_div" style="display:none;">
	       <table>
				<tr>
					<td>部门名称:</td>
					<td><input style="width:200px" name="departmentName" id="add_departmentName" /></td>
				</tr>
		   </table>
	</div>
	<div id="update_div" style="display:none;">
	       <table>
				<tr>
					<td>部门名称:</td>
					<td><input style="width:200px" name="departmentName" id="update_departmentName" /></td>
				</tr>
		   </table>
	</div>
</body>
</html>