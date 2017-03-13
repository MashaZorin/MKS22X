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
		int row = inf.nextInt() - 1;
		int col = inf.nextInt() - 1;
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

    //for testing
    private static void printAry(int[][]ary){
	String out = "";
	for (int r = 0; r < ary.length; r ++){
	    for (int c = 0; c < ary[0].length; c ++){
		out += ary[r][c] + " ";
	    }
	    out += "\n";
	}
	System.out.println(out);
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
	    maxElev --;
	    lower --;
	}
	land[r    ][c    ] = spots[0];
	land[r + 1][c    ] = spots[1];
	land[r + 2][c    ] = spots[2];
	land[r    ][c + 1] = spots[3];
	land[r + 1][c + 1] = spots[4];
	land[r + 2][c + 1] = spots[5];
	land[r    ][c + 2] = spots[6];
	land[r + 1][c + 2] = spots[7];
	land[r + 2][c + 2] = spots[8];
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

    public int silver(String filename){
    }

    public static void main(String[]args){
	USACO test = new USACO();
	System.out.println(test.bronze("test1.txt"));
    }
}
