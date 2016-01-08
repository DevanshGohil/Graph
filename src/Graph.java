import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//-------------------prims baki----------------

public class Graph {

	Node[] list;
	String type;
	private ArrayList<Edge> edges;
	private int last=0;
	
	//-------------constructor----------------
	Graph(int n,int m,String type){
		this.type=type;
		this.type=this.type.toLowerCase();
		list=new Node[n];
		for(int i=0;i<n;i++){
			list[i]=new Node(i);
		}
		edges=new ArrayList<Edge>();
	}
	
	//-----------add edge in graph--------------
	public void addEdge(int d,int e,int w){
		boolean b;
		if(this.type.equals("undirected")){
			list[d].addCon(list[e],w);
			list[e].addCon(list[d],w);
			b=false;
		}else{
			list[d].addCon(list[e],w);
			b=true;
		}
		edges.add(new Edge(list[d],list[e],w,b));
	}

	//----------single source shortest path----------
	public void dijkstra(int t){
		Node d=list[t];
		Initialize_Source(d);
		MinHeap p=new MinHeap(list);
		while(p.size!=0){
			Node temp=p.extract_min();
			for(int i=0;i<temp.con.size();i++){
				relax(temp,temp.con.get(i),temp.weight.get(i),p);
			}
		}
	}

	//----------minimum spanning tree----------
	public int krushkal(){
		edges.sort(null);
		int ans=0;
		DisjointSet s=new DisjointSet(list.length);
		for(int i=0;i<edges.size();i++){
			if(!s.isConnected(edges.get(i).n1.getId(),edges.get(i).n2.getId())){
				ans+=edges.get(i).weight;
			}
			s.union(edges.get(i).n1.getId(),edges.get(i).n2.getId());
		}
		return ans;
	}
	
	
	//-----------search tree----------------
	public void bfs(Node start) {
		for(int i=0;i<list.length;i++){
			list[i].color="white";
			list[i].dis=Integer.MAX_VALUE;
		}
		start.color="gray";
		start.dis=0;
		ArrayList<Node> temp=new ArrayList<Node>();
		temp.add(start);
		
		while(!temp.isEmpty()){
			Node u=temp.remove(0);
			for(int i=0;i<u.con.size();i++){
				if(u.con.get(i).color.equals("white")){
					u.con.get(i).color="gray";
					u.con.get(i).dis=u.dis+6;
					temp.add(u.con.get(i));
				}
			}
			u.color="black";
		}
		
		for(int j=0;j<list.length;j++){
			if(start==list[j])
				continue;
			if(list[j].dis==Integer.MAX_VALUE)
				System.out.print(-1+" ");
			else
				System.out.print(list[j].dis+" ");
		}
		System.out.println();
	}
	
	public void dfs(Node start) {
		for(int i=0;i<start.con.size();i++){
			start.con.get(i).color="white";
		}
		
		start.dis=0;
		for(int i=0;i<start.con.size();i++){
			if(start.con.get(i).color.equals("white")){
				dfs_visit(start.con.get(i),start.dis);
			}
		}
		
		for(int j=0;j<list.length;j++){
			if(start==list[j])
				continue;
			if(list[j].dis==Integer.MAX_VALUE)
				System.out.print(-1+" ");
			else
				System.out.print(list[j].dis+" ");
		}
		System.out.println();
	}
	
	//----to see current status of nodes----
	public void print() {
		// TODO Auto-generated method stub
		for(int i=0;i<list.length;i++){
			System.out.print(list[i].dis+" ");
		}
		System.out.println();
	}
	
	//----------sub-routine-----------
	private void dfs_visit(Node node,long dis) {
		// TODO Auto-generated method stub
		node.color="gray";
		node.dis=dis+6;
		for(int i=0;i<node.con.size();i++){
			if(node.con.get(i).color.equals("white")){
				dfs_visit(node.con.get(i),node.dis);
			}
		}
		node.color="black";
	}
	
	private void relax(Node temp, Node node, int w,MinHeap p) {
		// TODO Auto-generated method stub
		if(node.dis>temp.dis+w){
			node.dis=temp.dis+w;
			int i=p.getIndex(node);
			p.decrease_key(i, node.dis);
		}
	}

	private void Initialize_Source(Node d) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.length;i++){
			list[i].dis=Integer.MAX_VALUE;
		}
		d.dis=0;
	}
}
