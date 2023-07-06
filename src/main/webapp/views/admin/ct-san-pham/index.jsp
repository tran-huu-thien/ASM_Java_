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
<header><h2 style="text-align: center;">Quản Lý Chi Tiết Sản Phẩm</h2></header>
<a href="/admin/ct-san-pham/create" class="btn btn-danger col-1">Thêm mới</a>
<table class="table mt-4">
    <thead>

    <th scope="col">Sản Phẩm</th>
    <th scope="col">NSX</th>
    <th scope="col">Màu Sắc</th>
    <th scope="col">Dòng SP</th>
    <th scope="col">Năm Bảo Hành</th>
    <th scope="col">Mô tả</th>
    <th scope="col">Số lượng tồn</th>
    <th scope="col">Giá nhập</th>
    <th scope="col">Giá bán</th>

    <th colspan="2">Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${ data.content }" var="nv" >
        <tr>

            <td>${ nv.SP.ten } </td>
            <td>${ nv.nsx.ten }</td>
            <td>${ nv.MS.ten }</td>
            <td>${ nv.DSP.ten }</td>
            <td>${ nv.namBH}</td>
            <td>${ nv.moTa }</td>
            <td>${ nv.soLuongTon }</td>
            <td>${ nv.giaNhap }</td>
            <td>${ nv.giaBan }</td>
            <td>
                <a class="btn btn-success" href="/admin/ct-san-pham/edit/${nv.id}">Cập nhật</a>
            </td>
            <td>
                <a class="btn btn-primary" href="/admin/ct-san-pham/delete/${nv.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${ data.totalPages -1}" varStatus="loop">
            <li class="page-item">
                <a class="page-link" href="/admin/ct-san-pham/index?page=${loop.begin + loop.count - 1}">
                        ${loop.begin + loop.count }
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>