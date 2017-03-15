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
	try{
	    Scanner inf = new Scanner(new File(filename));
	    int rows = inf.nextInt();
	    int cols = inf.nextInt();
	    int time = inf.nextInt();

	    int[][]board = new int[rows][cols];
	    for (int r = 0; r < rows; r ++){
		String line = inf.next();
		for (int c = 0; c < cols; c ++){
		    if (line.charAt(c) == '.'){
			board[r][c] = 0;
		    }
		    else if (line.charAt(c) == '*'){
			board[r][c] = -1;
		    }
		}
	    }
	    int r1 = inf.nextInt() - 1;
	    int c1 = inf.nextInt() - 1;
	    int r2 = inf.nextInt() - 1;
	    int c2 = inf.nextInt() - 1;
	    return numWays(board, r1, c1, r2, c2, time);
	}
	catch(FileNotFoundException e){
	}
	return 0;
    }

    private static int numWays(int[][]ary, int r1, int c1, int r2, int c2, int moves){
	if (r1 >= 0 && r1 < ary.length &&
	    c1 >= 0 && c1 < ary[0].length &&
	    r2 >= 0 && r2 < ary.length &&
	    c2 >= 0 && c2 < ary[0].length){
	    if (ary[r1][c1] == -1 || ary[r2][c2] == -1){
		return 0;
	    }
	    else if (moves == 0){
		if (r1 == r2 && c1 == c2){
		    return 1;
		}
		else{
		    return 0;
		}
	    }
	    else{
		return numWays(ary, r1, c1, r2 + 1, c2    , moves - 1) +
		    numWays(ary, r1, c1, r2 - 1, c2    , moves - 1) +
		    numWays(ary, r1, c1, r2    , c2 + 1, moves - 1) +
		    numWays(ary, r1, c1, r2    , c2 - 1, moves - 1);
	    }
	}
	else{
	    return 0;
	}
    }

    public static void main(String[]args){
	USACO test = new USACO();
	System.out.println(test.bronze("test1.txt"));
	System.out.println(test.silver("silverTest1.txt"));
    }
}
