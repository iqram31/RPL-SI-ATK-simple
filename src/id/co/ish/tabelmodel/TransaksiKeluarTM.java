/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.tabelmodel;

import id.co.ish.entity.TransaksiKeluar;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class TransaksiKeluarTM extends AbstractTableModel {

    private ArrayList<TransaksiKeluar> arrayTransKeluar;

    public void setArrayTransKeluar(ArrayList<TransaksiKeluar> arrayTransKeluar) {
        this.arrayTransKeluar = arrayTransKeluar;
    }

    @Override
    public int getRowCount() {
        return this.arrayTransKeluar.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayTransKeluar.get(rowIndex).getIdTransKlr();
            case 1:
                return arrayTransKeluar.get(rowIndex).getNamaBrg();
            case 2:
                return arrayTransKeluar.get(rowIndex).getTglKlr();
            case 3:
                return arrayTransKeluar.get(rowIndex).getNamaPegawai();
            case 4:
                return arrayTransKeluar.get(rowIndex).getDivisi();
            case 5:
                return arrayTransKeluar.get(rowIndex).getJumlah();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Transaksi";
            case 1:
                return "Nama Barang";
            case 2:
                return "Tanggal";
            case 3:
                return "Nama Pemohon";
            case 4:
                return "Bidang Kerja";
            case 5:
                return "Jumlah";
        }
        return null;
    }

}
