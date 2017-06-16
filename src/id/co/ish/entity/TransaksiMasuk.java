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
public class TransaksiMasuk {
    private String idTransMsk;
    private String kodeBrg;
    private String namaBrg;
    private Date tglMsk;
    private int jumlah;

    public String getIdTransMsk() {
        return idTransMsk;
    }

    public void setIdTransMsk(String idTransMsk) {
        this.idTransMsk = idTransMsk;
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

    public Date getTglMsk() {
        return tglMsk;
    }

    public void setTglMsk(Date tglMsk) {
        this.tglMsk = tglMsk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
