import java.util.Random;

public class Quick{
    public static int quickselect(int[]data, int k){
	int start = 0;
	int end = data.length - 1;
	int index = part(data, start, end);
	System.out.println(index);
	System.out.println(k);
	while (index != k){
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
	//System.out.println(start);
	//System.out.println(end);
	Random rand = new Random();
	int pIndex = rand.nextInt(end - start + 1) + start;
	//System.out.println(pIndex);
	int pivot = data[pIndex];
	int[] newData = new int[end - start + 1];
	int beg = 0;
	int fin = end - start;
	int ans = 0;
	for (int i = start; i <= end; i ++){
	    //System.out.println(i);
	    if (data[i] > pivot){
		newData[fin] = data[i];
		if (i != end){
		    fin --;
		}
		else{
		    ans = fin - 1;
		}
	    }
	    else if (data[i] < pivot){
		newData[beg] = data[i];
		if (i != end){
		    beg ++;
		    //System.out.println("here");
		}
		else{
		    ans = beg + 1;
		}
	    }
	}
	for (int i = 0; i < end - start + 1; i ++){
	    data[start + i] = newData[i];
	}
	printAry(data);
	//System.out.println(beg);
	return ans;
    }

    public static void printAry(int[]ary){
	String str = "";
	for (int i = 0; i < ary.length; i ++){
	    str += (ary[i] + ", ");
	}
	System.out.println(str);
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
