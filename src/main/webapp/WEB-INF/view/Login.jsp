<%--
  Created by IntelliJ IDEA.
  User: miryo
  Date: 2024-03-08
  Time: AM 3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="/jquery/jquery-3.7.0.min.js"></script>
    <script src="/script/commonScript.js"></script>
    <title>login</title>
</head>
<body>
    <form action="loginProc" method="post" name="topForm">
        <h2>로그인</h2>
        <div>
            <input type="text" name="id" id="id" title="아이디" placeholder="아이디" class="chkt">
        </div>
        <div>
            <input type="password" name="passwd" id="pw" title="비밀번호" placeholder="비밀번호" class="chkt">
        </div>
        <button type="submit">로그인</button>
        <button type="button" onclick="location.href='Register'">회원가입</button>
    </form>
</body>
</html>
