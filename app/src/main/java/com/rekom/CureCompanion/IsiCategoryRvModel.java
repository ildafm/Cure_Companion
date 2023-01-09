package com.rekom.CureCompanion;

public class IsiCategoryRvModel {
    String namaObat;
    String id;
    String hargaObat;
    String kategoriObat;
    String netto;
    String deksripsi;
    String image;

    public IsiCategoryRvModel() {
    }

    public IsiCategoryRvModel(String namaObat, String id, String hargaObat, String netto, String deksripsi, String image) {
        this.namaObat = namaObat;
        this.id = id;
        this.hargaObat = hargaObat;
//        this.kategoriObat = kategoriObat;
        this.netto = netto;
        this.deksripsi = deksripsi;
        this.image = image;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(String hargaObat) {
        this.hargaObat = hargaObat;
    }

//    public String getKategoriObat() {
//        return kategoriObat;
//    }
//
//    public void setKategoriObat(String kategoriObat) {
//        this.kategoriObat = kategoriObat;
//    }

    public String getNetto() {
        return netto;
    }

    public void setNetto(String netto) {
        this.netto = netto;
    }

    public String getDeksripsi() {
        return deksripsi;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}