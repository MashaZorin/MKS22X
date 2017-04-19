public class Driver{
    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	//test add
	list.add(0, 7);
	System.out.println(list + "\n");
	list.add(1, 5);
	System.out.println(list + "\n");
	list.add(0, 4);
	System.out.println(list + "\n");
	list.add(2, 9);
	System.out.println(list);
	try{
	    list.add(6, 0);
	    System.out.println(list);
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Passed: Index out of bounds: 6\n");
	}

	//test indexOf
	System.out.println(list.indexOf(3));
	System.out.println(list.indexOf(5));

	//test get
	System.out.println(list.get(3));
	try{
	    System.out.println(list.get(4));
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Passed: Index out of bounds: 4\n");
	}

	//test set
	list.set(0, 10);
	list.set(3, 3);
	System.out.println(list);
	try{
	    list.set(9, 0);
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Passed: Index out of bounds: 9\n");
	}

	//test remove
	System.out.println(list.remove(2));
	System.out.println(list);
	System.out.println(list.remove(2));
	System.out.println(list);
	System.out.println(list.remove(0));
	System.out.println(list);
	try{
	    list.remove(2);
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Passed: Index out of bounds: 2\n");
	}
    }
}
