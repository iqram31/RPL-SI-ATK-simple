/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.tabelmodel;

import id.co.ish.entity.Barang;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class PilihBarangTM extends AbstractTableModel {

    private ArrayList<Barang> arrayBarang;

    public void setArrayBarang(ArrayList<Barang> arrayBarang) {
        this.arrayBarang = arrayBarang;
    }
    
    @Override
    public int getRowCount() {
         return this.arrayBarang.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayBarang.get(rowIndex).getKodeBrg();
            case 1:
                return arrayBarang.get(rowIndex).getNama();
            case 2:
                return arrayBarang.get(rowIndex).getStokBrg();

        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode Barang";
            case 1:
                return "Nama Barang";
            case 2:
                return "Stok";
        }
        return null;
    }
    
}
