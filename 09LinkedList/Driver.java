public class Driver{
    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	list.add(0, 7);
	System.out.println(list + "\n");
	list.add(1, 5);
	System.out.println(list + "\n");
	list.add(0, 4);
	System.out.println(list + "\n");
	list.add(2, 9);
	System.out.println(list);
    }
}
