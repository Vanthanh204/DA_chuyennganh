package model;

import javax.persistence.*;

@Entity
@Table(name = "GIOHANGCHITIET")
public class GioHangChiTiet {

    @EmbeddedId
    private GioHangChiTietId id;

    @ManyToOne
    @MapsId("maGH")
    @JoinColumn(name = "MaGH")
    private GioHang gioHang;

    @ManyToOne
    @MapsId("maSP")
    @JoinColumn(name = "MaSP")
    private SanPham sanPham;

    public GioHangChiTiet() {
		super();
	}

	@Column(name = "SoLuong", nullable = false)
    private int soLuong;

	public GioHangChiTietId getId() {
		return id;
	}

	public void setId(GioHangChiTietId id) {
		this.id = id;
	}

	public GioHang getGioHang() {
		return gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public GioHangChiTiet(GioHang gioHang, SanPham sanPham, int soLuong) {
		super();
		this.gioHang = gioHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public GioHangChiTiet(SanPham sanPham, int soLuong) {
		super();
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public GioHangChiTiet(int soLuong) {
		super();
		this.soLuong = soLuong;
	}

	public GioHangChiTiet(GioHangChiTietId id, GioHang gioHang, SanPham sanPham, int soLuong) {
		super();
		this.id = id;
		this.gioHang = gioHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

    
}
