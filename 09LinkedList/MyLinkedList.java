public class MyLinkedList{
    private LNode start;
    private int size;

    public boolean add(int value){
	add(size - 1, value);
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String str = "";
	LNode current = start;
	while(current != null){
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
	LNode current = start;
	for (int i = 0; i <= index; i ++){
	    current = current.next();
	}
	return current.getValue();
    }

    //has exceptions
    public int set(int index, int newValue){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for (int i = 0; i <= index; i ++){
	    current = current.next();
	}
	return current.setValue(newValue);
    }

    public int indexOf(int value){
	LNode current = start;
	while (current != null && current.getValue() != value){
	    current.next();
	}
	if (current == null){
	    return -1;
	}
	else{
	    return current.getValue();
	}
    }

    //has exceptions
    public void add(int index, int value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for (int i = 0; i <= index; i ++){
	    current = current.next();
	}
	LNode temp = new LNode(value, current.next());
	current.setNode(temp);
    }

    //has exceptions
    public int remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode current = start;
	for (int i = 0; i < index; i ++){
	    current = current.next();
	}
	int oldVal = current.next().getValue();
	LNode temp = current.next().next();
	current.setNode(temp);
	return oldVal;
    }
}
