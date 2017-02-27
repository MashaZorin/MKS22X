public class Driver{
    public static void main(String[]args){
	KnightBoard one = new KnightBoard(1, 1);
	KnightBoard three = new KnightBoard(3, 3);
	KnightBoard four = new KnightBoard(4, 4);
	KnightBoard five = new KnightBoard(5, 5);
	KnightBoard six = new KnightBoard(6 ,6);
	KnightBoard eight = new KnightBoard(8 ,8);

	one.solve();
	System.out.println(one);

	three.solve();
	System.out.println(three);

	four.solve();
	System.out.println(four);

	five.solve();
	System.out.println(five);

	six.solve();
	System.out.println(six);

	//eight.solve();
	//System.out.println(eight);
    }
}
