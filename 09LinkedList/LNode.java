public class LNode{
    private int value;
    private LNode node;

    public LNode(int v, LNode l){
	value = v;
	node = l;
    }

    public LNode(int v){
	value = v;
	node = null;
    }

    public LNode next(){
	this = node;
	return this;
    }

    public boolean hasMoreNodes(){
	return this != null;
    }

    public int getValue(){
	return value;
    }
}
