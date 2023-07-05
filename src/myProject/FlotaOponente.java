package myProject;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
public class Flota {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Batalla Naval");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 550);

        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(11, 11); // 11 filas, 11 columnas (para la numeración)
        panel.setLayout(layout);

        // Agregar etiquetas de columna (números)
        panel.add(new JLabel("")); // Celda vacía en la esquina superior izquierda

        for (char c = 'A'; c <= 'J'; c++) {
            JLabel label = new JLabel(Character.toString(c));
            label.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label);
        }

        // Agregar componentes a la cuadrícula
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(Integer.toString(i + 1));
            label.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label);

            for (int j = 0; j < 10; j++) {
                JButton button = new JButton();
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde negro
                button.setBackground(new Color(15, 96, 141)); // Fondo gris claro
                panel.add(button);
            }

            frame.add(panel);
            frame.setVisible(true);
        }
    }

}
