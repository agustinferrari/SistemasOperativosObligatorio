
package interfaz;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ColoresMemoria extends DefaultTableCellRenderer {

//    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, int index, boolean isSelected, boolean hasFocus, int row, int col) {
        JLabel  label =  (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        String texto = value.toString();
        Color color;
        
        if(texto.contains("+")) {
            color = Color.GREEN;
        } else if(texto.contains("*"))  {
            color = Color.RED;
        } else {
            color = Color.BLUE;
        }
        
        label.setBackground(color);
        return label;
    }
    
    
}