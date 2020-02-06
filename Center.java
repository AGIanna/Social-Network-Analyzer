import java.util.*;

public class Center {
	// place your code here
	List<center> galaxy;
	// the nested class used to define a center
	public static class center {
		int id; // the center
		int count; // the betweenness centrality

		center(int i, int c) {
			id = i;
			count = c;
		}

		int getId() {
			return id;
		}

		int getCount() {
			return count;
		}
		void addCount(int frequency) {
			count+=frequency;
		}
	}

	public Center(Graph g) {
		galaxy = new ArrayList<center>();
		int last = g.getV();
		List<Integer> vertices = new ArrayList<Integer>();
		vertices.addAll(g.getVertices());
		int size = vertices.get(last-1);
		BreadthFirstSearch path;
		for (int i : g.getVertices()) {
			center planet = new center(i,0);
			galaxy.add(planet);
		}
		for (int i : g.getVertices()) {
			path = new BreadthFirstSearch();
			path.bfs(g, i, size+1, true);
			for (center k : galaxy) {
				k.addCount(path.getFreq(k.getId()));
			}
		}
		// place your code here
	}

	class centComparator implements Comparator<center> { 

		public int compare(center first, center second) {
			return Double.compare(second.getCount(), first.getCount());
		}
	} 

	public List<center> top(int k) {
		// place your code here
		List<center> topList = new ArrayList<center>();
		galaxy.sort(new centComparator());
		for (int i=0;i<k;i++) {
			topList.add(galaxy.get(i));
		}
		return topList;
	}
}
