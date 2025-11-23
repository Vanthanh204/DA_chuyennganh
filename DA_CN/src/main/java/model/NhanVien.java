package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {

    @Id
    @Column(name = "MaNV", length = 20)
    private String maNV;

    @Column(name = "HoTen", length = 50, nullable = false)
    private String hoTen;

    @Column(name = "MK", length = 20, nullable = false)
    private String mk;

    @Column(name = "SDT", length = 10, nullable = false, unique = true)
    private String sdt;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    public NhanVien() {
		super();
	}

	@Column(name = "VaiTro", length = 20, nullable = false)
    private String vaiTro;

    @Column(name = "Email", length = 50)
    private String email;

    @OneToMany(mappedBy = "nhanVien")
    private List<DonHang> donHangs;

    @OneToMany(mappedBy = "nhanVien")
    private List<ThanhToan> thanhToans;

    @OneToMany(mappedBy = "nhanVien")
    private List<BaoHanh> baoHanhs;

    @OneToMany(mappedBy = "nhanVien")
    private List<GiaoHang> giaoHangs;

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
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

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DonHang> getDonHangs() {
		return donHangs;
	}

	public void setDonHangs(List<DonHang> donHangs) {
		this.donHangs = donHangs;
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

	public List<GiaoHang> getGiaoHangs() {
		return giaoHangs;
	}

	public void setGiaoHangs(List<GiaoHang> giaoHangs) {
		this.giaoHangs = giaoHangs;
	}

	public NhanVien(String hoTen, String mk, String sdt, String trangThai, String vaiTro, String email,
			List<DonHang> donHangs, List<ThanhToan> thanhToans, List<BaoHanh> baoHanhs, List<GiaoHang> giaoHangs) {
		super();
		this.hoTen = hoTen;
		this.mk = mk;
		this.sdt = sdt;
		this.trangThai = trangThai;
		this.vaiTro = vaiTro;
		this.email = email;
		this.donHangs = donHangs;
		this.thanhToans = thanhToans;
		this.baoHanhs = baoHanhs;
		this.giaoHangs = giaoHangs;
	}

	public NhanVien(String maNV, String hoTen, String mk, String sdt, String trangThai, String vaiTro, String email,
			List<DonHang> donHangs, List<ThanhToan> thanhToans, List<BaoHanh> baoHanhs, List<GiaoHang> giaoHangs) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.mk = mk;
		this.sdt = sdt;
		this.trangThai = trangThai;
		this.vaiTro = vaiTro;
		this.email = email;
		this.donHangs = donHangs;
		this.thanhToans = thanhToans;
		this.baoHanhs = baoHanhs;
		this.giaoHangs = giaoHangs;
	}

    
}
