public class MyHeap{
    private String[] heap;
    private boolean maxOrMin; // true is max, min is false
    private int size;
    
    public MyHeap(){
	maxOrMin = true;
	heap = new String[1];
	size = 0;
    }

    public MyHeap(boolean m){
	maxOrMin = m;
	heap = new String[1];
	size = 0;
    }

    public void add(){
    }

    public String remove(){
    }

    public String peek(){
    }

    private void pushUp(){
    }

    private void pushDown(){
    }

    private void doubleSize(){
	String[] temp = new String[heap.length * 2];
	for (int i = 1; i < size; i ++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }
}
