package Tipos_de_dados;

public interface Oriented_Graphs {
	void add_edge(int o, int d);//recebe dois nós(origem e destino) e acrescenta uma aresta unindo os dois com a orientação definida.
	void remove_edge(int o, int d);//recebe dois nós(origem e destino) e elimina a aresta existente entre ambos com essa orientação.
	List parents(int n);//recebe um nó n e devolve a lista dos seus pais.
}
