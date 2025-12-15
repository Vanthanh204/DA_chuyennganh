package model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "giohang")
public class GioHang {

    @Id
    @Column(name = "MaGH", length = 20)
    private String maGH;

    @OneToOne
    @JoinColumn(name = "MaKH")
    private KhachHang khachHang;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.EAGER)
    private List<GioHangChiTiet> dsChiTiet;
    public List<GioHangChiTiet> getDsChiTiet() {
		return dsChiTiet;
	}

	public void setDsChiTiet(List<GioHangChiTiet> dsChiTiet) {
		this.dsChiTiet = dsChiTiet;
	}

	public GioHang() {}

	public GioHang(String maGH, KhachHang khachHang) {
		super();
		this.maGH = maGH;
		this.khachHang = khachHang;
	}

	public GioHang(KhachHang khachHang) {
		super();
		this.khachHang = khachHang;
	}

	public String getMaGH() {
		return maGH;
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

    
}
