/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.dao;

import id.co.ish.entity.TransaksiKeluar;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface TransaksiKeluarDAO {
    
    ArrayList<TransaksiKeluar> getTransKeluar();
    
    ArrayList<TransaksiKeluar> getTransKeluar(String cari);
    
    boolean tambahTransKeluar(TransaksiKeluar transKeluar);
     
    TransaksiKeluar noUrut();
    
}
