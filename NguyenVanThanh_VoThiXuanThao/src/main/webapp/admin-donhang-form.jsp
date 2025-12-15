<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo/Sửa đơn hàng</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>

<body class="bg-light">

<div class="container mt-4">
    <h3 class="mb-3">
        ${dh == null ? "Tạo đơn hàng" : "Sửa đơn hàng"}
    </h3>

    <form action="admin-donhang" method="post" class="bg-white p-4 rounded shadow">
    <input type="hidden" name="action"
           value="${dh == null ? 'insert' : 'update'}">

        <div class="mb-3">
            <input type="text" name="maDH" class="form-control"
                value="${dh.maDH}" 
                ${dh != null ? "readonly" : ""} required>
        </div>

        <div class="mb-3">
        <label>Khách hàng</label>
            <select name="maKH" class="form-select" required>
                <option value="">-- Chọn khách hàng --</option>

                <c:forEach var="kh" items="${listKH}">
                    <option value="${kh.maKH}"
                        ${dh != null && dh.khachHang.maKH == kh.maKH ? "selected" : ""}>
                        ${kh.hoTen}
                    </option>
                </c:forEach>
            </select>
    </div>

    <div class="mb-3">
        <label>Nhân viên xử lý</label>
            <select name="maNV" class="form-select" required>
                <option value="">-- Chọn nhân viên --</option>

                <c:forEach var="nv" items="${listNV}">
                    <option value="${nv.maNV}"
                        ${dh != null && dh.nhanVien.maNV == nv.maNV ? "selected" : ""}>
                        ${nv.hoTen}
                    </option>
                </c:forEach>
            </select>
    </div>

    <div class="mb-3">
        <label>Địa chỉ giao hàng</label>
        <input type="text" name="diaChi" class="form-control"
                value="${dh.diaChiGiaoHang}" required>
    </div>

    <div class="mb-3">
        <label>Tổng tiền</label>
        <input type="number" name="tongTien" class="form-control"
                value="${dh.tongTien}" required>
    </div>
    <div class="mb-3">
    <label>Trạng thái đơn hàng</label>
    <select name="trangThai" class="form-select" required>
        <option value="Đang xử lý"
            ${dh != null && dh.trangThai == 'Đang xử lý' ? 'selected' : ''}>
            Đang xử lý
        </option>

        <option value="Đã xác nhận"
            ${dh != null && dh.trangThai == 'Đã xác nhận' ? 'selected' : ''}>
            Đã xác nhận
        </option>

        <option value="Đang giao"
            ${dh != null && dh.trangThai == 'Đang giao' ? 'selected' : ''}>
            Đang giao
        </option>

        <option value="Hoàn thành"
            ${dh != null && dh.trangThai == 'Hoàn thành' ? 'selected' : ''}>
            Hoàn thành
        </option>

        <option value="Hủy"
            ${dh != null && dh.trangThai == 'Hủy' ? 'selected' : ''}>
            Hủy
        </option>
    </select>
</div>
    
    <h5 class="mt-4">Sản phẩm</h5>

        <table class="table table-bordered bg-white">
            <thead class="table-light">
                <tr>
                    <th>Chọn</th>
                    <th>Tên SP</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                </tr>
            </thead>

            <tbody>
               <c:forEach var="sp" items="${listSP}" >
					<tr>
					    <td>
					        <input type="checkbox" name="maSP" value="${sp.maSP}">
					    </td>
					
					    <td>${sp.tenSP}</td>
					
					    <td>
					        <input type="number" name="soLuong"
					               class="form-control" value="1" min="1">
					    </td>
					
					    <td>
					        <!-- Cho phép sửa giá -->
					        <input type="number" name="donGia"
					               class="form-control" value="${sp.giaBan}" >
					    </td>
					</tr>
</c:forEach>

            </tbody>
        </table>

    <button class="btn btn-outline-success">Lưu đơn hàng</button>
    <a href="admin-donhang" class="btn btn-outline-secondary">Quay lại</a>
    </form>
</div>

</body>