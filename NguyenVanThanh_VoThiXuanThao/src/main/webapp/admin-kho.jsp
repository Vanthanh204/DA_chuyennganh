<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý kho</title>
<link rel="stylesheet" 
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>
<body>

<div class="container mt-4">

    <h3 class="mb-3">Quản lý kho</h3>

    <form action="admin-kho" method="get" class="d-flex mb-3">
    <input type="hidden" name="action" value="search">
    <input class="form-control me-2" name="key" placeholder="Nhập mã kho hoặc tên sản phẩm"
           value="${param.key}">
    <button class="btn btn-outline-primary" style="width:100px">Tìm kiếm</button>
    <a href="admin-home.jsp" class="btn btn-outline-primary " style="width:100px">Quay lại</a>
</form>


    <c:if test="${empty listKho}">
        <div class="alert alert-warning">Không tìm thấy dữ liệu kho</div>
    </c:if>

    <table class="table table-bordered table-striped">
        <thead class="table-primary">
            <tr>
                <th>Mã kho</th>
                <th>Sản phẩm</th>
                <th>Số lượng tồn</th>
                <th>Ngày cập nhật</th>
                <th>Hành động</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="k" items="${listKho}">
                <tr>
                    <td>${k.maKho}</td>
                    <td>${k.sanPham.tenSP}</td>
                    <td>${k.soLuongTon}</td>
                    <td><fmt:formatDate value="${k.ngayCapNhat}" pattern="dd/MM/yyyy"/></td>
                    <td>
                        <a href="admin-kho?action=edit&maKho=${k.maKho}" class="btn btn-sm btn-outline-primary">Sửa</a>

						<a href="admin-kho?action=delete&maKho=${k.maKho}" class="btn btn-sm btn-outline-danger">Xóa</a>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
