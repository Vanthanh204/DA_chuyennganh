package model;

import javax.persistence.*;

@Entity
@Table(name = "anh")
public class Anh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnh;

    @Column(name = "TenAnh")
    private String tenAnh;

    public Anh() {}

    public Anh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public int getIdAnh() {
        return idAnh;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }
}
