package interfaz;

import dominio.Instruccion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTblInstruccion extends AbstractTableModel {

    private static final int CANT_COLS = 3;
    private static final String[] NOM_COLS = {"Nombre", "Rango de tiempo posible (t)", "Recurso asociado"};
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
                return "[" + inst.getTiempoEjecucionMin() + "," + inst.getTiempoEjecucionMax() + "]";
            case 2:

                return (inst.getRecurso() != null) ? inst.getRecurso().getNombre() : null;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
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
