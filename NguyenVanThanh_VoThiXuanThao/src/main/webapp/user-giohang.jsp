<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    .cart-img { width: 90px; height: 90px; object-fit: cover; border-radius: 10px; }
    .qty-btn { 
        padding: 3px 10px; 
        border: 1px solid #aaa; 
        border-radius: 6px;
        text-decoration: none;
        color: black;
    }
</style>
</head>

<body>

<div class="container mt-4">

    <h3>🛒 Giỏ hàng</h3>

    <a href="userservlet" class="btn btn-secondary mb-3">⬅ Tiếp tục mua</a>

    <c:forEach var="ct" items="${list}">
        <div class="row border-bottom py-3 align-items-center">

            <!-- ẢNH -->
            <div class="col-2">
                <img src="images/${ct.sanPham.hinhAnh}" class="cart-img">
            </div>

            <div class="col-4">
                <b>${ct.sanPham.tenSP}</b>

                <div class="mt-2">
                    <a href="giohang?action=minus&maSP=${ct.sanPham.maSP}" class="qty-btn">−</a>
                    <span class="mx-2">${ct.soLuong}</span>
                    <a href="giohang?action=plus&maSP=${ct.sanPham.maSP}" class="qty-btn">+</a>
                </div>
            </div>

            <!-- GIÁ -->
            <div class="col-3 text-danger fw-bold">
                <fmt:formatNumber value="${ct.sanPham.giaBan * ct.soLuong}" type="number"/> đ
            </div>

            <!-- XÓA -->
            <div class="col-3 text-end">
                <a href="giohang?action=delete&maSP=${ct.sanPham.maSP}" class="text-danger">
                    Xóa
                </a>
            </div>

        </div>
    </c:forEach>

    <!-- TỔNG TIỀN -->
    <div class="mt-4 p-3 bg-white rounded shadow-sm">
        <h4>Tổng tiền:
            <span class="text-danger fw-bold">
                <fmt:formatNumber value="${tong}" type="number"/> đ
            </span>
        </h4>

        <a href="chon-pttt.jsp" class="btn btn-danger w-100">Thanh toán</a>
    </div>

</div>

</body>
</html>
