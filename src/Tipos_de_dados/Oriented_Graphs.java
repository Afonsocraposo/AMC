package Tipos_de_dados;

public interface Oriented_Graphs {
	void add_edge(int o, int d);//recebe dois n�s(origem e destino) e acrescenta uma aresta unindo os dois com a orienta��o definida.
	void remove_edge(int o, int d);//recebe dois n�s(origem e destino) e elimina a aresta existente entre ambos com essa orienta��o.
	List parents(int n);//recebe um n� n e devolve a lista dos seus pais.
	int dim(); //devolve o número de nós do grafo.
}
