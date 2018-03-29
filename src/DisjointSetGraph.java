
public class DisjointSetGraph {
	Edge edges[];
	int E;
	int V;
	
	class Edge{
		int src;
		int dest;
	}
	
	DisjointSetGraph(int E,int V){
		this.E = E;
		this.V = V;
		
		for (int i=0;i<E;i++) {
			this.edges[i] = new Edge();
		}
		
	}
	
	
	public static void main(String args[]) {
		DisjointSetGraph graph = new DisjointSetGraph(3,3);
		graph.edges[0].src = 0;
		graph.edges[0].src = 1;
		graph.edges[1].src = 1;
		graph.edges[1].src = 2;
		graph.edges[2].src = 0;
		graph.edges[2].src = 2;
		
	}
}
