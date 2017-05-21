public class MyHeap{
    private Location[] heap;
    private boolean max; // true is max, min is false
    private int size;
    
    public MyHeap(){
	max = true;
	heap = new Location[1];
	size = 0;
    }

    public MyHeap(boolean m){
	max = m;
	heap = new Location[1];
	size = 0;
    }
    
    public Location peek(){
	if (size > 0){
	    return heap[1];
	}
	else{
	    return "empty heap";
	}
    }


    private void doubleSize(){
	Location[] temp = new Location[heap.length * 2];
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

    public void add(Location s){
	if (size + 1 == heap.length){
	    doubleSize();
	}
	size ++;
	heap[size] = s;
	pushUp();
    }

    public Location remove(){
	Location old = heap[1];
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
	Location temp = heap[index1];
	heap[index1] = heap[index2];
	heap[index2] = temp;
    }
}
