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

    public LNode(){
	value = 0;
	node = null;
    }
}
