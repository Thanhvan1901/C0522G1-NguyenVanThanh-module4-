<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/13/2022
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="mt-5 row">
        <div class="col-lg-6">
            <h4>Danh sách tờ khai y tế</h4>
        </div>
        <div class="d-flex justify-content-end col-lg-6">
            <a href="/add"><button class="btn btn-success">Thêm mới tờ khai y tế</button></a>
        </div>
    </div>
    <div class="mt-5">
        <table class="table table-hover text-center">
            <tr>
                <th>STT</th>
                <th>Họ tên</th>
                <th>Năm sinh</th>
                <th>CMND/Hộ chiếu</th>
                <th>Quốc tịch</th>
                <th></th>
            </tr>
            <c:forEach items="${list}" var="medicalDeclaration" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${medicalDeclaration.name}</td>
                    <td>${medicalDeclaration.yearOfBirth}</td>
                    <td>${medicalDeclaration.id}</td>
                    <td>${medicalDeclaration.nationality}</td>
                    <td>
                        <a href="/update/${medicalDeclaration.id}">
                            <button class="btn btn-success w-100">Cập nhật</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>
