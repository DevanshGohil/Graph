public class DisjointSet {

	private int parent[];
	private int size[];
	DisjointSet(int n){
		parent=new int[n];
		size=new int[n];
		for(int i=0;i<n;i++){
			parent[i]=i;
			size[i]=1;
		}
	}
	
	public int root(int i){
		while(parent[i]!=i){
			parent[i]=parent[parent[i]];
			i=parent[i];
		}
		return i;
	}
	
	public boolean isConnected(int i,int j){
		return root(i)==root(j);
	}
	
	public void union(int i,int j){
		int ir=root(i);
		int jr=root(j);
		if(ir==jr)return;
		
		if(size[ir]<size[jr]){
			parent[ir]=jr;
			size[jr]+=size[ir];
		}else{
			parent[jr]=ir;
			size[ir]+=size[jr];
		}
	}
	
	public void print(){
		for(int i=0;i<parent.length;i++){
			System.out.print(parent[i]+" ");
		}
		System.out.println();
	}
	
}
