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
}
