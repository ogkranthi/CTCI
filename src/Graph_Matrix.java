import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;;
public class Graph_Matrix {
	int V;
	int[][] adjMatrix;
	Graph_Matrix(int v){
		this.V = v;
		this.adjMatrix = new int[v][v];
		
		for (int i=0;i<v;i++)
		{
			this.adjMatrix[i][i] = 0;
		}
	}
	
	//for undirected graph
	public void addEdge(int src, int dest) {
		this.adjMatrix[src][dest] = 1;
		//undirected
		//this.adjMatrix[dest][src] = 1;
	}
	
	public void printGraph() {
		for (int i=0;i<this.V;i++)
		{
			for (int j=0;j<this.V;j++) {
				System.out.print(this.adjMatrix[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public boolean isConnected(int src, int dest) {
		if (this.adjMatrix[src][dest] == 1) return true;
		return false;
	}
	//Method to find inward edges
	//Method to find outward edges
	//Method to return subgraph
	
	public static void main(String args[]) {
		Graph_Matrix graph = new Graph_Matrix(7);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(0,3);
		graph.addEdge(3,4);
		graph.addEdge(3,5);
		graph.addEdge(4,6);
		graph.addEdge(5,6);
		graph.printGraph();
		//graph.BFS(3);
		//graph.DFS(0);
		System.out.print(graph.isConnected(4, 5));
	}
}
