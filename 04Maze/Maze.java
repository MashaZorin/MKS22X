import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
	try{
	    File text = new File(filename);// can be a path"/full/path/to/file.txt" 
	    Scanner inf = new Scanner(text);
	    String data = "";
	    int numRows = 1;
	    int numCols = 1;
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		if (numRows == 1){
		    for (int i = 0; i < line.length(); i ++){
			numCols ++;
		    }
		}
		data += line;
		numRows ++;
	    }
	    maze = new char[numRows][numCols];
	    int E = 0;
	    int S = 0;
	    for (int r = 0; r < numRows - 1; r ++){
		for (int c = 0; c < numCols - 1; c ++){
		    int i = r * (numCols - 1) + c;
		    if (data.charAt(i) == 'E'){
			E ++;
		    }
		    else if (data.charAt(i) == 'S'){
			S ++;
		    }
		    maze[r][c] = data.charAt(i);
		}
	    }
	    if (E != 1 || S != 1){
		throw new IllegalArgumentException();
	    }
	}
	catch(FileNotFoundException e){
	}
	animate = false;
    }

    public void setAnimate(boolean b){

        animate = b;

    }

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void clearTerminal(){

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	    int startx = 0,starty = 0;
	    for (int y = 0; y < maze.length; y ++){
		for (int x = 0; x < maze[0].length; x ++){
		    if (maze[y][x] == 'S'){
			startx = x;
			starty = y;
		    }
		}
	    }
	    //System.out.println

            //Initialize startx and starty with the location of the S. 

            maze[starty][startx] = ' ';//erase the S, and start solving!
            return solve(startx,starty);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int x, int y){
        if(animate){
            System.out.println("\033[2J\033[1;1H" + this);
            wait(20);
        }

        //COMPLETE SOLVE
	if (x < maze[0].length && x >= 0 && y < maze.length && y >= 0){
	    if (maze[y][x] == ' '){
		maze[y][x] = '@';
		System.out.println(maze[y][x]);
		if( solve(x + 1, y    ) ||
		    solve(x - 1, y    ) ||
		    solve(x    , y + 1) ||
		    solve(x    , y - 1)){
		    return true;
		}
		else{
		    maze[y][x] = '.';
		}
	    }
	    else if (maze[y][x] == 'E'){
		return true;
	    }
	    else if (maze[y][x] == '#'){
		return false;
	    }
	}

        return false; //so it compiles
    }

    public String toString(){
	String str = "";
	for (int r = 0; r < maze.length; r ++){
	    for (int c = 0; c < maze[0].length; c ++){
		str += maze[r][c];
	    }
	    str += "\n";
	}
	return str;
    }


}
