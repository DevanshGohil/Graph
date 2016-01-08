
public class Edge implements Comparable<Edge>{
	Node n1,n2;
	int weight;
	String type;
	boolean directed;
	Edge(Node n1,Node n2,int weight,boolean b){
		this.n1=n1;
		this.n2=n2;
		directed=b;
	}
	
	public void setType(String t){
		this.type=t;
	}
	
	public int compareTo(Edge e) {
		if(this.weight<e.weight)
			return -1;
		else if(this.weight==e.weight)
			return 0;
		else
			return 1;
	}
}
