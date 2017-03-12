import java.util.Scanner;

public class USACO{
    public USACO(){}

    public int bronze(String filename){
	try{
	    Scanner inf = new Scanner(new File(filename));
	    int rows = inf.nextInt();
	    int cols = inf.nextInt();
	    int elevation = inf.nextInt();
	    int numInstructions = inf.nextInt();

	    int[][]land = new int[rows][cols];
	    for (int i = 0; i < rows * cols; r ++){
		int r = i / cols;
		int c = i % cols;
		land[r][c] = inf.nextInt();
	    }
	    for (int i = 0; i < numInstructions; i ++){
		int row = inf.nextInt();
		int col = inf.nextInt();
		int lower = inf.nextInt();
		stomp(row, col, lower);
	    }
	    int aggrDepth = 0;
	    for (int i = 0; i < rows * cols; i ++){
		int r = i / cols;
		int c = i % cols;
		if (elevation - land[r][c] > 0){
		    aggrDepth += (elevation - land[r][c]);
		}
	    }
	    return aggrDepth * 72 * 72;
	}
	catch(FileNotFoundException e){
	}
    }

    public int silver(String filename){
    }
}
