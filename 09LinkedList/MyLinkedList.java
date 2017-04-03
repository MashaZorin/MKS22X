public class MyLinkedList{
    private LNode start;
    private int size;

    public boolean add(int value){
    }

    public int size(){
	return size;
    }

    public String toString(){
	String str = "";
	LNode current = start;
	while(current.hasMoreNodes()){
	    str += current.getValue() + " ,";
	    current = current.next();
	}
	return str;
    }

    //has exceptions
    public int get(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}	
    }

    //has exceptions
    public int set(int index, int newValue){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}	
    }

    public int indexOf(int value){
    }

    //has exceptions
    public void add(int index, int value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
    }

    //has exceptions
    public int remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
    }
}
