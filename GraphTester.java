public class GraphTester {
	public static void main(String[] args) {
		long startTime, endTime;
		double estTime;
		Graph g = new Graph();
		GraphLoader.loadGraph(g, "../data/facebook_2000.txt");
		startTime = System.nanoTime();
		Ego e = new Ego(g);
		int i = 0;
		System.out.println("======== Top 5 ego networks ========");
		for (Ego.egonet element : e.top(5)) {
			System.out.printf("[%d] center: %4d strength: %d\n", i, element.getCenter(), element.getG().getE());
			i++;
		}
		Influence in = new Influence(g);
		i = 0;
		System.out.println("======== Top 5 Influencers ========");
		for (Influence.influencer element : in.top(5)) {
			System.out.printf("[%d] source: %4d influence: %.2f\n", i, element.getSource(), element.getPower());
			i++;
		}
		Center ct = new Center(g);
		i = 0;
		System.out.println("======== Top 5 Centers ========");
		for (Center.center element : ct.top(5)) {
			System.out.printf("[%d] Id: %4d centrality: %d\n", i, element.getId(), element.getCount());
			i++;
		}
		endTime = System.nanoTime();
		estTime = (endTime - startTime) / 1000000.0;
		System.out.printf("You used %.2f ms\n", estTime);
//		System.out.println("Bonus project:");
//		CC cc = new CC(g);
//		i = 0;
//		System.out.println("======== Top 5 Connected Component ========");
//		System.out.println("Total number of CC: " + cc.count());
//		for (CC.cc element : cc.top(5)) {
//			System.out.printf("[%d] Id: %2d Size: %d\n", i, element.getId(), element.getSize());
//			i++;
//		}
//		System.out.println("======== Social Diameter ========");
//		Graph cg = new Graph();
//		GraphLoader.loadGraph(cg, "data/facebook_1000.txt");
//		Diameter dm = new Diameter(cg);
//		System.out.printf("Largest Diameter: %d\n", dm.getDiameter());
	}
}
