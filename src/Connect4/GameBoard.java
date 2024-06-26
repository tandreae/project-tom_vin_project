package Connect4;

public class GameBoard {
    private Token[][] grid;
    private int rows;
    private int columns;

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Token[rows][columns];
    }

    public boolean playMove(int column, Token token) {
        if (column < 0 || column >= columns) {
            return false; // Invalid column
        }
        for (int row = rows - 1; row >= 0; row--) {
            if (grid[row][column] == null) {
                grid[row][column] = token;
                return true;
            }
        }
        return false; // Column is full
    }

    public boolean checkWin(Token token){
        return checkHorizontalWin(token) || checkVerticalWin(token) || checkDiagonalWin(token);
     }

     // Check for horizontal win
     private boolean checkHorizontalWin(Token token) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == token && grid[row][col + 1] == token && 
                    grid[row][col + 2] == token && grid[row][col + 3] == token) {
                        return true; // horizontal win met
                    }
            }
        }
        return false;
     }

     // Check for vertical win
     private boolean checkVerticalWin(Token token) {
        for (int col = 0; col < col; col++) {
            for (int row = 0; row < row - 3; row++) {
                if (grid[row][col] == token && grid[row + 1][col] == token &&
                    grid[row + 2][col] == token && grid[row + 3][col] == token) {
                        return true; // vertical win met
                    }
            }
        }
        return false;
     }
     private boolean checkDiagonalWin(Token token) {
        // downwards diagonal
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == token && 
                    grid[row + 1][col + 1] == token &&
                    grid[row + 2][col + 2] == token &&
                    grid[row + 3][col + 3] == token) {
                        return true; // downwards diagonal met
            }
        }
     }
     // upwards diagonal
        for (int row = 3; row < rows; row++) {
            for (int col = 0; col < columns - 3; col++) {
                if (grid[row][col] == token &&
                    grid[row - 1][col + 1] == token &&
                    grid[row - 2][col + 2] == token &&
                    grid[row - 3][col + 3] == token) {
                        return true;
                }
            }
        }
        return false;
    }
    // check to see if board is full
    public boolean isFull() {
        for (int col = 0; col < columns; col++) {
            if (grid[0][col] == null) {
                return false; // if empty space in top row, not full
            }
        }
        return true; // no empty spaces, board full
    }
}
    // Add additional methods for isFull, isEmpty, checkWin, checkTie later

    //testing for pushing