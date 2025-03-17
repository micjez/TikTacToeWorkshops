import java.util.Scanner;

public class TicTacToe {
    public static char[][] board = new char[3][3];
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) { // using 3 for board rows
            for (int j = 0; j < 3; j++) { // using 3 for board columns
                board[i][j] = ' ';
            }
        }
        
        char currentPlayer = 'X';  // Starting player
        int moveCount = 0;         // Count of moves made
        
        while (true) {
            System.out.println("Current Board:");
            for (int i = 0; i < 3; i++) {
                System.out.print("|");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + "|");
                }
                System.out.println();
            }
            
            // Get player input
            System.out.println("Player " + currentPlayer + ", enter your move (row and column from 0 to 2): ");
            int row = scanner.nextInt();  // no error checking for non-integer input
            int col = scanner.nextInt();
            
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move, try again.");
                continue;
            }
            
            // Place the player's move
            board[row][col] = currentPlayer;
            moveCount++;
            
            boolean win = false;
            // Check rows
            if (board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer)
                win = true;
            if (board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer)
                win = true;
            if (board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer)
                win = true;
            // Check columns
            if (board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer)
                win = true;
            if (board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer)
                win = true;
            if (board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer)
                win = true;
            // Check diagonals
            if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
                win = true;
            if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
                win = true;
            
            if (win) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            
            // If all 9 moves are done and no win, it's a draw
            if (moveCount == 9) { // magic number: total moves
                System.out.println("It's a draw!");
                break;
            }
            
            // Switch player using a basic if-else
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        }
        
        scanner.close();
    }
}
