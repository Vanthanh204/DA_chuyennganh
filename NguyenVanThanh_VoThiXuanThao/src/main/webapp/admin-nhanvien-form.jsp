<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm/Sửa nhân viên</title>
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>
<body class="bg-light">

<div class="container mt-4">
    <h3 class="mb-3">
        ${nv == null ? "Thêm nhân viên" : "Sửa nhân viên"}
    </h3>

<form action="admin-nhanvien" method="post" class="bg-white p-4 rounded shadow">

    <input type="hidden" name="action" value="${action}">

    <div class="mb-3">
        <label>Mã nhân viên</label>
        <input type="text" name="maNV" class="form-control"
       value="${nv.maNV}" readonly>
    </div>
    

    <div class="mb-3">
        <label>Họ tên</label>
        <input type="text" name="hoTen" class="form-control"
            value="${nv != null ? nv.hoTen : ''}" required>
    </div>

    <div class="mb-3">
        <label>Mật khẩu</label>
        <input type="text" name="mk" class="form-control"
            value="${nv != null ? nv.mk : ''}" required>
    </div>

    <div class="mb-3">
        <label>SĐT</label>
        <input type="text" name="sdt" class="form-control"
            value="${nv != null ? nv.sdt : ''}" required>
    </div>

    <div class="mb-3">
        <label>Email</label>
        <input type="text" name="email" class="form-control"
            value="${nv != null ? nv.email : ''}">
    </div>

    <div class="mb-3">
        <label>Vai trò</label>
        <select name="vaiTro" class="form-select">
            <option value="BANHANG"  ${nv != null && nv.vaiTro == "BANHANG" ? "selected" : ""}>Bán hàng</option>
            <option value="KYTHUAT"  ${nv != null && nv.vaiTro == "KYTHUAT" ? "selected" : ""}>Kỹ thuật</option>
            <option value="KHO"      ${nv != null && nv.vaiTro == "KHO" ? "selected" : ""}>Kho</option>
            <option value="ADMIN"    ${nv != null && nv.vaiTro == "ADMIN" ? "selected" : ""}>Admin</option>
        </select>
    </div>

    <div class="mb-3">
        <label>Trạng thái</label>
        <select name="trangThai" class="form-select">
            <option value="Dang lam" ${nv != null && nv.trangThai == "Dang lam" ? "selected" : ""}>Đang làm</option>
            <option value="Nghi viec" ${nv != null && nv.trangThai == "Nghi viec" ? "selected" : ""}>Nghỉ việc</option>
        </select>
    </div>

    <button class="btn btn-outline-success">Lưu</button>
    <a href="admin-nhanvien" class="btn btn-outline-secondary ms-2">Hủy</a>
    </form>
</div>

</body>
</html>

