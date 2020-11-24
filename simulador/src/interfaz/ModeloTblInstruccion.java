/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Instruccion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Agustin
 */
public class ModeloTblInstruccion extends AbstractTableModel {

    private static final int CANT_COLS = 3;
    private static final String[] NOM_COLS = {"Nombre", "tiempo de ejecucion", "Recurso asociado"};
    private List<Instruccion> Instrucciones;

    @Override
    public int getRowCount() {
        return Instrucciones.size();
    }

    @Override
    public int getColumnCount() {
        return CANT_COLS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Instruccion inst = Instrucciones.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inst.getNombre();
            case 1:
                return inst.getTiempoEjecucion();
            case 2:
                return inst.getRecurso().getNombre();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return int.class;
            case 2:
                return String.class;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return NOM_COLS[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void setDatos(List<Instruccion> lista) {
        Instrucciones = lista;
    }

    public Instruccion getAdmin(int row) {
        return Instrucciones.get(row);
    }

}
