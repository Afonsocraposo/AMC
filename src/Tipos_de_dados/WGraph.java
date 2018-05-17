package Tipos_de_dados;

import java.util.ArrayList;

// Grafo pesado implementado como uma array em que cada posição é um Node e cada Node tem uma ArrayList
// chamada children em que terá a os nós aos quais liga e os seus respetivos pesos na forma de Edge
public class WGraph implements Weighted_Graphs {
	
	// uma classe de arestas que tem o nó A, o nó B e o peso Weight
	class Edge {
		// self-explanatory
		private int nodeA;
		private int nodeB;
		private double weight;
		
		public Edge(int nA, int nB, double w) {
			nodeA = nA;
			nodeB = nB;
			weight = w;
		}
		
		public int getNodeA() {
			return nodeA;
		}
		
		public int getNodeB() {
			return nodeB;
		}
		
		public double getWeight() {
			return weight;
		}
		
	}
	
	// classe nó que fará parte da implementação 
	private class Node {
		
		// filhos de cada nó, ou seja, nós aos quais liga
		private ArrayList<Edge> children;
		
		public Node() {
			children = new ArrayList<Edge>();
		}
		
		public ArrayList<Edge> getChildren(){
			return children;
		}
		
		public void addChildren(int nodeA, int nodeB, double weight) {
			children.add(new Edge(nodeA, nodeB, weight));
		}
		
		// Devolve um booleano após verificar se o nó tem o filho nodeB, ou seja, se o nó em
		// estudo se liga ao nodeB
		public boolean hasChildren(int nodeB) {
			for(int i=0;i<children.size();i++) {
				if(children.get(i).getNodeB()==nodeB) {
					return true;
				}
			}
			return false;
		}
		
		// Remove a ligação entre os nós caso exista
		public void removeChildren(int nodeB) {
			for(int i=0;i<children.size();i++) {
				if(children.get(i).getNodeB()==nodeB) {
					children.remove(i);
				}
			}
		}
		
	}
	
	private Node[] nodes;
	protected int dim;
	
	// inicializador
	public WGraph (int n) {
		dim=n;
		nodes = new Node[n];
		// cria um nó em cada posição da array de dimensão n
		for(int i=0; i<n; i++) {
			nodes[i]=new Node();
		}
	}
	
	public int dim() {
		return dim;
	}
	
	// adiciona a aresta caso não seja um loop e caso não exista já
	public void add_edge (int node1, int node2, double weight) {
		if(node1!=node2) {
			if(!nodes[node1].hasChildren(node2)) {
				// adiciona o filho em cada um dos nós
				nodes[node1].addChildren(node1, node2, weight);
				nodes[node2].addChildren(node2, node1, weight);
			}
		}
	}
	
	// remove aresta
	public void remove_edge(int node1, int node2) {
		if(node1!=node2) {
			nodes[node1].removeChildren(node2);
			nodes[node2].removeChildren(node1);
		}
	}
	
	
	public DGraph MST(int node){
		
		// inicialização das variáveis que serviram para armazenar os valores a adicionar ao grafo orientado
		int nodeA2add=-1;
		int nodeB2add=-1;
		double weight2add;
		
		DGraph result_dgraph = new DGraph(dim+1);
		
		// lista de nós visitados
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		// o nó onde se começa é adicionado aos visitados
		visited.add(node);
		// adiciona-se a ligação entre a classe e o primeiro nó
		result_dgraph.add_edge(dim, node);
		
		// enquanto todos os nós não foram visitados, o programa corre
		while(visited.size()!=dim) {
			
			// parametrização do peso mínimo
			weight2add=-1;
			
			// percorre a lista de nós visitados
			for(int no:visited) {
				// obtém a aresta com o maior peso que leva a um nó não visitado
				Edge aux = adj(no,visited);
				// vai comparando os valores das arestas de maior peso e guarda o máximo
				if(aux.getWeight()>weight2add) {
					nodeA2add=aux.getNodeA();
					nodeB2add=aux.getNodeB();
					weight2add=aux.getWeight();
				}
			}
			
			// adiciona o novo nó à lista de visitados
			visited.add(nodeB2add);
			
			// check if it works
			//System.out.println(nodeA2add + " , " + nodeB2add + " | " + weight2add);
			
			// adiciona a aresta ao grafo orientado
			result_dgraph.add_edge(nodeA2add,nodeB2add);

			// liga a classe ao novo nó adicionado
			result_dgraph.add_edge(dim,nodeB2add);
			
		}
		
		return result_dgraph;
	
	}
	
	// descobre qual a maior aresta do nó node que leva a um nó ainda não visitado
	public Edge adj(int node, ArrayList<Integer> visited) {
		
		// parametrização dos valores de máximo e maximizante, usa-se -1 pois funciona como mínimo
		double max = -1;
		int nodeb = -1;
		
		// percorre as arestas da lista de filhos do nó node e descobre a aresta com o maior peso 
		for(Edge edge:nodes[node].getChildren()) {
			if(edge.getWeight()>max && !visited.contains(edge.getNodeB())) {
				max=edge.getWeight();
				nodeb=edge.getNodeB();
			}
		}
		
		Edge result = new Edge(node,nodeb,max);
		
		return result;
		
	}
	
	
//  TRY IT
	
/*
	public static void main(String[] args) {
		WGraph wg = new WGraph(10);
		
 
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
		
		
		
		@SuppressWarnings("unused")
		DGraph dg = wg.MST(0);

	}
*/

	
	
}
