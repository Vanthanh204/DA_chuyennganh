-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 11, 2025 at 04:31 PM
-- Server version: 8.0.44
-- PHP Version: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_quanlybandienthoai`
--

-- --------------------------------------------------------

--
-- Table structure for table `anh`
--

DROP TABLE IF EXISTS `anh`;
CREATE TABLE IF NOT EXISTS `anh` (
  `IdAnh` int NOT NULL AUTO_INCREMENT,
  `TenAnh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdAnh`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `anh`
--

INSERT INTO `anh` (`IdAnh`, `TenAnh`) VALUES
(1, 'banner1.png'),
(2, 'banner2.png'),
(4, 'banner2.jpg'),
(5, 'banner3.jpg'),
(6, 'banner4.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `baohanh`
--

DROP TABLE IF EXISTS `baohanh`;
CREATE TABLE IF NOT EXISTS `baohanh` (
  `MaBH` char(20) NOT NULL,
  `MaDH` char(20) NOT NULL,
  `MaNV` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `NgayNhan` datetime NOT NULL,
  `NgayTra` datetime DEFAULT NULL,
  `TinhTrang` varchar(50) DEFAULT NULL,
  `GhiChu` varchar(50) DEFAULT NULL,
  `IMEI` char(20) NOT NULL,
  PRIMARY KEY (`MaBH`),
  KEY `MaDH` (`MaDH`),
  KEY `MaNV` (`MaNV`),
  KEY `MaSP` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `baohanh`
--

INSERT INTO `baohanh` (`MaBH`, `MaDH`, `MaNV`, `MaSP`, `NgayNhan`, `NgayTra`, `TinhTrang`, `GhiChu`, `IMEI`) VALUES
('BH001', 'DH001', 'NV002', 'SP001', '2025-11-21 20:28:57', NULL, 'Đang xử lý', 'Lỗi nguồn', 'IMEI1234567890'),
('BH002', 'DH002', 'NV002', 'SP003', '2025-11-21 20:28:57', '2025-11-21 20:28:57', 'Hoàn tất', 'Thay pin', 'IMEI9876543210');

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
CREATE TABLE IF NOT EXISTS `chitietdonhang` (
  `MaDH` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `DonGia` int NOT NULL,
  `SoLuong` int NOT NULL,
  `ThanhTien` int NOT NULL,
  PRIMARY KEY (`MaDH`,`MaSP`),
  KEY `MaSP` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`MaDH`, `MaSP`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES
('DH001', 'SP001', 37990000, 1, 37990000);

-- --------------------------------------------------------

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
CREATE TABLE IF NOT EXISTS `danhgia` (
  `MaDG` char(20) NOT NULL,
  `MaKH` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `NgayDanhGia` datetime NOT NULL,
  `NoiDung` varchar(50) DEFAULT NULL,
  `SoSao` int DEFAULT NULL,
  PRIMARY KEY (`MaDG`),
  KEY `MaKH` (`MaKH`),
  KEY `MaSP` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `danhgia`
--

INSERT INTO `danhgia` (`MaDG`, `MaKH`, `MaSP`, `NgayDanhGia`, `NoiDung`, `SoSao`) VALUES
('DG001', 'KH001', 'SP001', '2025-11-21 20:27:43', 'Máy mạnh, pin tốt!', 5),
('DG002', 'KH002', 'SP003', '2025-11-21 20:27:43', 'Camera rất đẹp!', 5);

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

DROP TABLE IF EXISTS `danhmuc`;
CREATE TABLE IF NOT EXISTS `danhmuc` (
  `MaDM` char(20) NOT NULL,
  `TenDM` varchar(50) NOT NULL,
  PRIMARY KEY (`MaDM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`MaDM`, `TenDM`) VALUES
('DM001', 'Điện thoại'),
('DM002', 'Phụ kiện'),
('DM003', 'Tablet');

-- --------------------------------------------------------

--
-- Table structure for table `doitra`
--

DROP TABLE IF EXISTS `doitra`;
CREATE TABLE IF NOT EXISTS `doitra` (
  `MaDT` char(20) NOT NULL,
  `MaDH` char(20) NOT NULL,
  `LyDo` varchar(50) NOT NULL,
  `NgayYeuCau` datetime NOT NULL,
  `NgayXuLy` datetime DEFAULT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaDT`),
  KEY `MaDH` (`MaDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
CREATE TABLE IF NOT EXISTS `donhang` (
  `MaDH` char(20) NOT NULL,
  `MaKH` char(20) NOT NULL,
  `MaNV` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `DiaChiGiaoHang` varchar(50) NOT NULL,
  `TongTien` int NOT NULL,
  `NgayTao` datetime NOT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaDH`),
  KEY `MaKH` (`MaKH`),
  KEY `MaNV` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`MaDH`, `MaKH`, `MaNV`, `DiaChiGiaoHang`, `TongTien`, `NgayTao`, `TrangThai`) VALUES
('DH001', 'KH001', 'NV001', 'HCM, Q1', 37990000, '2025-11-21 20:26:11', 'Đang xử lý'),
('DH002', 'KH002', 'NV001', 'HN, Hoan Kiem', 37990000, '2025-11-21 20:26:11', 'Đang xử lý');

-- --------------------------------------------------------

--
-- Table structure for table `giaohang`
--

DROP TABLE IF EXISTS `giaohang`;
CREATE TABLE IF NOT EXISTS `giaohang` (
  `MaGH` char(20) NOT NULL,
  `MaNV` char(20) NOT NULL,
  `MaDH` char(20) NOT NULL,
  `NgayGiao` datetime NOT NULL,
  `DiaChiGiao` varchar(50) NOT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaGH`),
  KEY `MaNV` (`MaNV`),
  KEY `MaDH` (`MaDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `giohang`
--

DROP TABLE IF EXISTS `giohang`;
CREATE TABLE IF NOT EXISTS `giohang` (
  `MaGH` char(20) NOT NULL,
  `MaKH` char(20) NOT NULL,
  PRIMARY KEY (`MaGH`),
  UNIQUE KEY `MaKH` (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `giohang`
--

INSERT INTO `giohang` (`MaGH`, `MaKH`) VALUES
('GH001', 'KH001'),
('GH002', 'KH002'),
('GHKH1763869221436', 'KH1763869221436');

-- --------------------------------------------------------

--
-- Table structure for table `giohangchitiet`
--

DROP TABLE IF EXISTS `giohangchitiet`;
CREATE TABLE IF NOT EXISTS `giohangchitiet` (
  `MaGH` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `SoLuong` int NOT NULL,
  PRIMARY KEY (`MaGH`,`MaSP`),
  KEY `MaSP` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `giohangchitiet`
--

INSERT INTO `giohangchitiet` (`MaGH`, `MaSP`, `SoLuong`) VALUES
('GH001', 'SP003', 1),
('GH002', 'SP003', 1),
('GH002', 'SP006', 1),
('GH002', 'SP007', 1);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `MaKH` char(20) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `DiaChi` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  `MK` varchar(20) NOT NULL,
  `SDT` char(10) NOT NULL,
  PRIMARY KEY (`MaKH`),
  UNIQUE KEY `SDT` (`SDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `HoTen`, `DiaChi`, `Email`, `TrangThai`, `MK`, `SDT`) VALUES
('KH001', 'Nguyen Van Thanh', 'HCM', 'a@gmail.com', 'Hoạt động', '123456', '0912345678'),
('KH002', 'Tran Thi B', 'Hanoi', 'b@gmail.com', 'Hoạt động', '123456', '0987654321'),
('KH1763869221436', 'xun thao', '180 Cao Lo', 'vanthanh20042021@gmail.com', 'hoat dong', '1234', '0986780542');

-- --------------------------------------------------------

--
-- Table structure for table `kho`
--

DROP TABLE IF EXISTS `kho`;
CREATE TABLE IF NOT EXISTS `kho` (
  `MaKho` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `SoLuongTon` int NOT NULL,
  `NgayCapNhat` datetime NOT NULL,
  PRIMARY KEY (`MaKho`),
  KEY `MaSP` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kho`
--

INSERT INTO `kho` (`MaKho`, `MaSP`, `SoLuongTon`, `NgayCapNhat`) VALUES
('K001', 'SP001', 120, '2025-12-11 01:35:12'),
('K002', 'SP002', 100, '2025-12-11 01:37:29'),
('K003', 'SP003', 100, '2025-12-10 18:51:07'),
('K004', 'SP007', 40, '2025-12-10 18:51:37'),
('K005', 'SP010', 29, '2025-12-10 18:52:06');

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
CREATE TABLE IF NOT EXISTS `khuyenmai` (
  `MaKM` char(20) NOT NULL,
  `TenKM` varchar(50) NOT NULL,
  `NgayBatDau` datetime NOT NULL,
  `NgayKetThuc` datetime NOT NULL,
  `MucGiam` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MaKM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenKM`, `NgayBatDau`, `NgayKetThuc`, `MucGiam`) VALUES
('KM001', 'Giảm 10% Tết 2025', '2025-01-01 00:00:00', '2025-02-01 00:00:00', '10%'),
('KM002', 'Giảm sốc cuối năm', '2024-12-01 00:00:00', '2024-12-31 00:00:00', '5%');

-- --------------------------------------------------------

--
-- Table structure for table `linhkien`
--

DROP TABLE IF EXISTS `linhkien`;
CREATE TABLE IF NOT EXISTS `linhkien` (
  `MaLK` char(20) NOT NULL,
  `TenLK` varchar(50) NOT NULL,
  `GiaLK` int NOT NULL,
  `SoLuongTon` int NOT NULL,
  PRIMARY KEY (`MaLK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `linhkien`
--

INSERT INTO `linhkien` (`MaLK`, `TenLK`, `GiaLK`, `SoLuongTon`) VALUES
('LK001', 'Pin iPhone 16 Pro Max', 1500000, 10),
('LK002', 'Màn hình Samsung S24 Ultra', 4500000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `linhkienchitiet`
--

DROP TABLE IF EXISTS `linhkienchitiet`;
CREATE TABLE IF NOT EXISTS `linhkienchitiet` (
  `MaBH` char(20) NOT NULL,
  `MaLK` char(20) NOT NULL,
  `SoLuong` int NOT NULL,
  PRIMARY KEY (`MaBH`,`MaLK`),
  KEY `MaLK` (`MaLK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `linhkienchitiet`
--

INSERT INTO `linhkienchitiet` (`MaBH`, `MaLK`, `SoLuong`) VALUES
('BH002', 'LK001', 1),
('BH002', 'LK002', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `MaNV` char(20) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `MK` varchar(20) NOT NULL,
  `SDT` char(10) NOT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  `VaiTro` varchar(20) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaNV`),
  UNIQUE KEY `SDT` (`SDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `HoTen`, `MK`, `SDT`, `TrangThai`, `VaiTro`, `Email`) VALUES
('AD01', 'Thao', '111', '0909090003', 'Dang lam', 'ADMIN', 'xuanthao943@gmail.com'),
('NV001', 'Nguyen Van Thanh', '1234', '0909090001', 'Dang lam', 'KYTHUAT', 'nv1@shop.com'),
('NV002', 'Vo Thi Xuan Thao', '1234', '0909090002', 'Dang lam', 'BANHANG', 'nv2@shop.com');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
CREATE TABLE IF NOT EXISTS `sanpham` (
  `MaSP` char(20) NOT NULL,
  `TenSP` varchar(50) NOT NULL,
  `MaDM` char(20) DEFAULT NULL,
  `MoTa` varchar(100) DEFAULT NULL,
  `CauHinh` varchar(100) DEFAULT NULL,
  `MauSac` varchar(50) DEFAULT NULL,
  `DungLuong` varchar(50) DEFAULT NULL,
  `HangSX` varchar(50) DEFAULT NULL,
  `GiaBan` int NOT NULL,
  `TrangThai` varchar(20) DEFAULT NULL,
  `HinhAnh` varchar(255) DEFAULT NULL,
  `MoTaChiTiet` text,
  PRIMARY KEY (`MaSP`),
  KEY `MaDM` (`MaDM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `MaDM`, `MoTa`, `CauHinh`, `MauSac`, `DungLuong`, `HangSX`, `GiaBan`, `TrangThai`, `HinhAnh`, `MoTaChiTiet`) VALUES
('SP001', 'iPhone 17 Pro Max', 'DM001', 'Chip A19 Pro, USB-C', 'A19 Pro', 'Cam Vũ Trụ', '256GB', 'Apple', 37990000, 'Hết hàng', NULL, NULL),
('SP002', 'iPhone 16 Pro', 'DM001', 'A18 Pro, Camera 48MP', 'A18 Pro', 'Titanium Tự Nhiên', '128GB', 'Apple', 31990000, 'Còn hàng', 'iphone16pro.jpg', 'iPhone 16 Pro sử dụng chip A18 Pro, camera 48MP, thiết kế titan đen sang trọng và tối ưu hóa năng lượng vượt trội.'),
('SP003', 'Samsung Galaxy S24 Ultra', 'DM001', 'Snapdragon 8 Gen 3, S Pen', 'SD 8 Gen 3', 'Titanium Grey', '256GB', 'Samsung', 30990000, 'Còn hàng', 's24ultra.jpg', 'Galaxy S24 Ultra trang bị Snapdragon 8 Gen 3, camera 200MP, zoom 100x, hỗ trợ S-Pen và kính Gorilla thế hệ mới.'),
('SP004', 'Xiaomi 14 Ultra', 'DM001', 'Leica Optics, SD 8 Gen 3', 'Snapdragon 8 Gen 3', 'White', '512GB', 'Xiaomi', 24990000, 'Còn hàng', 'xiaomi14ultra.jpg', 'Xiaomi 14 Ultra sở hữu camera Leica, zoom tiềm vọng, màn hình 2K và chip Snapdragon 8 Gen 3 mạnh mẽ.'),
('SP005', 'Oppo Find X7 Ultra', 'DM001', 'Camera siêu cảm biến', 'Dimensity 9300', 'Blue', '256GB', 'Oppo', 22990000, 'Còn hàng', 'oppofindx7.jpg', 'Oppo Find X7 Ultra trang bị camera siêu cảm biến, chụp đêm xuất sắc, chip Dimensity 9300 và màn hình 120Hz.'),
('SP006', 'Realme GT6', 'DM001', 'Chip Snapdragon 8s Gen 3', 'SD 8s Gen 3', 'Silver', '256GB', 'Realme', 14990000, 'Còn hàng', 'gt6.jpg', 'Realme GT6 dùng chip Snapdragon 8s Gen 3, màn hình AMOLED 144Hz, pin lớn và sạc siêu nhanh.'),
('SP007', 'iPhone Air', 'DM001', 'Camera Pro, A19 Pro – Flagship 2025', 'A19 Pro, iOS 26', 'Xanh Da Trời', '512GB', 'Apple', 35990000, 'Còn hàng', 'iphone-air.jpg', 'iPhone Air sở hữu thiết kế mới, camera ProMax 2025, chip A19 Pro, Dynamic Island'),
('SP008', 'Samsung Galaxy S25 Ultra', 'DM001', 'Snapdragon 8 Elite, S Pen – Flagship Android 2025', 'Snapdragon 8 Elite', 'Titan Black', '512GB', 'Samsung', 39990000, 'Còn hàng', 's25ultra.jpg', 'Galaxy S25 Ultra dùng Snapdragon 8 Elite, hỗ trợ S-Pen, camera 250MP và AI Galaxy thế hệ mới.'),
('SP009', 'Xiaomi 15 Ultra', 'DM001', 'Leica Camera 50MP×3, Snapdragon 8 Elite – 2025', 'Snapdragon 8 Elite', 'Black', '512GB', 'Xiaomi', 34990000, 'Còn hàng', 'xiaomi15ultra.jpg', 'Xiaomi 15 Ultra sử dụng camera Leica 50MPx3, chip Snapdragon 8 Elite và màn hình tần số quét cao.'),
('SP010', 'OnePlus 15 Pro', 'DM001', 'Ultimate speed, 2025 flagship OnePlus', 'Snapdragon 8 Elite', 'Silver', '256GB', 'OnePlus', 30990000, 'Còn hàng', 'oneplus15pro.jpg', 'OnePlus 15 Pro – flagship Android tốc độ cao, dùng Snapdragon 8 Elite, sạc nhanh 120W và OxygenOS tối ưu.'),
('SP011', 'iPad A16 Wifi 128GB 2025 ', 'DM003', 'Màn hình: 11 inches, Liquid Retina, 	\r\nCamera góc rộng: 12MP, Chip A16', '	\r\nChip A16,	\r\nCPU 5 lõi', 'Xanh', '128 GB', 'Apple', 9390000, 'Còn hàng', 'ipad-a16.jpg', 'Màn hình: 11 inches, Liquid Retina, 	\r\nCamera góc rộng: 12MP, ƒ/1.8, Độ thu phóng kỹ thuật số lên đến 5x\r\nChụp ảnh toàn cảnh Panorama: 63MP, Tích hợp pin sạc Li-Po 28,93 watt‑giờ, 	\r\nChip A16'),
('SP012', 'Máy tính bảng Lenovo Idea Tab Wifi ', 'DM003', 'ZAFR0484VN kèm bút, pin 7040mAh', '8C, 2x A76 @2.4 GHz + 6x A55@2.0 GHz', 'Xám', '128 GB', 'Apple', 5590000, 'Còn hàng', 'ipad-lenovo.jpg', 'Android 15 trở lên, Kích thước màn hình 11 inch, Độ phân giải 2560x1600 pixel,Tần số quét 90Hz 500nits'),
('SP0123', 'Tai nghe AirPod 4', 'DM002', 'Cảm biến lực,Thời gian nghe lên đến 5 giờ với một lần sạc', 'Chip tai nghe H2', 'Trắng', '5 giờ sử dụng/ lần sạc', 'Apple', 3390000, 'Còn hàng', 'airpod4.jpg', 'Thời gian nghe lên đến 5 giờ với một lần sạc. Thời gian đàm thoại lên đến 4,5 giờ với một lần sạc. Tai nghe: 30.2 x 18.3 x 18.1 mm, Hộp sạc: 46.2 x 50.1 x 21.2 mm, '),
('SP013', 'Pin dự phòng Anker', 'DM002', '25.000mAh 165W tích hợp cáp rút gọn A1695', '	\r\n165W', 'Đen', '165W', 'Anker', 1890000, 'Còn hàng', 'pin.jpg', 'Sạc nhanh\r\nChống cháy nổ, chập điện\r\nHiển thị thông số sạc'),
('SP014', 'Ốp lưng iPhone 14 Plus', 'DM002', 'Gear4 D30 Milan hỗ trợ sạc Magsafe', 'Chống sốc, Ốp trong', 'Tím', 'Dùng iPhone 14 Plus | iPhone 15 Plus', 'Gear4', 648900, 'Còn hàng', 'oplung.jpg', 'Hỗ trợ sạc MagSafe, Hỗ trợ sạc không dây, Chống sốc, va đập'),
('SP015', 'Sạc Xiaomi cổng USB-A', 'DM002', 'cổng USB-A 120W kèm cáp Type-C', '120W', 'Trắng', 'Chiều dài 1m', 'Xiaomi', 990000, 'Còn hàng', 'sac.jpg', '	\r\nSạc nhanh,Chống quá nhiệt, ngắn mạch,...\r\nLớp bảo vệ hoạt động đồng bộ để kiểm soát dòng điện và nhiệt độ');

-- --------------------------------------------------------

--
-- Table structure for table `sanphamkhuyenmai`
--

DROP TABLE IF EXISTS `sanphamkhuyenmai`;
CREATE TABLE IF NOT EXISTS `sanphamkhuyenmai` (
  `MaKM` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  PRIMARY KEY (`MaKM`,`MaSP`),
  KEY `MaSP` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sanphamkhuyenmai`
--

INSERT INTO `sanphamkhuyenmai` (`MaKM`, `MaSP`) VALUES
('KM001', 'SP001'),
('KM002', 'SP003'),
('KM002', 'SP006');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham_anh`
--

DROP TABLE IF EXISTS `sanpham_anh`;
CREATE TABLE IF NOT EXISTS `sanpham_anh` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `MaSP` char(20) DEFAULT NULL,
  `HinhAnh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `MaSP` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `thanhtoan`
--

DROP TABLE IF EXISTS `thanhtoan`;
CREATE TABLE IF NOT EXISTS `thanhtoan` (
  `MaTT` char(20) NOT NULL,
  `MaNV` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MaDH` char(20) NOT NULL,
  `SoTien` int NOT NULL,
  `NgayThanhToan` datetime NOT NULL,
  `HinhThucTT` varchar(50) NOT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaTT`),
  KEY `MaNV` (`MaNV`),
  KEY `MaDH` (`MaDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `thanhtoan`
--

INSERT INTO `thanhtoan` (`MaTT`, `MaNV`, `MaDH`, `SoTien`, `NgayThanhToan`, `HinhThucTT`, `TrangThai`) VALUES
('TT001', 'NV001', 'DH001', 36990000, '2025-11-21 20:26:50', 'Chuyển khoản', 'Thành công'),
('TT002', 'NV001', 'DH002', 30990000, '2025-11-21 20:26:50', 'Tiền mặt', 'Thành công');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `baohanh`
--
ALTER TABLE `baohanh`
  ADD CONSTRAINT `baohanh_ibfk_1` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`),
  ADD CONSTRAINT `baohanh_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `baohanh_ibfk_3` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `chitietdonhang_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`),
  ADD CONSTRAINT `chitietdonhang_ibfk_3` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`) ON DELETE CASCADE;

--
-- Constraints for table `danhgia`
--
ALTER TABLE `danhgia`
  ADD CONSTRAINT `danhgia_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  ADD CONSTRAINT `danhgia_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `doitra`
--
ALTER TABLE `doitra`
  ADD CONSTRAINT `doitra_ibfk_1` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`);

--
-- Constraints for table `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  ADD CONSTRAINT `donhang_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);

--
-- Constraints for table `giaohang`
--
ALTER TABLE `giaohang`
  ADD CONSTRAINT `giaohang_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `giaohang_ibfk_2` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`);

--
-- Constraints for table `giohang`
--
ALTER TABLE `giohang`
  ADD CONSTRAINT `giohang_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`);

--
-- Constraints for table `giohangchitiet`
--
ALTER TABLE `giohangchitiet`
  ADD CONSTRAINT `giohangchitiet_ibfk_1` FOREIGN KEY (`MaGH`) REFERENCES `giohang` (`MaGH`),
  ADD CONSTRAINT `giohangchitiet_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `kho`
--
ALTER TABLE `kho`
  ADD CONSTRAINT `kho_ibfk_1` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `linhkienchitiet`
--
ALTER TABLE `linhkienchitiet`
  ADD CONSTRAINT `linhkienchitiet_ibfk_1` FOREIGN KEY (`MaBH`) REFERENCES `baohanh` (`MaBH`),
  ADD CONSTRAINT `linhkienchitiet_ibfk_2` FOREIGN KEY (`MaLK`) REFERENCES `linhkien` (`MaLK`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaDM`) REFERENCES `danhmuc` (`MaDM`);

--
-- Constraints for table `sanphamkhuyenmai`
--
ALTER TABLE `sanphamkhuyenmai`
  ADD CONSTRAINT `sanphamkhuyenmai_ibfk_1` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`),
  ADD CONSTRAINT `sanphamkhuyenmai_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `sanpham_anh`
--
ALTER TABLE `sanpham_anh`
  ADD CONSTRAINT `sanpham_anh_ibfk_1` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`);

--
-- Constraints for table `thanhtoan`
--
ALTER TABLE `thanhtoan`
  ADD CONSTRAINT `thanhtoan_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  ADD CONSTRAINT `thanhtoan_ibfk_2` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
