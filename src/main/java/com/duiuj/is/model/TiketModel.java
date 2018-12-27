package com.duiuj.is.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tiket")
public class TiketModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Size(max = 8)
    @Column(name = "password_tiket", nullable = false)
    private String passwordTiket;

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
}
