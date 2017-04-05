public class Driver{
    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	list.add(0, 7);
	list.add(1, 5);
	list.add(0, 4);
	list.add(2, 3);
	System.out.println(list);
    }
}
