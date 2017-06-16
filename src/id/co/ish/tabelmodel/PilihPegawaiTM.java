/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.tabelmodel;

import id.co.ish.entity.Barang;
import id.co.ish.entity.Pegawai;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iqram
 */
public class PilihPegawaiTM extends AbstractTableModel {
     private ArrayList<Pegawai> arrayPegawai;
     
      public void setArrayPegawai(ArrayList<Pegawai> arrayPegawai) {
        this.arrayPegawai = arrayPegawai;
    }

    @Override
    public int getRowCount() {
         return this.arrayPegawai.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayPegawai.get(rowIndex).getIdPegawai();
            case 1:
                return arrayPegawai.get(rowIndex).getNamaPegawai();
            case 2:
                return arrayPegawai.get(rowIndex).getDivisiPegawai();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Pegawai";
            case 1:
                return "Nama Pegawai";
            case 2:
                return "Divisi";
        }
        return null;
    }
    
    
}
