package myProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BattleShipGame extends JFrame {
    private final int ROWS = 10;
    private final int COLS = 10;
    private int[][] opponentBoard;
    private JButton[][] opponentButtons;
    private Map<Integer, Integer> shipCounts;

    public BattleShipGame() {
        opponentBoard = new int[ROWS][COLS];
        opponentButtons = new JButton[ROWS][COLS];
        shipCounts = new HashMap<>();
        initializeOpponentBoard();

        setTitle("Battle Ship Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        GridLayout layout1 = new GridLayout(ROWS + 1, COLS + 1); // +1 para la numeración
        panel1.setLayout(layout1);
        panel1.setPreferredSize(new Dimension(450, 450));
        panel1.setBackground(new Color(79, 192, 201));

        panel1.add(new JLabel("")); // Celda vacía en la esquina superior izquierda

        // Agregar etiquetas de columna (letras)
        for (char c = 'A'; c <= 'J'; c++) {
            JLabel label = new JLabel(Character.toString(c));
            label.setHorizontalAlignment(JLabel.CENTER);
            panel1.add(label);
        }

        // Agregar etiquetas de fila (números)
        for (int i = 0; i < ROWS; i++) {
            JLabel label = new JLabel(Integer.toString(i + 1));
            label.setHorizontalAlignment(JLabel.CENTER);
            panel1.add(label);

            for (int j = 0; j < COLS; j++) {
                JButton button = createButton();
                panel1.add(button);
                opponentButtons[i][j] = button;

                int row = i;
                int col = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (opponentBoard[row][col] != 0) {
                            markHit(row, col);
                        } else {
                            markMiss(row, col);
                        }
                    }
                });
            }
        }

        add(panel1);
        setVisible(true);

        generateRandomBoard();
    }

    private void initializeOpponentBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                opponentBoard[i][j] = 0;
            }
        }
    }

    private JButton createButton() {
        JButton button = new JButton();
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setBackground(new Color(15, 96, 141));
        return button;
    }

    private void generateRandomBoard() {
        shipCounts.put(1, 1); // Portaaviones (4 casillas)
        shipCounts.put(2, 2); // Submarinos (3 casillas cada uno)
        shipCounts.put(3, 3); // Destructores (2 casillas cada uno)
        shipCounts.put(4, 4); // Fragatas (1 casilla cada uno)

        for (int shipType = 1; shipType <= 4; shipType++) {
            int shipCount = shipCounts.get(shipType);
            for (int count = 0; count < shipCount; count++) {
                int length = getShipLength(shipType);
                placeShipRandomly(shipType, length);
            }
        }
    }

    private int getShipLength(int shipType) {
        switch (shipType) {
            case 1: // Portaaviones
                return 4;
            case 2: // Submarinos
                return 3;
            case 3: // Destructores
                return 2;
            case 4: // Fragatas
                return 1;
            default:
                return 0;
        }
    }

    private void placeShipRandomly(int shipType, int length) {
        Random random = new Random();
        boolean isHorizontal = random.nextBoolean();
        int row, col;

        do {
            if (isHorizontal) {
                row = random.nextInt(ROWS);
                col = random.nextInt(COLS - length + 1);
            } else {
                row = random.nextInt(ROWS - length + 1);
                col = random.nextInt(COLS);
            }
        } while (!isValidPlacement(row, col, length, isHorizontal));

        for (int i = 0; i < length; i++) {
            if (isHorizontal) {
                opponentBoard[row][col + i] = shipType;
            } else {
                opponentBoard[row + i][col] = shipType;
            }
        }
    }

    private boolean isValidPlacement(int row, int col, int length, boolean isHorizontal) {
        if (isHorizontal) {
            for (int i = 0; i < length; i++) {
                if (col + i >= COLS || opponentBoard[row][col + i] != 0) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (row + i >= ROWS || opponentBoard[row + i][col] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void markHit(int row, int col) {
        opponentButtons[row][col].setBackground(Color.YELLOW);
    }

    private void markMiss(int row, int col) {
        opponentButtons[row][col].setBackground(Color.RED);
        opponentButtons[row][col].setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BattleShipGame game = new BattleShipGame();
        });
    }
}
