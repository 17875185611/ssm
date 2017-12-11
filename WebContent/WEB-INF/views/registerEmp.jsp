<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
<script type="text/javascript">
	function button() {
		window.history.back(-1);
	}
</script>
</head>
<body>
	<div align="center">
		<form:form action="addEmp" method="post"
			style="width: 50%" modelAttribute="emp">
			<table>
				<tr>
					<td>员工名称:</td>
					<td><input style="width: 200px" name="lastName" id="lastName" /></td>
				</tr>
				<tr>
					<td>员工邮箱:</td>
					<td><input style="width: 200px" name="email" id="email" /></td>
					<td><form:errors path="email"></form:errors></td>
				</tr>
				<tr>
					<td>员工性别:</td>
					<td><label><input name="gender" id="gender"
							type="radio" value="Male" checked="checked" />Male</label> <label><input
							name="gender" id="gender" type="radio" value="Female" />Female</label></td>
				</tr>
				<tr>
					<td>所属部门:</td>
					<td><select style="width: 200px; height: 30px;"
						name="department.depaid" id="department.depaid">
							<c:forEach items="${list }" var="list">
								<option value="${list.depaid }">${list.departmentName }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>员工地址:</td>
					<td><input style="width: 200px" name="address" id="address" /></td>
				</tr>
				<tr>
					<td>员工电话:</td>
					<td><input style="width: 200px" name="iphone" id="iphone" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="添加" />
						<input type="reset" value="重置" /> <input onclick="button();"
						type="button" value="取消" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>