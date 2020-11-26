package interfaz;

import dominio.Proceso;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTblMemoria extends AbstractTableModel {

    private static final int CANT_COLS = 1;
    private static final String[] NOM_COLS = {"Memoria (32 KB)"};
    private List<Proceso> Procesos;

    @Override
    public int getRowCount() {
        return Procesos.size();
    }

    @Override
    public int getColumnCount() {
        return CANT_COLS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proceso inst = Procesos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inst;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Proceso.class;
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

    public void setDatos(List<Proceso> lista) {
        Procesos = lista;
    }

    public Proceso getAdmin(int row) {
        return Procesos.get(row);
    }

}
