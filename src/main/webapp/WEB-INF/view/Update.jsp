<%--
  Created by IntelliJ IDEA.
  User: miryo
  Date: 2024-03-08
  Time: PM 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원정보 수정</title>
</head>
<body>
<form action="memUpProc" name="topForm1" method="post">
    <table>

        <thead>
        <tr>
            <th colspan="2">회원가입</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td class="col1">아이디</td>
            <td class="col2">
                ${mdto.id}<input type="hidden" name="mem_id" value="${mdto.id}">
            </td>
        </tr>
        <tr>
            <td class="col1">패스워드</td>
            <td class="col2"><input type="password" id="check1" name="m_passwd" class="chk1" title="패스워드"
                                    value="${mdto.pwd}">
                <font id="check" size="2" color="green"></font></td>

        </tr>
        <tr>
            <td class="col1">패스워드 확인</td>
            <td class="col2"><input type="password" id="check2" name="m_repasswd" class="chk1" title="패스워드확인"
                                    value="${mdto.pwd}">
            </td>

        </tr>
        <tr>
            <td class="col1">이름</td>
            <td class="col2"> ${mdto.name}
            </td>
        </tr>
        <tr>
            <td class="col1">이메일</td>
            <td class="col2"><input type="text" name="m_email" value="${mdto.email}">
            </td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="2" class="tableBtn">
                <button class="submit1" type="button">회원정보수정</button>
            </td>
        </tr>
        </tfoot>

    </table>

</form>

</body>
</html>
