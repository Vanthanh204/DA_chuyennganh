<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>
<body>

<div class="container mt-4">
    
	<h3 class="mb-3">Quản lý sản phẩm</h3>
	
	<form action="admin-sanpham" method="get" class="d-flex mb-3">
    <input type="hidden" name="action" value="search">
    <input class="form-control me-2" name="key" 
    	value="${param.key}" placeholder="Nhập mã hoặc tên sản phẩm">
    <button class="btn btn-outline-primary" style="width:100px">Tìm kiếm</button>
	</form>
	
	<c:if test="${empty listSP}">
    <div class="alert alert-warning">Không tìm thấy sản phẩm </div>
	</c:if>
	
	
	<a href="admin-sanpham?action=add" class="btn btn-outline-primary mb-3">Thêm sản phẩm</a>
	<a href="admin-home.jsp" class="btn btn-outline-primary mb-3">Quay lại</a>
	
	<table class="table table-bordered table-striped">
        <thead class="table-primary">
            <tr>
                <th style="width: 70px;">Mã SP</th>
        		<th style="width: 150px;">Tên sản phẩm</th>
       	 		<th style="width: 100px;">Danh mục</th>
       	 		<th>Mô tả</th>
       	 		<th>Cấu hình</th>
       	 		<th>Màu sắc</th>
       	 		<th style="width: 120px;">Dung Lượng</th>
       	 		<th style="width: 130px;">Hãng sản xuất</th>
       	 		<th>Giá bán</th>
       	 		<th style="width: 100px;">Trạng thái</th>
       	 		<th style="width: 120px;">Hành động</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="sp" items="${listSP}">
        <tr>
            <td>${sp.maSP}</td>
            <td>${sp.tenSP}</td>
            <td> ${sp.danhMuc.tenDM}</td>
            <td>${sp.moTa}</td>
            <td>${sp.cauHinh}</td>
            <td> ${sp.mauSac}</td>
            <td>${sp.dungLuong}</td>
            <td> ${sp.hangSX}</td>
            <td><fmt:formatNumber value="${sp.giaBan}" type="currency" /></td>

            <td>${sp.trangThai}</td>
            <td>
                <a href="admin-sanpham?action=edit&masp=${sp.maSP}" class="btn btn-sm btn-outline-primary">Sửa</a>
                <a href="admin-sanpham?action=delete&masp=${sp.maSP}" class="btn btn-sm btn-outline-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>