package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GIAOHANG")
public class GiaoHang {

    @Id
    @Column(name = "MaGH", length = 20)
    private String maGH;

    @ManyToOne
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MaDH", nullable = false)
    private DonHang donHang;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayGiao", nullable = false)
    private Date ngayGiao;

    @Column(name = "DiaChiGiao", length = 50, nullable = false)
    private String diaChiGiao;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

	public String getMaGH() {
		return maGH;
	}

	public void setMaGH(String maGH) {
		this.maGH = maGH;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public Date getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public String getDiaChiGiao() {
		return diaChiGiao;
	}

	public void setDiaChiGiao(String diaChiGiao) {
		this.diaChiGiao = diaChiGiao;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public GiaoHang() {
		super();
	}

	public GiaoHang(String maGH, NhanVien nhanVien, DonHang donHang, Date ngayGiao, String diaChiGiao,
			String trangThai) {
		super();
		this.maGH = maGH;
		this.nhanVien = nhanVien;
		this.donHang = donHang;
		this.ngayGiao = ngayGiao;
		this.diaChiGiao = diaChiGiao;
		this.trangThai = trangThai;
	}

	public GiaoHang(NhanVien nhanVien, DonHang donHang, Date ngayGiao, String diaChiGiao, String trangThai) {
		super();
		this.nhanVien = nhanVien;
		this.donHang = donHang;
		this.ngayGiao = ngayGiao;
		this.diaChiGiao = diaChiGiao;
		this.trangThai = trangThai;
	}

	public GiaoHang(DonHang donHang, Date ngayGiao, String diaChiGiao, String trangThai) {
		super();
		this.donHang = donHang;
		this.ngayGiao = ngayGiao;
		this.diaChiGiao = diaChiGiao;
		this.trangThai = trangThai;
	}

	public GiaoHang(Date ngayGiao, String diaChiGiao, String trangThai) {
		super();
		this.ngayGiao = ngayGiao;
		this.diaChiGiao = diaChiGiao;
		this.trangThai = trangThai;
	}

}
