<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>

<style>
    body {
        background: #f5f5f5;
        font-family: Arial;
        margin: 0;
    }

    .container {
        width: 380px;
        background: white;
        margin: 50px auto;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.2);
    }

    h2 {
        text-align: center;
        color: #cc0000;
        margin-bottom: 25px;
    }

    input[type="text"], input[type="password"], input[type="email"] {
        width: 100%;
        padding: 12px;
        border: 1px solid #ddd;
        border-radius: 6px;
        margin-bottom: 15px;
        font-size: 15px;
    }

    input:focus {
        border-color: #cc0000;
        outline: none;
    }

    .btn {
        width: 100%;
        padding: 12px;
        background: #cc0000;
        color: white;
        border: none;
        cursor: pointer;
        border-radius: 6px;
        font-size: 16px;
        margin-top: 5px;
    }

    .btn:hover {
        background: #b30000;
    }

    .login-link {
        text-align: center;
        margin-top: 18px;
        font-size: 14px;
    }
    .login-link a {
        color: #cc0000;
        text-decoration: none;
        font-weight: bold;
    }
</style>

<script>
function validateForm() {
    let pass = document.getElementById("mk").value;
    let repass = document.getElementById("repass").value;

    if (pass !== repass) {
        alert("Mật khẩu nhập lại không khớp!");
        return false;
    }
    return true;
}
</script>

</head>
<body>

<div class="container">
    <h2>Đăng ký tài khoản</h2>

    <form action="registerservlet" method="post" onsubmit="return validateForm()">

        <input type="text" name="hoten" placeholder="Họ và tên" required>

        <input type="text" name="sdt" placeholder="Số điện thoại" required>

        <input type="email" name="email" placeholder="Email">

        <input type="text" name="diachi" placeholder="Địa chỉ">

        <input type="password" id="mk" name="mk" placeholder="Mật khẩu" required>

        <input type="password" id="repass" placeholder="Nhập lại mật khẩu" required>

        <button class="btn" type="submit">Đăng ký</button>

        <div class="login-link">
            Bạn đã có tài khoản? <a href="login.jsp">Đăng nhập ngay</a>
        </div>

    </form>
</div>

</body>
</html>
