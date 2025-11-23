<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang quản lý cửa hàng</title>
<style>
    body { font-family: Arial; margin: 0; background: #f4f4f4; }
    .header { background: #cc0000; padding: 15px; color: #fff; font-size: 22px; }
    .container { padding: 20px; }
    .menu {
        display: flex;
        gap: 20px;
        flex-wrap: wrap;
    }
    .item {
        background: white;
        width: 220px;
        padding: 20px;
        text-align: center;
        border-radius: 10px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        cursor: pointer;
        transition: 0.2s;
        text-decoration: none;
        color: black;
        font-size: 18px;
    }
    .item:hover { transform: scale(1.05); background: #eee; }
    .logout { float: right; color: #fff; font-size: 16px; }
</style>
</head>
<body>

<div class="header">
    Xin chào, <%= session.getAttribute("admin") %> — Admin
    <a class="logout" href="logout">Đăng xuất</a>
</div>

<div class="container">
    <h2>Quản lý cửa hàng</h2>

    <div class="menu">
        <a class="item" href="#">📱 Quản lý sản phẩm</a>
        <a class="item" href="#">🛒 Quản lý đơn hàng</a>
        <a class="item" href="#">👥 Quản lý khách hàng</a>
        <a class="item" href="#">👨‍🔧 Quản lý nhân viên</a>
        <a class="item" href="#">💸 Khuyến mãi</a>
        <a class="item" href="#">🏬 Kho – tồn kho</a>
        <a class="item" href="#">📦 Bảo hành</a>
        <a class="item" href="#">🔧 Linh kiện</a>
    </div>
</div>

</body>
</html>
