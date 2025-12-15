package model;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
public class NhanVien {

    @Id
    @Column(name = "MaNV", length = 20)
    private String maNV;

    @Column(name = "HoTen", length = 50, nullable = false)
    private String hoTen;

    @Column(name = "MK", length = 20, nullable = false)
    private String mk;

    @Column(name = "SDT", length = 10, nullable = false)
    private String sdt;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @Column(name = "VaiTro", length = 20, nullable = false)
    private String vaiTro;

    @Column(name = "Email", length = 50)
    private String email;

    public NhanVien() {}

	public NhanVien(String maNV, String hoTen, String mk, String sdt, String trangThai, String vaiTro, String email) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.mk = mk;
		this.sdt = sdt;
		this.trangThai = trangThai;
		this.vaiTro = vaiTro;
		this.email = email;
	}

	public NhanVien(String hoTen, String mk, String sdt, String trangThai, String vaiTro, String email) {
		super();
		this.hoTen = hoTen;
		this.mk = mk;
		this.sdt = sdt;
		this.trangThai = trangThai;
		this.vaiTro = vaiTro;
		this.email = email;
	}

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

   
}
