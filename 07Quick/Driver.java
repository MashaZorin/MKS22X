import java.util.Random;
public class Driver{
    public static void printAry(int[]ary){
	String str = "";
	for (int i = 0; i < ary.length; i ++){
	    str +=(ary[i] + ", ");
	}
	System.out.println(str);
    }
    
    public static void main(String[]args){
	Random rand  = new Random();
	for (int i = 0; i < 20; i ++){
	    int[]ary = new int[i];
	    for (int j = 0; j < i; j ++){
		ary[j] = rand.nextInt(50);
	    }
	    Quick.quicksort(ary);
	    printAry(ary);
	}
	int[]ary = {3,3,3,2,6,7,4,1,0,0,9,4,5,8,0,5};
	printAry(ary);
	Quick.quicksort(ary);
	printAry(ary);
	System.out.println(Quick.quickselect(ary, 5));
    }
}
