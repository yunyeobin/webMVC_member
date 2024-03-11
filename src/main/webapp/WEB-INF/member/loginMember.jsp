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
    <style>

        #id {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #pw {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #loginbutton {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }

        a {
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
    <title>Login Page</title>
</head>
<body>

<%--해당양식을 제출하면 LoginCintroller에 post요청--%>
<form id="login" action="/login" method="post">
    <div id="id">
        <label>아이디</label>
        <input type="text" name="mid">
    </div>
    <br>
    <div id="pw">
        <label>비밀번호</label>
        <input type="text" name="mpw">
    </div>
    <div id="loginbutton">
        <button type="submit">로그인하기</button>
    </div>
</form>

<%--해당 링크를 클릭하면 RegisterMemberController에서 Get요청--%>
<a href="/registerMembers.do">회원가입하기</a>

</body>
</html>
