public class MinHeap{
	
	Node[] arr;
	int size;
	
	MinHeap(Node[] temp){
		arr=new Node[10000];
		for(int i=0;i<temp.length;i++){
			arr[i]=temp[i];
		}
		size=temp.length;
		build_Heap();
	}
	
	MinHeap(){
		arr=new Node[10000];
		size=10000;
	}

	public int left_child(int i){
		return 2*i+1;
	}
	
	public int right_child(int i){
		return 2*i+2;
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public void build_Heap() {
		for(int i=size/2;i>=0;i--){
			this.heapify(i);
		}
	}

	public void heapify(int i) {
		int min;
		int l=this.left_child(i);
		int r=this.right_child(i);
		
		if(l<size && arr[l].compareTo(arr[i])==-1){
			min=l;
		}else{
			min=i;
		}
		if(r<size && arr[r].compareTo(arr[min])==-1){
			min=r;
		}
		
		if(min!=i){
			exchange(i,min);
			this.heapify(min);
		}
	}
	
	public Node extract_min(){
		if(this.size<1){
			System.out.println("Heap Underflow");
			return null;
		}
		Node min=arr[0];
		exchange(0,size-1);
		size--;
		this.heapify(0);
		return min;
	}

	public void decrease_key(int i,long key){
		if(arr[i].dis<key){
			System.out.println("already low key");
			return;
		}
		
		arr[i].setkey(key);
		level_up(i);
	}
	
	public void insert(Node d){
		if(this.size==10000){
			System.out.println("Heap overflow");
			return;
		}
		
		arr[size]=d;
		size++;
		this.level_up(size-1);
	}
	
	private void level_up(int i) {
		while(i>0 && arr[parent(i)].compareTo(arr[i])==1){
			this.exchange(parent(i), i);
			i=this.parent(i);
		}
	}

	private void exchange(int min, int i) {
		// TODO Auto-generated method stub
		Node temp=arr[min];
		arr[min]=arr[i];
		arr[i]=temp;
	}
	
	public void print(){
		for(int i=0;i<this.size;i++){
			System.out.print(arr[i].dis+" ");
		}
		System.out.println();
	}

	public int getIndex(Node node) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++){
			if(arr[i].getId()==node.getId())
				return i;
		}
		return -1;
	}
}