CREATE DATABASE  IF NOT EXISTS `quanlybandienthoai` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanlybandienthoai`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlybandienthoai
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `baohanh`
--

DROP TABLE IF EXISTS `baohanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baohanh` (
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
  KEY `MaSP` (`MaSP`),
  CONSTRAINT `baohanh_ibfk_1` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`),
  CONSTRAINT `baohanh_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  CONSTRAINT `baohanh_ibfk_3` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baohanh`
--

LOCK TABLES `baohanh` WRITE;
/*!40000 ALTER TABLE `baohanh` DISABLE KEYS */;
INSERT INTO `baohanh` VALUES ('BH001','DH001','NV002','SP001','2025-11-21 20:28:57',NULL,'Đang xử lý','Lỗi nguồn','IMEI1234567890'),('BH002','DH002','NV002','SP003','2025-11-21 20:28:57','2025-11-21 20:28:57','Hoàn tất','Thay pin','IMEI9876543210');
/*!40000 ALTER TABLE `baohanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdonhang` (
  `MaDH` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `DonGia` int NOT NULL,
  `SoLuong` int NOT NULL,
  `ThanhTien` int NOT NULL,
  PRIMARY KEY (`MaDH`,`MaSP`),
  KEY `MaSP` (`MaSP`),
  CONSTRAINT `chitietdonhang_ibfk_1` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`),
  CONSTRAINT `chitietdonhang_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonhang`
--

LOCK TABLES `chitietdonhang` WRITE;
/*!40000 ALTER TABLE `chitietdonhang` DISABLE KEYS */;
INSERT INTO `chitietdonhang` VALUES ('DH001','SP001',36990000,1,36990000),('DH002','SP003',30990000,1,30990000);
/*!40000 ALTER TABLE `chitietdonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhgia` (
  `MaDG` char(20) NOT NULL,
  `MaKH` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `NgayDanhGia` datetime NOT NULL,
  `NoiDung` varchar(50) DEFAULT NULL,
  `SoSao` int DEFAULT NULL,
  PRIMARY KEY (`MaDG`),
  KEY `MaKH` (`MaKH`),
  KEY `MaSP` (`MaSP`),
  CONSTRAINT `danhgia_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  CONSTRAINT `danhgia_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`),
  CONSTRAINT `danhgia_chk_1` CHECK ((`SoSao` between 1 and 5))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
INSERT INTO `danhgia` VALUES ('DG001','KH001','SP001','2025-11-21 20:27:43','Máy mạnh, pin tốt!',5),('DG002','KH002','SP003','2025-11-21 20:27:43','Camera rất đẹp!',5);
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhmuc`
--

DROP TABLE IF EXISTS `danhmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhmuc` (
  `MaDM` char(20) NOT NULL,
  `TenDM` varchar(50) NOT NULL,
  PRIMARY KEY (`MaDM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES ('DM001','Điện thoại'),('DM002','Phụ kiện'),('DM003','Tablet');
/*!40000 ALTER TABLE `danhmuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doitra`
--

DROP TABLE IF EXISTS `doitra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doitra` (
  `MaDT` char(20) NOT NULL,
  `MaDH` char(20) NOT NULL,
  `LyDo` varchar(50) NOT NULL,
  `NgayYeuCau` datetime NOT NULL,
  `NgayXuLy` datetime DEFAULT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaDT`),
  KEY `MaDH` (`MaDH`),
  CONSTRAINT `doitra_ibfk_1` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doitra`
--

LOCK TABLES `doitra` WRITE;
/*!40000 ALTER TABLE `doitra` DISABLE KEYS */;
/*!40000 ALTER TABLE `doitra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `MaDH` char(20) NOT NULL,
  `MaKH` char(20) NOT NULL,
  `MaNV` char(20) NOT NULL,
  `DiaChiGiaoHang` varchar(50) NOT NULL,
  `TongTien` int NOT NULL,
  `NgayTao` datetime NOT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaDH`),
  KEY `MaKH` (`MaKH`),
  KEY `MaNV` (`MaNV`),
  CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
  CONSTRAINT `donhang_ibfk_2` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
INSERT INTO `donhang` VALUES ('DH001','KH001','NV001','HCM, Q1',36990000,'2025-11-21 20:26:11','CHỜ XÁC NHẬN'),('DH002','KH002','NV001','HN, Hoan Kiem',30990000,'2025-11-21 20:26:11','ĐANG GIAO');
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giaohang`
--

DROP TABLE IF EXISTS `giaohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giaohang` (
  `MaGH` char(20) NOT NULL,
  `MaNV` char(20) NOT NULL,
  `MaDH` char(20) NOT NULL,
  `NgayGiao` datetime NOT NULL,
  `DiaChiGiao` varchar(50) NOT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaGH`),
  KEY `MaNV` (`MaNV`),
  KEY `MaDH` (`MaDH`),
  CONSTRAINT `giaohang_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  CONSTRAINT `giaohang_ibfk_2` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giaohang`
--

LOCK TABLES `giaohang` WRITE;
/*!40000 ALTER TABLE `giaohang` DISABLE KEYS */;
/*!40000 ALTER TABLE `giaohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giohang`
--

DROP TABLE IF EXISTS `giohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giohang` (
  `MaGH` char(20) NOT NULL,
  `MaKH` char(20) NOT NULL,
  PRIMARY KEY (`MaGH`),
  UNIQUE KEY `MaKH` (`MaKH`),
  CONSTRAINT `giohang_ibfk_1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giohang`
--

LOCK TABLES `giohang` WRITE;
/*!40000 ALTER TABLE `giohang` DISABLE KEYS */;
INSERT INTO `giohang` VALUES ('GH001','KH001'),('GH002','KH002');
/*!40000 ALTER TABLE `giohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giohangchitiet`
--

DROP TABLE IF EXISTS `giohangchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giohangchitiet` (
  `MaGH` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `SoLuong` int NOT NULL,
  PRIMARY KEY (`MaGH`,`MaSP`),
  KEY `MaSP` (`MaSP`),
  CONSTRAINT `giohangchitiet_ibfk_1` FOREIGN KEY (`MaGH`) REFERENCES `giohang` (`MaGH`),
  CONSTRAINT `giohangchitiet_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giohangchitiet`
--

LOCK TABLES `giohangchitiet` WRITE;
/*!40000 ALTER TABLE `giohangchitiet` DISABLE KEYS */;
INSERT INTO `giohangchitiet` VALUES ('GH001','SP003',1),('GH002','SP006',2);
/*!40000 ALTER TABLE `giohangchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('KH001','Nguyen Van A','HCM','a@gmail.com','Hoạt động','123456','0912345678'),('KH002','Tran Thi B','Hanoi','b@gmail.com','Hoạt động','123456','0987654321');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kho`
--

DROP TABLE IF EXISTS `kho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kho` (
  `MaKho` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  `SoLuongTon` int NOT NULL,
  `NgayCapNhat` datetime NOT NULL,
  PRIMARY KEY (`MaKho`),
  KEY `MaSP` (`MaSP`),
  CONSTRAINT `kho_ibfk_1` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kho`
--

LOCK TABLES `kho` WRITE;
/*!40000 ALTER TABLE `kho` DISABLE KEYS */;
/*!40000 ALTER TABLE `kho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuyenmai` (
  `MaKM` char(20) NOT NULL,
  `TenKM` varchar(50) NOT NULL,
  `NgayBatDau` datetime NOT NULL,
  `NgayKetThuc` datetime NOT NULL,
  `MucGiam` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MaKM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
INSERT INTO `khuyenmai` VALUES ('KM001','Giảm 10% Tết 2025','2025-01-01 00:00:00','2025-02-01 00:00:00','10%'),('KM002','Giảm sốc cuối năm','2024-12-01 00:00:00','2024-12-31 00:00:00','5%');
/*!40000 ALTER TABLE `khuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linhkien`
--

DROP TABLE IF EXISTS `linhkien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `linhkien` (
  `MaLK` char(20) NOT NULL,
  `TenLK` varchar(50) NOT NULL,
  `GiaLK` int NOT NULL,
  `SoLuongTon` int NOT NULL,
  PRIMARY KEY (`MaLK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linhkien`
--

LOCK TABLES `linhkien` WRITE;
/*!40000 ALTER TABLE `linhkien` DISABLE KEYS */;
INSERT INTO `linhkien` VALUES ('LK001','Pin iPhone 16 Pro Max',1500000,10),('LK002','Màn hình Samsung S24 Ultra',4500000,5);
/*!40000 ALTER TABLE `linhkien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linhkienchitiet`
--

DROP TABLE IF EXISTS `linhkienchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `linhkienchitiet` (
  `MaBH` char(20) NOT NULL,
  `MaLK` char(20) NOT NULL,
  `SoLuong` int NOT NULL,
  PRIMARY KEY (`MaBH`,`MaLK`),
  KEY `MaLK` (`MaLK`),
  CONSTRAINT `linhkienchitiet_ibfk_1` FOREIGN KEY (`MaBH`) REFERENCES `baohanh` (`MaBH`),
  CONSTRAINT `linhkienchitiet_ibfk_2` FOREIGN KEY (`MaLK`) REFERENCES `linhkien` (`MaLK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linhkienchitiet`
--

LOCK TABLES `linhkienchitiet` WRITE;
/*!40000 ALTER TABLE `linhkienchitiet` DISABLE KEYS */;
INSERT INTO `linhkienchitiet` VALUES ('BH002','LK001',1),('BH002','LK002',1);
/*!40000 ALTER TABLE `linhkienchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('NV001','Nguyen Van Thanh','1234','0909090001','Dang lam','KYTHUAT','nv1@shop.com'),('NV002','Vo Thi Xuan Thao','1234','0909090002','Dang lam','BANHANG','nv2@shop.com');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
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
  PRIMARY KEY (`MaSP`),
  KEY `MaDM` (`MaDM`),
  CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`MaDM`) REFERENCES `danhmuc` (`MaDM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES ('SP001','iPhone 16 Pro Max','DM001','Chip A18 Pro, USB-C','A18 Pro','Titanium Natural','256GB','Apple',36990000,'Còn hàng'),('SP002','iPhone 16 Pro','DM001','A18 Pro, Camera 48MP','A18 Pro','Titanium Black','128GB','Apple',31990000,'Còn hàng'),('SP003','Samsung Galaxy S24 Ultra','DM001','Snapdragon 8 Gen 3, S Pen','SD 8 Gen 3','Titanium Grey','256GB','Samsung',30990000,'Còn hàng'),('SP004','Xiaomi 14 Ultra','DM001','Leica Optics, SD 8 Gen 3','Snapdragon 8 Gen 3','White','512GB','Xiaomi',24990000,'Còn hàng'),('SP005','Oppo Find X7 Ultra','DM001','Camera siêu cảm biến','Dimensity 9300','Blue','256GB','Oppo',22990000,'Còn hàng'),('SP006','Realme GT6','DM001','Chip Snapdragon 8s Gen 3','SD 8s Gen 3','Silver','256GB','Realme',14990000,'Còn hàng'),('SP007','iPhone 17 Pro Max','DM001','Camera Pro, A19 Pro – Flagship 2025','A19 Pro','Graphite','512GB','Apple',42990000,'Còn hàng'),('SP008','Samsung Galaxy S25 Ultra','DM001','Snapdragon 8 Elite, S Pen – Flagship Android 2025','Snapdragon 8 Elite','Titan Black','512GB','Samsung',39990000,'Còn hàng'),('SP009','Xiaomi 15 Ultra','DM001','Leica Camera 50MP×3, Snapdragon 8 Elite – 2025','Snapdragon 8 Elite','Black','512GB','Xiaomi',34990000,'Còn hàng'),('SP010','OnePlus 15 Pro','DM001','Ultimate speed, 2025 flagship OnePlus','Snapdragon 8 Elite','Silver','256GB','OnePlus',30990000,'Còn hàng');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanphamkhuyenmai`
--

DROP TABLE IF EXISTS `sanphamkhuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanphamkhuyenmai` (
  `MaKM` char(20) NOT NULL,
  `MaSP` char(20) NOT NULL,
  PRIMARY KEY (`MaKM`,`MaSP`),
  KEY `MaSP` (`MaSP`),
  CONSTRAINT `sanphamkhuyenmai_ibfk_1` FOREIGN KEY (`MaKM`) REFERENCES `khuyenmai` (`MaKM`),
  CONSTRAINT `sanphamkhuyenmai_ibfk_2` FOREIGN KEY (`MaSP`) REFERENCES `sanpham` (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanphamkhuyenmai`
--

LOCK TABLES `sanphamkhuyenmai` WRITE;
/*!40000 ALTER TABLE `sanphamkhuyenmai` DISABLE KEYS */;
INSERT INTO `sanphamkhuyenmai` VALUES ('KM001','SP001'),('KM002','SP003'),('KM002','SP006');
/*!40000 ALTER TABLE `sanphamkhuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhtoan`
--

DROP TABLE IF EXISTS `thanhtoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thanhtoan` (
  `MaTT` char(20) NOT NULL,
  `MaNV` char(20) NOT NULL,
  `MaDH` char(20) NOT NULL,
  `SoTien` int NOT NULL,
  `NgayThanhToan` datetime NOT NULL,
  `HinhThucTT` varchar(50) NOT NULL,
  `TrangThai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaTT`),
  KEY `MaNV` (`MaNV`),
  KEY `MaDH` (`MaDH`),
  CONSTRAINT `thanhtoan_ibfk_1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`),
  CONSTRAINT `thanhtoan_ibfk_2` FOREIGN KEY (`MaDH`) REFERENCES `donhang` (`MaDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhtoan`
--

LOCK TABLES `thanhtoan` WRITE;
/*!40000 ALTER TABLE `thanhtoan` DISABLE KEYS */;
INSERT INTO `thanhtoan` VALUES ('TT001','NV001','DH001',36990000,'2025-11-21 20:26:50','Chuyển khoản','Thành công'),('TT002','NV001','DH002',30990000,'2025-11-21 20:26:50','Tiền mặt','Thành công');
/*!40000 ALTER TABLE `thanhtoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'quanlybandienthoai'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-21 20:34:53
