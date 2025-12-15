<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán chuyển khoản</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body { background: #f6f6f6; }
    .qr-box {
        background: white;
        padding: 25px;
        border-radius: 12px;
        max-width: 550px;
        margin: auto;
        text-align: center;
        box-shadow: 0 3px 10px rgba(0,0,0,0.12);
    }
</style>

</head>
<body>

<div class="container mt-5">

    <div class="qr-box">

        <h3 class="fw-bold mb-3 text-primary">Quét mã QR để thanh toán</h3>

        <img src="images/qr.jpg" class="img-fluid" width="300">

        <p class="mt-3 fs-5">
            Vui lòng chuyển khoản đúng số tiền:  
            <b class="text-danger">
           <fmt:formatNumber value="${tong}" type="number"/> đ 
            </b>
        </p>

        <form action="xacnhan-bank" method="post">
            <button class="btn btn-success fs-5 px-4 mt-3">
                Tôi đã thanh toán
            </button>
        </form>

        <a href="giohang?action=view" class="btn btn-link mt-3">← Quay lại giỏ hàng</a>

    </div>

</div>

</body>
</html>
