package Tipos_de_dados;

public class Edge implements Node_Edge {
	
	private int nodea;
	private int nodeb;
	private double weight;

	Edge(int node1, int node2, double value){
		nodea = node1;
		nodeb = node2;
		weight = value;
	}
	
	public int getA() {
		return nodea;
	}
	
	public int getB() {
		return nodeb;
	}
	
	public double getW() {
		return weight;
	}
	
}
