<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán thành công</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body { background: #f6f6f6; }
    .box {
        background: white;
        padding: 30px;
        border-radius: 12px;
        text-align: center;
        box-shadow: 0 3px 10px rgba(0,0,0,0.12);
        max-width: 500px;
        margin: auto;
    }
</style>

</head>
<body>

<div class="container mt-5">

    <div class="box">

        <h2 class="text-success fw-bold">✔ Thanh toán thành công!</h2>

        <p class="mt-3 fs-5">
            Mã đơn hàng: <b class="text-primary">${maDH}</b>
        </p>

        <p class="fs-5">
            Phương thức: <b class="text-danger">${pttt}</b>
        </p>

        <a href="userservlet" class="btn btn-primary mt-3 px-4">
            Về trang chủ
        </a>

        <a href="donhang" class="btn btn-outline-secondary mt-3 px-4">
            Xem đơn hàng
        </a>
    </div>

</div>

</body>
</html>
