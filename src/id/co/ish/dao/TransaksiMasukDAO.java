/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.dao;

import id.co.ish.entity.TransaksiMasuk;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface TransaksiMasukDAO {
    
    ArrayList<TransaksiMasuk> getTransMasuk();
    
    ArrayList<TransaksiMasuk> getTransMasuk(String cari);
    
    boolean tambahTransMasuk(TransaksiMasuk transMasuk);
     
    TransaksiMasuk noUrut();
    
}
