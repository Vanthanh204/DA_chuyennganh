<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý đơn hàng</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>

<body>
<div class="container mt-4">
    
	<h3 class="mb-3">Quản lý đơn hàng</h3>
	
	<form action="admin-donhang" method="get" class="d-flex mb-3">
    <input type="hidden" name="action" value="search">

    <input class="form-control me-2"
           name="key"
           value="${param.key}"
           placeholder="Nhập mã đơn hoặc tên khách hàng">
    <button class="btn btn-outline-primary" style="width:100px">Tìm kiếm</button>
	</form>
	
	<c:if test="${empty listDH}">
    <div class="alert alert-warning">Không tìm thấy đơn hàng</div>
	</c:if>
	
	<a href="admin-donhang?action=add" class="btn btn-outline-primary mb-3">Tạo đơn hàng</a>
	<a href="admin-home.jsp" class="btn btn-outline-primary mb-3">Quay lại</a>
	
	<table class="table table-bordered table-striped">
        <thead class="table-primary">
            <tr>
                <th>Mã đơn</th>
        		<th>Khách hàng</th>
        		<th>Tổng tiền</th>
        		<th>Ngày tạo</th>
        		<th>Trạng thái</th>
        		<th style="width: 180px;">Hành động</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="dh" items="${listDH}">
        <tr>
            <td>${dh.maDH}</td>
            <td>${dh.khachHang.hoTen}</td>
           <td><fmt:formatNumber value="${dh.tongTien}" type="currency" /></td>
            <td>${dh.ngayTao}</td>
            <td>${dh.trangThai}</td>
            <td>
            <a href="admin-donhang?action=view&maDH=${dh.maDH}"
                           class="btn btn-outline-info btn-sm">Xem</a>
                <a href="admin-donhang?action=edit&maDH=${dh.maDH}" class="btn btn-sm btn-outline-primary">Sửa</a>
                <a href="admin-donhang?action=delete&maDH=${dh.maDH}" class="btn btn-sm btn-outline-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
</html>