package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "THANHTOAN")
public class ThanhToan {

    @Id
    @Column(name = "MaTT", length = 20)
    private String maTT;

    @ManyToOne
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "MaDH", nullable = false)
    private DonHang donHang;

    public ThanhToan() {
		super();
	}

	@Column(name = "SoTien", nullable = false)
    private int soTien;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayThanhToan", nullable = false)
    private Date ngayThanhToan;

    @Column(name = "HinhThucTT", length = 50, nullable = false)
    private String hinhThucTT;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

	public String getMaTT() {
		return maTT;
	}

	public void setMaTT(String maTT) {
		this.maTT = maTT;
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

	public int getSoTien() {
		return soTien;
	}

	public void setSoTien(int soTien) {
		this.soTien = soTien;
	}

	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}

	public String getHinhThucTT() {
		return hinhThucTT;
	}

	public void setHinhThucTT(String hinhThucTT) {
		this.hinhThucTT = hinhThucTT;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public ThanhToan(NhanVien nhanVien, DonHang donHang, int soTien, Date ngayThanhToan, String hinhThucTT,
			String trangThai) {
		super();
		this.nhanVien = nhanVien;
		this.donHang = donHang;
		this.soTien = soTien;
		this.ngayThanhToan = ngayThanhToan;
		this.hinhThucTT = hinhThucTT;
		this.trangThai = trangThai;
	}

	public ThanhToan(String maTT, NhanVien nhanVien, DonHang donHang, int soTien, Date ngayThanhToan, String hinhThucTT,
			String trangThai) {
		super();
		this.maTT = maTT;
		this.nhanVien = nhanVien;
		this.donHang = donHang;
		this.soTien = soTien;
		this.ngayThanhToan = ngayThanhToan;
		this.hinhThucTT = hinhThucTT;
		this.trangThai = trangThai;
	}

	public ThanhToan(int soTien, Date ngayThanhToan, String hinhThucTT, String trangThai) {
		super();
		this.soTien = soTien;
		this.ngayThanhToan = ngayThanhToan;
		this.hinhThucTT = hinhThucTT;
		this.trangThai = trangThai;
	}

	public ThanhToan(DonHang donHang, int soTien, Date ngayThanhToan, String hinhThucTT, String trangThai) {
		super();
		this.donHang = donHang;
		this.soTien = soTien;
		this.ngayThanhToan = ngayThanhToan;
		this.hinhThucTT = hinhThucTT;
		this.trangThai = trangThai;
	}

}
