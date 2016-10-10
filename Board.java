
public class Board
{
    
    SubBoard[][] board;
    
    private String winner;
    
    public Board(){
        board = new SubBoard[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = new SubBoard();
            }
        }
    }
    
    public void init(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j].init();
            }
        }
    }
    
    public boolean hasWon(String nextToken, int currentRow, int currentCol){
        int count = 0;
        for(int j = 0; j < 3; j++){
            if(board[currentRow][j].hasWon(nextToken, 0, 0) || board[currentRow][j].hasWon(nextToken, 1, 1) || board[currentRow][j].hasWon(nextToken, 2, 2)){
                count++;
                if(count == 3){
                    return true;
                }
            }
        }
        count = 0;
        for(int i = 0; i < 3; i++){
            if(board[i][currentCol].hasWon(nextToken, 0, 0) || board[i][currentCol].hasWon(nextToken, 1, 1) || board[i][currentCol].hasWon(nextToken, 2, 2)){
                count++;
                if(count == 3){
                    return true;
                }
            }
        }
        if(currentRow == currentCol){
            count = 0;
            int i = 0;
            for(int j = 0; j < 3; j++){
                if(board[i][j].hasWon(nextToken, 0, 0) || board[i][j].hasWon(nextToken, 1, 1) || board[i][j].hasWon(nextToken, 2, 2)){
                    count++;
                    if(count == 3){
                        return true;
                    }
                }
                i++;
            }
        }
        if(currentRow + currentCol == 2){
            count = 0;
            int i = 2;
            for(int j = 0; j < 3; j++){
                if(board[i][j].hasWon(nextToken, 0, 0) || board[i][j].hasWon(nextToken, 1, 1) || board[i][j].hasWon(nextToken, 2, 2)){
                    count++;
                    if(count == 3){
                        return true;
                    }
                }
                i--;
            }
        }        
        return false;
    }
    
    

}
