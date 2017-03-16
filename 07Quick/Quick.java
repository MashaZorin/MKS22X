import java.util.Random;

public class Quick{
    public static int quickselect(int[]data, int k){
	int start = 0;
	int end = data.length - 1;
	int index = part(data, start, end);
	while (index != k){
	    System.out.println(part(data, start, end));
	    if (k < index){
		end = index - 1;
	    }
	    else{
		start = index + 1;
	    }
	    index = part(data, start, end);
	}
	return data[k];
    }

    public static int part(int[]data, int start, int end){
	Random rand = new Random();
	int pIndex = rand.nextInt(end - start + 1) + start;
	System.out.println(pIndex);
	int pivot = data[pIndex];
	int[] newData = new int[end - start + 1];
	int beg = 0;
	int fin = end - start;
	for (int i = start; i <= end; i ++){
	    if (data[i] > pivot){
		newData[fin] = data[i];
		if (i != end){
		    fin --;
		}
	    }
	    else if (data[i] < pivot){
		newData[beg] = data[i];
		if (i != end){
		    beg ++;
		    System.out.println("here");
		}
	    }
	}
	for (int i = 0; i < end - start + 1; i ++){
	    data[start + i] = newData[i];
	}
	//System.out.println(beg);
	return beg + 1 + start;
    }

    public static void main(String[]args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect( ary , 0 ));// would return 0
	System.out.println(quickselect( ary , 1 ));//  would return 2
	System.out.println(quickselect( ary , 2 ));//  would return 5
	System.out.println(quickselect( ary , 3 ));//  would return 10
	System.out.println(quickselect( ary , 4 ));//  would return 15
	System.out.println(quickselect( ary , 5 ));//  would return 23
	
	//System.out.println(part(ary, 2, 5));
    }
}
