public class MyHeap{
    private String[] heap;
    private boolean max; // true is max, min is false
    private int size;
    
    public MyHeap(){
	max = true;
	heap = new String[1];
	size = 0;
    }

    public MyHeap(boolean m){
	max = m;
	heap = new String[1];
	size = 0;
    }

    /*
    public void add(String s){
	if (size + 1 == heap.length){
	    doubleSize();
	}
	heap[size + 1] = s;
	int index = size + 1;
	System.out.println(index);
	System.out.println(index / 2);
	System.out.println(heap[index / 2]);
	if (max){
	    while (index > 1 && heap[index].compareTo(heap[index / 2]) > 0){
		pushDown(index);
		index = index / 2;
		System.out.println(index);
	    }
	}
	else{
	    while (index > 1 && heap[index].compareTo(heap[index / 2]) < 0){
		pushDown(index);
		index = index / 2;
	    }
	}
	System.out.println(this);
	size ++;
    }

    public String remove(){
	String old = heap[1];
	heap[1] = heap[size];
	heap[size] = null;
	size --;
	int index = 1;
	while (index * 2 <= size){
	    index = pushUp(index);
	}
	return old;
    }
    */
    
    public String peek(){
	if (size > 0){
	    return heap[1];
	}
	else{
	    return "empty heap";
	}
    }

    /*
    private int pushUp(int index){
	int left = index * 2;
	int right = left + 1;
	if (left < size){
	    if (right < size){
		if (max){
		    if (heap[left].compareTo(heap[right]) > 0){
			String temp = heap[left];
			heap[left] = heap[index];
			heap[index] = temp;
			return left;
		    }
		    else{
			String temp = heap[right];
			heap[right] = heap[index];
			heap[index] = temp;
			return right;
		    }
		}
		else{
		    if (heap[left].compareTo(heap[right]) < 0){
			String temp = heap[left];
			heap[left] = heap[index];
			heap[index] = temp;
			return left;
		    }
		    else{
			String temp = heap[right];
			heap[right] = heap[index];
			heap[index] = temp;
			return right;
		    }
		}
	    }
	    else{
		String temp = heap[left];
		heap[left] = heap[index];
		heap[index] = temp;
		return left;
	    }
	}
	return size;
    }

    private void pushDown(int index){
	String temp = heap[index];
	heap[index] = heap[index / 2];
	heap[index / 2] = temp;
    }
    */

    private void doubleSize(){
	String[] temp = new String[heap.length * 2];
	for (int i = 1; i <= size; i ++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }

    public String toString(){
	String str = "";
	for (int i = 1; i <= size; i = i * 2){
	    for (int j = i; j < i * 2; j ++){
		str += heap[j] + " ";
	    }
	    str += "\n";
	}
	return str;
    }

    //retry of add, remove, pushUp, and pushDown
    //add uses pushUp, remove uses pushDown
    //pushUp checks parent
    //pushDown checks children

    public void add(String s){
	if (size + 1 == heap.length){
	    doubleSize();
	}
	size ++;
	heap[size] = s;
	pushUp();
    }

    public String remove(){
	String old = heap[1];
	heap[1] = heap[size];
	heap[size] = null;
	size --;
	pushDown();
	return old;
    }

    private void pushUp(){
	int parent;
	for (int index = size; index > 1; index = index / 2){
	    parent = index / 2;
	    if (max){
		if (heap[parent].compareTo(heap[index]) < 0){
		    swap(parent, index);
		}
		else{
		    index = 1;
		}
	    }
	    else{
		if (heap[parent].compareTo(heap[index]) > 0){
		    swap(parent, index);
		}
		else{
		    index = 1;
		}
	    }
	}
    }

    private void pushDown(){
	int index = 1;
	int right;
	int left;
	while (index * 2 < size){
	    right = index * 2 + 1;
	    left = index * 2;
	    if (max){
		if (heap[right].compareTo(heap[left]) > 0){
		    if (heap[right].compareTo(heap[index]) > 0){
			swap(right, index);
			index = right;
		    }
		    else{
			index = size;
		    }
		}
		else{
		    if (heap[left].compareTo(heap[index]) > 0){
			swap(left , index);
			index = left;
		    }
		    else{
			index = size;
		    }
		}
	    }
	    else{
		if (heap[right].compareTo(heap[left]) < 0){
		    if (heap[right].compareTo(heap[index]) < 0){
			swap(right, index);
			index = right;
		    }
		    else{
			index = size;
		    }
		}
		else{
		    if (heap[left].compareTo(heap[index]) < 0){
			swap(left , index);
			index = left;
		    }
		    else{
			index = size;
		    }
		}
	    }
	}
	if (index * 2 == size){
	    if (max && heap[index * 2].compareTo(heap[index]) > 0){
		swap(index * 2, index);
	    }
	    else if (!max && heap[index * 2].compareTo(heap[index]) < 0){
		swap(index * 2, index);
	    }
	}
    }

    //precondition: index1 and index2 are in bounds
    private void swap(int index1, int index2){
	String temp = heap[index1];
	heap[index1] = heap[index2];
	heap[index2] = temp;
    }
}
