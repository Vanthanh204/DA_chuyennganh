package model;

import javax.persistence.*;

@Entity
@Table(name = "sanpham")
public class SanPham {

    @Id
    @Column(name = "MaSP", length = 20)
    private String maSP;

    @Column(name = "TenSP", length = 50, nullable = false)
    private String tenSP;

    @ManyToOne
    @JoinColumn(name = "MaDM")
    private DanhMuc danhMuc;

    @Column(name = "MoTa", length = 100)
    private String moTa;

    @Column(name = "CauHinh", length = 100)
    private String cauHinh;

    @Column(name = "MauSac", length = 50)
    private String mauSac;

    @Column(name = "DungLuong", length = 50)
    private String dungLuong;

    @Column(name = "HangSX", length = 50)
    private String hangSX;

    @Column(name = "GiaBan")
    private int giaBan;

    @Column(name = "TrangThai", length = 20)
    private String trangThai;

    @Column(name = "HinhAnh", length = 255)
    private String hinhAnh;

    @Column(name = "MoTaChiTiet", columnDefinition = "TEXT")
    private String moTaChiTiet;
    public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMoTaChiTiet() {
		return moTaChiTiet;
	}

	public void setMoTaChiTiet(String moTaChiTiet) {
		this.moTaChiTiet = moTaChiTiet;
	}

	public SanPham() {}

	public SanPham(String maSP, String tenSP, DanhMuc danhMuc, String moTa, String cauHinh, String mauSac,
			String dungLuong, String hangSX, int giaBan, String trangThai) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.danhMuc = danhMuc;
		this.moTa = moTa;
		this.cauHinh = cauHinh;
		this.mauSac = mauSac;
		this.dungLuong = dungLuong;
		this.hangSX = hangSX;
		this.giaBan = giaBan;
		this.trangThai = trangThai;
	}

	public SanPham(String tenSP, DanhMuc danhMuc, String moTa, String cauHinh, String mauSac, String dungLuong,
			String hangSX, int giaBan, String trangThai) {
		super();
		this.tenSP = tenSP;
		this.danhMuc = danhMuc;
		this.moTa = moTa;
		this.cauHinh = cauHinh;
		this.mauSac = mauSac;
		this.dungLuong = dungLuong;
		this.hangSX = hangSX;
		this.giaBan = giaBan;
		this.trangThai = trangThai;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getDungLuong() {
		return dungLuong;
	}

	public void setDungLuong(String dungLuong) {
		this.dungLuong = dungLuong;
	}

	public String getHangSX() {
		return hangSX;
	}

	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}

	public int getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

    
}
