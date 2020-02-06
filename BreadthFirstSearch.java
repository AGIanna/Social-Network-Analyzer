import java.util.*;

public class BreadthFirstSearch {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo; 
	private int[] freq; 
	public void bfs(Graph g, int s, int size) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		marked = new boolean[size];	
		edgeTo = new int[size];
		distTo = new int[size];
		marked[s] = true;
		distTo[s] = 0;
		while(!q.isEmpty()) {
			int v = q.remove();
			
			for ( int w : g.adj(v)) {
				if (!marked[w]) {
					q.add(w);
					marked[w] = true;
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
				}
			}
		}
	}
	
	public void bfs(Graph g, int s, int size, boolean x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		marked = new boolean[size];	
		edgeTo = new int[size];
		distTo = new int[size];
		freq = new int[size];
		marked[s] = true;
		distTo[s] = 0;
		int path = -1;
		while(!q.isEmpty()) {
			int v = q.remove();
			for ( int w : g.adj(v)) {
				if (!marked[w]) {
					q.add(w);
					marked[w] = true;
					edgeTo[w] = v;
					path = w;
					while (path != s) {
						freq[path]++;
						path = edgeTo[path];
					}
					distTo[w] = distTo[v] + 1;
				}
			}
			if (v!=s)freq[v]++;
		}
	}
	public int [] getDistTo() {
		return distTo;
	}
	public int [] getEdgeTo() {
		return edgeTo;
	}
	public int getFreq(int i) {
		return freq[i];
	}
}
