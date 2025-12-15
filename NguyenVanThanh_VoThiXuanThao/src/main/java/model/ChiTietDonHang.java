package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "chitietdonhang")
@IdClass(ChiTietDonHangId.class)
public class ChiTietDonHang implements Serializable {

    @Id
    @Column(name = "MaDH", length = 20)
    private String maDH;

    @Id
    @Column(name = "MaSP", length = 20)
    private String maSP;

    @Column(name = "DonGia")
    private int donGia;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "ThanhTien")
    private int thanhTien;

    @ManyToOne
    @JoinColumn(name = "MaDH", insertable = false, updatable = false)
    private DonHang donHang;

    public ChiTietDonHang() {}

    public ChiTietDonHang(String maDH, String maSP, int donGia, int soLuong, int thanhTien) {
        this.maDH = maDH;
        this.maSP = maSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }
}
