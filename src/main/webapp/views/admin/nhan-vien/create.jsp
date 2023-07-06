<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17321 - CRUD Nhan Vien</title>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">
<header><h2 style="text-align: center;">Nhân Viên</h2></header>
<sf:form method="post" action="${ action }" modelAttribute="nv" class="container">
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
    <div class=row>
        <div class="mb-3 col-6 ">
            <label class="form-label">Tên Đệm</label>
            <sf:input type="text" class="form-control" path="tenDem"/>
            <div>
                <small><sf:errors path="TenDem" class="text-danger"/></small>
            </div>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label">Họ</label>
            <sf:input type="text" class="form-control" path="ho"/>
            <div>
                <small><sf:errors path="Ho" class="text-danger"/></small>
            </div>
        </div>
    </div>
    <div class="mb-3">
        <label class="form-label">Giới Tính </label>
        <sf:radiobuttons path="gioiTinh" items="${gioiTinh}"/>
        <div>
            <small><sf:errors path="GioiTinh" class="text-danger"/></small>
        </div>
    </div>
    <div class=row>
        <div class="mb-3 col-6 ">
            <label class="form-label">Ngày Sinh </label>
            <sf:input class="form-control" type="date" path="ngaySinh"/>
            <div>
                <small><sf:errors path="NgaySinh" class="text-danger"/></small>
            </div>
        </div>
        <div class="mb-3 col-6 ">
            <label class="form-label">Địa Chỉ</label>
            <sf:input type="text" class="form-control" path="diaChi"/>
            <div>
                <small><sf:errors path="DiaChi" class="text-danger"/></small>
            </div>
        </div>
    </div>

    <div class=row>
        <div class="mb-3 col-6 ">
            <label class="form-label">Số Điện Thoại</label>
            <sf:input type="text" class="form-control" path="sdt"/>
            <div>
                <small><sf:errors path="Sdt" class="text-danger"/></small>
            </div>
        </div>
        <div class="mb-3 col-6 ">
            <label class="form-label">Mật Khẩu</label>
            <sf:input class="form-control" type="password" path="matKhau"/>
            <div>
                <small><sf:errors path="MatKhau" class="text-danger"/></small>
            </div>
        </div>
    </div>
    <div class="mb-3 col-6 ">
        <label class="form-label">Trạng Thái </label>
        <sf:radiobuttons path="trangThai" items="${trangThai}"/>
        <div>
            <small><sf:errors path="TrangThai" class="text-danger"/></small>
        </div>
    </div>
    <div class=row>
        <div class="mb-3 col-6">
            <label class="form-label">Chức vụ</label>
            <sf:select class="form-select" path="CV">
                <c:forEach items="${cv}" var="cv">
                    <sf:option value="${cv.id}">${cv.ten}</sf:option>
                </c:forEach>
            </sf:select>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label">Cửa Hàng</label>
            <sf:select class="form-select" path="CH">
                <c:forEach items="${ch}" var="ch">
                    <sf:option value="${ch.id}">${ch.ten}</sf:option>
                </c:forEach>
            </sf:select>
        </div>
    </div>
    <div class="mb-3">
        <button class="btn btn-danger">Thêm mới</button>
    </div>
</sf:form>
<footer><p style="text-align: center;">Trần Hữu Thiện</p></footer>
</body>
</html>