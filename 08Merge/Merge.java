public class Merge{
    public static void mergesort(int[]ary){
	if (ary.length > 1){
	    int[]left = new int[ary.length / 2];
	    int[]right = new int[ary.length - ary.length / 2];
	    for (int i = 0; i < ary.length; i ++){
		if (i < ary.length /2){
		    left[i] = ary[i];
		}
	}
    }
}
