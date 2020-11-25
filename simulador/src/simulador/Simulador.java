package simulador;

import interfaz.VentanaPrincipal;
import interfaz.VentanaPruebas;
import java.awt.Dimension;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Simulador {

    public static void main(String[] args) {

        VentanaPruebas vent = new VentanaPruebas();
        vent.setMinimumSize(new Dimension(445, 180));
        vent.setVisible(true);
    }


  

    private static void cambiarEstiloUIWindows() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

        }
    }
}
