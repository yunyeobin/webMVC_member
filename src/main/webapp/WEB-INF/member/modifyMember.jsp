<%--
  Created by IntelliJ IDEA.
  User: fabul
  Date: 2024-03-10
  Time: 오후 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modify Member Page</title>
</head>
<body>
<form action="/member/modMember.do" method="post">
    <div>
        <input type="text" name="mid" value="${dto.mid}" readonly>
    </div>
    <div>
        <input type="text" name="mpw" value="${dto.mpw}">
    </div>
    <div>
        <input type="text" name="mname" value="${dto.mname}">
    </div>
    <div>
        <input type="text" name="mmail" value="${dto.mmail}">
    </div>

    <div>
        <button type="submit">수정하기</button>
    </div>
</form>
</body>
</html>
