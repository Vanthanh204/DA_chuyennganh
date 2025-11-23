package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GIOHANG")
public class GioHang {

    @Id
    @Column(name = "MaGH", length = 20)
    private String maGH;

    @OneToOne
    @JoinColumn(name = "MaKH", nullable = false, unique = true)
    private KhachHang khachHang;

    @OneToMany(mappedBy = "gioHang")
    private List<GioHangChiTiet> chiTiets;

	public String getMaGH() {
		return maGH;
	}

	public GioHang() {
		super();
	}

	public void setMaGH(String maGH) {
		this.maGH = maGH;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public List<GioHangChiTiet> getChiTiets() {
		return chiTiets;
	}

	public void setChiTiets(List<GioHangChiTiet> chiTiets) {
		this.chiTiets = chiTiets;
	}

	public GioHang(KhachHang khachHang, List<GioHangChiTiet> chiTiets) {
		super();
		this.khachHang = khachHang;
		this.chiTiets = chiTiets;
	}

	public GioHang(String maGH, KhachHang khachHang, List<GioHangChiTiet> chiTiets) {
		super();
		this.maGH = maGH;
		this.khachHang = khachHang;
		this.chiTiets = chiTiets;
	}

	public GioHang(List<GioHangChiTiet> chiTiets) {
		super();
		this.chiTiets = chiTiets;
	}

    
}
