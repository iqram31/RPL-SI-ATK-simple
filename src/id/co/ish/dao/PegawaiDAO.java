/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.dao;

import id.co.ish.entity.Pegawai;
import java.util.ArrayList;

/**
 *
 * @author Iqram
 */
public interface PegawaiDAO {
    
    ArrayList<Pegawai> getPegawai();
    
    ArrayList<Pegawai> getPegawai(String cari);
}
