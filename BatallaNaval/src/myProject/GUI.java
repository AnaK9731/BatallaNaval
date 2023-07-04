package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.border.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//imports para el Rich JLabel

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
public class GUI extends JFrame {


    private  JPanel panelNorte, panelSur, panelEste, panelCentro;
    private JButton ayuda, comenzarPartida, movimientosEnemigo,reiniciar;


     public GUI() {

        initGUI();

        Color myWhite = new Color(79, 192, 201);
        this.getContentPane().setBackground(myWhite); // Se establece el color de fondo del contenido del JFrame
        // Configuración del JFrame
        this.setTitle("Batalla Naval");
        this.setSize(1500,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        panelNorte = new JPanel();
        panelSur = new JPanel();
        panelEste = new JPanel();
        panelCentro = new JPanel();

        // Creación de paneles para el JFrame
        Color myWhite = new Color(79, 192, 201);
        this.getContentPane().setBackground(myWhite);
        panelNorte.setBackground(myWhite);
        panelSur.setBackground(myWhite);
        panelEste.setBackground(myWhite);
        panelCentro.setBackground(myWhite);

        // Se agregan los paneles al JFrame
        this.add(panelNorte,BorderLayout.NORTH);
        this.add(panelSur,BorderLayout.SOUTH);
        this.add(panelEste,BorderLayout.EAST);
        this.add(panelCentro,BorderLayout.CENTER);

        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER,250,5));
        panelSur.setBorder(new TitledBorder(new EtchedBorder(), "SDFSDF"));


        //CONFIGURACIÓN PANEL NORTE
        panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
        RichJLabel label = new RichJLabel("BATALLA NAVAL");
        label.setLeftShadow(1, 1, Color.WHITE);
        label.setRightShadow(1, 1, Color.gray);
        label.setForeground(new Color(17, 45, 101));;
        label.setFont(label.getFont().deriveFont(48f));
        Box top = Box.createHorizontalBox();
        top.add(Box.createHorizontalStrut(10));
        top.add(Box.createHorizontalStrut(10));
        top.add(label);
        panelNorte.add(top);

        //TABLERO DE JUEGO
        panelEste.setLayout(new FlowLayout(FlowLayout.CENTER,100,60));
        panelEste.setBorder(new TitledBorder(new EtchedBorder(), "PANEL DE JUEGO"));


        //TABLERO DE NAVAL SHIP
        panelCentro.setLayout(new GridLayout(1,1,0,100));
        panelCentro.setBorder(new TitledBorder(new EtchedBorder(), "FICHAS"));


        //DIMENSIONES DE CAJAS TABLERO
        panelSur.setPreferredSize(new Dimension(100,60));
        panelNorte.setPreferredSize(new Dimension(100,60));
        panelEste.setPreferredSize(new Dimension(1000,60));
        panelCentro.setPreferredSize(new Dimension(300,100));







        //JLABEL CLASSs
        }
    class RichJLabel extends JLabel {
        private int tracking;

        public RichJLabel(String text) {
            super(text);
            this.tracking = tracking;
        }

        private int left_x, left_y, right_x, right_y;
        private Color left_color, right_color;

        public void setLeftShadow(int x, int y, Color color) {
            left_x = x;
            left_y = y;
            left_color = color;
        }

        public void setRightShadow(int x, int y, Color color) {
            right_x = x;
            right_y = y;
            right_color = color;
        }

        public Dimension getPreferredSize() {
            String text = getText();
            FontMetrics fm = this.getFontMetrics(getFont());

            int w = fm.stringWidth(text);
            w += (text.length()) * tracking;
            w += left_x + right_x;
            int h = fm.getHeight();
            h += left_y + right_y;

            return new Dimension(w, h);
        }

        //se agregan graficos al contorno del titulo

        public void paintComponent(Graphics g) {
            ((Graphics2D) g).setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            char[] chars = getText().toCharArray();

            FontMetrics fm = this.getFontMetrics(getFont());

            int h = fm.getAscent();
            int x = 0;

            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                int w = fm.charWidth(ch) + tracking;

                g.setColor(left_color);
                g.drawString("" + chars[i], x - left_x, h - left_y);

                g.setColor(right_color);
                g.drawString("" + chars[i], x + right_x, h + right_y);

                g.setColor(this.getForeground());
                g.drawString("" + chars[i], x, h);

                x += w;
            }
        }
    }
    /**
     * Main process of the Java program
     *
     * @param args Object used in order to send input data from command line when
     *             the program is executed by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new GUI(); // Eliminado el objeto myProject que no se utiliza
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {
        // Aquí puedes implementar listeners o funcionalidad adicional si es necesario
    }
}
