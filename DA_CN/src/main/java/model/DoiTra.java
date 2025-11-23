package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DOITRA")
public class DoiTra {

    @Id
    @Column(name = "MaDT", length = 20)
    private String maDT;

    @ManyToOne
    @JoinColumn(name = "MaDH", nullable = false)
    private DonHang donHang;

    @Column(name = "LyDo", length = 50, nullable = false)
    private String lyDo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayYeuCau", nullable = false)
    private Date ngayYeuCau;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NgayXuLy")
    private Date ngayXuLy;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

	public String getMaDT() {
		return maDT;
	}

	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public String getLyDo() {
		return lyDo;
	}

	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}

	public Date getNgayYeuCau() {
		return ngayYeuCau;
	}

	public void setNgayYeuCau(Date ngayYeuCau) {
		this.ngayYeuCau = ngayYeuCau;
	}

	public Date getNgayXuLy() {
		return ngayXuLy;
	}

	public void setNgayXuLy(Date ngayXuLy) {
		this.ngayXuLy = ngayXuLy;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public DoiTra(String maDT, DonHang donHang, String lyDo, Date ngayYeuCau, Date ngayXuLy, String trangThai) {
		super();
		this.maDT = maDT;
		this.donHang = donHang;
		this.lyDo = lyDo;
		this.ngayYeuCau = ngayYeuCau;
		this.ngayXuLy = ngayXuLy;
		this.trangThai = trangThai;
	}

	public DoiTra() {
		super();
	}

	public DoiTra(DonHang donHang, String lyDo, Date ngayYeuCau, Date ngayXuLy, String trangThai) {
		super();
		this.donHang = donHang;
		this.lyDo = lyDo;
		this.ngayYeuCau = ngayYeuCau;
		this.ngayXuLy = ngayXuLy;
		this.trangThai = trangThai;
	}

	public DoiTra(String lyDo, Date ngayYeuCau, Date ngayXuLy, String trangThai) {
		super();
		this.lyDo = lyDo;
		this.ngayYeuCau = ngayYeuCau;
		this.ngayXuLy = ngayXuLy;
		this.trangThai = trangThai;
	}

   
}
