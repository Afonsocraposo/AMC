package Tipos_de_dados;

import java.util.ArrayList;

public class WGraph { // implements Weighted_Graphs {
	
	private double[][] nodes;
	private int dim;
	
	public WGraph (int n) {
		nodes = new double[n-1][];
		for(int i=1;i<n;i++) {
			nodes[i-1]=new double[n-i];
		}
		dim = n;
	}
	
	public int dim() {
		return dim;
	}
	public void add_edge (int node1, int node2, double weight) {
		if(node1!=node2) {
			if(node1>node2) nodes[node2][node1-(node2+1)] = weight;
			else nodes[node1][node2-(node1+1)] = weight;
		}
	}
	
	public void remove_edge(int node1, int node2) {
		if(node1!=node2) {
			if(node1>node2) nodes[node2][node1-(node2+1)] = 0;
			else nodes[node1][node2-(node1+1)] = 0;
		}
	}
	
	
	public DGraph MST(int node){
		
		ListaE options = new ListaE();
		
		DGraph result_dgraph = new DGraph(dim+1);
				
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		visited.add(node);
		result_dgraph.add_edge(dim, node);
		
		while(visited.size()!=dim) {
			
			options = new ListaE();
			
			for(int no:visited) {
				Edge aux = adj(no,visited);
				options.append(aux.getA(), aux.getB(), aux.getW());
			}
			
			Edge edge2add = options.maxEdge();
			visited.add(edge2add.getB());
			
			// check if it works
			//System.out.println(Integer.toString(edge2add.getA()) + " , " + Integer.toString(edge2add.getB()) + " | " + Double.toString(edge2add.getW()));
			
			result_dgraph.add_edge(edge2add.getA(),edge2add.getB());
			result_dgraph.add_edge(dim,edge2add.getB());
			
		}
		
		return result_dgraph;
	
	}
	
	
	public Edge adj(int node, ArrayList<Integer> visited) {
		
		ListaE edges = new ListaE(); 
		
		for(int i=0;i<node;i++) {
			if(!(visited.contains(i)) && nodes[i][node-(i+1)]!=0) {
				edges.append(node, i, nodes[i][node-(i+1)]);
			}
		}
			
		for(int j=0; j<dim-1-node;j++) {
			if(!(visited.contains(node+j+1)) && nodes[node][j]!=0) {
				edges.append(node, node+j+1, nodes[node][j]);
			}
		}
		
		double max = -1;
		int nodeb = -1;
		
		for(int i=0; i<edges.len();i++) {
			if(edges.pos(i).getW()>max) {
				max=edges.pos(i).getW();
				nodeb=edges.pos(i).getB();
			}
		}
		
		Edge result = new Edge(node,nodeb,max);
		
		return result;
		
	}
	
	
//  TRY IT
//	public static void main(String[] args) {
//		WGraph wg = new WGraph(9);
//		wg.add_edge(0, 1, 4.0);
//		wg.add_edge(0, 7, 8.0);
//		wg.add_edge(1, 7, 11.0);
//		wg.add_edge(1, 2, 8.0);
//		wg.add_edge(7, 6, 1.0);
//		wg.add_edge(7, 8, 7.0);
//		wg.add_edge(2, 8, 2.0);
//		wg.add_edge(8, 6, 6.0);
//		wg.add_edge(6, 5, 2.0);
//		wg.add_edge(2, 5, 4.0);
//		wg.add_edge(2, 3, 7.0);
//		wg.add_edge(3, 5, 14.0);
//		wg.add_edge(3, 4, 9.0);
//		wg.add_edge(5, 4, 10.0);
//		DGraph dg = wg.MST(0);
//
//	}


	
	
}
