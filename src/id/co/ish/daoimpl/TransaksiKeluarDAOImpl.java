/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.daoimpl;

import id.co.ish.dao.TransaksiKeluarDAO;
import id.co.ish.entity.TransaksiKeluar;
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
public class TransaksiKeluarDAOImpl implements TransaksiKeluarDAO{
    
    private final Connection conn;

    public TransaksiKeluarDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    
    @Override
    public ArrayList<TransaksiKeluar> getTransKeluar() {
        return getTransKeluar(null);
    }

    @Override
    public ArrayList<TransaksiKeluar> getTransKeluar(String cari) {
        ArrayList<TransaksiKeluar> arrayTransaksiKeluar = null;
        PreparedStatement state = null;
        boolean isSearching = cari != null && !cari.isEmpty();

        String SELECT;
        if (isSearching) {
            SELECT = "SELECT trans_atk_keluar.kode_klr,alat_tulis.kode,alat_tulis.nama,"
                    + "trans_atk_keluar.tgl_klr,pegawai.id_pegawai,pegawai.nama,pegawai.divisi,"
                    + "trans_atk_keluar.jumlah "
                    + "FROM trans_atk_keluar,alat_tulis,pegawai "
                    + "WHERE trans_atk_keluar.kode_atk = alat_tulis.kode "
                    + "AND trans_atk_keluar.id_pegawai = pegawai.id_pegawai "
                    + "AND (trans_atk_keluar.kode_klr LIKE ? OR alat_tulis.nama LIKE ?)";
        } else {
            SELECT = "SELECT trans_atk_keluar.kode_klr,alat_tulis.kode,alat_tulis.nama,"
                    + "trans_atk_keluar.tgl_klr,pegawai.id_pegawai,pegawai.nama,pegawai.divisi,"
                    + "trans_atk_keluar.jumlah "
                    + "FROM trans_atk_keluar,alat_tulis,pegawai "
                    + "WHERE trans_atk_keluar.kode_atk = alat_tulis.kode "
                    + "AND trans_atk_keluar.id_pegawai = pegawai.id_pegawai";
        }
        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + cari + "%");
                state.setString(2, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayTransaksiKeluar = new ArrayList<>();
                while (result.next()) {
                    TransaksiKeluar tk = new TransaksiKeluar();
                    tk.setIdTransKlr(result.getString(1));
                    tk.setKodeBrg(result.getString(2));
                    tk.setNamaBrg(result.getString(3));
                    tk.setTglKlr(result.getDate(4));
                    tk.setIdPegawai(result.getString(5));
                    tk.setNamaPegawai(result.getString(6));
                    tk.setDivisi(result.getString(7));
                    tk.setJumlah(result.getInt(8));
                    arrayTransaksiKeluar.add(tk);
                }
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiKeluarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiKeluarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return arrayTransaksiKeluar;
    }

    @Override
    public boolean tambahTransKeluar(TransaksiKeluar transKeluar) {
        String INSERT = "INSERT INTO trans_atk_keluar (kode_klr,kode_atk,"
                + "tgl_klr,jumlah,id_pegawai) "
                + "VALUES (?,?,?,?,?)";

        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);

            java.util.Date utilDate = new java.util.Date();
            utilDate = transKeluar.getTglKlr();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            state.setString(1, transKeluar.getIdTransKlr());
            state.setString(2, transKeluar.getKodeBrg());
            state.setDate(3, sqlDate);
            state.setInt(4, transKeluar.getJumlah());
            state.setString(5, transKeluar.getIdPegawai());
            int qty = state.executeUpdate();
            return qty > 0;

        } catch (SQLException ex) {
            Logger.getLogger(TransaksiKeluarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public TransaksiKeluar noUrut() {
        TransaksiKeluar tk = null;
        String SELECT = "SELECT MAX(RIGHT(kode_klr,4)) FROM trans_atk_keluar";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            ResultSet result = state.executeQuery();
            tk = new TransaksiKeluar();
            if (result != null && result.next()) {
                tk.setIdTransKlr(result.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TransaksiKeluarDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tk;  
    }
    
}
