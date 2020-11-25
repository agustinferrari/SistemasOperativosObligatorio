
package interfaz;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Colores implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList jlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel  label = (JLabel) (new DefaultListCellRenderer()).getListCellRendererComponent(jlist, value, index, isSelected, cellHasFocus);
        String texto = value.toString();
        Color color;
        
        if(texto.contains("+")) {
            color = Color.GREEN;
        } else if(texto.contains("*"))  {
            color = Color.RED;
        } else {
            color = Color.YELLOW;
        }
        
        label.setBackground(color);
        return label;
    }
    
    
}
