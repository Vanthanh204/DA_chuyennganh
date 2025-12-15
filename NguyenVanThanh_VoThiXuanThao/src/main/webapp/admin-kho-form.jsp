<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm / Sửa kho</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>

<body class="bg-light">

<div class="container mt-4">
    <h3 class="mb-3">
        ${kho == null ? "Thêm kho" : "Sửa kho"}
    </h3>

    <form action="admin-kho" method="post" class="bg-white p-4 rounded shadow">

        <label>Mã kho</label>
        <input type="text" name="maKho" class="form-control mb-3"
               value="${kho.maKho}" required>

        <label>Sản phẩm</label>
        <select name="maSP" class="form-select mb-3">
            <c:forEach var="sp" items="${listSP}">
                <option value="${sp.maSP}"
                    ${kho != null && kho.sanPham != null && kho.sanPham.maSP == sp.maSP ? "selected" : ""}>
                    ${sp.tenSP}
                </option>
            </c:forEach>
        </select>

        <label>Số lượng tồn</label>
        <input type="number" name="soLuongTon" class="form-control mb-3"
               value="${kho.soLuongTon}" required>

        <label>Ngày cập nhật</label>

        <input type="date" name="ngayCapNhat" class="form-control mb-3"
               value="<c:if test='${kho != null}'>
                        <fmt:formatDate value='${kho.ngayCapNhat}' pattern='yyyy-MM-dd'/>
                      </c:if>">

        <button class="btn btn-outline-success">Lưu</button>
        <a href="admin-kho?action=list" class="btn btn-outline-secondary ms-2">Hủy</a>
    </form>
</div>

</body>
</html>
