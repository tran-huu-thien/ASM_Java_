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
<header><h2 style="text-align: center;">Chi Tiết Sán Phẩm</h2></header>
<sf:form method="post" action="${ action }" modelAttribute="ctsp" class="container">
    <div class=row>
        <div class="mb-3 col-6">
            <label class="form-label">Năm Bảo Hành </label>
            <sf:input type="number" class="form-control" path="namBH"/>
            <div>
                <small><sf:errors path="NamBH" class="text-danger"/></small>
            </div>
        </div>
    </div>
    <div class=row>
        <div class="mb-3 col-6 ">
            <label class="form-label">Mô tả</label>
            <sf:input type="text" class="form-control" path="moTa"/>
            <div>
                <small><sf:errors path="MoTa" class="text-danger"/></small>
            </div>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label">Số Lượng Tồn</label>
            <sf:input type="number" class="form-control" path="soLuongTon"/>
            <div>
                <small><sf:errors path="SoLuongTon" class="text-danger"/></small>
            </div>
        </div>
    </div>
    <div class=row>
        <div class="mb-3 col-6 ">
            <label class="form-label">Giá Nhập</label>
            <sf:input class="form-control" type="number" path="giaNhap"/>
            <div>
                <small><sf:errors path="GiaNhap" class="text-danger"/></small>
            </div>
        </div>
        <div class="mb-3 col-6 ">
            <label class="form-label">Giá Bán </label>
            <sf:input type="number" class="form-control" path="giaBan"/>
            <div>
                <small><sf:errors path="GiaBan" class="text-danger"/></small>
            </div>
        </div>
    </div>
    <div class=row>
        <div class="mb-3 col-6">
            <label class="form-label">SanPham</label>
            <sf:select class="form-select" path="SP">
                <c:forEach items="${sp}" var="sp">
                    <sf:option value="${sp.id}">${sp.ten}</sf:option>
                </c:forEach>
            </sf:select>
        </div>
        <div class="mb-3 col-6">
            <label class="form-label">Nhà Sản Xuất</label>
            <sf:select class="form-select" path="Nsx">
                <c:forEach items="${nsx}" var="nsx">
                    <sf:option value="${nsx.id}">${nsx.ten}</sf:option>
                </c:forEach>
            </sf:select>
        </div>
    </div>
      <div class=row>
            <div class="mb-3 col-6">
                <label class="form-label">Màu Sắc</label>
                <sf:select class="form-select" path="MS">
                    <c:forEach items="${ms}" var="ms">
                        <sf:option value="${ms.id}">${ms.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="mb-3 col-6">
                <label class="form-label">Dòng Sản Phẩm</label>
                <sf:select class="form-select" path="DSP">
                    <c:forEach items="${dsp}" var="dsp">
                        <sf:option value="${dsp.id}">${dsp.ten}</sf:option>
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