<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./board/list?searchWord=안녕"> 한글 확인</a>
<form action="./board/list?searchWord=안녕" method="post"> 
<input type="text" name="searchWord">
<button>한글 포스트 확인</button>
</form>>
</body>
</html>
