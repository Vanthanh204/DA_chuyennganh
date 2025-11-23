<%@page import="model.SanPham"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<SanPham> list =(List<SanPham>) request.getAttribute("listSP");
%>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ khách hàng</title>

<style>
/* ======= RESET ======= */
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f5f5f5;
}

/* ======= HEADER ======= */
.header {
    width: 100%;
    background: #d70018;
    padding: 15px 20px;
    color: white;
    font-size: 22px;
    font-weight: bold;
}

/* ======= CONTAINER ======= */
.container {
    width: 95%;
    margin: 20px auto;
}

/* ======= GRID SP ======= */
.products-grid {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
}

/* ======= CARD SP ======= */
.card {
    width: 240px;
    border-radius: 12px;
    background: white;
    padding: 15px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    transition: 0.3s;
}
.card:hover {
    transform: translateY(-5px);
}

/* ======= Ảnh sản phẩm ======= */
.card img {
    width: 100%;
    height: 210px;
    object-fit: cover;
    border-radius: 8px;
}

/* ======= Tên SP ======= */
.card-title {
    margin-top: 10px;
    font-size: 18px;
    font-weight: bold;
    height: 45px;
}

/* ======= Giá SP ======= */
.card-price {
    color: red;
    font-size: 18px;
    font-weight: bold;
    margin: 10px 0 5px 0;
}

/* ======= Nút mua hàng ======= */
.btn-buy {
    display: inline-block;
    padding: 8px 12px;
    background: #d70018;
    color: white;
    text-decoration: none;
    border-radius: 6px;
    margin-top: 10px;
}
.btn-buy:hover {
    background: #bb0015;
}
</style>
</head>

<body>

<!-- HEADER -->
<div class="header">
    📱 CỬA HÀNG ĐIỆN THOẠI – TRANG KHÁCH HÀNG
</div>

<!-- MAIN CONTENT -->
<div class="container">
    <h2>📌 Danh sách sản phẩm</h2>

    <div class="products-grid">

        <% 
        if (list != null) {
            for (SanPham sp : list
            		) { 
        %>

        <div class="card">
            <!-- ảnh mặc định -->
            <img src="images/default.png" alt="Sản phẩm">

            <div class="card-title"><%= sp.getTenSP() %></div>
            <div class="card-price"><%= String.format("%,d", sp.getGiaBan()) %>₫</div>

            <a class="btn-buy" href="product-detail.jsp?masp=<%= sp.getMaSP() %>">
                Xem chi tiết
            </a>
        </div>

        <% 
            }
        } else { 
        %>

        <p>Không có sản phẩm nào trong hệ thống.</p>

        <% } %>

    </div>
</div>

</body>
</html>
