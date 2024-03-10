<%--
  Created by IntelliJ IDEA.
  User: fabul
  Date: 2024-03-08
  Time: 오후 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            width: 300px;
            border: 1px solid #ccc;
            padding: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            text-align: center;
        }

        .label-input {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }

        label {
            width: 80px;
            margin-right: 10px;
        }

        input {
            flex: 1;
        }

        .buttons {
            display: flex;
            margin-top: 10px;
        }

        button {
            width: 100px;
            margin-right: 10px;
        }
    </style>
    <title>Register Page</title>
</head>
<body>
<div class="container">
    <h1>회원 가입</h1>
    <form action="/registerMembers.do" method="post">
        <div class="label-input">
            <label for="mid">아이디</label>
            <input type="text" id="mid" name="mid">
        </div>
        <div class="label-input">
            <label for="mpw">비밀번호</label>
            <input type="text" id="mpw" name="mpw">
        </div>
        <div class="label-input">
            <label for="mname">이름</label>
            <input type="text" id="mname" name="mname">
        </div>
        <div class="label-input">
            <label for="mmail">이메일</label>
            <input type="text" id="mmail" name="mmail">
        </div>
        <div class="buttons">
            <button type="submit">가입하기</button>
            <button type="reset">다시 입력</button>
        </div>
    </form>
</div>
</body>
</html>
