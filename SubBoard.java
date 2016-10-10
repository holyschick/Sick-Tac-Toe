/**
 * The Board class models the game-board.
 */
public class SubBoard {  // save as Board.java
    // Named-constants for the dimensions
    public static final int ROWS = 3;
    public static final int COLS = 3;

    // package access
    Square[][] minor;  // a board composed of ROWS-by-COLS Strings
    
    private String winner;

    /** Constructor to initialize the game board as empty*/
    public SubBoard() {
        // sets each square to "EMPTY"
        myBoard = new Square[ROWS][COLS];
        for(int i = 0; i < myBoard.length; i++){
            for(int j = 0; j < myBoard[0].length; j++){
                myBoard[i][j] = new Square();
            }
        }
    }

    /** Initialize (or re-initialize) the contents of the game board */
    public void init() {
        // sets each square to "EMPTY"
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                myBoard[i][j] = new Square();
            }
        }
    }

    /** Return true if it is a tie game (i.e., no more EMPTY square) */
    public boolean isTieGame() {
        // if an empty square is found,not a tie yet, so exit
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(myBoard[i][j].get().equals("EMPTY")){
                    return false;
                }
            }
        }
        // no empty square, it's a tie game
        return true;
    }

    /** Return true if the player with "nextToken" has won after placing at
    (currentRow, currentCol) */
    public boolean hasWon(String nextToken,int currentRow,int currentCol) 
    {
        // 3-in-the-row
        // 3-in-the-column
        // 3-in-the-diagonal
        // 3-in-the-opposite-diagonal
        int count = 0;
        for(int j = 0; j < COLS; j++){
            if(myBoard[currentRow][j].get().equals(nextToken)){
                count++;
                if(count == 3){
                    winner = nextToken;
                    return true;
                }
            }
        }
        count = 0;
        for(int i = 0; i < ROWS; i++){
            if(myBoard[i][currentCol].get().equals(nextToken)){
                count++;
                if(count == 3){
                    winner = nextToken;
                    return true;
                }
            }
        }
        if(currentRow == currentCol){
            count = 0;
            int i = 0;
            for(int j = 0; j < COLS; j++){
                if(myBoard[i][j].get().equals(nextToken)){
                    count++;
                    if(count == 3){
                        winner = nextToken;
                        return true;
                    }
                }
                i++;
            }
        }
        if(currentRow+currentCol == 2){
            count = 0;
            int i = 2;
            for(int j = 0; j < COLS; j++){
                if(myBoard[i][j].get().equals(nextToken)){
                    count++;
                    if(count == 3){
                        winner = nextToken;
                        return true;
                    }
                }
                i--;
            }
        }
        return false;
    }

    /** Paint entire board to console window */
    public void paint() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                myBoard[row][col].paint();   // each square paints itself
                if (col < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("-----------");
            }
        }
    }
    
    public String get(){
        return winner;
    }
}
