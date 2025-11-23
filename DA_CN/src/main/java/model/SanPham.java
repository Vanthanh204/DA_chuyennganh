package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SANPHAM")
public class SanPham {

    @Id
    @Column(name = "MaSP", length = 20)
    private String maSP;

    @Column(name = "TenSP", length = 50, nullable = false)
    private String tenSP;

    @ManyToOne
    @JoinColumn(name = "MaDM")
    private DanhMuc danhMuc;

    public SanPham() {
		super();
	}
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

    @Column(name = "GiaBan", nullable = false)
    private int giaBan;

    @Column(name = "TrangThai", length = 20)
    private String trangThai;

    @OneToMany(mappedBy = "sanPham")
    private List<ChiTietDonHang> chiTietDonHangs;

    @OneToMany(mappedBy = "sanPham")
    private List<DanhGia> danhGias;

    @OneToMany(mappedBy = "sanPham")
    private List<GioHangChiTiet> gioHangChiTiets;

    @OneToMany(mappedBy = "sanPham")
    private List<SanPhamKhuyenMai> sanPhamKhuyenMais;

    @OneToMany(mappedBy = "sanPham")
    private List<Kho> khos;


	public SanPham(String maSP, String tenSP, DanhMuc danhMuc, String moTa, String cauHinh, String mauSac,
			String dungLuong, String hangSX, int giaBan, String trangThai, List<ChiTietDonHang> chiTietDonHangs,
			List<DanhGia> danhGias, List<GioHangChiTiet> gioHangChiTiets, List<SanPhamKhuyenMai> sanPhamKhuyenMais,
			List<Kho> khos, List<BaoHanh> baoHanhs) {
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
		this.chiTietDonHangs = chiTietDonHangs;
		this.danhGias = danhGias;
		this.gioHangChiTiets = gioHangChiTiets;
		this.sanPhamKhuyenMais = sanPhamKhuyenMais;
		this.khos = khos;
		this.baoHanhs = baoHanhs;
	}

	public SanPham(String tenSP, DanhMuc danhMuc, String moTa, String cauHinh, String mauSac, String dungLuong,
			String hangSX, int giaBan, String trangThai, List<ChiTietDonHang> chiTietDonHangs, List<DanhGia> danhGias,
			List<GioHangChiTiet> gioHangChiTiets, List<SanPhamKhuyenMai> sanPhamKhuyenMais, List<Kho> khos,
			List<BaoHanh> baoHanhs) {
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
		this.chiTietDonHangs = chiTietDonHangs;
		this.danhGias = danhGias;
		this.gioHangChiTiets = gioHangChiTiets;
		this.sanPhamKhuyenMais = sanPhamKhuyenMais;
		this.khos = khos;
		this.baoHanhs = baoHanhs;
	}





	@OneToMany(mappedBy = "sanPham")
    private List<BaoHanh> baoHanhs;

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

	public List<ChiTietDonHang> getChiTietDonHangs() {
		return chiTietDonHangs;
	}

	public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}

	public List<DanhGia> getDanhGias() {
		return danhGias;
	}

	public void setDanhGias(List<DanhGia> danhGias) {
		this.danhGias = danhGias;
	}

	public List<GioHangChiTiet> getGioHangChiTiets() {
		return gioHangChiTiets;
	}

	public void setGioHangChiTiets(List<GioHangChiTiet> gioHangChiTiets) {
		this.gioHangChiTiets = gioHangChiTiets;
	}

	public List<SanPhamKhuyenMai> getSanPhamKhuyenMais() {
		return sanPhamKhuyenMais;
	}

	public void setSanPhamKhuyenMais(List<SanPhamKhuyenMai> sanPhamKhuyenMais) {
		this.sanPhamKhuyenMais = sanPhamKhuyenMais;
	}

	public List<Kho> getKhos() {
		return khos;
	}

	public void setKhos(List<Kho> khos) {
		this.khos = khos;
	}

	public List<BaoHanh> getBaoHanhs() {
		return baoHanhs;
	}

	public void setBaoHanhs(List<BaoHanh> baoHanhs) {
		this.baoHanhs = baoHanhs;
	}
   
}
