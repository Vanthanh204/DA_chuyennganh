package model;

import javax.persistence.*;

@Entity
@Table(name = "danhmuc")
public class DanhMuc {

    @Id
    @Column(name = "MaDM", length = 20)
    private String maDM;

    @Column(name = "TenDM", length = 50, nullable = false)
    private String tenDM;

    public DanhMuc() {}

	public DanhMuc(String maDM, String tenDM) {
		super();
		this.maDM = maDM;
		this.tenDM = tenDM;
	}

	public DanhMuc(String tenDM) {
		super();
		this.tenDM = tenDM;
	}

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

    
}
