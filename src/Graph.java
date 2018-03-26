import java.util.LinkedList;;
public class Graph {
	int V;
	LinkedList<Integer> adjList[];
	Graph(int v){
		this.V = v;
		this.adjList = new LinkedList[v];
		
		for (int i=0;i<v;i++)
		{
			this.adjList[i] = new LinkedList<Integer>();
		}
	}
	
	//for undirected graph
	public void addEdge(int src, int dest) {
		this.adjList[src].addFirst(dest);
		this.adjList[dest].addFirst(src);
	}
	
	public void printGraph() {
		for (int j=0;j<this.V;j++)
		{	System.out.print("Adjacency list for vertex:");
			System.out.print(j);
			for (int element:this.adjList[j]) {
				System.out.print("-->" + element);
			}
			System.out.print("\n");
		}
	}
	
	//Method to find inward edges
	//Method to find outward edges
	//Method to return subgraph
	
	public static void main(String args[]) {
		Graph graph = new Graph(5);
		graph.addEdge(0,1);
		graph.addEdge(0,4);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(1,4);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.printGraph();
	}
}
