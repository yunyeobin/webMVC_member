<%--
  Created by IntelliJ IDEA.
  User: fabul
  Date: 2024-03-10
  Time: 오후 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="/login" method="post">
    <label>아이디</label>
    <input type="text" name="mid">
    <label>비밀번호</label>
    <input type="text" name="mpw">
    <button type="submit">로그인하기</button>
</form>
<a href="/registerMembers.do">회원가입하기</a>

</body>
</html>