
package interfaz;

import dominio.Proceso;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Colores implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList jlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel  label = (JLabel) (new DefaultListCellRenderer()).getListCellRendererComponent(jlist, value, index, isSelected, cellHasFocus);
       
        
        Proceso p = (Proceso) value;
        
        label.setBackground(p.getColor());
        label.setText(p.toString());
        return label;
    }
    
    
    
    
}
