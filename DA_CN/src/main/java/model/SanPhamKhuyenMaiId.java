package model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SanPhamKhuyenMaiId implements Serializable {

    private String maKM;
    private String maSP;

    public SanPhamKhuyenMaiId() {}

    public SanPhamKhuyenMaiId(String maKM, String maSP) {
        this.maKM = maKM;
        this.maSP = maSP;
    }

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof SanPhamKhuyenMaiId)) return false;
	        SanPhamKhuyenMaiId that = (SanPhamKhuyenMaiId) o;
	        return Objects.equals(maKM, that.maKM) &&
	               Objects.equals(maSP, that.maSP);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(maKM, maSP);
	    }
}
