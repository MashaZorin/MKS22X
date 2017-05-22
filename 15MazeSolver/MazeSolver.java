public class MazeSolver{
    private Maze board;
    private boolean animate;
    
    public MazeSolver(String filename){
	board = new Maze(filename);
    }

    public MazeSolver(String filename, boolean anim){
	board = new Maze(filename);
	animate = anim;
    }

    public void solve(){
	solve(1);
    }

    public void solve(int style){
	Frontier frontier;
	if (style == 0){
	    //DFS
	}
	else if (style == 1){
	    //BFS
	}
	else if (style == 2){
	    //Best first
	}
	else{
	    //A
	}
	Location start = board.getStart();
	Location end = board.getEnd();
	frontier.add(start);
	board.set(start.getRow(), start.getCol(), '?');//is that the right char?
	while (frontier.getSize != 0 && frontier.peek().getDistToGoal() != 0){
	    Location here = frontier.next();
	    boolean deadEnd = true;
	    int row = here.getRow();
	    int col = here.getCol();
	    //ugly variable calculations
	    int toStartRight = Math.abs(row + 1 - start.getRow()) + Math.abs(col - start.getCol());
	    int toEndRight = Math.abs(row + 1 - end.getRow()) + Math.abs(col - end.getCol());
	    int toStartLeft = Math.abs(row - 1 - start.getRow()) + Math.abs(col - start.getCol());
	    int toEndLeft = Math.abs(row - 1 - end.getRow()) + Math.abs(col - end.getCol());
	    int toStartUp = Math.abs(row - start.getRow()) + Math.abs(col + 1 - start.getCol());
	    int toEndUp = Math.abs(row - end.getRow()) + Math.abs(col + 1 - end.getCol());
	    int toStartDown = Math.abs(row - start.getRow()) + Math.abs(col - 1 - start.getCol());
	    int toEndDown = Math.abs(row - end.getRow()) + Math.abs(col - 1 - end.getCol());
	    //the four spots
	    Location right = new Location(row + 1, col, here, toStartRight, toEndRight, true);
	    Location left = new Location(row - 1, col, here, toStartLeft, toEndLeft, true);
	    Location up = new Location(row, col + 1, here, toStartUp, toEndUp, true);
	    Location down = new Location(row, col - 1, here, toStartDown, toEndDown, true);
	    if (row + 1 < board.getMaxRows && board.get(row + 1, col) == ' '){
		frontier.add(right);
		deadend = false;
	    }
	    if (row - 1 >= 0 && board.get(row - 1, col) == ' '){
		frontier.add(left);
		deadend = false;
	    }
	    if (col + 1 < board.getMaxCols && board.get(row, col + 1) == ' '){
		frontier.add(up);
		deadend = false;
	    }
	    if (col - 1 >= 0 && board.get(row, col - 1) == ' '){
		frontier.add(down);
		deadend = false;
	    }
	    if (deadend){
		board.set(row, col, '.');
		frontier.add(here.getPrevious());
	    }
	}
	if (frontier.peek().getDistToGoal() == 0){
	    Location node = frontier.next();
	    while (node.getRow() != start.getRow() && node.getCol() != start.getCol()){
		board.set(node.getRow(), node.getCol(), '@');
		node = node.getPrevious();
	    }
	    board.set(node.getRow(), node.getCol(), '@');
    }

    public String toString(){
	return board.toString();
    }
}
