<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm/Sửa danh mục</title>
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>
<body class="bg-light">

<div class="container mt-4">
    <h3 class="mb-3">
        ${dm == null ? "Thêm danh mục" : "Sửa danh mục"}
    </h3>

    <form action="admin-danhmuc" method="post" class="bg-white p-4 rounded shadow">
    <input type="hidden" name="action"
           value="${dm == null ? 'insert' : 'update'}">

        <div class="mb-3">
            <label>Mã đơn hàng</label>
            <input type="text" name="maDM" class="form-control"
                value="${dh.maDM}" 
                ${dm != null ? "readonly" : ""} required>
        </div>

        <div class="mb-3">
            <label>Tên danh mục</label>
            <input type="text" name="tenDM" class="form-control"
                value="${dm.tenDM}" required>
        </div>

        <button class="btn btn-outline-success">Lưu</button>
        <a href="admin-danhmuc" class="btn btn-outline-secondary">Quay lại</a>
    </form>
</div>

</body>
</html>