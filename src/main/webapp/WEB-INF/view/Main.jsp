<%--
  Created by IntelliJ IDEA.
  User: miryo
  Date: 2024-03-06
  Time: PM 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <title>AlGo보니?</title>
</head>
<body>
<%@ include file="Top.jsp" %>
<%-- <c:import url="Top.jsp"></c:import> --%>
<div class="clear"></div>
<div id="contents">
    <c:import url="./${contentsJsp}.jsp"></c:import>
</div>
</body>
</html>
