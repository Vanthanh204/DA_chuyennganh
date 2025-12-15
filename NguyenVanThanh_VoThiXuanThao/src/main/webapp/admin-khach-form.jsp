<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm/Sửa khách hàng</title>
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>

<body class="bg-light">

<div class="container mt-4"> 
    <h3 class="mb-3">
        ${kh == null ? "Thêm khách hàng" : "Sửa khách hàng"}
    </h3>

    <form action="admin-khach" method="post" class="bg-white p-4 rounded shadow">

        <!-- HIDDEN ACTION (đặt đúng vị trí trong form) -->
        <input type="hidden" name="action" value="${kh == null ? 'insert' : 'update'}">

        <div class="mb-3">
            <label>Mã KH</label>
            <input type="text" name="maKH" class="form-control"
                value="${kh.maKH}" required>
        </div>

        <div class="mb-3">
            <label>Họ tên</label>
            <input type="text" name="hoTen" class="form-control"
                value="${kh.hoTen}" required>
        </div>

        <div class="mb-3">
            <label>Địa chỉ</label>
            <input type="text" name="diaChi" class="form-control"
                value="${kh.diaChi}">
        </div>

        <div class="mb-3">
            <label>Email</label>
            <input type="email" name="email" class="form-control"
                value="${kh.email}">
        </div>

        <div class="mb-3">
            <label>SĐT</label>
            <input type="text" name="sdt" class="form-control"
                value="${kh.sdt}" required>
        </div>

        <div class="mb-3">
            <label>Mật khẩu</label>
            <input type="password" name="mk" class="form-control"
                value="${kh.mk}" required>
        </div>

        <div class="mb-3">
            <label>Trạng thái</label>
            <input type="text" name="trangThai" class="form-control"
                value="${kh.trangThai}">
        </div>

        <button class="btn btn-outline-success">Lưu</button>
        <a href="admin-khach?action=list" class="btn btn-outline-secondary ms-2">Hủy</a>
    </form>
</div>

</body>
</html>
