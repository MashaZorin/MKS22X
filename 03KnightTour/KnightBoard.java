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
	if (row < board.length && col < board.length[0] && row >= 0 && col >= 0){
	    if (level == 1){
		board[row][col] = level;
		return solveH(row, col, level + 1);
	    }
	    else{
		
	    }
	}
    }

    private boolean isGoodSpot(int row, int col){
	return;
    }

    public String toString(){
    }
}
