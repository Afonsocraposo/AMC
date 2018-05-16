package Tipos_de_dados;

import java.util.ArrayList;

public class WGraph { // implements Weighted_Graphs {
	
	
	class Edge {
		
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
	
	private class Node {
		
		private class Nedge {
			private int node;
			private double weight;
			
			public Nedge(int n, double w) {
				node = n;
				weight = w;
			}
			
			public int getNode() {
				return node;
			}
			
			public double getWeight() {
				return weight;
			}
			
		}
		
		private ArrayList<Nedge> children;
		
		public Node() {
			children = new ArrayList<Nedge>();
		}
		
		public ArrayList<Nedge> getChildren(){
			return children;
		}
		
		public void addChildren(int node, double weight) {
			children.add(new Nedge(node,weight));
		}
		
		public boolean hasChildren(int node) {
			for(int i=0;i<children.size();i++) {
				if(children.get(i).getNode()==node) {
					return true;
				}
			}
			return false;
		}
		
		public void removeChildren(int node) {
			for(int i=0;i<children.size();i++) {
				if(children.get(i).getNode()==node) {
					children.remove(i);
				}
			}
		}
		
	}
	
	private Node[] nodes;
	private int dim;
	
	public WGraph (int n) {
		dim=n;
		nodes = new Node[n];
		for(int i=0; i<n; i++) {
			nodes[i]=new Node();
		}
	}
	
	public int dim() {
		return dim;
	}
	
	public void add_edge (int node1, int node2, double weight) {
		if(node1!=node2) {
			if(!nodes[node1].hasChildren(node2)) {
				nodes[node1].addChildren(node2, weight);
				nodes[node2].addChildren(node1, weight);
			}
		}
	}
	
	public void remove_edge(int node1, int node2) {
		if(node1!=node2) {
			nodes[node1].removeChildren(node2);
			nodes[node2].removeChildren(node1);
		}
	}
	
	
	public DGraph MST(int node){
		
		int nodeA2add;
		int nodeB2add;
		double weight2add;
		
		DGraph result_dgraph = new DGraph(dim+1);
				
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		visited.add(node);
		result_dgraph.add_edge(dim, node);
		
		while(visited.size()!=dim) {
			
			weight2add=-1;
			nodeA2add=node;
			nodeB2add=-1;
			
			for(int no:visited) {
				Edge aux = adj(no,visited);
				if(aux.getW()>weight2add) {
					nodeA2add=aux.getA();
					nodeB2add=aux.getB();
					weight2add=aux.getW();
				}
			}
			
			visited.add(nodeB2add);
			
			// check if it works
			 System.out.println(nodeA2add + " , " + nodeB2add + " | " + weight2add);
			
			result_dgraph.add_edge(nodeA2add,nodeB2add);

			result_dgraph.add_edge(dim,nodeB2add);
			
		}
		
		return result_dgraph;
	
	}
	
	
	public Edge adj(int node, ArrayList<Integer> visited) {
		
		double max = -1;
		int nodeb = -1;
		
		for(int i=0; i<nodes[node].getChildren().size();i++) {
			if(nodes[node].getChildren().get(i).getWeight()>max && !visited.contains(nodes[node].getChildren().get(i).getNode())) {
				max=nodes[node].getChildren().get(i).getWeight();
				nodeb=nodes[node].getChildren().get(i).getNode();
			}
		}
		
		Edge result = new Edge(node,nodeb,max);
		
		return result;
		
	}
	
	
//  TRY IT
					
	public static void main(String[] args) {
		WGraph wg = new WGraph(9);
		
		wg.add_edge(0, 1, 4.0);
		wg.add_edge(0, 7, 8.0);
		wg.add_edge(1, 7, 11.0);
		wg.add_edge(1, 2, 8.0);
		wg.add_edge(7, 6, 1.0);
		wg.add_edge(7, 8, 7.0);
		wg.add_edge(2, 8, 2.0);
		wg.add_edge(8, 6, 6.0);
		wg.add_edge(6, 5, 2.0);
		wg.add_edge(2, 5, 4.0);
		wg.add_edge(2, 3, 7.0);
		wg.add_edge(3, 5, 14.0);
		wg.add_edge(3, 4, 9.0);
		wg.add_edge(5, 4, 10.0); 
		

/*

		wg.add_edge(0,1,0);
		wg.add_edge(0,2,0.0889);
		wg.add_edge(0,3,0.1512);
		wg.add_edge(0,4,0.1504);
		wg.add_edge(0,5,0.0836);
		wg.add_edge(0,6,0.1027);
		wg.add_edge(0,7,0.1255);
		wg.add_edge(0,8,0.0722);
		wg.add_edge(0,9,0.0909);

		
		wg.add_edge(1,2,0.0889);
		wg.add_edge(1,3,0.1512);
		wg.add_edge(1,4,0.1504);
		wg.add_edge(1,5,0.0836);
		wg.add_edge(1,6,0.1027);
		wg.add_edge(1,7,0.0722);
		wg.add_edge(1,8,0.0909);
		
		wg.add_edge(2,3,0.0825);
		wg.add_edge(2,4,0.0833);
		wg.add_edge(2,5,0.0367);
		wg.add_edge(2,6,0.0532);
		wg.add_edge(2,7,0.0580);
		wg.add_edge(2,8,0.0386);
		wg.add_edge(2,9,0.0448);
		
		wg.add_edge(3,4,0.1852);
		wg.add_edge(3,5,0.0862);
		wg.add_edge(3,6,0.1212);
		wg.add_edge(3,7,0.1120);
		wg.add_edge(3,8,0.0709);
		wg.add_edge(3,9,0.0931);

		
		wg.add_edge(4,5,0.0769);
		wg.add_edge(4,6,0.1056);
		wg.add_edge(4,7,0.1083);
		wg.add_edge(4,8,0.0660);
		wg.add_edge(4,9,0.0887);

		
		wg.add_edge(5,6,0.0686);
		wg.add_edge(5,7,0.0672);
		wg.add_edge(5,8,0.0402);
		wg.add_edge(5,9,0.0506);

		
		wg.add_edge(6,7,0.0821);
		wg.add_edge(6,8,0.0467);
		wg.add_edge(6,9,0.0737);

		
		wg.add_edge(7,8,0.0569);
		wg.add_edge(7,9,0.0691);

		wg.add_edge(8,9,0.0511);
		
*/
		
		
		DGraph dg = wg.MST(0);

	}


	
	
}
