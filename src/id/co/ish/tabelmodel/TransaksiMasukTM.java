/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.tabelmodel;

import id.co.ish.entity.TransaksiMasuk;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class TransaksiMasukTM extends AbstractTableModel {
    
     private ArrayList<TransaksiMasuk> arrayTransMasuk;
     
     public void setArrayTransMasuk(ArrayList<TransaksiMasuk> arrayTransMasuk) {
        this.arrayTransMasuk = arrayTransMasuk;
    }
    
    @Override
    public int getRowCount() {
        return this.arrayTransMasuk.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayTransMasuk.get(rowIndex).getIdTransMsk();
            case 1:
                return arrayTransMasuk.get(rowIndex).getNamaBrg();
            case 2:
                return arrayTransMasuk.get(rowIndex).getTglMsk();
            case 3:
                return arrayTransMasuk.get(rowIndex).getJumlah();

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
                return "Tanggal Masuk";
            case 3:
                return "Jumlah";
        }
        return null;
    }
    
    
    
}
