<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update</title>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		var html = "";
		var genderId = $("#genderId").val();
		if ("Male" == genderId) {
			html = "<label><input  name='gender' id='gender' type='radio' value='Male' checked='checked' />Male</label>"
					+ "<label><input name='gender' id='gender' type='radio' value='Female' />Female</label>";
		} else if ("Female" == genderId) {
			html = "<label><input  name='gender' id='gender' type='radio' value='Male'  />Male</label>"
					+ "<label><input name='gender' id='gender' type='radio' value='Female' checked='checked'/>Female</label>";
		}
		$("#gId").html(html);
		$.ajax({
			type : "GET",
			url : "<%=request.getContextPath()%>/ajax",
			dataType : "json",
			success : function(data) {
			    var list = data.list;
			    var optionstring = "";
			    var depaid = $("#depaid").val();
			    for (var i = 0; i < list.length; i++) {
			         if (depaid == list[i].depaid) {
						optionstring += "<option selected='selected' value=\"" + list[i].depaid + "\" >" + list[i].departmentName + "</option>";
					} else {
					    optionstring += "<option value=\"" + list[i].depaid + "\" >" + list[i].departmentName + "</option>";
					 }
				}
				$("#deparId").html(optionstring);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
			}
		});
	});
	
	function button(){
	     window.history.back(-1); 
	}
</script>
</head>
<body>
	<input type="hidden" value="${emp.gender}" id="genderId">
	<input type="hidden" value="${emp.department.depaid}" id="depaid">

	<div align="center">
		<form action="<%=request.getContextPath()%>/updateEmp" method="post"
			style="width: 50%">
			<input type="hidden" value="${emp.id}" name="id" id="id">
			<input type="hidden" name="_method" value="PUT">
			<table>
				<tr>
					<td>员工邮箱:</td>
					<td><input style="width: 200px" name="email" id="email"
						value="${emp.email }" /></td>
				</tr>
				<tr>
					<td>员工性别:</td>
					<td id="gId"></td>
				</tr>
				<tr>
					<td>所属部门:</td>
					<td><select style="width: 200px; height: 30px;"
						name="department.depaid" id="deparId">
							
					</select></td>
				</tr>
				<tr>
					<td>员工地址:</td>
					<td><input style="width: 200px" name="address" id="address"
						value="${emp.address }" /></td>
				</tr>
				<tr>
					<td>员工电话:</td>
					<td><input style="width: 200px" name="iphone" id="iphone"
						value="${emp.iphone }" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="修改" />
						<input type="reset" value="重置" /> <input onclick="button();" type="button" value="取消" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>