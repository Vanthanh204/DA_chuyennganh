package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DANHMUC")
public class DanhMuc {

    @Id
    @Column(name = "MaDM", length = 20)
    private String maDM;

    @Column(name = "TenDM", length = 50, nullable = false)
    private String tenDM;

    @OneToMany(mappedBy = "danhMuc")
    private List<SanPham> sanPhams;

	public String getMaDM() {
		return maDM;
	}

	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public DanhMuc(String tenDM, List<SanPham> sanPhams) {
		super();
		this.tenDM = tenDM;
		this.sanPhams = sanPhams;
	}

	public DanhMuc(String maDM, String tenDM, List<SanPham> sanPhams) {
		super();
		this.maDM = maDM;
		this.tenDM = tenDM;
		this.sanPhams = sanPhams;
	}

}
