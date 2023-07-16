package myProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private final int ROWS = 10;
    private final int COLS = 10;

    private int[][] matrix;

    private JButton[][] buttons;

    public Game() {
        matrix = new int[ROWS][COLS];
        initializeMatrix();

        setTitle("Battle Ship Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS));
        add(gridPanel);

        buttons = new JButton[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(40, 40));
                button.addActionListener(new ButtonListener(i, j));
                button.setBackground(new Color(15, 96, 141));
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(button);
                buttons[i][j] = button;
            }
        }

        setVisible(true);
    }

    private void initializeMatrix() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    private void displayMatrix() {
        System.out.println("Matrix:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private class ButtonListener implements ActionListener {
        private int row;
        private int col;

        public ButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (matrix[row][col] == 0) {
                int selectedOption = JOptionPane.showConfirmDialog(null, "¿Qué barco desea colocar en esta posición?", "Colocar Barco", JOptionPane.DEFAULT_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION) {
                    int selectedShip = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número del barco (1: Portaaviones, 2: Submarino, 3: Destructor, 4: Fragata)"));
                    boolean validPlacement = false;

                    switch (selectedShip) {
                        case 1: // Portaaviones (4 casillas)
                            int carrierOrientation = JOptionPane.showOptionDialog(null, "Seleccione la orientación del portaaviones", "Orientación", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Horizontal", "Vertical"}, null);
                            if (carrierOrientation == JOptionPane.YES_OPTION) { // Horizontal
                                if (canPlaceShip(row, col, 4, true)) {
                                    for (int i = 0; i < 4; i++) {
                                        matrix[row][col + i] = selectedShip;
                                        buttons[row][col + i].setBackground(Color.BLACK);
                                    }
                                    validPlacement = true;
                                }
                            } else { // Vertical
                                if (canPlaceShip(row, col, 4, false)) {
                                    for (int i = 0; i < 4; i++) {
                                        matrix[row + i][col] = selectedShip;
                                        buttons[row + i][col].setBackground(Color.BLACK);
                                    }
                                    validPlacement = true;
                                }
                            }
                            break;
                        case 2: // Submarinos (3 casillas cada uno)
                            int submarines = 2;
                            for (int j = 0; j < submarines; j++) {
                                int submarineOrientation = JOptionPane.showOptionDialog(null, "Seleccione la orientación del submarino " + (j + 1), "Orientación", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Horizontal", "Vertical"}, null);
                                if (submarineOrientation == JOptionPane.YES_OPTION) { // Horizontal
                                    if (canPlaceShip(row, col, 3, true)) {
                                        for (int i = 0; i < 3; i++) {
                                            matrix[row][col + i] = selectedShip;
                                            buttons[row][col + i].setBackground(Color.BLACK);
                                        }
                                        validPlacement = true;
                                        break;
                                    }
                                } else { // Vertical
                                    if (canPlaceShip(row, col, 3, false)) {
                                        for (int i = 0; i < 3; i++) {
                                            matrix[row + i][col] = selectedShip;
                                            buttons[row + i][col].setBackground(Color.BLACK);
                                        }
                                        validPlacement = true;
                                        break;
                                    }
                                }
                            }
                            break;
                        case 3: // Destructores (2 casillas cada uno)
                            int destroyers = 3;
                            for (int j = 0; j < destroyers; j++) {
                                int destroyerOrientation = JOptionPane.showOptionDialog(null, "Seleccione la orientación del destructor " + (j + 1), "Orientación", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Horizontal", "Vertical"}, null);
                                if (destroyerOrientation == JOptionPane.YES_OPTION) { // Horizontal
                                    if (canPlaceShip(row, col, 2, true)) {
                                        for (int i = 0; i < 2; i++) {
                                            matrix[row][col + i] = selectedShip;
                                            buttons[row][col + i].setBackground(Color.BLACK);
                                        }
                                        validPlacement = true;
                                        break;
                                    }
                                } else { // Vertical
                                    if (canPlaceShip(row, col, 2, false)) {
                                        for (int i = 0; i < 2; i++) {
                                            matrix[row + i][col] = selectedShip;
                                            buttons[row + i][col].setBackground(Color.BLACK);
                                        }
                                        validPlacement = true;
                                        break;
                                    }
                                }
                            }
                            break;
                        case 4: // Fragatas (1 casilla cada uno)
                            int frigates = 4;
                            for (int j = 0; j < frigates; j++) {
                                if (canPlaceShip(row, col, 1, true)) {
                                    matrix[row][col] = selectedShip;
                                    buttons[row][col].setBackground(Color.BLACK);
                                    validPlacement = true;
                                    break;
                                }
                            }
                            break;
                        default:
                            break;
                    }

                    if (validPlacement) {
                        displayMatrix();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo colocar el barco en esta posición", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya hay un barco en esta posición", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean canPlaceShip(int row, int col, int length, boolean isHorizontal) {
        if (isHorizontal) {
            for (int i = 0; i < length; i++) {
                if (col + i >= COLS || matrix[row][col + i] != 0) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (row + i >= ROWS || matrix[row + i][col] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }
}
