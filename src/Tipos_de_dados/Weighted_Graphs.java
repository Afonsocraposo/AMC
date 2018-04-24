package Tipos_de_dados;

public interface Weighted_Graphs {
	void add_edge(int node1, int node2, double weight); //adiciona a aresta com extremidades node1 e node2 e peso weight ao grafo
	void remove_edge(int node1, int node2); //remove a aresta com extremidades node1 e node2
	DGraph MST(int node); //recebe um no node e retorna a arvore geradora maximal (como Grafo orientado) cuja raiz e node.
	void adj(int node, ListaE l); //recebe o nó n e a Lista de Arestas l e adiciona à mesma todos os nós parentes do nó node
}
