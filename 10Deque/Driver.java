import java.util.*;
public class Driver{
    public static void main(String[]args){
	MyDeque queue = new MyDeque();
	//test exceptions for remove and get
	try{
	    queue.removeFirst();
	}
	catch(NoSuchElementException e){
	    System.out.println("Passed NoSuchElement Exception for removeFirst");
	}
	try{
	    queue.removeLast();
	}
	catch(NoSuchElementException e){
	    System.out.println("Passed NoSuchElement Exception for removeLast");
	}
	try{
	    queue.getFirst();
	}
	catch(NoSuchElementException e){
	    System.out.println("Passed NoSuchElement Exception for getFirst");
	}
	try{
	    queue.getLast();
	}
	catch(NoSuchElementException e){
	    System.out.println("Passed NoSuchElement Exception for getLast");
	}
	//test add first
	queue.addFirst("a");
	queue.addFirst("b");
	queue.addFirst("c");
	System.out.println(queue);
	try{
	    queue.addFirst(null);
	}
	catch(NullPointerException e){
	    System.out.println("Passed NullPointerException");
	}

	//test add last
	queue.addLast("d");
	queue.addLast("e");
	queue.addLast("f");
	queue.addLast("g");
	queue.addLast("h");
	queue.addLast("i");
	queue.addLast("j");
	//to test double ary (reached the max of original ary length:
	queue.addLast("k");
	System.out.println(queue);
	try{
	    queue.addLast(null);
	}
	catch(NullPointerException e){
	    System.out.println("Pass NullPointerException");
	}

	//test remove first
	System.out.println(queue.removeFirst());
	System.out.println(" should have been 'c'");
	System.out.println(queue);

	//test remove last
	System.out.println(queue.removeLast());
	System.out.println(" should have been 'k'");
	System.out.println(queue);

	//test get first
	System.out.println(queue.getFirst());
	System.out.println(" should have been 'b'");

	//test get las
	System.out.println(queue.getLast());
	System.out.println(" should have been 'j'");
    }
}
