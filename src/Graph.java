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
	
	public boolean isCyclicUtil(int vertex, boolean[] visited, int parent) {
		visited[vertex] = true;
		for (int i=0;i<this.adjList[vertex].size();i++) {
			if (!visited[this.adjList[vertex].get(i)]) {
				if (isCyclicUtil(this.adjList[vertex].get(i),visited,vertex)) {
					return true;
				} 
			} else if (vertex != parent) {
				return true;
			}	
		}	
		return false;
	}
	
	public boolean isCyclic() {
		boolean visited[] = new boolean[this.V];
		for (int j=0;j<this.V;j++) {
			visited[j] = false;
		}
		for (int i=0;i<this.V;i++) {
			if (!visited[i]) {
				if (isCyclicUtil(i,visited,-1)) return true;
			}
		}
		return false;
	}
	
	//Method to find inward edges
	//Method to find outward edges
	//Method to return subgraph
	
	public static void main(String args[]) {
		Graph graph = new Graph(5);
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		//graph.addEdge(3,1);
		if (graph.isCyclic()) {
			System.out.print("Graph is cyclic");
		} else {
			System.out.print("Graph is not cyclic");
		}
	}
}
