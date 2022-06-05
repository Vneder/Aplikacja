package com.example.demo;
import javax.persistence.*;

@Entity
@Table(name="Filmy")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nazwa;
    private String data;
    private String gatunek;
    private String dlugosc;
    private String ocena;
    private String kategoria;
    @Transient
    boolean  nowy;

    public Film(String nazwa, String data, String gatunek, String dlugosc, String ocena, String kategoria, boolean nowy) {
        this.nazwa = nazwa;
        this.data = data;
        this.gatunek = gatunek;
        this.dlugosc = dlugosc;
        this.ocena = ocena;
        this.kategoria = kategoria;
        this.nowy = nowy;
    }

    public Film(Integer id, String nazwa, String data, String gatunek, String dlugosc, String ocena, String kategoria, boolean nowy) {
        this.id = id;
        this.nazwa = nazwa;
        this.data = data;
        this.gatunek = gatunek;
        this.dlugosc = dlugosc;
        this.ocena = ocena;
        this.kategoria = kategoria;
        this.nowy = nowy;
    }

    public Film() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(String dlugosc) {
        this.dlugosc = dlugosc;
    }

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }
    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", data='" + data + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", dlugosc='" + dlugosc + '\'' +
                ", ocena='" + ocena + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", nowy=" + nowy +
                '}';
    }
}
