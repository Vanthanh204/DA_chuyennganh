package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class GioHangChiTiet_ID implements Serializable {

    private String maGH;
    private String maSP;

    public GioHangChiTiet_ID() {}

    public GioHangChiTiet_ID(String maGH, String maSP) {
        this.maGH = maGH;
        this.maSP = maSP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maGH, maSP);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GioHangChiTiet_ID other = (GioHangChiTiet_ID) obj;
        return Objects.equals(maGH, other.maGH) &&
               Objects.equals(maSP, other.maSP);
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

    // getters/setters
}
