package model;

import javax.persistence.*;

@Entity
@Table(name = "giohangchitiet")
public class GioHangChiTiet {

    @EmbeddedId
    private GioHangChiTiet_ID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("maGH")
    @JoinColumn(name = "MaGH")
    private GioHang gioHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("maSP")
    @JoinColumn(name = "MaSP")
    private SanPham sanPham;

    @Column(name = "SoLuong")
    private int soLuong;

    public GioHangChiTiet() {}

    public GioHangChiTiet(GioHang gioHang, SanPham sanPham, int soLuong) {
        this.id = new GioHangChiTiet_ID(gioHang.getMaGH(), sanPham.getMaSP());
        this.gioHang = gioHang;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

	public GioHangChiTiet_ID getId() {
		return id;
	}

	public void setId(GioHangChiTiet_ID id) {
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

   
}
