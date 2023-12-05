import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private JButton[][] buttons; // 2D array to store the buttons in the grid
    private char currentPlayer; // variable to keep track of the current Player ('X' or 'O')

    // Constructor to initialize the UI
    public TicTacToeGUI() {
        buttons = new JButton[3][3]; // Create a 3X3 grid of buttons
        currentPlayer = 'X'; // Player 'X' starts

        initializeUI(); // Call the method to set up the UI
    }

    // Method to set up the initial UI
    private void initializeUI() {
        setTitle("Tic Tak Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3)); // Use a 3X3 grid layout for the buttons

        // Create buttons set their appearance and add action listeners
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" "); // Create a new buttons
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50)); // Set button font
                buttons[i][j].setFocusPainted(false); // Remove the focus border
                buttons[i][j].addActionListener(new ButtonClickListener()); // Add Action Listener
                add(buttons[i][j]); // Add the button to the JFrame
            }
        }

        pack(); // Pack the components tightly together
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true); // Make the JFrame Visible
    }

    // ActionListener for buttons clicks
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource(); // Get the clicked button

            // Check if the clicked button is empty
            if (clickedButton.getText().equals("")) {
                clickedButton.setText(String.valueOf(currentPlayer)); // Set the text of the button to the current
                                                                      // player

                // check for a win or a tie
                if (checkWin()) {
                    JOptionPane.showMessageDialog(null, "Player" + currentPlayer + "Wins!"); // Show a message dialog
                    resetGame(); // Reset the game
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "It's a Tie"); // Show a message dialog
                    resetGame(); // Reset the game
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch to the other player
                }
            }
        }
    }

    // Method to check for a win
    private boolean checkWin() {
        // check rows and columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer))
                    && buttons[i][1].getText().equals(String.valueOf(currentPlayer))
                    && buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true; // Row win
            }

            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer))
                    && buttons[1][i].getText().equals(String.valueOf(currentPlayer))
                    && buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true; // Diagonal win
        }

        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true; // Diagonal win
        }

        return false; // No win
    }

    // Method to check if the board is full (tie)
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }

    // Method to reset the game
    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(" "); // clear the text of each button
            }
        }
        currentPlayer = 'X'; // Set the starting player to 'X'
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeGUI()); // Create an instance of the game on the event dispatch
                                                              // thread
    }
}