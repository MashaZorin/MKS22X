public class FrontierPriorityQueue implements Frontier{
    private MyHeap frontier;
    private int size;
    
    //Write own priority queue code - 
    //add will add the Location and put it correct place in queue
    //next will get the next location and remove it from queue
    //instance variables:
    //heap

    public FrontierPriorityQueue(){
	frontier = new MyHeap(false);
	size = 0;
    }

    public void add(Location l){
	frontier.add(l);
	size ++;
    }

    public Location next(){
	return frontier.remove();
	size --;
    }

    public Location peek(){
	return frontier.peek();
    }

    public int getSize(){
	return size;
    }
}
