<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <form action="<%=request.getContextPath() %>/test" method="POST" enctype="multipart/form-data">
          File:<input type="file" name="file">
          Text:<input type="text" name="text">
          <input type="submit">
      </form>
      
      <form action="<%=request.getContextPath() %>/testFileUpload" method="POST" enctype="multipart/form-data">
          File:<input type="file" name="file">
          Text:<input type="text" name="text">
          <input type="submit">
      </form>
      
      <a href="<%=request.getContextPath() %>/testResponseEntity">testResponseEntity</a>
      
      <form action="<%=request.getContextPath() %>/testTransactional" method="POST">
                          用户ID：<input type="text" name="userId" />
                          书本ID：<input type="text" name="bookId" />
           <input type="submit">
      </form>
      
      <form action="<%=request.getContextPath() %>/testPoi" method="post" enctype="multipart/form-data">
           File:<input type="file" name="file">
           <input type="submit" value="提交">
      </form>
</body>
</html>