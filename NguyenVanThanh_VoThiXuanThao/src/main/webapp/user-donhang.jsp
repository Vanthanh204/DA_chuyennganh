<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng của bạn</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body { background: #f6f6f6; }
    .order-box {
        background: white;
        padding: 20px;
        margin-bottom: 15px;
        border-radius: 12px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }
    .status {
        font-weight: bold;
    }
    .status.cho { color: orange; }
    .status.hoan-tat { color: green; }
    .status.huy { color: red; }
</style>

</head>
<body>

<div class="container mt-4">

    <h3 class="mb-4">📦 Đơn hàng của bạn</h3>
    <h3>🛒 Giỏ hàng</h3>
    <a href="userservlet" class="btn btn-secondary mb-3">⬅ Tiếp tục mua</a>

    <c:if test="${empty listDH}">
        <div class="alert alert-warning">Bạn chưa có đơn hàng nào.</div>
    </c:if>

    <c:forEach var="dh" items="${listDH}">

        <div class="order-box">

            <div class="d-flex justify-content-between">
                <div>
                    <div>Mã đơn: <b>${dh.maDH}</b></div>
                    <div>Ngày đặt: 
                        <fmt:formatDate value="${dh.ngayTao}" pattern="dd/MM/yyyy HH:mm"/>
                    </div>
                </div>

                <c:choose>

			    <c:when test="${dh.trangThai eq 'cho xu ly'}">
			        <div class="status cho">Chờ xử lý</div>
			    </c:when>
			
			    <c:when test="${dh.trangThai eq 'Thanh cong'}">
			        <div class="status hoan-tat">Thành công</div>
			    </c:when>
			
			    <c:when test="${dh.trangThai eq 'da huy'}">
			        <div class="status huy">Đã hủy</div>
			    </c:when>
			
			    <c:otherwise>
			        <div class="status">${dh.trangThai}</div>
			    </c:otherwise>
			
				</c:choose>

            </div>

            <hr>

            <div>
                Tổng tiền:
                <b class="text-danger">
                    <fmt:formatNumber value="${dh.tongTien}" type="number"/> đ
                </b>
            </div>

            <a href="#" class="btn btn-primary btn-sm mt-3">
                Xem chi tiết
            </a>

        </div>

    </c:forEach>
</div>

</body>
</html>
