package interfaz;

import dominio.Proceso;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class ColoresMemoria extends JLabel implements TableCellRenderer {///extends DefaultTableCellRenderer {

    public ColoresMemoria() {
        super.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {

        if (o == null) {
            super.setBackground(Color.WHITE);
            super.setText(" ");
            return this;
        }
        String texto = o.toString();
        Proceso p = (Proceso) o;


        
        super.setBackground(p.getColor());
        super.setText(texto);
        return this;
    }
}
