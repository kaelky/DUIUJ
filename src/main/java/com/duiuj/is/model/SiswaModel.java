package com.duiuj.is.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "siswa")
public class SiswaModel implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserModel user;

    @NotNull
    @Size(max = 255)
    @Column(name = "asal_sekolah", nullable = false)
    private String asalSekolah;

    @Size(max = 255)
    @Column(name = "nomor_handphone", nullable = true)
    private Number nomorHandphone;

    @Size(max = 255)
    @Column(name = "alamat", nullable = true)
    private String alamat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public Number getNomorHandphone() {
        return nomorHandphone;
    }

    public void setNomorHandphone(Number nomorHandphone) {
        this.nomorHandphone = nomorHandphone;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
