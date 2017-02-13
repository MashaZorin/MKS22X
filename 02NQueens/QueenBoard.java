public class QueenBoard{
    
    private int[][]board;
    private int solutionCount;

    

    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0; i < size * size; i ++){
	    int r = i % size;
	    int c = i / size;
	    board[c][r] = 0;
	}
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){
	if (col < board.length){
	    for (int row = 0; row < board[0].length; row ++){
		if (board[col][row] == 0){
		    board[col][row] = 1;
		    for (int i = 0; i < board.length * board[0].length; i ++){
			int c = i / board.length;
			int r = i % board.length;
			if (c != col && r == row){
			    board[c][r] -= 1;
			}
			else if (c == col && r != row){
			    board[c][r] -= 1;
			}
			else if (row - r == col - c){
			    board[c][r] -= 1;
			}
		    }
		    if (!solveH(col + 1)){
			board[col][row] = -1;
			for (int i = 0; i < board.length * board[0].length; i ++){
			    int c = i / board.length;
			    int r = i % board.length;
			    if (c != col && r == row){
				board[c][r] += 1;
			    }
			    else if (c == col && r != row){
				board[c][r] += 1;
			    }
			    else if (row - r == col - c && r != row){
				board[c][r] += 1;
			    }
			}
			return solveH(col);
		    }
		    else{
			return true;
		    }
		}
	    }
	    return false;
	}
	else {
	    return true;
	}
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.

     *The board should be reset after this is run.    

     */

    public int getSolutionCount(){
    	return -1;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }
}
