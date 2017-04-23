import java.util.*;
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

    private static int mod(int num, int div){
	if (num >= 0){
	    return num % div;
	}
	else{
	    return num % div + div;
	}
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
	    front = mod(front - 1, ary.length);
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
	back = mod(back + 1,  ary.length);
	size ++;
    }

    public String removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String old = ary[front];
	ary[front] = null;
	front = mod(front + 1, ary.length);
	size --;
	return old;
    }

    public String removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	String old = ary[back - 1];
	ary[mod(back - 1, ary.length)] = null;
	back = mod(back - 1, ary.length);
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
	return ary[mod(back - 1, ary.length)];
    }

    public String toString(){
	String str = "";
	if (size != 0){
	    if (front < back){
		for (int i = front; i < back; i ++){
		    str += ary[i] + ", ";
		}
	    }
	    else{
		for (int i = front; i < ary.length; i ++){
		    str += ary[i] + ", ";
		}
		for (int i = 0; i < back; i ++){
		    str += ary[i] + ", ";
		}
	    }
	}
	return str;
    }
}
