<%@page import="java.util.List"%>
<%@page import="model.NhanVien"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    if (request.getAttribute("tongDoanhThu") == null) {
        request.getRequestDispatcher("admin-home").forward(request, response);
        return;
    }
%>

<%
    NhanVien nv = (NhanVien) session.getAttribute("admin");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ - Admin</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
    background: #f0f2f5;
    font-family: Arial;
}
.topbar {
    background: #c9d9f8;
    color: #084298; 
    padding: 12px 20px;
    font-size: 18px;
    font-weight: bold;
    border-bottom: 1px solid #9bbcf3;
    box-shadow: 0 2px 6px rgba(0,0,0,0.05);
}
.user-menu {
    position: absolute;
    right: 20px;
    top: 50%;
    transform: translateY(-50%);
}
.user-menu button {
    font-size: 16px;
    padding: 8px 18px;
}
.sidebar {
    width: 220px;
    background: #ffffff;
    border-right: 1px solid #dee2e6;
    height: 100vh;
    padding-top: 20px;
    position: fixed;
}
.menu-item {
    padding: 12px 20px;
    text-decoration: none;
    display: block;
    color: #333;
    font-size: 16px;
}
.menu-item:hover {
    background: #e9ecef;
}
.active-menu {
    background: #e7f1ff;
    border-left: 4px solid #0d6efd;
    font-weight: bold;
    color: #0d6efd;
}
.main {
    margin-left: 240px;
    padding: 20px;
}
.stat-card {
    padding: 20px;
    border-radius: 10px;
    background: #ffffff;
    border: 1px solid #dee2e6;
    color: #0d6efd;
    font-weight: bold;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}
.trangchu {
    background: #ffffff;
    border-radius: 10px;
    padding: 18px;
    border: 1px solid #dee2e6;
    box-shadow: 0 2px 4px rgba(0,0,0,0.05);
}
.trangchu-title {
    font-weight: bold;
    margin-bottom: 12px;
    color: #0d6efd;
}
#doanhThu { color: #1abc9c; font-size: 24px; font-weight: bold; }
#soDon { color: #1abc9c; font-size: 24px; font-weight: bold; }
#spBan { color: #1abc9c; font-size: 24px; font-weight: bold; }

</style>

</head>
<body>
<div class="topbar d-flex align-items-center position-relative" style="height: 56px;">
    <div class="dropdown user-menu">

        <% if (nv != null) { %>
            <button class="btn btn-sm btn-light dropdown-toggle" data-bs-toggle="dropdown">
                Xin chào: <b><%= nv.getHoTen() %></b>
            </button>
            <ul class="dropdown-menu dropdown-menu-end">
                <li><a class="dropdown-item" href="#">Tài khoản</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item text-danger" href="logout">Đăng xuất</a></li>
            </ul>

        <% } else { %>
            <a href="login.jsp" class="btn btn-sm btn-outline-primary">
                <i class="bi bi-person-circle"></i> Đăng nhập
            </a>

        <% } %>

    </div>
</div>


	<div class="sidebar">
	    <a href="admin-home" class="menu-item active-menu">Trang chủ</a>
	    
	    <a href="admin-danhmuc" class="menu-item">Quản lý danh mục</a>
	    
	    <a href="admin-sanpham" class="menu-item">Quản lý sản phẩm</a>
	    <a href="admin-donhang" class="menu-item">Quản lý đơn hàng</a>
	    <a href="admin-khach?action=list" class="menu-item">Quản lý khách hàng</a>
	    <a href="admin-nhanvien" class="menu-item">Quản lý nhân viên</a>
	    <a href="admin-kho" class="menu-item">Tồn kho</a>
	</div>
	
	<div class="main">
	    <div class="row g-3 mb-4">
	
	    <div class="col-lg-4 col-md-7">
	    <div class="stat-card stat-green">
	        Doanh thu<br>
	        <span id="doanhThu">
	    <fmt:formatNumber value="${tongDoanhThu}" type="currency" />
	</span>
	
	    </div>
	</div>
	
	<div class="col-lg-4 col-md-7">
	    <div class="stat-card stat-blue">
	        Đơn hàng<br>
	        <span id="soDon">${soDon}</span>
	    </div>
	</div>
	
	<div class="col-lg-4 col-md-7">
	    <div class="stat-card stat-blue">
	        Sản phẩm bán ra<br>
	        <span id="spBan">${tongSPBan}</span>
	    </div>
	</div>
	
	
	</div>
	
	
	</div>

</body>
</html>