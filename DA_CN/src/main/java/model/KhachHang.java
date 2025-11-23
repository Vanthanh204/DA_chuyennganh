package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KHACHHANG")
public class KhachHang {

    public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public KhachHang() {
		super();
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getMk() {
		return mk;
	}

	public void setMk(String mk) {
		this.mk = mk;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<DonHang> getDonHangs() {
		return donHangs;
	}

	public void setDonHangs(List<DonHang> donHangs) {
		this.donHangs = donHangs;
	}

	public List<DanhGia> getDanhGias() {
		return danhGias;
	}

	public void setDanhGias(List<DanhGia> danhGias) {
		this.danhGias = danhGias;
	}

	public GioHang getGioHang() {
		return gioHang;
	}

	public void setGioHang(GioHang gioHang) {
		this.gioHang = gioHang;
	}

	@Id
    @Column(name = "MaKH", length = 20)
    private String maKH;

    @Column(name = "HoTen", length = 50, nullable = false)
    private String hoTen;

    @Column(name = "DiaChi", length = 50)
    private String diaChi;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @Column(name = "MK", length = 20, nullable = false)
    private String mk;

    @Column(name = "SDT", length = 10, nullable = false, unique = true)
    private String sdt;

    // Quan hệ
    @OneToMany(mappedBy = "khachHang")
    private List<DonHang> donHangs;

    @OneToMany(mappedBy = "khachHang")
    private List<DanhGia> danhGias;

    @OneToOne(mappedBy = "khachHang")
    private GioHang gioHang;

	public KhachHang(String hoTen, String diaChi, String email, String trangThai, String mk, String sdt,
			List<DonHang> donHangs, List<DanhGia> danhGias, GioHang gioHang) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.email = email;
		this.trangThai = trangThai;
		this.mk = mk;
		this.sdt = sdt;
		this.donHangs = donHangs;
		this.danhGias = danhGias;
		this.gioHang = gioHang;
	}

}
