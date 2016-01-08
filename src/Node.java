import java.util.ArrayList;

class Node{
	
	private int id;
	ArrayList<Node> con;
	ArrayList<Integer> weight;
	long dis=Integer.MAX_VALUE;
	String color="white";
	
	Node(int i){
		setId(i);
		con=new ArrayList<Node>();
		weight=new ArrayList<Integer>();
	}
	
	public void addCon(Node e,int w) {
		con.add(e);
		weight.add(w);
	}
	
	public int compareTo(Node node) {
		if(this.dis<node.dis)
			return -1;
		else if(this.dis==node.dis)
			return 0;
		else
			return 1;
	}
	
	public void setkey(long key) {
		this.dis=key;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}