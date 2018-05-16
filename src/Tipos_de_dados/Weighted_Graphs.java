package Tipos_de_dados;

import java.util.ArrayList;

import Tipos_de_dados.WGraph.Edge;

public interface Weighted_Graphs {
	void add_edge(int node1, int node2, double weight); //adiciona a aresta com extremidades node1 e node2 e peso weight ao grafo
	void remove_edge(int node1, int node2); //remove a aresta com extremidades node1 e node2
	DGraph MST(int node); //recebe um no node e retorna a arvore geradora maximal (como Grafo orientado) cuja raiz e node.
	Edge adj(int node, ArrayList<Integer> visited); //recebe o nó, node, e a lista de arestas visitadas, visited, e devolve a aresta com o maior peso que leva a um nó ainda não visitado
}
