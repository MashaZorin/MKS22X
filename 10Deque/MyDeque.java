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
    }

    public void addFirst(String str){
    }

    public void addLast(String str){
    }

    public String removeFirst(){
    }

    public String removeLast(){
    }

    public String getFirst(){
    }

    public String getLast(){
    }
}
