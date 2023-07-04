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


public class GUI extends JFrame {


    private JPanel panelNorte, panelSur, panelEste, panelCentro;
    private JButton fragata, destructor, submarino, portaAviones;
    private Escucha escucha;


    public GUI() {

        initGUI();

        Color myWhite = new Color(79, 192, 201);
        this.getContentPane().setBackground(myWhite); // Se establece el color de fondo del contenido del JFrame
        // Configuración del JFrame
        this.setTitle("Batalla Naval");
        this.setSize(1500, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {

        escucha = new Escucha(); //Create listener object and control object
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
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelSur, BorderLayout.SOUTH);
        this.add(panelEste, BorderLayout.EAST);
        this.add(panelCentro, BorderLayout.CENTER);

        panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 250, 5));
        panelSur.setBorder(new TitledBorder(new EtchedBorder(), "SDFSDF"));


        //CONFIGURACIÓN PANEL NORTE
        panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));
        RichJLabel label = new RichJLabel("BATALLA NAVAL");
        label.setLeftShadow(1, 1, Color.WHITE);
        label.setRightShadow(1, 1, Color.gray);
        label.setForeground(new Color(17, 45, 101));
        ;
        label.setFont(label.getFont().deriveFont(48f));
        Box top = Box.createHorizontalBox();
        top.add(Box.createHorizontalStrut(10));
        top.add(Box.createHorizontalStrut(10));
        top.add(label);
        panelNorte.add(top);

        //TABLERO DE JUEGO
        panelEste.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 60));
        panelEste.setBorder(new TitledBorder(new EtchedBorder(), "PANEL DE JUEGO"));

        //TABLERO DE NAVAL SHIP
        panelCentro.setLayout(new GridLayout(1, 1, 0, 100));

        // BOTONES-FICHAS
        ButtonGroup buttonGroup = new ButtonGroup();

// Configuración del botón "fragata"
        fragata = new JButton();
        buttonGroup.add(fragata);
        ImageIcon icono = new ImageIcon("C:/Users/tylum/IdeaProjects/BatallaNaval/src/recursos/fragata.png");
        Image imagen = icono.getImage().getScaledInstance(400, 135, Image.SCALE_SMOOTH);
        fragata.setIcon(new ImageIcon(imagen));
        fragata.setBackground(new Color(79, 192, 201));
        fragata.setFocusable(false);
        fragata.setBorder(null);
        fragata.addActionListener(escucha);

// Configuración del botón "destructor"
        destructor = new JButton();
        buttonGroup.add(destructor);
        ImageIcon icono2 = new ImageIcon("C:/Users/tylum/IdeaProjects/BatallaNaval/src/recursos/destructor.png");
        Image imagen2 = icono2.getImage().getScaledInstance(400, 135, Image.SCALE_SMOOTH);
        destructor.setIcon(new ImageIcon(imagen2));
        destructor.setBackground(new Color(79, 192, 201));
        destructor.setFocusable(false);
        destructor.setBorder(null);


// Configuración del botón "PortaAviones"
        portaAviones = new JButton();
        buttonGroup.add(portaAviones);
        ImageIcon icono3 = new ImageIcon("C:/Users/tylum/IdeaProjects/BatallaNaval/src/recursos/Portaavion.png");
        Image imagen3 = icono3.getImage().getScaledInstance(400, 135, Image.SCALE_SMOOTH);
        portaAviones.setIcon(new ImageIcon(imagen3));
        portaAviones.setBackground(new Color(79, 192, 201));
        portaAviones.setFocusable(false);
        portaAviones.setBorder(null);

// Configuración del botón "Submarino"
        submarino = new JButton();
        buttonGroup.add(submarino);
        ImageIcon icono4 = new ImageIcon("C:/Users/tylum/IdeaProjects/BatallaNaval/src/recursos/submarino.png");
        Image imagen4 = icono4.getImage().getScaledInstance(400, 135, Image.SCALE_SMOOTH);
        submarino.setIcon(new ImageIcon(imagen4));
        submarino.setBackground(new Color(79, 192, 201));
        submarino.setFocusable(false);
        submarino.setBorder(null);


// Configuración del panel panelCentro
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.add(fragata);
        panelCentro.add(destructor);
        panelCentro.add(portaAviones);
        panelCentro.add(submarino);

        //DIMENSIONES DE CAJAS TABLERO
        panelSur.setPreferredSize(new Dimension(100, 60));
        panelNorte.setPreferredSize(new Dimension(100, 60));
        panelEste.setPreferredSize(new Dimension(1000, 60));
        panelCentro.setPreferredSize(new Dimension(300, 100));


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
    private class Escucha implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String imagePath1 = "C:\\Users\\tylum\\IdeaProjects\\BatallaNaval\\src\\recursos\\Iconfragata.png";
            String imagePath2 = "C:\\Users\\tylum\\IdeaProjects\\BatallaNaval\\src\\recursos\\Iconfragata2.png";

            // Crear los botones con las imágenes
            JToggleButton[] buttons = createToggleButtons(imagePath1, imagePath2);

            // Crear el panel que contendrá los botones
            JPanel panel = new JPanel();
            for (JToggleButton button : buttons) {
                panel.add(button);
            }

            // Mostrar el JOptionPane personalizado
            int option = JOptionPane.showOptionDialog(null, panel, "Escoge la posición de tu nave:",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    buttons, null);

            if (option == 0) {
                // El usuario seleccionó el primer botón (imagen vertical)
                if (buttons[0].isSelected()) {
                } else { }
                // El usuario seleccionó el primer botón (imagen horizontal)
            } else if (option == 1) {
                if (buttons[1].isSelected()) {
                                    } else { }
            }
        }



        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private JToggleButton[] createToggleButtons(String imagePath1, String imagePath2) {
        JToggleButton button1 = new JToggleButton(new ImageIcon(imagePath1));
        JToggleButton button2 = new JToggleButton(new ImageIcon(imagePath2));

        button1.setPreferredSize(new Dimension(200, 200));
        button2.setPreferredSize(new Dimension(200, 200));

        JToggleButton[] buttons = {button1, button2};

        for (JToggleButton button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Actualizar el estado de selección del botón
                    JToggleButton sourceButton = (JToggleButton) e.getSource();
                    if (sourceButton.isSelected()) {
                        sourceButton.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    } else {
                        sourceButton.setBorder(null);
                    }
                }
            });
        }

        return buttons;
    }
}