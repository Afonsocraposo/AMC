package Tipos_de_dados;

import Tipos_de_dados.ListaE.Node2;

public class WGraph {
	
	private int[][] nodes;
	private int dim;
	
	public WGraph (int n) {
		nodes = new int[n-1][];
		for(int i=1;i<n;i++) {
			nodes[i-1]=new int[n-i];
		}
		dim = n-1;
	}
	
	public void add_edge (int node1, int node2, int weight) {
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
		
		ListaE result = new ListaE();
		ListaE options = new ListaE();
		
		DGraph result_dgraph = new DGraph(dim+1);
		
		Node2 aux;
		
		Lista visited = new Lista();
		visited.insert(node);
		
		while(visited.length!=dim+1) {
			options = new ListaE();
			for(int i=0; i<visited.length; i++) {
				adj(visited.pos(i),options);
			}
			for(int i=options.len()-1; i>0; i--) {
				aux=options.pos(i);
				if(!visited.isIn(aux.nodeb)) {
					result.append(aux.nodea, aux.nodeb, aux.weight);
					visited.insert(aux.nodeb);
					break;
				}
			}
			
		}
		
		for(int i=0;i<dim+1;i++) {
			aux=result.pos(i);
			result_dgraph.add_edge(aux.nodea, aux.nodeb);
		}
		return result_dgraph;
	}
	
	public void adj(int node, ListaE l) {
		for(int i=0;i<node;i++) {
			if(!(l.pert(i, node)) && nodes[i][node-(i+1)]!=0) {
				l.append(node, i, nodes[i][node-(i+1)]);
			}
		}
			
		for(int j=0; j<dim-node;j++) {
			if(!(l.pert(node, node+j+1)) && nodes[node][j]!=0) {
				l.append(node, node+j+1, nodes[node][j]);
			}
		}
		l.insort();
	}
	
	public static void main(String[] args) {
		WGraph wg = new WGraph(9);
		wg.add_edge(0, 1, 4);
		wg.add_edge(0, 7, 8);
		wg.add_edge(1, 7, 11);
		wg.add_edge(1, 2, 8);
		wg.add_edge(7, 6, 1);
		wg.add_edge(7, 8, 7);
		wg.add_edge(2, 8, 2);
		wg.add_edge(8, 6, 6);
		wg.add_edge(6, 5, 2);
		wg.add_edge(2, 5, 4);
		wg.add_edge(2, 3, 7);
		wg.add_edge(3, 5, 14);
		wg.add_edge(3, 4, 9);
		wg.add_edge(5, 4, 10);
		DGraph dg = wg.MST(0);
	}
	
	
	
	
}
