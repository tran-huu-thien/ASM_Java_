<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SD17313 - CRUD Cua Hang</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="f" uri="jakarta.tags.functions" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body class="container">
<header><h2 style="text-align: center;">Quản Lý Khách Hàng</h2></header>
<a href="/admin/khach-hang/create" class="btn btn-danger col-1">Thêm mới</a>
<table class="table mt-4">
    <thead>
    <th scope="col">Mã</th>
    <th scope="col">Họ Và Tên</th>
    <th scope="col">Ngày sinh</th>
    <th scope="col">Địa chỉ</th>
    <th scope="col">SDT</th>
    <th scope="col">Thành Phố</th>
    <th scope="col">Quốc Gia</th>
    <th colspan="2">Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${ data.content }" var="nv">
        <tr>
            <td>${ nv.ma }</td>
            <td>${ nv.ho } ${ nv.tenDem } ${ nv.ten }</td>
            <td>${ nv.ngaySinh }</td>
            <td>${ nv.diaChi }</td>
            <td>${ nv.sdt }</td>
            <td>${ nv.thanhPho  }</td>
            <td>${ nv.quocGia }</td>
            <td>
                <a class="btn btn-success" href="/admin/khach-hang/edit/${nv.id}">Cập nhật</a>
            </td>
            <td>
                <a class="btn btn-primary" href="/admin/khach-hang/delete/${nv.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${ data.totalPages -1}" varStatus="loop">
            <li class="page-item">
                <a class="page-link" href="/admin/khach-hang/index?page=${loop.begin + loop.count - 1}">
                        ${loop.begin + loop.count }
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>