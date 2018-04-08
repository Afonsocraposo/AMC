package Tipos_de_dados;

public class WGraph {
	
	private int[][] nodes;
	private int dim;
	
	public WGraph (int n) {
		nodes = new int[n][n];
		dim = n;
	}
	
	public void add_edge (int node1, int node2, int weight) {
		nodes[node1][node2] = weight;
		nodes[node2][node1] = weight;
	}
	
	public void remove_edge(int node1, int node2) {
		nodes[node1][node2] = 0;
		nodes[node2][node1] = 0;
	}
	
	
}
