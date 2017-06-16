/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.daoimpl;

import id.co.ish.dao.PegawaiDAO;
import id.co.ish.entity.Pegawai;
import id.co.ish.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqram
 */
public class PegawaiDAOImpl implements PegawaiDAO{

    private final Connection conn;

    public PegawaiDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    @Override
    public ArrayList<Pegawai> getPegawai() {
        return getPegawai(null);
    }

    @Override
    public ArrayList<Pegawai> getPegawai(String cari) {
        ArrayList<Pegawai> arrayPegawai = null;
        PreparedStatement state = null;

        boolean isSearching = cari != null && !cari.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM pegawai WHERE "
                    + "(id_pegawai LIKE ? OR nama LIKE ?)";
        } else {
            SELECT = "SELECT * FROM pegawai";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, "%" + cari + "%");
                state.setString(2, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPegawai = new ArrayList<>();

                while (result.next()) {
                    Pegawai pegawai = new Pegawai();
                    pegawai.setIdPegawai(result.getString(1));
                    pegawai.setNamaPegawai(result.getString(2));
                    pegawai.setDivisiPegawai(result.getString(3));
                    pegawai.setNoHp(result.getString(4));
                   
                    arrayPegawai.add(pegawai);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        return arrayPegawai;
    }
    
}
