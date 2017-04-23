public class MyDeque{
    private String[] ary;
    private int front;
    private int back;
    private int size;

    public MyDeque(){
	ary = new String[10];
	front = 0;
	back = 0;
	size = 0;
    }

    private void doubleAry(){
	String[] temp = new String[ary.length * 2];
	for (int i = 0; i < size; i ++){
	    temp[i] = ary[(front + i) % size];
	}
	front = 0;
	back = size;
	ary = temp;
    }

    public void addFirst(String str){
	if (str == null){
	    throw new NullPointerException();
	}
	if (size == ary.length){
	    doubleAry();
	}
	if (size == 0){
	    ary[front] = str;
	    back ++;
	}
	else{
	    front = (front - 1) % ary.length;
	    ary[front] = str;
	}
	size ++;
    }

    public void addLast(String str){
	if (str == null){
	    throw new NullPointerException();
	}
	if (size == ary.length){
	    doubleAry();
	}
	ary[back] = str;
	back = (back + 1) % ary.length;
	size ++;
    }

    public String removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String old = ary[front];
	ary[front] = null;
	front = (front + 1) % ary.length;
	size --;
	return old;
    }

    public String removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String old = ary[back - 1];
	ary[(back - 1) % ary.length] = null;
	back = (back - 1) % ary.length;
	size --;
	return old;
    }

    public String getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return ary[front];
    }

    public String getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return ary[(back - 1) % ary.length];
    }
}
