public class RunningMedian{
    private MyHeap min;
    private MyHeap max;
    private int sizeMin;
    private int sizeMax;

    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap(true);
	sizeMin = 0;
	sizeMax = 0;
    }

    //add smaller numbers to maxheap, bigger numbers to minheap
    public void add(int num){
	if (sizeMin + sizeMax == 0){
	    min.add(num);
	    sizeMin ++;
	}
	else{
	    if (min.peek() >= num){
		max.add(num);
		sizeMax ++;
	    }
	    else{
		min.add(num);
		sizeMin ++;
	    }
	}
	if (sizeMin - sizeMax >= 2){
	    max.add(min.remove());
	    sizeMin --;
	    sizeMax ++;
	}
	else if (sizeMax - sizeMin >= 2){
	    min.add(max.remove());
	    sizeMin ++;
	    sizeMax --;
	}
    }

    public int getMedian(){
	if (sizeMin == sizeMax){
	    return (min.peek() + max.peek()) / 2;
	}
	else if (sizeMin > sizeMax){
	    return min.peek();
	}
	else{
	    return max.peek();
	}
    }
}
