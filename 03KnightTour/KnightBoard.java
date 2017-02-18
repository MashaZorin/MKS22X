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
	    if (isGoodSpot(row, col)){
		board[row][col] = level;
		return solveH(row + 2, col + 1, level + 1) ||
		    solveH(row + 2, col - 1, level + 1) ||
		    solveH(row + 1, col + 2, level + 1) ||
		    solveH(row + 1, col - 2, level + 1) ||
		    solveH(row - 2, col + 1, level + 1) ||
		    solveH(row - 2, col - 1, level + 1) ||
		    solveH(row - 1, col + 2, level + 1) ||
		    solveH(row - 1, col - 2, level + 1);
	    }
	    else{
		return false;
	    }
	}
	else{
	    return true;
	}
    }

    private boolean isGoodSpot(int row, int col){
	return row < board.length &&
	    row >= 0              &&
	    col < board[].length  &&
	    col >= 0              &&
	    board[row][col] == 0;
    }

    public String toString(){
    }
}
