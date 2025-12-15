package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "donhang")
public class DonHang {

    @Id
    @Column(name = "MaDH", length = 20)
    private String maDH;

    @ManyToOne
    @JoinColumn(name = "MaKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MaNV")
    private NhanVien nhanVien;

    @Column(name = "DiaChiGiaoHang", length = 50)
    private String diaChiGiaoHang;

    @Column(name = "TongTien")
    private int tongTien;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    public DonHang() {}

	public DonHang(String maDH, KhachHang khachHang, NhanVien nhanVien, String diaChiGiaoHang, int tongTien,
			Date ngayTao, String trangThai) {
		super();
		this.maDH = maDH;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
	}

	public DonHang(KhachHang khachHang, NhanVien nhanVien, String diaChiGiaoHang, int tongTien, Date ngayTao,
			String trangThai) {
		super();
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

    
}
