<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đơn hàng</title>

<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />

</head>
<body class="bg-light">

<div class="container mt-4">

    <h3 class="mb-3">Chi tiết đơn hàng #${don.maDH}</h3>

    <div class="bg-white p-4 rounded shadow">

        <h5 class="text-primary">Thông tin đơn hàng</h5>
        <table class="table table-bordered">
            <tr>
                <th style="width: 200px;">Mã đơn hàng</th>
                <td>${dh.maDH}</td>
            </tr>
            <tr>
                <th>Khách hàng</th>
                <td>${dh.khachHang.hoTen} - ${don.khachHang.sdt}</td>
            </tr>
            <tr>
                <th>Nhân viên xử lý</th>
                <td>${dh.nhanVien.hoTen}</td>
            </tr>
            <tr>
                <th>Địa chỉ giao hàng</th>
                <td>${dh.diaChiGiaoHang}</td>
            </tr>
            <tr>
                <th>Ngày tạo</th>
                <td>${dh.ngayTao}</td>
            </tr>
            <tr>
                <th>Trạng thái</th>
                <td><span class="badge bg-info">${dh.trangThai}</span></td>
            </tr>
            <tr>
                <th>Tổng tiền</th>
                <td class="fw-bold text-danger">${dh.tongTien} VND</td>
            </tr>
        </table>

        <hr>
        <h5 class="text-primary">Chi tiết sản phẩm</h5>

        <table class="table table-bordered table-striped mt-3">
            <thead class="table-dark">
                <tr>
                    <th>Mã SP</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Thành tiền</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="ct" items="${listCT}">
                    <tr>
                        <td>${ct.maSP}</td>
                        <td>${ct.soLuong}</td>
                        <td>${ct.donGia}</td>
                        <td class="fw-bold text-danger">${ct.thanhTien}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="admin-donhang" class="btn btn-secondary">Quay lại</a>
    </div>

</div>

</body>
</html>