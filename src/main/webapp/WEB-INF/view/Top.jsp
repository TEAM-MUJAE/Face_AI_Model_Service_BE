<%--
  Created by IntelliJ IDEA.
  User: miryo
  Date: 2024-03-08
  Time: PM 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <script src="/jquery/jquery-3.7.0.min.js"></script>
    <script src="/script/commonScript.js"></script>
    <title>Title</title>
</head>
<body>
<div id="Top">
    <header>
        <nav id="top_menu">
            <table class="top1">
                <tr>
                    <th><a href="/">홈으로 가보자고</a></th>
                    <c:choose>
                        <c:when test="${ssKey!=null}">
                            <th><a href="/logoutProc">로그아웃</a></th>
                            <th><a href="/info">정보수정</a></th>
                        </c:when>
                        <c:when test="${ssKey==null}">
                            <th><a href="/login">회원가입</a></th>
                            <th><a href="/join">로그인</a></th>
                        </c:when>
                    </c:choose>
                </tr>
            </table>
        </nav>
    </header>
    <aside>
        <article>
            <div>
                <c:choose>
                    <c:when test="${ssKey!=null}">
                        <form action="/logoutProc" method="post" name="topForm">
                            <ul>
                                <li style="height: 20px">${ssKey.name}님</li>
                                <li style="height: 20px">반갑습니다</li>
                            </ul>
                        </form>
                    </c:when>
                    <c:when test="${ssKey==null}">
                        <form action="loginProc" method="post" name="topForm">
                            <ul id="">
                                <li><input type="text" name="mem_id" class="chkt" title="아이디"></li>
                                <li><input type="password" name="m_passwd" class="chkt" title="패스워드"></li>
                            </ul>
                        </form>
                    </c:when>
                </c:choose>
            </div>
        </article>
    </aside>
</div>


</body>
</html>
