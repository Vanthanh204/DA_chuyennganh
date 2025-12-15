<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chọn phương thức thanh toán</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>
    body { background: #f6f6f6; }
    .box {
        background: white;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        max-width: 550px;
        margin: auto;
    }

    .method-card {
        border: 2px solid #ddd;
        border-radius: 12px;
        padding: 15px;
        cursor: pointer;
        transition: 0.2s;
    }

    .method-card:hover {
        border-color: #d70018;
        background: #fff4f5;
    }
</style>

</head>
<body>

<div class="container mt-5">

    <div class="box">
        <h3 class="text-center mb-4 text-danger fw-bold">Chọn phương thức thanh toán</h3>

        <form action="thanhtoan" method="post">

            <!-- COD -->
            <label class="method-card mb-3 d-flex align-items-center">
                <input type="radio" name="pttt" value="COD" checked class="form-check-input me-3">
                <div>
                    <b>Thanh toán khi nhận hàng (COD)</b><br>
                    <small>Không cần thanh toán trước</small>
                </div>
            </label>

            <!-- BANK -->
            <label class="method-card d-flex align-items-center">
                <input type="radio" name="pttt" value="BANK" class="form-check-input me-3">
                <div>
                    <b>Chuyển khoản ngân hàng</b><br>
                    <small>Quét mã QR để thanh toán</small>
                </div>
            </label>

            <div class="text-center mt-4">
                <button class="btn btn-danger px-4 fs-5">Tiếp tục</button>
            </div>

        </form>
    </div>

</div>

</body>
</html>
