<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/9/2022
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quy Đổi Tiền Tệ</title>
</head>
<body>
<h1>Từ Điển</h1>
<c:forEach var="translate" items="${result}">
    <p>Tiếng việt: ${translate.vietNam}</p>
</c:forEach>
</body>
</html>
