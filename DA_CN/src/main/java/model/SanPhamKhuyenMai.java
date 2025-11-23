package model;

import javax.persistence.*;

@Entity
@Table(name = "SANPHAMKHUYENMAI")
public class SanPhamKhuyenMai {

    @EmbeddedId
    private SanPhamKhuyenMaiId id;

    @ManyToOne
    @MapsId("maKM")
    @JoinColumn(name = "MaKM")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @MapsId("maSP")
    @JoinColumn(name = "MaSP")
    private SanPham sanPham;

	public SanPhamKhuyenMaiId getId() {
		return id;
	}

	public void setId(SanPhamKhuyenMaiId id) {
		this.id = id;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public SanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham) {
		super();
		this.khuyenMai = khuyenMai;
		this.sanPham = sanPham;
	}

	public SanPhamKhuyenMai(SanPham sanPham) {
		super();
		this.sanPham = sanPham;
	}

	public SanPhamKhuyenMai() {
		super();
	}

}
