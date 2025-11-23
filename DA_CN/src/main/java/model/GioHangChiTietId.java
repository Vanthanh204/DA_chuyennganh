package model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GioHangChiTietId implements Serializable {

    private String maGH;
    private String maSP;

    public GioHangChiTietId() {}

    public GioHangChiTietId(String maGH, String maSP) {
        this.maGH = maGH;
        this.maSP = maSP;
    }

	public String getMaGH() {
		return maGH;
	}

	public void setMaGH(String maGH) {
		this.maGH = maGH;
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
	        if (!(o instanceof GioHangChiTietId)) return false;
	        GioHangChiTietId that = (GioHangChiTietId) o;
	        return Objects.equals(maGH, that.maGH) &&
	               Objects.equals(maSP, that.maSP);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(maGH, maSP);
	    }
    
}
