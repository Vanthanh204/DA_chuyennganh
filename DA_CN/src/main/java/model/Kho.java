package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KHO")
public class Kho {

    @Id
    @Column(name = "MaKho", length = 20)
    private String maKho;

    @ManyToOne
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;

    @Column(name = "SoLuongTon", nullable = false)
    private int soLuongTon;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayCapNhat", nullable = false)
    private Date ngayCapNhat;

	public Kho(String maKho, SanPham sanPham, int soLuongTon, Date ngayCapNhat) {
		super();
		this.maKho = maKho;
		this.sanPham = sanPham;
		this.soLuongTon = soLuongTon;
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getMaKho() {
		return maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public Kho(SanPham sanPham, int soLuongTon, Date ngayCapNhat) {
		super();
		this.sanPham = sanPham;
		this.soLuongTon = soLuongTon;
		this.ngayCapNhat = ngayCapNhat;
	}

	public Kho(int soLuongTon, Date ngayCapNhat) {
		super();
		this.soLuongTon = soLuongTon;
		this.ngayCapNhat = ngayCapNhat;
	}

	public Kho() {
		super();
	}

 
}
