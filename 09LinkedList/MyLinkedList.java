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
	for (int i = 0; i < index; i ++){
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
	for (int i = 0; i < index; i ++){
	    current = current.next();
	}
	return current.setValue(newValue);
    }

    public int indexOf(int value){
	LNode current = start;
	int index = 0;
	while (current != null && current.getValue() != value){
	    current = current.next();
	    index ++;
	}
	if (current == null){
	    return -1;
	}
	else{
	    return index;
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
	else if (index == 0){
	    LNode temp = new LNode(value);
	    temp.setNextNode(start);
	    start.setPreNode(temp);
	    start = temp;
	}
	else if (index == size){
	    LNode current = start;
	    for (int i = 0; i < index - 1; i ++){
		current = current.next();
	    }
	    LNode temp = new LNode(value);
	    temp.setPreNode(current);
	    current.setNextNode(temp);
	}
	else{
	    LNode current = start;
	    for (int i = 0; i < index - 1; i ++){
		current = current.next();
	    }
	    LNode temp = new LNode(value);
	    temp.setNextNode(current.next());
	    temp.setPreNode(current);
	    current.setNextNode(temp);
	    current.next().next().setPreNode(temp);
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
	int oldVal = current.getValue();
	if (index == 0){
	    start = current.next();
	}
	if (current.back() != null){
	    current.back().setNextNode(current.next());
	}
	if (current.next() != null){
	    current.next().setPreNode(current.back());
	}
	size --;
	return oldVal;
    }




    public class LNode{
	private int value;
	private LNode before;
	private LNode after;

	public LNode(int v, LNode a, LNode b){
	    value = v;
	    after = a;
	    before = b;
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
