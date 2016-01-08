import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int m=s.nextInt();
		Graph g=new Graph(n,m,"unDirected");
		for(int i=0;i<m;i++){
			g.addEdge(s.nextInt()-1, s.nextInt()-1, s.nextInt()); //because of 1st indexing
		}
		int source=s.nextInt();
		//g.dijkstra(source);
		System.out.println(g.krushkal());
		//g.print();
	}

}