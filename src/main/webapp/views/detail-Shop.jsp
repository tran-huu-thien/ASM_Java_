<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="section-title">
    <h2>Chi tiết sản phẩm</h2>

    <div class="row mt-3">
        <div class="col-2"></div>
        <div class="col-6">
            <img alt="" src="/img/denchongcan.jpg" style="width: 319px; height: 319px">
        </div>
        <div class="col-3">
            <br>
<%--            <h2>${l.SP.ten}</h2>--%>
<%--            </br> Xuất Xứ: ${l.NSX.ten }</br> Gía Tiền :--%>
<%--            <fmt:formatNumber type="number" pattern="###,### VNĐ"--%>
<%--                              value="${l.price}" />--%>
            </br> Số Lượng : ${l.soLuongTon }</br>
<%--            Brand : ${l.DSP.ten }</br>--%>
<%--            Màu sản phẩm :${l.MS.ten }--%>
            </br>
            <div class="pt-5">
                <a href="" type="button"
                   class="btn btn-primary">Mua ngay</a>
                <a href="/admin/add?id=${l.id}" class="btn btn-primary">Add giỏ hàng session</a>


            </div>
        </div>
    </div>


</div>