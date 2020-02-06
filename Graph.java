import java.util.*;

public class Graph {
	private int V;
	private int E;
	private Map<Integer, HashSet<Integer>> adjList;

	// constructor a graph represented by adjacency list
	public Graph() {
		V = 0;
		E = 0;
		adjList = new HashMap<Integer, HashSet<Integer>>();
	}

	// return the number of vertices
	public int getV() {
		return V;
	}

	// return the number of edges
	public int getE() {
		return E;
	}

	// return the neighbors of a vertex
	public Set<Integer> adj(int v) {
		return new HashSet<Integer>(adjList.get(v));
	}

	// return vertex set
	public Set<Integer> getVertices() {
		return adjList.keySet();
	}

	// add a vertex
	public void addVertex(int v) {
		if (!adjList.keySet().contains(v)) {
			adjList.put(v, new HashSet<Integer>());
			V++;
		}
	}

	// add an edge from v to w
	public void addEdge(int v, int w) {
		if (adjList.containsKey(v) && adjList.containsKey(w)) {
			if (adjList.get(v).add(w)) {
				E++;
				// System.out.println(v + " "+ w);
				// System.out.println(adjList.get(v));
			}
		}
	}

	// return the copy of the data structure that represents the graph
	public HashMap<Integer, HashSet<Integer>> exportGraph() {
		return new HashMap<Integer, HashSet<Integer>>(adjList);
	}

	// print a graph
	public void print() {
		System.out.println(adjList);
	}
}
