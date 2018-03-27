import java.util.LinkedList;
import java.util.Queue;;
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
		this.adjList[src].add(dest);
		//this.adjList[dest].addFirst(src);
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
	
	public void BFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[this.V];
		
		visited[start] = true;
		queue.add(start);
		
		while (!queue.isEmpty()) {
			int s = queue.poll();
			System.out.print(s + "-->");
			for (int i=0;i<this.adjList[s].size();i++) {
				if (!visited[this.adjList[s].get(i)]) {
					queue.add(this.adjList[s].get(i));
					visited[this.adjList[s].get(i)] = true;
				}	
			}
		}
	}
	
	public void DFShelper(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + "-->");
		for (int i=0;i<this.adjList[vertex].size();i++) {
			if (!visited[this.adjList[vertex].get(i)]) {
				DFShelper(this.adjList[vertex].get(i),visited);
			}	
		}
	}
	
	public void DFS(int start) {
		boolean visited[] = new boolean[this.V];
		DFShelper(start,visited);
	}
	
	//Method to find inward edges
	//Method to find outward edges
	//Method to return subgraph
	
	public static void main(String args[]) {
		Graph graph = new Graph(7);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(0,3);
		graph.addEdge(3,4);
		graph.addEdge(3,5);
		graph.addEdge(4,6);
		graph.addEdge(5,6);
		graph.printGraph();
		//graph.BFS(3);
		graph.DFS(0);
	}
}
