package Tipos_de_dados;

public interface List_Edges {

	void append(int node1, int node2, double x); //adiciona um edge com a origem no node1, destino no node2 e peso x ao final da lista
	Edge pos(int n); //devolve o edge que esta na posiçao n da lista
	int len(); //devolve o comprimento da lista
	Edge maxEdge(); //devolve a aresta com o maior peso

}


