/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.daoimpl;

import id.co.ish.dao.TransaksiMasukDAO;
import id.co.ish.entity.TransaksiMasuk;
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
public class TransaksiMasukDAOImpl implements TransaksiMasukDAO {

    private final Connection conn;

    public TransaksiMasukDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<TransaksiMasuk> getTransMasuk() {
        return getTransMasuk(null);
    }

    @Override
    public ArrayList<TransaksiMasuk> getTransMasuk(String cari) {
        ArrayList<TransaksiMasuk> arrayTransaksiMasuk = null;
        PreparedStatement state = null;
        boolean isSearching = cari != null && !cari.isEmpty();

        String SELECT;
        if (isSearching) {
            SELECT = "SELECT trans_atk_masuk.kode_msk,trans_atk_masuk.kode_atk,alat_tulis.nama,"
                    + "trans_atk_masuk.tgl_msk,trans_atk_masuk.jumlah "
                    + "FROM trans_atk_masuk, alat_tulis "
                    + "WHERE trans_atk_masuk.kode_atk = alat_tulis.kode "
                    + "AND (trans_atk_masuk.kode_msk LIKE ? OR alat_tulis.nama LIKE ?)";
        } else {
            SELECT = "SELECT trans_atk_masuk.kode_msk,trans_atk_masuk.kode_atk,alat_tulis.nama,"
                    + "trans_atk_masuk.tgl_msk,trans_atk_masuk.jumlah "
                    + "FROM trans_atk_masuk, alat_tulis "
                    + "WHERE trans_atk_masuk.kode_atk = alat_tulis.kode";
        }
        try {
            state = conn.prepareStatement(SELECT);

            if (isSearching) {
                state.setString(1, "%" + cari + "%");
                state.setString(2, "%" + cari + "%");
            }
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayTransaksiMasuk = new ArrayList<>();
                while (result.next()) {
                    TransaksiMasuk tm = new TransaksiMasuk();
                    tm.setIdTransMsk(result.getString(1));
                    tm.setKodeBrg(result.getString(2));
                    tm.setNamaBrg(result.getString(3));
                    tm.setTglMsk(result.getDate(4));
                    tm.setJumlah(result.getInt(5));
                    arrayTransaksiMasuk.add(tm);
                }
            }
                result.close();
            }catch (SQLException ex) {
            Logger.getLogger(TransaksiMasukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiMasukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

            return arrayTransaksiMasuk;
        }

        @Override
        public boolean tambahTransMasuk
        (TransaksiMasuk transMasuk
        
            ) {
         String INSERT = "INSERT INTO trans_atk_masuk (kode_msk,kode_atk,"
                    + "tgl_msk,jumlah) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement state = null;

            try {
                state = conn.prepareStatement(INSERT);

                java.util.Date utilDate = new java.util.Date();
                utilDate = transMasuk.getTglMsk();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                state.setString(1, transMasuk.getIdTransMsk());
                state.setString(2, transMasuk.getKodeBrg());
                state.setDate(3, sqlDate);
                state.setInt(4, transMasuk.getJumlah());
                int qty = state.executeUpdate();
                return qty > 0;

            } catch (SQLException ex) {
                Logger.getLogger(TransaksiMasukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            return false;
        }

        @Override
        public TransaksiMasuk noUrut
        
            () {
       TransaksiMasuk tm = null;
            String SELECT = "SELECT MAX(RIGHT(kode_msk,4)) FROM trans_atk_masuk";
            PreparedStatement state = null;

            try {
                state = conn.prepareStatement(SELECT);
                ResultSet result = state.executeQuery();
                tm = new TransaksiMasuk();
                if (result != null && result.next()) {
                    tm.setIdTransMsk(result.getString(1));
                }

            } catch (SQLException ex) {
                Logger.getLogger(TransaksiMasukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tm;
        }

    }
