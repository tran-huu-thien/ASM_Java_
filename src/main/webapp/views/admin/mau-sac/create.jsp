<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17321 - CRUD Dòng Sản Phẩm</title>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">
<header><h2 style="text-align: center;">Màu Sắc</h2></header>
<sf:form method="post" action="${ action }" modelAttribute="ms" class="container">
    <div class=row>
        <div class="mb-3 col-6">
            <label class="form-label">Mã</label>
            <sf:input type="text" class="form-control" path="ma" />
            <div>
                <small><sf:errors path="Ma" class="text-danger"/></small>
            </div>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label">Tên</label>
            <sf:input type="text" class="form-control" path="ten"/>
            <div>
                <small><sf:errors path="Ten" class="text-danger"/></small>
            </div>
        </div>
    </div>

    <div class="mb-3">
        <button class="btn btn-danger">Thêm mới</button>
    </div>
</sf:form>
<footer><p style="text-align: center;">Trần Hữu Thiện</p></footer>
</body>
</html>