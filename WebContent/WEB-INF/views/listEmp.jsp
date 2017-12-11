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
	function deleteFunction(empId){
		if(confirm("确认要删除员工编码为"+empId+"的员工信息？")){
			$.ajax({
				type:"GET",
				url:"<%=request.getContextPath()%>/deleteEmp/"+empId,
				success:function(data){
					if("success"==data.mark){
						alert("删除成功");
						window.location.reload();
					}
				}
			})
		}
	}
	function chakan(empId){
	     $.ajax({
				type:"GET",
				url:"<%=request.getContextPath()%>/queryEmp/"+empId,
				success:function(data){
					var emp = data.emp;
					$("#lastName").html(emp.last_Name);
					$("#email").html(emp.email);
					$("#gender").html(emp.gender);
					$("#department").html(emp.department.departmentName);
					$("#address").html(emp.address);
					$("#phone").html(emp.iphone);
				}
			});
	     layer.open({
            type: 1,
            shade: false,
            title: false, //不显示标题
            content: $('#div'), //捕获的元素
            area: ['420px', '240px'],
            cancel: function(index){
                layer.close(index);
                this.content.show();
            }
        });
	}
</script>
</head>
<body>
	<div align="center">
		<div align="right" style="width: 70%">
			<a href="<%=request.getContextPath()%>/queryDepa">添加</a>
		</div>
		<table border="1" style="width: 80%">

			<tr>
				<th>员工编号</th>
				<th>员工名称</th>
				<th>员工邮箱</th>
				<th>员工性别</th>
				<th>所属部门</th>
				<th>操作</th>
			</tr>

			<c:forEach items="${list}" var="i">
				<tr>
					<td>${i.id }</td>
					<td>${i.last_Name }</td>
					<td>${i.email }</td>
					<td>${i.gender }</td>
					<td>${i.department.departmentName }</td>
					<td align="center">
						<a href="<%=request.getContextPath() %>/queryOneDepa/${i.id }"><button>修改</button></a>&nbsp;||&nbsp;
						<input type="button" onclick="deleteFunction(${i.id});" value="删除"/>&nbsp;||&nbsp;
						<button onclick="chakan(${i.id});">查看</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div id="div" style="display:none;">
	     <div align="center">
		          员工名称:<font id="lastName"></font><br/>
			员工邮箱:<font id="email"></font><br/>
			员工性别:<font id="gender"></font><br/>
			所属部门:<font id="department"></font><br/>
			员工地址:<font id="address"></font><br/>
			员工电话:<font id="phone"></font><br/>
	     </div>
		
	</div>
</body>
</html>