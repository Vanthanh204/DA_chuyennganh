package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kho")
public class Kho {

    @Id
    @Column(name = "MaKho", length = 20)
    private String maKho;

    @ManyToOne
    @JoinColumn(name = "MaSP")
    private SanPham sanPham;

    @Column(name = "SoLuongTon")
    private int soLuongTon;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "NgayCapNhat")
    private Date ngayCapNhat;

    public Kho() {}

	public Kho(String maKho, SanPham sanPham, int soLuongTon, Date ngayCapNhat) {
		super();
		this.maKho = maKho;
		this.sanPham = sanPham;
		this.soLuongTon = soLuongTon;
		this.ngayCapNhat = ngayCapNhat;
	}

	public Kho(SanPham sanPham, int soLuongTon, Date ngayCapNhat) {
		super();
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

    
}
