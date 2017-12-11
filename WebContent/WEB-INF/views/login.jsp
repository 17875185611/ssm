<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>login</title>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>
</head>
<body onload="err();">
    <div align="right">
       <form id="a" action="i18n">
       <input type="hidden" id="locale" name="locale" value="">
	        语言：<select onchange="onChange();" id="select">
	           <c:if test="${language!='en_US' }">
	                <option value="zh_CN" selected="selected">中文</option>
	                <option value="en_US" >English</option>
	           </c:if>
	           <c:if test="${language=='en_US' }">
	                <option value="zh_CN" >中文</option>
	                <option value="en_US" selected="selected">English</option>
	           </c:if>
	        </select>
	   </form>
    </div>
	<form action="<%=request.getContextPath()%>/checkServlet"
		method="post">
		<div align="center">
			<table>
				<tbody>
					<tr>
						<td><fmt:bundle basename="i18n">
								<fmt:message key="i18n.username" />
							</fmt:bundle></td>
						<td><input type="text" name="user" /></td>
					</tr>
					<tr>
						<td><fmt:bundle basename="i18n">
								<fmt:message key="i18n.password" />
							</fmt:bundle></td>
						<td><input type="text" name="pd" /></td>
					</tr>
					<tr>
						<td><font size="4px" id="valueId">验证码</font></td>
						<td>
							<div align="center" style="display: none;" id="code">
								<input type="hidden" name="hiddenCode" id="hiddenCodeId"
									value="${hiddenCode}"> <input type="text"
									name="randomCode" /> <img id="vimg" title="点击更换"
									onclick="changeCode();" src="servlet/AuthImageServlet"> <br />
								<input type="hidden" name="err" id="errId" value="${err}" /> <span
									id="span"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="登录" /> <input type="reset" value="重置" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>

<script type="text/javascript">
	function changeCode() {
		var imgNode = document.getElementById("vimg");
		//Math.random(); 随机数，只是为了每次都请求sevlet，如果每次请求的都是同一个值，那么只会请求一次servlet
		imgNode.src = "servlet/AuthImageServlet?t=" + Math.random();
	}

	function err() {
		var hiddenCodeId = document.getElementById("hiddenCodeId").value;/* 得到隐藏验证码输入框的值 */
		var err = document.getElementById("errId").value;//得到错误的值
		if ("" == hiddenCodeId) {//如果值等于空，就说明是第一次登录
			$("#valueId").hide();
			document.getElementById("code").style.display = "none";//将验证码输入框隐藏起来
		} else if ("1" == hiddenCodeId) {//如果等于1 说明不是第一次

			document.getElementById("code").style.display = "";//将验证码输入框 
		}

		if ("0" == err) {//如果err等于0或2，表示用户名或密码错误
			//alert("请输入验证码");/*弹出框效果  */
			$("#valueId").show();
			$("#span").html("请输入验证码!").css("color", "green");/* 直接在页面打出来 */
		} else if ("1" == err) {//如果err等于1，表示用户名或密码为空
			//alert("请输入用户名或密码");
			$("#valueId").show();
			$("#span").html("请输入用户名或密码").css("color", "green");
		} else if ("2" == err) {//如果err等于2，表示用户名或密码错误
			//alert("用户名或密码错误");
			$("#valueId").show();
			$("#span").html("用户名或密码错误").css("color", "green");
		} else if ("3" == err) {//如果err等于3，表示验证码输入错误
			//alert("验证码输入错误");
			$("#valueId").show();
			$("#span").html("验证码输入错误").css("color", "green");
		}
	}
	
	function onChange(){
	     var locale = $("#select").val();
	     var action = "i18n?locale="+locale;
	     var locale = $("#locale").val(locale);
	     $("#a").submit();
	}
</script>
</html>