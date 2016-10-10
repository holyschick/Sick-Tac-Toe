import java.awt.Font;
import java.awt.*;
public class Player
{
    // number of squares, ROWS by COLS
    public static final int ROWS = 3;
    public static final int COLS = 3;

    //Named-constants of the various dimensions used for graphics drawing
    public static final int SQUARE_SIZE = 250; // square width and height (square)
    public static final int CANVAS_WIDTH = SQUARE_SIZE * COLS;  // the drawing canvas
    public static final int CANVAS_HEIGHT = SQUARE_SIZE * ROWS;
    public static final int HEADER = 50;

    // Symbols (cross/nought) are displayed inside a square, with this center
    public static final int SQUARE_CENTER = SQUARE_SIZE / 2;

    private String[] gameState = { "PLAYING", "DRAW", "EX_WON", "OH_WON" };
    private String currentState;
    private String status;
    private boolean justClicked;

    public String[] fill = { "EMPTY", "EX", "OH" };
    private String currentPlayer; 

    private Board game;

    public Player(){
        game = new Board();
        status = gameState[0];
    }

    public void paintMajor(){
        // initialize drawing window
        StdDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT+HEADER);
        StdDraw.setXscale(-10, CANVAS_WIDTH+10);  // sets x scale
        StdDraw.setYscale(-10, CANVAS_HEIGHT+HEADER+10);  // sets y scale
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenRadius(0.01);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(CANVAS_WIDTH/3 , 0 , CANVAS_WIDTH/3 ,CANVAS_HEIGHT );
        StdDraw.line(CANVAS_WIDTH*2/3 , 0 , CANVAS_WIDTH*2/3 ,CANVAS_HEIGHT );
        StdDraw.line( 0 , CANVAS_HEIGHT/3 , CANVAS_WIDTH , CANVAS_HEIGHT/3 );
        StdDraw.line( 0 , CANVAS_HEIGHT*2/3 , CANVAS_WIDTH , CANVAS_HEIGHT*2/3 );

        // Draw the contents of all the squares if they are not empty

        Font font = new Font("Arial", Font.BOLD, SQUARE_SIZE/2);
        StdDraw.setFont(font);

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                int x1 = col * SQUARE_SIZE + SQUARE_CENTER;
                int y1 = (2-row) * SQUARE_SIZE + SQUARE_CENTER-HEADER/3;  // invert y scale
                if (game.mega[row][col].get() == fill[1]) 
                {
                    StdDraw.setPenColor(StdDraw.RED);             // red EX
                    StdDraw.text(x1 , y1 , "X");
                } 
                else if (game.mega[row][col].get() == fill[2]) 
                {
                    StdDraw.setPenColor(StdDraw.BLUE);            // blue OH
                    StdDraw.text(x1 , y1 , "O");
                }
                //System.out.println("y1: "+y1);
            }
        }

        // Print status message
        if (currentState == gameState[0]) 
        {
            if (currentPlayer == fill[1])
                status="X's Turn";
            else 
                status="O's Turn";
        }
        else if (currentState == gameState[3])
            status="It's a Draw! Click to play again.";
        else if (currentState == gameState[1])
            status="'X' Won! Click to play again.";
        else if (currentState == gameState[2])
            status="'O' Won! Click to play again.";

        font = new Font("Arial", Font.BOLD, HEADER/2);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(CANVAS_WIDTH/2, CANVAS_HEIGHT + HEADER/2, status);

        StdDraw.show();    

    }

    public void paintMinor(int row, int col){

    }
}
