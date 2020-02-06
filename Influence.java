import java.util.*;


public class Influence {
	// place your code here
	List<influencer> feisbuk;
	// the nested class used to define a influencer
	public static class influencer {
		int source; // the influencer
		double power; // the impact of this influencer

		influencer(int i, double p) {
			source = i;
			power = p;
		}

		int getSource() {
			return source;
		}

		double getPower() {
			return power;
		}
	}

	public double getScore(int[]a) {
		double sum = 0;
		for(int i : a) {
			if (i>0) sum += 1/(Math.pow(2.0, (double)(i-1)));
		}
		return sum;
	}

	public Influence(Graph g) {
		// place your code here
		feisbuk = new ArrayList<influencer>();
		double tempPower = 0;
		int last = g.getV();
		List<Integer> vertices = new ArrayList<Integer>();
		vertices.addAll(g.getVertices());
		int size = vertices.get(last-1);
		BreadthFirstSearch path;
		for (int i : g.getVertices()) {
			path = new BreadthFirstSearch();
			path.bfs(g, i, size+1);
			tempPower = getScore(path.getDistTo());
			influencer famous = new influencer(i,tempPower);
			feisbuk.add(famous);
		}
	}
	
	class powerComparator implements Comparator<influencer> { 

		public int compare(influencer first, influencer second) {
			return Double.compare(second.getPower(), first.getPower());
		}
	} 

	public List<influencer> top(int k) {
		// place your code here
		List<influencer> topList = new ArrayList<influencer>();
		feisbuk.sort(new powerComparator());
		for (int i=0;i<k;i++) {
			topList.add(feisbuk.get(i));
		}
		return topList;
	}
}
