<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎页面</title>
</head>
<frameset  frameSpacing=1 frameBorder=1 rows="50,*">
	<frameset  frameSpacing=1 frameBorder=1 cols="100%,*">
		<frame name="top" src="top.jsp" scrolling=no />
	</frameset>
	<frameset  frameSpacing=1 frameBorder=1 cols="15%,*">
		<frame name="left" src="left.jsp"
			scrolling=no />
		<frame name="right" src="right.jsp"
			scrolling=auto />
	</frameset>
</frameset>
</html>