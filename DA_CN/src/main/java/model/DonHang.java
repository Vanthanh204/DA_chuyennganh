package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DONHANG")
public class DonHang {

    @Id
    @Column(name = "MaDH", length = 20)
    private String maDH;

    @ManyToOne
    @JoinColumn(name = "MaKH", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;

    public DonHang() {
		super();
	}

	@Column(name = "DiaChiGiaoHang", length = 50, nullable = false)
    private String diaChiGiaoHang;

    @Column(name = "TongTien", nullable = false)
    private int tongTien;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayTao", nullable = false)
    private Date ngayTao;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @OneToMany(mappedBy = "donHang")
    private List<ChiTietDonHang> chiTietDonHangs;

    @OneToMany(mappedBy = "donHang")
    private List<ThanhToan> thanhToans;

    @OneToMany(mappedBy = "donHang")
    private List<BaoHanh> baoHanhs;

    @OneToMany(mappedBy = "donHang")
    private List<DoiTra> doiTras;

    @OneToMany(mappedBy = "donHang")
    private List<GiaoHang> giaoHangs;

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

	public List<ChiTietDonHang> getChiTietDonHangs() {
		return chiTietDonHangs;
	}

	public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}

	public List<ThanhToan> getThanhToans() {
		return thanhToans;
	}

	public void setThanhToans(List<ThanhToan> thanhToans) {
		this.thanhToans = thanhToans;
	}

	public List<BaoHanh> getBaoHanhs() {
		return baoHanhs;
	}

	public void setBaoHanhs(List<BaoHanh> baoHanhs) {
		this.baoHanhs = baoHanhs;
	}

	public List<DoiTra> getDoiTras() {
		return doiTras;
	}

	public void setDoiTras(List<DoiTra> doiTras) {
		this.doiTras = doiTras;
	}

	public List<GiaoHang> getGiaoHangs() {
		return giaoHangs;
	}

	public void setGiaoHangs(List<GiaoHang> giaoHangs) {
		this.giaoHangs = giaoHangs;
	}

	public DonHang(String maDH, KhachHang khachHang, NhanVien nhanVien, String diaChiGiaoHang, int tongTien,
			Date ngayTao, String trangThai, List<ChiTietDonHang> chiTietDonHangs, List<ThanhToan> thanhToans,
			List<BaoHanh> baoHanhs, List<DoiTra> doiTras, List<GiaoHang> giaoHangs) {
		super();
		this.maDH = maDH;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
		this.chiTietDonHangs = chiTietDonHangs;
		this.thanhToans = thanhToans;
		this.baoHanhs = baoHanhs;
		this.doiTras = doiTras;
		this.giaoHangs = giaoHangs;
	}

	public DonHang(KhachHang khachHang, NhanVien nhanVien, String diaChiGiaoHang, int tongTien, Date ngayTao,
			String trangThai, List<ChiTietDonHang> chiTietDonHangs, List<ThanhToan> thanhToans, List<BaoHanh> baoHanhs,
			List<DoiTra> doiTras, List<GiaoHang> giaoHangs) {
		super();
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
		this.chiTietDonHangs = chiTietDonHangs;
		this.thanhToans = thanhToans;
		this.baoHanhs = baoHanhs;
		this.doiTras = doiTras;
		this.giaoHangs = giaoHangs;
	}

	public DonHang(NhanVien nhanVien, String diaChiGiaoHang, int tongTien, Date ngayTao, String trangThai,
			List<ChiTietDonHang> chiTietDonHangs, List<ThanhToan> thanhToans, List<BaoHanh> baoHanhs,
			List<DoiTra> doiTras, List<GiaoHang> giaoHangs) {
		super();
		this.nhanVien = nhanVien;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
		this.chiTietDonHangs = chiTietDonHangs;
		this.thanhToans = thanhToans;
		this.baoHanhs = baoHanhs;
		this.doiTras = doiTras;
		this.giaoHangs = giaoHangs;
	}

	public DonHang(String diaChiGiaoHang, int tongTien, Date ngayTao, String trangThai,
			List<ChiTietDonHang> chiTietDonHangs, List<ThanhToan> thanhToans, List<BaoHanh> baoHanhs,
			List<DoiTra> doiTras, List<GiaoHang> giaoHangs) {
		super();
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.tongTien = tongTien;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
		this.chiTietDonHangs = chiTietDonHangs;
		this.thanhToans = thanhToans;
		this.baoHanhs = baoHanhs;
		this.doiTras = doiTras;
		this.giaoHangs = giaoHangs;
	}

    
}
