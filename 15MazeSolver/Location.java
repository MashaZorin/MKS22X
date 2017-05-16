public class Location implements Comparable<Location>{
    private int row, col;
    private Location previous;
    private int distToStart;
    private int distToGoal;
    private boolean aStar;

    public Location(int r, int c, Location pre,  int distToBeg, int distToEnd){
	this(r, c, pre, distToBeg, distToEnd, false);
    }  

    public Location(int r, int c, Location pre, int distToBeg, int distToEnd, boolean astar){
	row = r;
	col = c;
	previous = pre;
	distToStart = distToBeg;
	distToGoal = distToEnd;
	aStar = astar;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }
    
    public Location getPrevious(){
	return previous;
    }

    public int getDistToGoal(){
	return distToGoal;
    }

    public int getDistToStart(){
	return distToStart;
    }

    public boolean getAStar(){
	return aStar;
    }

    public int CompareTo(Location other){
	int dist;
	int otherDist;
	if (aStar){
	    dist = distToGoal + distToStart;
	    otherDist = other.getDistToGoal() + other.getDistToStart();
	}
	else{
	    dist = distToGoal;
	    otherDist = other.getDistToGoal();
	}
	if (dist > otherDist){
	    return 1;
	}
	else if (dist == otherDist){
	    return 0;
	}
	else{
	    return -1;
	}
    }
}
