import java.util.*;

public class Ego {
	List<egonet> networks;
	public static class egonet {
		int center; // center of the egonet
		Graph G; // subgraph that represents the egonet

		egonet(int c, Graph g) {
			center = c;
			G = g;
		}

		int getCenter() {
			return center;
		}

		Graph getG() {
			return G;
		}
	}

	public Ego(Graph g) {
		networks = new ArrayList<egonet>();
		for (int i : g.getVertices()) {
			Graph myGraph = new Graph();
			Set<Integer> neighbors = new HashSet<Integer>();
			neighbors.addAll(g.adj(i));
			myGraph.addVertex(i);
			for (int j : neighbors) {
				myGraph.addVertex(j);
				myGraph.addEdge(i, j);
				myGraph.addEdge(j, i);
				for (int k : g.adj(j)) {
					if (neighbors.contains(k)&&!myGraph.adj(j).contains(k)) {
						myGraph.addEdge(j, k);
						myGraph.addEdge(k, j);
					}
				}
			}	
			egonet net = new egonet(i, myGraph);
			networks.add(net);
		}
	}
	class strengthComparator implements Comparator<egonet> { 

		public int compare(egonet first, egonet second) {
			return Integer.compare(second.getG().getE(), first.getG().getE());
		}

	} 
	public List<egonet> top(int k) {
		List<egonet> topList = new ArrayList<egonet>();
		networks.sort(new strengthComparator());
		for (int i=0;i<k;i++) {
			topList.add(networks.get(i));
		}
		return topList;
	}
}
