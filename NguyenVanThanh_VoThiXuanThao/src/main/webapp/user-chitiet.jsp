<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${sp.tenSP}</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body { background: #f8f8f8; font-family: Arial; }

    .header-cps {
        background: #000;
        padding: 12px 20px;
        color: white;
        font-size: 20px;
        font-weight: bold;
    }

    .product-img {
        width: 100%;
        height: 420px;
        object-fit: contain;
        background: #fff;
        border-radius: 10px;
        padding: 20px;
    }

    .box-info {
        background: #fff;
        padding: 20px;
        border-radius: 12px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.08);
    }

    .sp-title { font-size: 26px; font-weight: bold; }
    .sp-price { color: #d70018; font-size: 30px; font-weight: bold; }

    .btn-buy {
        background: #d70018;
        color: white;
        width: 100%;
        padding: 14px;
        font-size: 20px;
        font-weight: bold;
        border: none;
    }

    .btn-cart {
        width: 100%;
        padding: 12px;
        font-size: 18px;
        margin-top: 10px;
        border: 2px solid #d70018;
        color: #d70018;
        font-weight: bold;
        background: none;
    }

    .spec-box {
        background: white;
        padding: 20px;
        border-radius: 10px;
        margin-top: 20px;
    }
    .spec-item {
        padding: 8px 0;
        border-bottom: 1px solid #eee;
        display: flex;
        justify-content: space-between;
    }
</style>

</head>
<body>

<div class="header-cps">
    DidongXun - Chi tiết sản phẩm
</div>

<div class="container mt-4">

    <!-- Back -->
    <a href="userservlet" class="btn btn-secondary mb-3">⬅ Quay lại</a>

    <div class="row g-4">

        <!-- IMAGE -->
        <div class="col-md-5">
            <img src="images/${sp.hinhAnh}" class="product-img">
        </div>

        <!-- INFO -->
        <div class="col-md-7">
            <div class="box-info">

                <div class="sp-title">${sp.tenSP}</div>
                <div class="sp-price">
                <fmt:formatNumber value="${sp.giaBan}" type="number"/> đ
                </div>

                <p><b>Màu sắc:</b> ${sp.mauSac}</p>
                <p><b>Dung lượng:</b> ${sp.dungLuong}</p>
                <p><b>Hãng:</b> ${sp.hangSX}</p>

                <!-- MUA NGAY -->
                <button class="btn-buy">MUA NGAY</button>

                <!-- THÊM VÀO GIỎ HÀNG -->
                <a href="giohang?action=add&maSP=${sp.maSP}" class="btn-cart text-center d-block">
                    Thêm vào giỏ hàng
                </a>
            </div>
        </div>
    </div>

    <!-- SPEC -->
    <div class="spec-box">
        <h5><b>Thông số kỹ thuật</b></h5>

        <div class="spec-item">
            <span>Cấu hình</span>
            <span>${sp.cauHinh}</span>
        </div>

        <div class="spec-item">
            <span>Mô tả ngắn</span>
            <span>${sp.moTa}</span>
        </div>

        <div class="spec-item">
            <span>Mô tả chi tiết</span>
            <span>${sp.moTaChiTiet}</span>
        </div>
    </div>

</div>

</body>
</html>
