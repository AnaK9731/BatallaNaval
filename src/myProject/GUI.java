package myProject;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.border.*;
import javax.swing.JLabel;
import java.awt.event.*;

//imports para el Rich JLabel

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ButtonGroup;


public class GUI extends JFrame {


    private JPanel panelNorte, panelSur, panelEste, panelCentro;
    private JButton fragata, destructor, submarino, portaAviones;
    private Escucha escucha;
    private boolean position;




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
    private void initGUI () {



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
        label.setFont(label.getFont().deriveFont(48f));
        Box top = Box.createHorizontalBox();
        top.add(Box.createHorizontalStrut(10));
        top.add(Box.createHorizontalStrut(10));
        top.add(label);
        panelNorte.add(top);

        //TABLERO DE JUEGO
        panelEste.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 60));
        //GRID DE TABLERO 1
        JPanel panel1 = new JPanel();
        GridLayout layout1 = new GridLayout(11, 11); // 11 filas, 11 columnas (para la numeración)
        panel1.setLayout(layout1);
        panel1.setPreferredSize(new Dimension(450, 450));
        panel1.setBackground(new Color(79, 192, 201));
        // Agregar etiquetas de columna (números)
        panel1.add(new JLabel("")); // Celda vacía en la esquina superior izquierda

        for (char c = 'A'; c <= 'J'; c++) {
            JLabel label1 = new JLabel(Character.toString(c));
            label.setHorizontalAlignment(JLabel.CENTER);
            panel1.add(label1);
        }
        // Agregar componentes a la cuadrícula
        for (int i = 0; i < 10; i++) {
            JLabel label1 = new JLabel(Integer.toString(i + 1));
            label.setHorizontalAlignment(JLabel.CENTER);
            panel1.add(label1);

            for (int j = 0; j < 10; j++) {
                JButton button = new JButton();
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.setBackground(new Color(15, 96, 141));
                panel1.add(button);
                button.addMouseMotionListener(escucha);
            }
        }

        // Panel 2
        JPanel panel2 = new JPanel();
        GridLayout layout2 = new GridLayout(11, 11); // 11 filas, 11 columnas (para la numeración)
        panel2.setLayout(layout2);
        panel2.setPreferredSize(new Dimension(450, 450));
        panel2.setBackground(new Color(79, 192, 201));
        // Agregar etiquetas de columna (números)
        panel2.add(new JLabel("")); // Celda vacía en la esquina superior izquierda

        for (char c = 'A'; c <= 'J'; c++) {
        JLabel label2 = new JLabel(Character.toString(c));
        label2.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(label2);
        }
        // Agregar componentes a la cuadrícula
        for (int i = 0; i < 10; i++) {
            JLabel label2 = new JLabel(Integer.toString(i + 1));
            label2.setHorizontalAlignment(JLabel.CENTER);
            panel2.add(label2);

            for (int j = 0; j < 10; j++) {
                JButton button = new JButton();
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.setBackground(new Color(15, 130, 140));
                panel2.add(button);
                button.addMouseMotionListener(escucha);
                button.addMouseListener(escucha);
            }
        }
        // Agregar los paneles al contenedor principal
        JPanel container = new JPanel(new BorderLayout());
        container.add(panel1, BorderLayout.WEST);
        container.add(panel2, BorderLayout.EAST);
        panelEste.add(container, BorderLayout.CENTER);
        panelEste.setVisible(true);
        panelEste.addMouseMotionListener(escucha);


        // BOTONES-FICHAS
        ButtonGroup buttonGroup = new ButtonGroup();

// Configuración del botón "fragata"
        fragata = new JButton();
        buttonGroup.add(fragata);
        ImageIcon icono = new ImageIcon("src/recursos/fragata.png");
        Image imagen = icono.getImage().getScaledInstance(400, 135, Image.SCALE_SMOOTH);
        fragata.setIcon(new ImageIcon(imagen));
        fragata.setBackground(new Color(79, 192, 201));
        fragata.setFocusable(false);
        fragata.setBorder(null);
        fragata.addActionListener(escucha);

// Configuración del botón "destructor"
        destructor = new JButton();
        buttonGroup.add(destructor);
        ImageIcon icono2 = new ImageIcon("src/recursos/destructor.png");
        Image imagen2 = icono2.getImage().getScaledInstance(400, 135, Image.SCALE_SMOOTH);
        destructor.setIcon(new ImageIcon(imagen2));
        destructor.setBackground(new Color(79, 192, 201));
        destructor.setFocusable(false);
        destructor.setBorder(null);
        destructor.addActionListener(escucha);


// Configuración del botón "PortaAviones"
        portaAviones = new JButton();
        buttonGroup.add(portaAviones);
        ImageIcon icono3 = new ImageIcon("src/recursos/Portaavion.png");
        Image imagen3 = icono3.getImage().getScaledInstance(400, 135, Image.SCALE_SMOOTH);
        portaAviones.setIcon(new ImageIcon(imagen3));
        portaAviones.setBackground(new Color(79, 192, 201));
        portaAviones.setFocusable(false);
        portaAviones.setBorder(null);
        portaAviones.addActionListener(escucha);

// Configuración del botón "Submarino"
        submarino = new JButton();
        buttonGroup.add(submarino);
        ImageIcon icono4 = new ImageIcon("src/recursos/submarino.png");
        Image imagen4 = icono4.getImage().getScaledInstance(400, 135, Image.SCALE_SMOOTH);
        submarino.setIcon(new ImageIcon(imagen4));
        submarino.setBackground(new Color(79, 192, 201));
        submarino.setFocusable(false);
        submarino.setBorder(null);
        submarino.addActionListener(escucha);

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

        //Se agrega el listener al panel este



        //JLABEL CLASSs
    }
    public void posicionHorizontal(){

    }
    public void posiciobVertical(){

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
    private class Escucha implements ActionListener, MouseListener, MouseMotionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == fragata) {
                String imagePath1 = "src/recursos/Iconfragata.png";
                String imagePath2 = "src/recursos/Iconfragata2.png";

                // Crear los botones con las imágenes
                JToggleButton[] buttons = createToggleButtons(imagePath1, imagePath2);

                // Crear el panel que contendrá los botones
                JPanel panel = new JPanel();
                for (JToggleButton button : buttons) {
                    panel.add(button);
                }
                // Mostrar el JOptionPane personalizado
                int option = JOptionPane.showOptionDialog(null, panel, "Escoge la posición de tu fragata:",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        buttons, null);
                //if para dar seleccionar
                if (option == 0) {
                    // El usuario seleccionó el primer botón (imagen vertical)
                    if (buttons[0].isSelected()) {
                    } else {
                    }
                    // El usuario seleccionó el primer botón (imagen horizontal)
                } else if (option == 1) {
                    if (buttons[1].isSelected()) {
                    } else {
                    }

                }
            }

            if (e.getSource() == destructor) {
                String imagePath1 = "src/recursos/Icondestructor .png";
                String imagePath2 = "src/recursos/Icondestructor2.png";

                // Crear los botones con las imágenes
                JToggleButton[] buttons = createToggleButtons(imagePath1, imagePath2);

                // Crear el panel que contendrá los botones
                JPanel panel = new JPanel();
                for (JToggleButton button : buttons) {
                    panel.add(button);
                }
                // Mostrar el JOptionPane personalizado
                int option = JOptionPane.showOptionDialog(null, panel, "Escoge la posición de tu destructor:",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        buttons, null);
                //if para dar seleccionar
                if (option == 0) {
                    // El usuario seleccionó el primer botón (imagen vertical)
                    if (buttons[0].isSelected()) {
                    } else {
                    }
                    // El usuario seleccionó el primer botón (imagen horizontal)
                } else if (option == 1) {
                    if (buttons[1].isSelected()) {
                    } else {
                    }

                }
            }

            if (e.getSource() == portaAviones) {
                    String imagePath1 = "src/recursos/Iconportavion.png";
                    String imagePath2 = "src/recursos/Iconportavion2.png";

                    // Crear los botones con las imágenes
                    JToggleButton[] buttons = createToggleButtons(imagePath1, imagePath2);

                    // Crear el panel que contendrá los botones
                    JPanel panel = new JPanel();
                    for (JToggleButton button : buttons) {
                        panel.add(button);
                    }
                    // Mostrar el JOptionPane personalizado
                    int option = JOptionPane.showOptionDialog(null, panel, "Escoge la posición de tu Porta Aviones:",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                            buttons, null);
                    //if para dar seleccionar
                    if (option == 0) {
                        // El usuario seleccionó el primer botón (imagen vertical)
                        if (buttons[0].isSelected()) {
                        } else {
                        }
                        // El usuario seleccionó el primer botón (imagen horizontal)
                    } else if (option == 1) {
                        if (buttons[1].isSelected()) {
                        } else {
                        }

                    }
                }

            if (e.getSource() == submarino) {
                String imagePath1 = "src/recursos/Iconsubmarino.png";
                String imagePath2 = "src/recursos/Iconsubmarino2.png";

                // Crear los botones con las imágenes
                JToggleButton[] buttons = createToggleButtons(imagePath1, imagePath2);

                // Crear el panel que contendrá los botones
                JPanel panel = new JPanel();
                for (JToggleButton button : buttons) {
                    panel.add(button);
                }
                // Mostrar el JOptionPane personalizado
                int option = JOptionPane.showOptionDialog(null, panel, "Escoge la posición de tu submarino:",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        buttons, null);
                //if para dar seleccionar
                if (option == 0) {
                    // El usuario seleccionó el primer botón (imagen vertical)
                    if (buttons[0].isSelected()) {
                    } else {
                    }
                    // El usuario seleccionó el primer botón (imagen horizontal)
                } else if (option == 1) {
                    if (buttons[1].isSelected()) {
                    } else {
                    }

                }
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

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

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