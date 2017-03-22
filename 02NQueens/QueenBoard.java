public class QueenBoard{
    
    private int[][]board;
    private int solutionCount;

    

    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0; i < size * size; i ++){
	    int r = i / size;
	    int c = i % size;
	    board[c][r] = 0;
	}
	solutionCount = -1;
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
    public boolean solve(){
	return solveH(0);
    }

    private boolean solveH(int col){
	if (col < board.length){
	    for (int row = 0; row < board[0].length; row ++){
		if (board[col][row] == 0){
		    board[col][row] = 1;
		    for (int i = 0; i < board.length * board[0].length; i ++){
			int c = i % board.length;
			int r = i / board.length;
			if (c != col || r != row){
			    if (r == row){
				board[c][r] -= 1;
			    }
			    else if (c == col){
				board[c][r] -= 1;
			    }
			    else if (row - r == col - c || r - row == col - c){
				board[c][r] -= 1;
			    }
			}
		    }
		    if (!solveH(col + 1)){
			board[col][row] = 0;
			for (int i = 0; i < board.length * board[0].length; i ++){
			    int c = i % board.length;
			    int r = i / board.length;
			    if (c != col || r != row){
				if (r == row){
				    board[c][r] += 1;
				}
				else if (c == col){
				    board[c][r] += 1;
				}
				else if (row - r == col - c || r - row == col - c){
				    board[c][r] += 1;
				}
			    }
			}
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
    public void countSolutions(){
	countSolutionsH(0);
    }

    public void countSolutionsH(int col){
        if (solutionCount < 0){
	    solutionCount = 0;
	}
	if (col < board.length){
	    for (int row = 0; row < board[0].length; row ++){
		if (board[col][row] == 0){
		    board[col][row] = 1;
		    for (int i = 0; i < board.length * board[0].length; i ++){
			int c = i % board.length;
			int r = i / board.length;
			if (c != col || r != row){
			    if (r == row){
				board[c][r] -= 1;
			    }
			    else if (c == col){
				board[c][r] -= 1;
			    }
			    else if (row - r == col - c || r - row == col - c){
				board[c][r] -= 1;
			    }
			}
		    }
		    countSolutionsH(col + 1);
		    board[col][row] = 0;
		    for (int i = 0; i < board.length * board[0].length; i ++){
			int c = i % board.length;
			int r = i / board.length;
			if (c != col || r != row){
			    if (r == row){
				board[c][r] += 1;
			    }
			    else if (c == col){
				board[c][r] += 1;
			    }
			    else if (row - r == col - c || r - row == col - c){
				board[c][r] += 1;
			    }
			}
		    }
		}
	    }
	}
	else {
	    solutionCount += 1;
	}
    }

    public int getSolutionCount(){
	for (int i = 0; i < board.length * board[0].length; i ++){
	    int r = i / board.length;
	    int c = i % board.length;
	    board[c][r] = 0;
	}
    	return solutionCount;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String boardStr = "";
    	for (int row = 0; row < board[0].length; row ++){
	    for (int col = 0; col < board.length; col ++){
		if (board[col][row] <= 0){
		    boardStr += "_,";
		}
		else{
		    boardStr += "Q, ";
		}
	    }
	    boardStr += "\n";
	}
	return boardStr;
    }
}
