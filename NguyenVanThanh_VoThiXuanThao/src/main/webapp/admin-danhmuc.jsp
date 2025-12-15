<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh mục</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>

<body>
<div class="container mt-4">
    
	<h3 class="mb-3">Quản lý danh mục</h3>
	
	<form action="admin-danhmuc" method="get" class="d-flex mb-3">
    <input type="hidden" name="action" value="search">
    <input class="form-control me-2" name="key" value="${param.key}" placeholder="Nhập mã hoặc tên danh mục">
    <button class="btn btn-outline-primary" style="width:100px">Tìm kiếm</button>
	</form>
	
	<c:if test="${empty listDM}">
    <div class="alert alert-warning">Không tìm thấy danh mục</div>
	</c:if>
	
	<a href="admin-danhmuc?action=add" class="btn btn-outline-primary mb-3">Thêm danh mục</a>
	<a href="admin-home.jsp" class="btn btn-outline-primary mb-3">Quay lại</a>
	
	<table class="table table-bordered table-striped">
        <thead class="table-primary">
            <tr>
                <th>Mã danh mục </th>
        		<th>Tên danh mục</th>
       	 		<th>Hành động</th>
            </tr>
        </thead>

        <tbody>
        <c:forEach var="dm" items="${listDM}">
        <tr>
            <td>${dm.maDM}</td>
            <td>${dm.tenDM}</td>
            <td>
                <a href="admin-danhmuc?action=edit&madm=${dm.maDM}" class="btn btn-sm btn-outline-primary">Sửa</a>
                <a href="admin-danhmuc?action=delete&madm=${dm.maDM}" class="btn btn-sm btn-outline-danger">Xóa</a>
            </td>
        </tr>
    	</c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>