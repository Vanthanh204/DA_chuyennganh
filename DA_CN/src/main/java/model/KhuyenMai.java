package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "KHUYENMAI")
public class KhuyenMai {

    @Id
    @Column(name = "MaKM", length = 20)
    private String maKM;

    @Column(name = "TenKM", length = 50, nullable = false)
    private String tenKM;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayBatDau", nullable = false)
    private Date ngayBatDau;

    public KhuyenMai() {
		super();
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayKetThuc", nullable = false)
    private Date ngayKetThuc;

    @Column(name = "MucGiam", length = 10)
    private String mucGiam;

    @OneToMany(mappedBy = "khuyenMai")
    private List<SanPhamKhuyenMai> sanPhamKhuyenMais;

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getMucGiam() {
		return mucGiam;
	}

	public void setMucGiam(String mucGiam) {
		this.mucGiam = mucGiam;
	}

	public List<SanPhamKhuyenMai> getSanPhamKhuyenMais() {
		return sanPhamKhuyenMais;
	}

	public void setSanPhamKhuyenMais(List<SanPhamKhuyenMai> sanPhamKhuyenMais) {
		this.sanPhamKhuyenMais = sanPhamKhuyenMais;
	}

	public KhuyenMai(String maKM, String tenKM, Date ngayBatDau, Date ngayKetThuc, String mucGiam,
			List<SanPhamKhuyenMai> sanPhamKhuyenMais) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.mucGiam = mucGiam;
		this.sanPhamKhuyenMais = sanPhamKhuyenMais;
	}

	public KhuyenMai(String tenKM, Date ngayBatDau, Date ngayKetThuc, String mucGiam,
			List<SanPhamKhuyenMai> sanPhamKhuyenMais) {
		super();
		this.tenKM = tenKM;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.mucGiam = mucGiam;
		this.sanPhamKhuyenMais = sanPhamKhuyenMais;
	}

    
}
