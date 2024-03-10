<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fabul
  Date: 2024-03-08
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        a {
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
    <title>listMembers Page</title>
</head>
<body>
<table border="1">
    <tr style="background-color: lightgray">
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <c:forEach items="${dtoList}" var="dto">
        <tr>
            <td>${dto.mid}</td>
            <td>${dto.mpw}</td>
            <td>${dto.mname}</td>
            <td>${dto.mmail}</td>
            <td>${dto.joinDate}</td>
            <td><a href="/member/modMember.do?mid=${dto.mid}">수정</a></td>
            <td>
                <form action="/member/delMember.do?mid=${dto.mid}" method="post">
                    <button type="submit">삭제</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/registerMembers.do">회원 가입하기</a>


</body>
</html>
