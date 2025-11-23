<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">

            <div class="card shadow-sm">
                <div class="card-header text-center bg-danger text-white">
                    <h4>Đăng nhập</h4>
                </div>

                <div class="card-body">

                    <form action="loginservlet" method="post">

                        <div class="mb-3">
                            <label class="form-label">Số điện thoại</label>
                            <input type="text" class="form-control" name="sdt" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mật khẩu</label>
                            <input type="password" class="form-control" name="mk" required>
                        </div>

                        <% if (request.getAttribute("error") != null) { %>
                            <div class="alert alert-danger">
                                <%= request.getAttribute("error") %>
                            </div>
                        <% } %>

                        <button class="btn btn-danger w-100">Đăng nhập</button>

                        <p class="mt-3 text-center">
                            Chưa có tài khoản? <a href="register.jsp">Đăng ký</a>
                        </p>

                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
