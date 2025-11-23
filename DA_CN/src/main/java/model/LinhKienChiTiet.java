package model;

import javax.persistence.*;

@Entity
@Table(name = "LINHKIENCHITIET")
public class LinhKienChiTiet {

    @EmbeddedId
    private LinhKienChiTietId id;

    @ManyToOne
    @MapsId("maBH")
    @JoinColumn(name = "MaBH")
    private BaoHanh baoHanh;

    @ManyToOne
    @MapsId("maLK")
    @JoinColumn(name = "MaLK")
    private LinhKien linhKien;

    @Column(name = "SoLuong", nullable = false)
    private int soLuong;

	public LinhKienChiTietId getId() {
		return id;
	}

	public void setId(LinhKienChiTietId id) {
		this.id = id;
	}

	public BaoHanh getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(BaoHanh baoHanh) {
		this.baoHanh = baoHanh;
	}

	public LinhKien getLinhKien() {
		return linhKien;
	}

	public void setLinhKien(LinhKien linhKien) {
		this.linhKien = linhKien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public LinhKienChiTiet(LinhKienChiTietId id, BaoHanh baoHanh, LinhKien linhKien, int soLuong) {
		super();
		this.id = id;
		this.baoHanh = baoHanh;
		this.linhKien = linhKien;
		this.soLuong = soLuong;
	}

	public LinhKienChiTiet() {
		super();
	}

	public LinhKienChiTiet(BaoHanh baoHanh, LinhKien linhKien, int soLuong) {
		super();
		this.baoHanh = baoHanh;
		this.linhKien = linhKien;
		this.soLuong = soLuong;
	}

	public LinhKienChiTiet(BaoHanh baoHanh, int soLuong) {
		super();
		this.baoHanh = baoHanh;
		this.soLuong = soLuong;
	}

	public LinhKienChiTiet(int soLuong) {
		super();
		this.soLuong = soLuong;
	}

    
}
