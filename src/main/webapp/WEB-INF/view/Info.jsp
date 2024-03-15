<%--
  Created by IntelliJ IDEA.
  User: miryo
  Date: 2024-03-08
  Time: PM 5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>회원정보</title>
<script src="/script/member.js"></script>
<body>
<div id="member">
    <table>

        <thead>
        <tr>
            <th>회원정보</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td>아이디</td>
            <td>${mdto.id}</td>

        </tr>
        <tr>
            <td>이름</td>
            <td>${mdto.name}</td>
        </tr>
        <tr>
            <td>이메일</td>
            <td>${mdto.email}</td>
        </tr>

        </tbody>
        <tfoot>
        <tr>
            <td colspan="2" class="tabBtn">
                <input class="update" type="button" name="update" onclick="update('u')" value="정보수정" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="update" type="button" name="delete" onclick="update('d')" value="회원탈퇴" />
            </td>
        </tr>
        </tfoot>
    </table>
</div>
<form name="upForm" id="upForm" action="" method="post">
    <input type ="hidden" id="memId" name="id" value="${mdto.id}">
    <input type ="hidden" id="pw" name="pwd" value="${mdto.pwd}">
</form>
</body>
</html>
