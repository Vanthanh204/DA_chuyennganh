<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
        body {
            background: #f0f2f5;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .dangky {
            width: 420px;
            background: #fff;
            padding: 35px;
            border-radius: 14px;
            box-shadow: 0 6px 20px rgba(0,0,0,0.15);
        }
        .title {
            font-weight: bold;
        }
        .text_dangnhap {
        text-decoration: none;
        }
    </style>
</head>
<body>
	<div class="dangky">
    <h3 class="text-center title mb-4">Đăng ký tài khoản</h3>

    <form action="register" method="post">
    
        <div class="mb-3">
            <label class="form-label">Họ tên</label>
            <input type="text" name="username" class="form-control" placeholder="Nhập họ tên" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Số điện thoại</label>
            <input type="password" name="password" class="form-control" placeholder="Nhập số điện thoại" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Nhập lại mật khẩu</label>
            <input type="password" name="password" class="form-control" required>
        </div>

        <% 
            String msg = (String) request.getAttribute("msg"); 
            if (msg != null) {
        %>
        <div 
        class="alert alert-danger py-2"><%= msg %>
        </div> 
        <% } %>

        <button class="btn btn-primary w-100 mt-2">Đăng ký</button>

        <div class="text-center mt-3">
            <a href="login.jsp" class= "text_dangnhap">Đã có tài khoản? <b>Đăng nhập</b></a>
        </div>
    </form>
</div>

</body>
</html>