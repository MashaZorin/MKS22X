public class Merge{
    public static void mergesort(int[]ary){
	if (ary.length > 1){
	    int[]left = new int[ary.length / 2];
	    int[]right = new int[ary.length - ary.length / 2];
	    for (int i = 0; i < ary.length; i ++){
		if (i < ary.length / 2){
		    left[i] = ary[i];
		}
		if (i >= ary.length / 2){
		    right[i - ary.length / 2] = ary[i];
		}
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
    }

    public static void merge(int[]ary1, int[]ary2, int[] merged){
	int i = 0;
	int j = 0;
	while (i < ary1.length && j < ary2.length){
	    if (ary1[i] > ary2[j]){
		merged[i + j] = ary2[j];
		j ++;
	    }
	    else{
		merged[i + j] = ary1[i];
		i ++;
	    }
	}
	if (i == ary1.length){
	    for (int jIndex = j; jIndex < ary2.length; jIndex ++){
		merged[i + jIndex] = ary2[jIndex];
	    }
	}
	else if (j == ary2.length){
	    for (int iIndex = i; iIndex < ary1.length; iIndex ++){
		merged[j + iIndex] = ary1[iIndex];
	    }
	}
    }

    private static void printAry(int[]ary){
	String str = "";
	for (int i = 0; i < ary.length; i ++){
	    str += ary[i] + ", ";
	}
	System.out.println(str);
    }
    
    public static void main(String[]args){
	int[]ary = {2,5,7,3,6,2};
	/*int[]left = {2,5,7};
	int[]right = {2,3,6};
	merge(left, right, ary);*/
	mergesort(ary);
	printAry(ary);
    }
}
