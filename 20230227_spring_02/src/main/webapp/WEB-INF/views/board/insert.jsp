<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>board insert</h1>
	<!-- file upload : enctype  -->
	<form action="insert" method="post" enctype="multipart/form-data" >
		<input type="text" name="boardTitle" placeholder="����"><br>
		<input type="text" name="boardContent" placeholder="����"><br>
		<!-- file�� ��� name�� vo�� �ٸ� �̸����� �ؾ���. -->
		<input type="file" name="report" placeholder="÷������"><br>
		<button type="submit">�Խñ۵��</button>
	</form>
</body>
</html>