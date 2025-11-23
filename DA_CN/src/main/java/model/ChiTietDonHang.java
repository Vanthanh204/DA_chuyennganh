package model;

import javax.persistence.*;

@Entity
@Table(name = "CHITIETDONHANG")
public class ChiTietDonHang {

    @EmbeddedId
    private ChiTietDonHangId id;

    @ManyToOne
    @MapsId("maDH")
    @JoinColumn(name = "MaDH")
    private DonHang donHang;

    @ManyToOne
    @MapsId("maSP")
    @JoinColumn(name = "MaSP")
    private SanPham sanPham;

    public ChiTietDonHang() {
		super();
	}

	@Column(name = "DonGia", nullable = false)
    private int donGia;

    @Column(name = "SoLuong", nullable = false)
    private int soLuong;

    @Column(name = "ThanhTien", nullable = false)
    private int thanhTien;

	public ChiTietDonHangId getId() {
		return id;
	}

	public void setId(ChiTietDonHangId id) {
		this.id = id;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	public ChiTietDonHang(DonHang donHang, SanPham sanPham, int donGia, int soLuong, int thanhTien) {
		super();
		this.donHang = donHang;
		this.sanPham = sanPham;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public ChiTietDonHang(SanPham sanPham, int donGia, int soLuong, int thanhTien) {
		super();
		this.sanPham = sanPham;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public ChiTietDonHang(int donGia, int soLuong, int thanhTien) {
		super();
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public ChiTietDonHang(ChiTietDonHangId id, DonHang donHang, SanPham sanPham, int donGia, int soLuong,
			int thanhTien) {
		super();
		this.id = id;
		this.donHang = donHang;
		this.sanPham = sanPham;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

}
