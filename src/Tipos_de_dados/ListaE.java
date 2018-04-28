package Tipos_de_dados;
import java.util.ArrayList;

public class ListaE implements List_Edges {
	
	private ArrayList<Edge> edges;
	
	public ListaE() {
		edges = new ArrayList<Edge>();
	}

	public void append(int node1, int node2, double weight) {
		edges.add(new Edge(node1, node2, weight));
	}
	
	public Edge pos(int n) {
		return edges.get(n);
	}
	
	public int len() {
		return edges.size();
	}
	
	public Edge maxEdge() {
		double max = -1;
		int maxpos = -1;
		
		for(int i=0; i<len();i++) {
			if(pos(i).getW()>max) {
				max=pos(i).getW();
				maxpos=i;
			}
		}
		
		return pos(maxpos);
		
	}
	
	
}



