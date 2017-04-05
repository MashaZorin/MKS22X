public class MyLinkedList{
    private LNode start;
    private int size;

    public MyLinkedList(){
	size = 0;
    }

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
	    str += current.toString() + "\n";
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
	if (start == null){
	    start = new LNode(value);
	}
	else{
	    LNode current = start;
	    for (int i = 0; i < index; i ++){
		current = current.next();
	    }
	    current
	}
	size ++;
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
	current.setNextNode(temp);
	size --;
	return oldVal;
    }




    public class LNode{
	private int value;
	private LNode before;
	private LNode after;

	public LNode(int v, LNode l){
	    value = v;
	    after = l;
	}

	public LNode(int v){
	    value = v;
	}

	public LNode next(){
	    return after;
	}

	public LNode back(){
	    return before;
	}


	public int getValue(){
	    return value;
	}

	public int setValue(int newVal){
	    int old = value;
	    value = newVal;
	    return old;
	}
    
	public void setNextNode(LNode newNode){
	    after = newNode;
	}

	public void setPreNode(LNode newNode){
	    before = newNode;
	}

	public String toString(){
	    String pre = "";
	    if (before == null){
		pre = "null";
	    }
	    else{
		pre += before.getValue();
	    }
	    String post = "";
	    if (after == null){
		post = "null";
	    }
	    else{
		post += after.getValue();
	    }
	    return pre + ", " + getValue() + ", " + post;
	}
    }
}
