<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
<style type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>
    body { font-family: Arial; background: #f6f6f6; }
    .topbar {
        background: #fafafa;
        padding: 5px 20px;
        font-size: 14px;
        border-bottom: 1px solid #ddd;
    }
    .dm-group:hover .dm-dropdown {
    display: block;
	}
    .dm-box {
    background: #ffebee;              
    color: #d70018;                   
    padding: 10px 18px;
    border-radius: 25px;
    border: 2px solid #d70018;
    font-weight: bold;
    display: flex;
    align-items: center;
    gap: 8px;
    cursor: pointer;
    transition: 0.2s;
    font-size: 16px;
	}
    .header2 {
        background: white;
        padding: 15px 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-shadow: 0 1px 4px rgba(0,0,0,0.05);
    }
    .header-icon {
        display: flex;
        align-items: center;
        gap: 6px;
        margin-left: 18px;
        cursor: pointer;
    }
    .header-icon i { font-size: 22px; }
    .menu-bar {
        background: #1f1f1f;
        padding: 10px 25px;
        display: flex;
        align-items: center;
        gap: 35px;
        justify-content: center;
        position: relative; /* QUAN TRỌNG */
    }

    .menu-item {
        color: white;
        text-decoration: none;
        font-size: 16px;
        cursor: pointer;
    }
    .menu-item:hover { color: #0d6efd; }

    .dm-group {
        position: relative; /* QUAN TRỌNG */
    }

    .dm-box {
        
        font-weight: bold;
        cursor: pointer;
        display: flex;
        align-items: center;
        gap: 5px;
    }

    .dm-dropdown {
        display: none;
        position: absolute;
        top: 40px;  
        left: 0;
        width: 250px;
        background: white;
        border: 1px solid #ddd;
        box-shadow: 0 3px 6px rgba(0,0,0,0.15);
        z-index: 99;
    }

    .dm-dropdown a {
        display: block;
        padding: 12px;
        color: #333;
        text-decoration: none;
        border-bottom: 1px solid #eee;
    }
	.dm-dropdown a:hover { background: #f1f1f1; }
	.dm-group:hover .dm-dropdown {
	    display: block;
	}
	.product-card {
	    background: white;
	    border-radius: 12px;
	    padding: 15px;
	    text-align: center;
	    transition: 0.25s ease-in-out;
	    box-shadow: 0 2px 6px rgba(0,0,0,0.08);
	}
	.product-card:hover {
	    transform: translateY(-5px);
	    box-shadow: 0 6px 16px rgba(0,0,0,0.15);
	}
	.sp-img {
	    width: 100%;
	    height: 230px;          
	    object-fit: contain;   
	    background: #ffffff;   
	    border-radius: 10px;    
	    padding: 10px;         
	    border: 1px solid #ececec;
	    transition: transform 0.2s ease;
	}
	.sp-img:hover {
	    transform: scale(1.05);
	}
	.sp-price {
	    color: #d70018;
	    font-size: 18px;
	    font-weight: bold;
	    margin-top: 5px;
	}
	footer p, footer a {
	    margin: 4px 0;
	    color: #333;
	    text-decoration: none;
	    font-size: 14px;
	}
	
	footer a:hover {
	    color: #d70000;
	}
</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

</head>
<body>

<!-- USER -->
<div class="topbar d-flex justify-content-end p-2 bg-light border-bottom">
    <c:if test="${not empty sessionScope.user}">
        <div class="dropdown">
            <button class="btn btn-sm btn-light dropdown-toggle" data-bs-toggle="dropdown">
                Xin chào: <b>${sessionScope.user.hoTen}</b>
            </button>
            <ul class="dropdown-menu dropdown-menu-end">
                <li><a class="dropdown-item" href="#">Tài khoản</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item text-danger" href="logout">Đăng xuất</a></li>
            </ul>
        </div>
    </c:if>
</div>

<!-- HEADER -->
<div class="header2 bg-white shadow-sm p-3 d-flex justify-content-between">

    <h3 class="fw-bold text-danger">2T Mobile</h3>

    <!-- DANH MỤC -->
    <div class="dm-group position-relative ms-5">
        <div class="dm-box"> <i class="bi bi-list"> </i>Danh mục </div>

        <div class="dm-dropdown">
            <c:forEach var="dm" items="${listDM}">
                <a href="userhome?madm=${dm.maDM}">
                    ${dm.tenDM}
                </a>
            </c:forEach>
        </div>
    </div>

    <form action="userservlet" method="get" class="flex-grow-1 px-3">
    <div class="input-group">
        <input type="text" name="keyword" class="form-control" placeholder="Bạn muốn tìm gì?">
        <button class="btn btn-dark"><i class="bi bi-search"></i></button>
    </div>
	</form>



    <!-- ICON -->
    <div class="d-flex align-items-center">
        <div class="header-icon me-3" onclick="window.location='giohang?action=view'">
            <i class="bi bi-cart3"></i> Giỏ hàng
        </div>

        <div class="header-icon me-3" onclick="window.location='donhang'">
            <i class="bi bi-receipt"></i> Đơn hàng
        </div>

        <c:if test="${empty sessionScope.user}">
            <div class="header-icon" onclick="window.location='login.jsp'">
                <i class="bi bi-person-circle"></i> Đăng nhập
            </div>
        </c:if>
    </div>

</div>

<!-- BANNER -->
<div class="banner-box mt-3 text-center">
    <img src="images/banner3.jpg" style="width:95%; border-radius:8px;">
</div>

<!-- LIST PRODUCT -->
<div class="container mt-4">
    <div class="row">

        <c:forEach var="sp" items="${listSP}">
            <div class="col-md-3 mb-3">
                <div class="product-card p-3 shadow-sm">

                    <img src="${pageContext.request.contextPath}/images/${sp.hinhAnh}" class="sp-img">

                    <div class="fw-bold mt-2">${sp.tenSP}</div>
                    <div class="sp-price text-danger fw-bold">
                    <fmt:formatNumber value="${sp.giaBan}" type="number"/> đ 
                    </div>

                    <a href="chitiet?masp=${sp.maSP}" class="btn btn-primary btn-sm mt-2">
                        Xem chi tiết
                    </a>

                </div>
            </div>
        </c:forEach>

        <c:if test="${empty listSP}">
            <div class="alert alert-warning">Không có sản phẩm nào.</div>
        </c:if>

    </div>
</div>
<footer style="background:#f5f5f7; padding:40px 0; margin-top:40px; font-family:Arial;">
    <div class="container" style="max-width:1200px; margin:auto;">
        <div class="row" style="display:flex; flex-wrap:wrap;">

            <div class="col" style="flex:1; min-width:250px; padding:10px;">
                <h5><b>Tổng đài hỗ trợ miễn phí</b></h5>
                <p>Mua hàng - bảo hành: <b>1900.0512</b></p>
                <p>Khiếu nại: <b>1800.0228</b></p>
                <h6><b>Thông tin cửa hàng</b></h6>
                <p><a href="#">Địa chỉ: 180 Cao Lỗ, P.4, Q.8, TP. HCM</a></p>
            </div>
            
            <div class="col" style="flex:1; min-width:250px; padding:10px;">
                <h5><b>Thông tin về chính sách</b></h5>
                <p><a href="#">Mua hàng và thanh toán Online</a></p>
                <p><a href="#">Mua hàng trả góp Online</a></p>
                <p><a href="#">Mua hàng trả góp bằng thẻ tín dụng</a></p>
                <p><a href="#">Chính sách giao hàng</a></p>
                <p><a href="#">Chính sách đổi trả</a></p>
            </div>
            
            <div class="col" style="flex:1; min-width:250px; padding:10px;">
                <h5><b>Dịch vụ và thông tin khác</b></h5>
                <p><a href="#">Quy chế hoạt động</a></p>
                <p><a href="#">Chính sách bảo mật thông tin cá nhân</a></p>
                <p><a href="#">Chính sách Bảo hành</a></p>
            </div>

            <div class="col" style="flex:1; min-width:250px; padding:10px;">
                <h5><b>Kết nối với 2T Mobile</b></h5>
                <div style="display:flex; gap:10px; margin-bottom:15px;">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/b/b8/2021_Facebook_icon.svg" width="30">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/a/a5/Instagram_icon.png" width="30">
                </div>  
            </div>
        </div>
    </div>
</footer>
</body>
</html>
