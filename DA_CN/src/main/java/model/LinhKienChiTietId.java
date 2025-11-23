package model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinhKienChiTietId implements Serializable {

    private String maBH;
    private String maLK;

    public LinhKienChiTietId() {}

    public LinhKienChiTietId(String maBH, String maLK) {
        this.maBH = maBH;
        this.maLK = maLK;
    }

	public String getMaBH() {
		return maBH;
	}

	public void setMaBH(String maBH) {
		this.maBH = maBH;
	}

	public String getMaLK() {
		return maLK;
	}

	public void setMaLK(String maLK) {
		this.maLK = maLK;
	}

	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof LinhKienChiTietId)) return false;
	        LinhKienChiTietId that = (LinhKienChiTietId) o;
	        return Objects.equals(maBH, that.maBH) &&
	               Objects.equals(maLK, that.maLK);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(maBH, maLK);
	    }
}
