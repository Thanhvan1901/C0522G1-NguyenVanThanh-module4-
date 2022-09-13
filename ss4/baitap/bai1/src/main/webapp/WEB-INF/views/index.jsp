<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
  <div class="row w-50 mx-auto">
    <div class="col-lg-12">
      <div class="row m-2">
        <h3>Email box setting</h3>
      </div>
      <form:form action="/save" method="post" modelAttribute="emailBox">
        <div class="row m-2">
          <div class="col-lg-3">
            <span>Language:</span>
          </div>
          <div class="col-lg-9">
            <form:select path="languages" items="${languageList}" class="form-select"/>
          </div>
        </div>
        <div class="row m-2">
          <div class="col-lg-3">
            <span>Page size:</span>
          </div>
          <div class="col-lg-9">
            <div class="row d-flex align-items-center">
              <span class="col-lg-2">Show</span>
              <div class="col-lg-3">
                <form:select  path="pageSize" items="${pageSizeList}" class="form-select"/>
              </div>
              <span class="col-lg-6">emails per page</span>
            </div>
          </div>
        </div>
        <div class="row m-2">
          <div class="col-lg-3">
            <span>Spams filter:</span>
          </div>
          <div class="col-lg-9">
            <div class="row d-flex align-items-center">
              <div class="col-lg-1">
                <form:checkbox cssClass="form-check-input" path="spamsFillter" value="true"/>
              </div>
              <div class="col-lg-11">
                <span>Enable spams filter</span>
              </div>
            </div>
          </div>
        </div>
        <div class="row m-2">
          <div class="col-lg-3">
            <span>Signature:</span>
          </div>
          <div class="col-lg-9">
            <div class="row">
              <div class="col-lg-12">
                <form:textarea path="signature" cssClass="form-control"/>
              </div>
            </div>
          </div>
        </div>
        <div class="row m-2">
          <div class="col-lg-3"></div>
          <div class="col-lg-9">
            <div class="row">
              <div class="col-lg-6 pe-2">
                <button type="submit" class="btn btn-primary w-100">Update</button>
              </div>
              <div class="col-lg-6 ps-2">
                <button class="btn btn-outline-dark w-100">Cancel</button>
              </div>
            </div>
          </div>
        </div>
      </form:form>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>