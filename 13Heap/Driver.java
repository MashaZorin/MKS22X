public class Driver{
    public static void main(String[]args){
	MyHeap maxHeap = new MyHeap(true);
	MyHeap minHeap = new MyHeap(false);
	MyHeap defHeap = new MyHeap();
	
	//tests edge case of peek
	System.out.println(maxHeap.peek());
	System.out.println(minHeap.peek());
	System.out.println(defHeap.peek());

	//test add for maxheap
	maxHeap.add("hi");
	System.out.println(maxHeap);
	maxHeap.add("hello");
	System.out.println(maxHeap);
	maxHeap.add("helloworld");
	System.out.println(maxHeap);
	maxHeap.add("die");
	System.out.println(maxHeap);
	maxHeap.add("love");
	System.out.println(maxHeap);

	//test add for minheap
	minHeap.add("hi");
	System.out.println(minHeap);
	minHeap.add("hello");
	System.out.println(minHeap);
	minHeap.add("helloworld");
	System.out.println(minHeap);
	minHeap.add("die");
	System.out.println(minHeap);
	minHeap.add("love");
	System.out.println(minHeap);

	//test remove for maxheap
	System.out.println(maxHeap);
	System.out.println(maxHeap.remove() + "\n");
	System.out.println(maxHeap);
	System.out.println(maxHeap.remove() + "\n");
	System.out.println(maxHeap);

	//test remove for minheap
	System.out.println(minHeap);
	System.out.println(minHeap.remove() + "\n");
	System.out.println(minHeap);
	System.out.println(minHeap.remove() + "\n");
	System.out.println(minHeap);

	//other tests for peek
	System.out.println(maxHeap.peek());
	System.out.println(minHeap.peek());

    }
}
