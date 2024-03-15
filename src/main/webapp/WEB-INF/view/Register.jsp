<%--
  Created by IntelliJ IDEA.
  User: miryo
  Date: 2024-03-08
  Time: AM 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/jquery/jquery-3.7.0.min.js"></script>
    <script src="/script/commonScript.js"></script>
    <title>info</title>
</head>
<body>
<form action="register" name="form1" method="post">
    <table>

        <thead>
        <tr>
            <th colspan="3">회원가입</th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td class="col1">아이디</td>
            <td class="col2"><input type="text" id="idchk" name="id" class="chk" title="아이디" placeholder="아이디를 입력하시오"></td>
            <td class="col3">아이디를 적어주시오</td>
        </tr>
        <tr>
            <td class="col1">패스워드</td>
            <td class="col2"><input type="password" id="check1" name="passwd" class="chk" title="패스워드" placeholder="비밀번호를 입력하시오"></td>
            <td class="col3">패스워드를 적어주시오</td>
        </tr>
        <tr>
            <td class="col1">패스워드 확인</td>
            <td class="col2"><input type="password" id="check2" name="repasswd" class="chk" title="패스워드확인" placeholder="패스워드를 확인하시오">
            </td>
            <td class="col3">패스워드를 확인하시오</td>
        </tr>
        <tr>
            <td class="col1">이름</td>
            <td class="col2"><input type="text" name="name" class="chk" title="이름" placeholder="이름을 입력하시오">
            </td>
            <td class="col3">고객 실명을 적어주세요</td>
        </tr>
        <tr>
            <td class="col1">이메일</td>
            <td class="col2"><input type="text" name="email" placeholder="aaa@himidia.co.kr">
            </td>
            <td class="col3">이메일을 적으시오</td>
        </tr>
        <tr>
            <td class="col1">전화번호</td>
            <td class="col2"><input type="text" class="chk" name="phone" title="전화번호" placeholder="전화번호(010-1111-1234)">
            </td>
            <td class="col3">전화번호를 입력하시오</td>
        </tr>

        </tbody>
        <tfoot>
        <tr>
            <td colspan="3">
                <button id="submit11" type="button">회원가입</button>
                <button type="reset">다시입력</button>
            </td>

        </tr>
        </tfoot>

    </table>

</form>
</body>
</html>
