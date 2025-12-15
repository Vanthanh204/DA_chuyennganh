<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý khách hàng</title>
<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />

</head>
<body class="bg-light">

<div class="container mt-4">
    <h3 class="mb-3">Quản lý khách hàng</h3>


<form action="./admin-khach" method="get" class="d-flex mb-3">
    <input type="hidden" name="action" value="search">

    <input class="form-control me-2"
           name="key"
           value="${param.key}"
           placeholder="Nhập mã, SĐT hoặc tên khách hàng">

    <button class="btn btn-outline-primary" style="width:100px">Tìm kiếm</button>
</form>

<c:if test="${empty listKH}">
    <div class="alert alert-warning">Không tìm thấy khách hàng nào.</div>
</c:if>
    <a href="./admin-khach?action=add" class="btn btn-outline-primary mb-3">Thêm khách hàng</a>
    <a href="admin-home.jsp" class="btn btn-outline-primary mb-3">Quay lại</a>


    <table class="table table-bordered table-striped">
        <thead class="table-primary">
            <tr>
                <th>Mã KH</th>
                <th>Họ tên</th>
                <th>SĐT</th>
                <th>Email</th>
                <th>Trạng thái</th>
                <th width="150px">Hành động</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="kh" items="${listKH}">
                <tr>
                    <td>${kh.maKH}</td>
                    <td>${kh.hoTen}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.email}</td>
                    <td>${kh.trangThai}</td>
                    <td>
                        <a href="admin-khach?action=edit&maKH=${kh.maKH}" class="btn btn-sm btn-outline-primary">Sửa</a>
                        <a href="admin-khach?action=delete&maKH=${kh.maKH}" class="btn btn-sm btn-outline-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>