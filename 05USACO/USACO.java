import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

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
	    for (int i = 0; i < rows * cols; i ++){
		int r = i / cols;
		int c = i % cols;
		land[r][c] = inf.nextInt();
	    }
	    for (int i = 0; i < numInstructions; i ++){
		int row = inf.nextInt();
		int col = inf.nextInt();
		int lower = inf.nextInt();
		stomp(land, row, col, lower);
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
	    System.out.println("File not found");
	}
	return 0;
    }

    private void stomp(int[][]land, int r, int c, int lower){
	int[] spots = {land[r][c    ], land[r + 1][c    ], land[r + 2][c    ],
		       land[r][c + 1], land[r + 1][c + 1], land[r + 2][c + 1],
		       land[r][c + 2], land[r + 1][c + 2], land[r + 2][c + 2]};
	int maxElev = max(spots);
	while (lower > 0){
	    for (int i = 0; i < spots.length; i ++){
		if (spots[i] == maxElev){
		    spots[i] --;
		}
	    }
	    lower --;
	}
    }

    private int max(int[] ary){
	int maxN = 0;
	for (int i = 0; i < ary.length; i ++){
	    if (maxN < ary[i]){
		maxN = ary[i];
	    }
	}
	return maxN;
    }

    //public int silver(String filename){
    //}
}
