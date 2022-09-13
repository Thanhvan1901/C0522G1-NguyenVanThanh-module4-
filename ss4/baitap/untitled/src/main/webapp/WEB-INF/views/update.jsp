<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 9/13/2022
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Amiri' rel='stylesheet'>
</head>
<body style="font-family: Amiri,serif">
<div class="container">
    <div class="text-center mt-5">
        <h3>TỜ KHAI Y TẾ</h3>
        <p><b>ĐÂY LÀ TÀI LIỆU QUAN, THÔNG TIN ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỀ PHÒNG DỊCH BỆNH
            TRUYỀN NHIỄM</b></p>
        <h5 class="text-danger">Khuyến cáo: khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lí hình
            sự</h5>
    </div>
    <div class="row">
        <form:form action="/save_update/${medicalDeclaration.id}" method="post" modelAttribute="medicalDeclaration">
            <div class="col-lg-12">
                <label for="name">Họ và tên(ghi chữ IN HOA)</label><span class="text-danger"><i>(*)</i></span>
                <form:input id="name" path="name" cssClass="form-control"/>
            </div>
            <div class="col-lg-12 mt-4">
                <div class="row">
                    <div class="col-lg-4">
                        <span>Năm sinh</span><span class="text-danger"><i>(*)</i></span>
                        <form:select path="yearOfBirth" items="${years}" cssClass="form-select"/>
                    </div>
                    <div class="col-lg-4">
                        <span>Giới tính</span><span class="text-danger"><i>(*)</i></span>
                        <form:select path="gender" items="${genders}" cssClass="form-select"/>
                    </div>
                    <div class="col-lg-4">
                        <span>Quốc tịch</span><span class="text-danger"><i>(*)</i></span>
                        <form:select path="nationality" items="${nationalities}" cssClass="form-select"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 mt-4">
                <lable>Số hộ chiếu hoặc số CMND hoặc giấy tờ thông hành hợp pháp khác</lable>
                <span class="text-danger"><i>(*)</i></span>
                <form:input path="id" cssClass="form-control"/>
            </div>
            <div class="col-lg-12 mt-4">
                <div class="row">
                    <div>
                        <span>Thông tin đi lại</span><span class="text-danger"><i>(*)</i></span>
                    </div>
                    <div>
                        <form:radiobuttons cssClass="ms-4 me-1" path="transport" items="${transports}"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 mt-4">
                <div class="row">
                    <div class="col-lg-6">
                        <span>Thông tin chi tiết phương tiện đi lại</span>
                        <form:input cssClass="form-control" path="transportNumber"
                                    placeholder="VD: VN123"/>
                    </div>
                    <div class="col-lg-6">
                        <span>Số ghế</span>
                        <form:input cssClass="form-control" path="seatNumber"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 mt-4">
                <div class="row">
                    <div class="col-lg-6">
                        <span>Ngày khởi hành</span><span class="text-danger"><i>(*)</i></span>
                        <div class="row">
                            <div class="col-lg-4">
                                <form:select path="startDay" cssClass="form-select" items="${days}"/>
                            </div>
                            <div class="col-lg-4">
                                <form:select path="startMonth" cssClass="form-select" items="${months}"/>
                            </div>
                            <div class="col-lg-4">
                                <form:select path="startYear" cssClass="form-select" items="${years}"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <span>Ngày kết thúc</span><span class="text-danger"><i>(*)</i></span>
                        <div class="row">
                            <div class="col-lg-4">
                                <form:select path="endDay" cssClass="form-select" items="${days}"/>
                            </div>
                            <div class="col-lg-4">
                                <form:select path="endMonth" cssClass="form-select" items="${months}"/>
                            </div>
                            <div class="col-lg-4">
                                <form:select path="endYear" cssClass="form-select" items="${years}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 mt-4">
                <div class="row">
                    <div>
                        <span>Trong vòng 14 ngày qua, Anh/Chị có đi đến tỉnh/thành phố nào?</span>
                        <span class="text-danger"><i>(*)</i></span>
                    </div>
                    <div>
                        <form:textarea path="moveHistory" cssClass="form-control"/>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 text-danger mt-4">
                <span>Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho phòng chống dịch, thuộc quản lí của Ban chỉ
                    đạo quốc gia về Phòng chống dịch Covid-19.Khi bạn đã nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</span>
            </div>
            <div class="col-lg-12 d-flex justify-content-center mt-4">
                <button type="submit" class="btn btn-success">Cập nhật tờ khai</button>
            </div>
        </form:form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>
