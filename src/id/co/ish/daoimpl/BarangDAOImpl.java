/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.daoimpl;

import id.co.ish.dao.BarangDAO;
import id.co.ish.entity.Barang;
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
public class BarangDAOImpl implements BarangDAO{
    
    private final Connection conn;

    public BarangDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Barang> getBarang() {
        return getBarang(null);
    }

    @Override
    public ArrayList<Barang> getBarang(String cari) {
        ArrayList<Barang> arrayBarang = null;
        PreparedStatement state = null;

        boolean isSearching = cari != null && !cari.isEmpty();
        String SELECT;
        if (isSearching) {
            SELECT = "SELECT * FROM alat_tulis WHERE "
                    + "(kode LIKE ? OR nama LIKE ?)";
        } else {
            SELECT = "SELECT * FROM alat_tulis";
        }

        try {
            state = conn.prepareStatement(SELECT);
            if (isSearching) {
                state.setString(1, "%" + cari + "%");
                state.setString(2, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayBarang = new ArrayList<>();

                while (result.next()) {
                    Barang barang = new Barang();
                    barang.setKodeBrg(result.getString(1));
                    barang.setNama(result.getString(2));
                    barang.setStokBrg(result.getInt(3));
                    barang.setSatuan(result.getString(4));
                   
                    arrayBarang.add(barang);
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
        return arrayBarang;
    }

    @Override
    public boolean tambahBarang(Barang barang) {
        String INSERT = "INSERT INTO alat_tulis VALUES (?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);

            state.setString(1, barang.getKodeBrg());
            state.setString(2, barang.getNama());
            state.setInt(3, barang.getStokBrg());
            state.setString(4, barang.getSatuan());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean ubahBarang(Barang barang) {
        String UPDATE = "UPDATE alat_tulis "
                + "SET nama = ?, satuan = ?"
                + "WHERE kode = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);

            state.setString(1, barang.getNama());
            state.setString(2, barang.getSatuan());
            state.setString(3, barang.getKodeBrg());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean ubahStok(Barang barang) {
        String UPDATE = "UPDATE alat_tulis "
                + "SET stok = ? WHERE kode = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setInt(1, barang.getStokBrg());
            state.setString(2, barang.getKodeBrg());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean hapusBarang(String kodeBrg) {
        String DELETE = "DELETE FROM alat_tulis "
                + "WHERE kode = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, kodeBrg);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
}
