package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BAOHANH")
public class BaoHanh {

    @Id
    @Column(name = "MaBH", length = 20)
    private String maBH;

    @ManyToOne
    @JoinColumn(name = "MaDH", nullable = false)
    private DonHang donHang;

    @ManyToOne
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayNhan", nullable = false)
    private Date ngayNhan;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayTra")
    private Date ngayTra;

    @Column(name = "TinhTrang", length = 50)
    private String tinhTrang;

    @Column(name = "GhiChu", length = 50)
    private String ghiChu;

    @Column(name = "IMEI", length = 20, nullable = false)
    private String imei;

    @OneToMany(mappedBy = "baoHanh")
    private List<LinhKienChiTiet> linhKienChiTiets;

	public String getMaBH() {
		return maBH;
	}

	public void setMaBH(String maBH) {
		this.maBH = maBH;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public List<LinhKienChiTiet> getLinhKienChiTiets() {
		return linhKienChiTiets;
	}

	public void setLinhKienChiTiets(List<LinhKienChiTiet> linhKienChiTiets) {
		this.linhKienChiTiets = linhKienChiTiets;
	}

	public BaoHanh() {
		super();
	}

	public BaoHanh(DonHang donHang, NhanVien nhanVien, SanPham sanPham, Date ngayNhan, Date ngayTra, String tinhTrang,
			String ghiChu, String imei, List<LinhKienChiTiet> linhKienChiTiets) {
		super();
		this.donHang = donHang;
		this.nhanVien = nhanVien;
		this.sanPham = sanPham;
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.tinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
		this.imei = imei;
		this.linhKienChiTiets = linhKienChiTiets;
	}

	public BaoHanh(NhanVien nhanVien, SanPham sanPham, Date ngayNhan, Date ngayTra, String tinhTrang, String ghiChu,
			String imei, List<LinhKienChiTiet> linhKienChiTiets) {
		super();
		this.nhanVien = nhanVien;
		this.sanPham = sanPham;
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.tinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
		this.imei = imei;
		this.linhKienChiTiets = linhKienChiTiets;
	}

	public BaoHanh(SanPham sanPham, Date ngayNhan, Date ngayTra, String tinhTrang, String ghiChu, String imei,
			List<LinhKienChiTiet> linhKienChiTiets) {
		super();
		this.sanPham = sanPham;
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.tinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
		this.imei = imei;
		this.linhKienChiTiets = linhKienChiTiets;
	}

	public BaoHanh(Date ngayNhan, Date ngayTra, String tinhTrang, String ghiChu, String imei,
			List<LinhKienChiTiet> linhKienChiTiets) {
		super();
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.tinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
		this.imei = imei;
		this.linhKienChiTiets = linhKienChiTiets;
	}

	public BaoHanh(String maBH, DonHang donHang, NhanVien nhanVien, SanPham sanPham, Date ngayNhan, Date ngayTra,
			String tinhTrang, String ghiChu, String imei, List<LinhKienChiTiet> linhKienChiTiets) {
		super();
		this.maBH = maBH;
		this.donHang = donHang;
		this.nhanVien = nhanVien;
		this.sanPham = sanPham;
		this.ngayNhan = ngayNhan;
		this.ngayTra = ngayTra;
		this.tinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
		this.imei = imei;
		this.linhKienChiTiets = linhKienChiTiets;
	}

}
