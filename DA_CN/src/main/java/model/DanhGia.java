package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DANHGIA")
public class DanhGia {

    @Id
    @Column(name = "MaDG", length = 20)
    private String maDG;

    @ManyToOne
    @JoinColumn(name = "MaKH", nullable = false)
    private KhachHang khachHang;

    public DanhGia() {
		super();
	}

	@ManyToOne
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayDanhGia", nullable = false)
    private Date ngayDanhGia;

    @Column(name = "NoiDung", length = 50)
    private String noiDung;

    @Column(name = "SoSao")
    private int soSao;

	public String getMaDG() {
		return maDG;
	}

	public void setMaDG(String maDG) {
		this.maDG = maDG;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public Date getNgayDanhGia() {
		return ngayDanhGia;
	}

	public void setNgayDanhGia(Date ngayDanhGia) {
		this.ngayDanhGia = ngayDanhGia;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public int getSoSao() {
		return soSao;
	}

	public void setSoSao(int soSao) {
		this.soSao = soSao;
	}

	public DanhGia(String maDG, KhachHang khachHang, SanPham sanPham, Date ngayDanhGia, String noiDung, int soSao) {
		super();
		this.maDG = maDG;
		this.khachHang = khachHang;
		this.sanPham = sanPham;
		this.ngayDanhGia = ngayDanhGia;
		this.noiDung = noiDung;
		this.soSao = soSao;
	}

	public DanhGia(KhachHang khachHang, SanPham sanPham, Date ngayDanhGia, String noiDung, int soSao) {
		super();
		this.khachHang = khachHang;
		this.sanPham = sanPham;
		this.ngayDanhGia = ngayDanhGia;
		this.noiDung = noiDung;
		this.soSao = soSao;
	}

	public DanhGia(SanPham sanPham, Date ngayDanhGia, String noiDung, int soSao) {
		super();
		this.sanPham = sanPham;
		this.ngayDanhGia = ngayDanhGia;
		this.noiDung = noiDung;
		this.soSao = soSao;
	}

	public DanhGia(Date ngayDanhGia, String noiDung, int soSao) {
		super();
		this.ngayDanhGia = ngayDanhGia;
		this.noiDung = noiDung;
		this.soSao = soSao;
	}

}
