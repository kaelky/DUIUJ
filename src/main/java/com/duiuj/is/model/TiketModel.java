package com.duiuj.is.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tiket")
public class TiketModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @Size(max = 21)
    @Column(name = "nama_lengkap", nullable = false)
    private String namaLengkap;

    @NotNull
    @Size(max = 20)
    @Column(name = "nomor_handphone", nullable = false)
    private String nomorHandphone;

    @NotNull
    @Size(max = 255)
    @Column(name = "asal_sekolah", nullable = false)
    private String asalSekolah;

    @NotNull
    @Size(max = 8)
    @Column(name = "kode_tiket", nullable = false)
    private String kodeTiket;

    @NotNull
    @Size(max = 255)
    @Column(name = "pilihan_jurusan_1", nullable = false)
    private String pilihanJurusan1;

    @Size(max = 255)
    @Column(name = "pilihan_jurusan_2", nullable = true)
    private String pilihanJurusan2;

    @Size(max = 255)
    @Column(name = "pilihan_jurusan_3", nullable = true)
    private String pilihanJurusan3;

    @NotNull
    @Column(name = "status_pembayaran", nullable = false)
    private int statusPembayaran;

    @NotNull
    @Column(name = "waktu_registrasi", nullable = false)
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNomorHandphone() {
        return nomorHandphone;
    }

    public void setNomorHandphone(String nomorHandphone) {
        this.nomorHandphone = nomorHandphone;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public String getKodeTiket() {
        return kodeTiket;
    }

    public void setKodeTiket(String kodeTiket) {
        this.kodeTiket = kodeTiket;
    }

    public String getPilihanJurusan1() {
        return pilihanJurusan1;
    }

    public void setPilihanJurusan1(String pilihanJurusan1) {
        this.pilihanJurusan1 = pilihanJurusan1;
    }

    public String getPilihanJurusan2() {
        return pilihanJurusan2;
    }

    public void setPilihanJurusan2(String pilihanJurusan2) {
        this.pilihanJurusan2 = pilihanJurusan2;
    }

    public String getPilihanJurusan3() {
        return pilihanJurusan3;
    }

    public void setPilihanJurusan3(String pilihanJurusan3) {
        this.pilihanJurusan3 = pilihanJurusan3;
    }

    public int getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(int statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
