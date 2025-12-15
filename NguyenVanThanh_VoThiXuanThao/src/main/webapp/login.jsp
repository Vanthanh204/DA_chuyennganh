<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: #f0f2f5;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .dangnhap {
            width: 420px;
            background: #fff;
            padding: 35px;
            border-radius: 14px;
            box-shadow: 0 6px 20px rgba(0,0,0,0.15);
        }
        .title {
            font-weight: bold;
        }
        .quen_mk {
        text-decoration: none;
        }
        .dangky {
        text-decoration: none;
        }
    </style>
</head>

<body>

<div class="dangnhap">
    <h3 class="text-center title mb-4">Đăng nhập</h3>

    <form action="login" method="post">
    
        <div class="mb-3">
    <label class="form-label">Số điện thoại</label>
    <input type="text" name="username" class="form-control" placeholder="Nhập số điện thoại" required>
</div>

<div class="mb-3">
    <label class="form-label">Mật khẩu</label>
    <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required>
</div>


        <div class="text-end mb-3">
            <a href="#" class="quen_mk">Quên mật khẩu?</a>
        </div>

        <% 
            String msg = (String) request.getAttribute("msg"); 
            if (msg != null) {
        %>
        <div 
        class="alert alert-danger py-2"><%= msg %>
        </div> 
        <% } %>

        <button class="btn btn-primary w-100 mt-2">Đăng nhập</button>

        <div class="text-center mt-3">
            <a href="dangky.jsp" class= "dangky">Chưa có tài khoản? <b>Đăng ký</b></a>
        </div>
    </form>
</div>

</body>
</html>
