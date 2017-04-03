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
	return node;
    }


    public int getValue(){
	return value;
    }

    public int setValue(int newVal){
	int old = value;
	value = newVal;
	return old;
    }
    
    public void setNode(LNode newNode){
	node = newNode;
    }
}
