public class KnightBoard{
    private int[][] board;
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for (int i = 0; i < startingRows * startingCols; i ++){
	    int r = i / startingRows;
	    int c = i % startingCols;
	    board[r][c] = 0;
	}
    }

    public void solve(){
    }

    private boolean solveH(int row ,int col, int level){
	if (level < board.length * board.length[0]){
	    if (row < board.length && col < board.length[0] && row >= 0 && col >= 0){
		if (level == 1){
		    board[row][col] = level;
		    return solveH(row, col, level + 1);
		}
		else{
		    if 
		}
	    }
	}
	else{
	    return true;
	}
    }

    private boolean findNextSpot(int row, int col){
	return row + 2 < board.length && col - 1 < board[0].length && board[row + 2][col - 1] == 0 ||
	    row + 2 < board.length && col + 1 < board[0].length && board[row + 2][col + 1] == 0 ||
	    row - 2 < board.length && col - 1 < board[0].length && board[row - 2][col - 1] == 0 ||
	    row - 2 < board.length && col + 1 < board[0].length && board[row - 2][col + 1] == 0 ||
	    row + 1 < board.length && col - 2 < board[0].length && board[row + 1][col - 2] == 0 ||
	    row + 1 < board.length && col + 2 < board[0].length && board[row + 1][col + 2] == 0 ||
	    row - 1 < board.length && col - 2 < board[0].length && board[row - 1][col - 2] == 0 ||
	    row - 1 < board.length && col + 2 < board[0].length && board[row - 1][col + 2] == 0;
    }

    public String toString(){
    }
}
