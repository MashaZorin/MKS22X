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

    public void add(String s){
	if (size + 1 == heap.length){
	    doubleSize();
	}
	heap[size + 1] = s;
	int index = size + 1;
	if (max){
	    while (index > 1 && heap[index].compareTo(heap[index / 2]) > 0){
		pushDown(index);
		index = index / 2;
	    }
	}
	else{
	    while (index > 1 && heap[index].compareTo(heap[index / 2]) < 0){
		pushDown(index);
		index = index / 2;
	    }
	}
	size ++;
    }

    public String remove(){
	String old = heap[1];
	heap[1] = heap[size];
	heap[size] = null;
	size --;
	while (index * 2 <= size){
	    index = pushUp(index);
	}
	return old;
    }

    public String peek(){
	return heap[i];
    }

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
	int temp = heap[index];
	heap[index] = heap[index / 2];
	heap[index / 2] = temp;
    }

    private void doubleSize(){
	String[] temp = new String[heap.length * 2];
	for (int i = 1; i < size; i ++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }

    public String toString(){
	String str = "";
	for (int i = 1; i < size; i = i * 2){
	    for (j = i; j < i * 2; j ++){
		str += heap[j] + " ";
	    }
	    str += "\n";
	}
	return str;
    }
}
