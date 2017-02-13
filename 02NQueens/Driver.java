public class Driver{
    public static void main(String[]args){
	QueenBoard two = new QueenBoard(2);
	QueenBoard three = new QueenBoard(3);
	QueenBoard four = new QueenBoard(4);
	QueenBoard eight = new QueenBoard(8);

	System.out.println(two.solve());
	System.out.println(three.solve());
	System.out.println(four.solve());
	System.out.println(eight.solve());
    }
}
	
