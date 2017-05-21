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
	board.set(start.getRow(), start.getCol(), '.');//is that the right char?
	while (frontier.getSize != 0 && frontier.peek().getDistToGoal() != 0){
	}
    }

    public String toString(){
	return board.toString();
    }
}
