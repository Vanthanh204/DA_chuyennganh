<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.NhanVien" %>

<%
    List<NhanVien> list = (List<NhanVien>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý nhân viên</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-4">
    <h3 class="mb-3">Quản lý nhân viên</h3>
	
<form action="admin-nhanvien" method="get" class="d-flex mb-3">
    <input type="hidden" name="action" value="search">
    <input class="form-control me-2" name="key" 
           value="${param.key}" placeholder="Nhập mã, SĐT hoặc tên nhân viên">
    <button class="btn btn-outline-primary" style="width:100px">Tìm kiếm</button>
</form>

<c:if test="${empty list}">
    <div class="alert alert-warning">Không tìm thấy nhân viên</div>
</c:if>

    <a href="admin-nhanvien?action=add" class="btn btn-outline-primary mb-3">Thêm nhân viên</a>
    <a href="admin-home.jsp" class="btn btn-outline-primary mb-3">Quay lại</a>

    <table class="table table-bordered table-striped">
        <thead class="table-primary">
            <tr>
                <th>Mã NV</th>
                <th>Họ tên</th>
                <th>SĐT</th>
                <th>Vai trò</th>
                <th>Trạng thái</th>
                <th>Email</th>
                <th>Hành động</th>
            </tr>
        </thead>

        <tbody>
            <%
    if (list != null && !list.isEmpty()) {
        for (NhanVien nv : list) {
%>
            <tr>
                <td><%= nv.getMaNV() %></td>
                <td><%= nv.getHoTen() %></td>
                <td><%= nv.getSdt() %></td>
                <td><%= nv.getVaiTro() %></td>
                <td><%= nv.getTrangThai() %></td>
                <td><%= nv.getEmail() %></td>
                <td>
                    <a href="admin-nhanvien?action=edit&id=<%= nv.getMaNV() %>" class="btn btn-sm btn-outline-primary">Sửa</a>
                    <a href="admin-nhanvien?action=delete&id=<%= nv.getMaNV() %>" class="btn btn-sm btn-outline-danger">Xóa</a>
                </td>
            </tr>
	<%
        }
    } else {
	%>
        <tr>
            <td colspan="7" class="text-center text-muted">
                Không có dữ liệu nhân viên.
            </td>
        </tr>
	<%
    }
	%>

        </tbody>

    </table>
</div>

</body>
</html>
