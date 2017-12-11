<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/layui.css">
<script src="js/layui.js"></script>
<script src="js/jquery-2.2.4.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<ul id="demo"></ul>

	<script type="text/javascript">
		layui.use('tree',function() {
							layui.tree({
										elem : '#demo' //传入元素选择器
										,
										nodes : [ { //节点
											name : '查看员工',
											id : 'emp'
										}, {
											name : '查看部门',
											id : 'depa'
										}, {
											name : '父节点2',
											children : [ {
												name : '子节点21',
												children : [ {
													name : '子节点211'
												} ]
											} ]
										} ],
										click : function name(node) {
										if (node.id != undefined) {
												if (node.id == "emp") {
													parent.right.location.href = "queryEmp";
												}else if (node.id == 'depa'){
													parent.right.location.href = "queryDepa2";
												} 
											}
										}
									});
						});
	</script>
</body>
</html>