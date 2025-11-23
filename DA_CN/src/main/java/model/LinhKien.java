package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LINHKIEN")
public class LinhKien {

    @Id
    @Column(name = "MaLK", length = 20)
    private String maLK;

    @Column(name = "TenLK", length = 50, nullable = false)
    private String tenLK;

    @Column(name = "GiaLK", nullable = false)
    private int giaLK;

    @Column(name = "SoLuongTon", nullable = false)
    private int soLuongTon;

    @OneToMany(mappedBy = "linhKien")
    private List<LinhKienChiTiet> chiTiets;

	public String getMaLK() {
		return maLK;
	}

	public void setMaLK(String maLK) {
		this.maLK = maLK;
	}

	public String getTenLK() {
		return tenLK;
	}

	public void setTenLK(String tenLK) {
		this.tenLK = tenLK;
	}

	public int getGiaLK() {
		return giaLK;
	}

	public void setGiaLK(int giaLK) {
		this.giaLK = giaLK;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public List<LinhKienChiTiet> getChiTiets() {
		return chiTiets;
	}

	public void setChiTiets(List<LinhKienChiTiet> chiTiets) {
		this.chiTiets = chiTiets;
	}

	public LinhKien(String maLK, String tenLK, int giaLK, int soLuongTon, List<LinhKienChiTiet> chiTiets) {
		super();
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.giaLK = giaLK;
		this.soLuongTon = soLuongTon;
		this.chiTiets = chiTiets;
	}

	public LinhKien() {
		super();
	}

	public LinhKien(String tenLK, int giaLK, int soLuongTon, List<LinhKienChiTiet> chiTiets) {
		super();
		this.tenLK = tenLK;
		this.giaLK = giaLK;
		this.soLuongTon = soLuongTon;
		this.chiTiets = chiTiets;
	}

    
}
