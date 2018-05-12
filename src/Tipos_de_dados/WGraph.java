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
			if(!visited.contains(i)) {
				edges.append(node, i, nodes[i][node-(i+1)]);
			}
		}
			
		for(int j=0; j<dim-1-node;j++) {
			if(!visited.contains(node+j+1)) {
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
	
/*	
 
  	[ 0 , 0.0889 , 0.1512 , 0.1504 , 0.0836 , 0.1027 , 0.0722 , 0.0909 ]
	[ 0 , 0 , 0 , 0  , 0 , 0 , 0 , 0 ]
	[ 0.0825 , 0.0833 , 0.0367 , 0.0532 , 0.0580 , 0.0386 , 0.0448 ]
	[ 0.1852 , 0.0862 , 0.1212 , 0.1120 , 0.0709 , 0.0931 ]
	[ 0.0769 , 0.1056 , 0.1083 , 0.0660 , 0.0887 ]
	[ 0.0686 , 0.0672 , 0.0402 , 0.0506 ]
	[ 0.0821 , 0.0467 , 0.0737 ]
	[ 0.0569 , 0.0691 ]
	[ 0.0511 ]
	
*/
					
	public static void main(String[] args) {
		WGraph wg = new WGraph(10);
/*		wg.add_edge(0, 1, 4.0);
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
		wg.add_edge(5, 4, 10.0); */
		
		wg.add_edge(0,1,0);
		wg.add_edge(0,2,0.0889);
		wg.add_edge(0,3,0.1512);
		wg.add_edge(0,4,0.1504);
		wg.add_edge(0,5,0.0836);
		wg.add_edge(0,6,0.1027);
		wg.add_edge(0,7,0.1255);
		wg.add_edge(0,8,0.0722);
		wg.add_edge(0,9,0.0909);

		
/*		wg.add_edge(1,2,0.0889);
		wg.add_edge(1,3,0.1512);
		wg.add_edge(1,4,0.1504);
		wg.add_edge(1,5,0.0836);
		wg.add_edge(1,6,0.1027);
		wg.add_edge(1,7,0.0722);
		wg.add_edge(1,8,0.0909);
*/
		
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

		
		
		DGraph dg = wg.MST(0);

	}


	
	
}
