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
	    while (index != 1 && heap[index].compareTo(heap[index / 2]) > 0){
		pushDown(index);
		index = index / 2;
	    }
	}
	else{
	    while (index != 1 && heap[index].compareTo(heap[index / 2]) < 0){
		pushDown(index);
		index = index / 2;
	    }
	}
	size ++;
    }

    public String remove(){
	
    }

    public String peek(){
	return heap[i];
    }

    private int pushUp(int index){
	int right
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
}
