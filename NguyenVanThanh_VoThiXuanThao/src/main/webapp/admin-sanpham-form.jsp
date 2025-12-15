<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm/Sửa sản phẩm</title>

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>

<body class="bg-light">

<div class="container mt-4">
    <h3 class="mb-3">
        ${sp == null ? "Thêm sản phẩm" : "Sửa sản phẩm"}
    </h3>
    <form action="admin-sanpham" method="post" class="bg-white p-4 rounded shadow">

    <input type="hidden" name="action"
           value="${sp == null ? 'insert' : 'update'}">
   
			
        <div class="mb-3">
            <label>Mã sản phẩm</label>
            <input type="text" name="maSP" class="form-control"
                value="${sp.maSP}" 
                ${sp != null ? "readonly" : ""}required>
        </div>
        
        <div class="mb-3">
            <label>Tên sản phẩm</label>
            <input type="text" name="tenSP" class="form-control"
                value="${sp.tenSP}" required>
        </div>

        <div class="mb-3">
            <label>Danh mục</label>
            <select name="danhMuc" class="form-select" required>
                <option value="">-- Chọn danh mục --</option>

                <c:forEach var="dm" items="${listDM}">
                    <option value="${dm.maDM}"
                        ${sp != null && sp.danhMuc.maDM == dm.maDM ? "selected" : ""}>
                        ${dm.tenDM}
                    </option>
                </c:forEach>

            </select>
        </div>
        
        <div class="mb-3">
            <label>Mô tả</label>
            <input type="text" name="moTa" class="form-control"
                value="${sp.moTa}" required>
        </div>
        
       	<div class="mb-3">
            <label>Cấu hình</label>
            <input type="text" name="cauHinh" class="form-control"
                value="${sp.cauHinh}" required>
        </div>
        
        <div class="mb-3">
            <label>Màu sắc</label>
            <input type="text" name="mauSac" class="form-control"
                value="${sp.mauSac}" required>
        </div>
        
        <div class="mb-3">
            <label>Dung Luợng</label>
            <input type="text" name="dungLuong" class="form-control"
                value="${sp.dungLuong}" required>
        </div>
        
        <div class="mb-3">
            <label>Hãng sản xuất</label>
            <input type="text" name="hangSX" class="form-control"
                value="${sp.hangSX}" required>
        </div>
        
        <div class="mb-3">
            <label>Giá bán</label>
            <input type="number" name="giaBan" class="form-control"
                value="${sp.giaBan}" required>
        </div>
            
         <div class="mb-3">
         <label>Trạng thái</label>
            <select name="trangThai" class="form-select">
                <option ${sp.trangThai == "Còn hàng" ? "selected" : ""}>Còn hàng</option>
                <option ${sp.trangThai == "Hết hàng" ? "selected" : ""}>Hết hàng</option>
            </select>
        </div>

        <button class="btn btn-outline-success">Lưu</button>
        <a href="admin-sanpham" class="btn btn-outline-secondary">Quay lại</a>
    </form>
    
</div>

</body>
</html>