/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.entity;

import java.util.Date;



/**
 *
 * @author Iqram
 */
public class TransaksiKeluar {
    private String idTransKlr;
    private String kodeBrg;
    private String namaBrg;
    private Date tglKlr;
    private String idPegawai;
    private String namaPegawai;
    private String divisi;
    private int jumlah;

    public String getIdTransKlr() {
        return idTransKlr;
    }

    public void setIdTransKlr(String idTransKlr) {
        this.idTransKlr = idTransKlr;
    }

    public String getKodeBrg() {
        return kodeBrg;
    }

    public void setKodeBrg(String kodeBrg) {
        this.kodeBrg = kodeBrg;
    }

    public String getNamaBrg() {
        return namaBrg;
    }

    public void setNamaBrg(String namaBrg) {
        this.namaBrg = namaBrg;
    }

    public Date getTglKlr() {
        return tglKlr;
    }

    public void setTglKlr(Date tglKlr) {
        this.tglKlr = tglKlr;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
    
    
}
