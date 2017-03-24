public class Quick{
    public static void quicksort(int[]ary){
	if (ary.length > 0){
	    int lo = 0;
	    int hi = ary.length - 1;
	    quickSortH(ary, lo, hi);
	}
    }

    private static void quickSortH(int[]ary, int lo, int hi){
	int pivot = ary[lo];
	int lt = lo;
	int gt = hi;
	int i = lt;
	while (i <= gt){
	    if (ary[i] < pivot){
		swap(ary, i, lt);
		lt ++;
		i ++;
	    }
	    else if (ary[i] > pivot){
		swap(ary, i, gt);
		gt --;
	    }
	    else{
		i ++;
	    }
	}
	if (lt > lo + 1){
	    quickSortH(ary, lo, lt - 1);
	}
	if (hi > gt + 1){
	    quickSortH(ary, gt + 1, hi);
	}
    }

    private static void swap(int[]ary, int i, int j){
	int temp = ary[i];
	ary[i] = ary[j];
	ary[j] = temp;
    }

    public static int quickselect(int[]ary, int k){
	quicksort(ary);
	return ary[k];
    }
}
