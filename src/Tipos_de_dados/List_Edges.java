package Tipos_de_dados;
import Tipos_de_dados.ListaE.Edge;

public interface List_Edges {

	void append(int node1, int node2, int x); //adiciona um edge com a origem no node1, destino no node2 e peso x ao final da lista
	void ins(int node1, int node2, int x, int n); //adiciona um edge com a origem no node1, destino no node2 e peso x na posição n
	boolean pert(int node1, int node2); //verifica se existe algum edge com node1 e node2 nas extremidades na lista
	Edge pos(int n); //devolve o edge que esta na posiçao n da lista
	void del(int n); //remove o edge que está na posição n da lista
	void disp(); //print da lista
	int len(); //devolve o comprimento da lista
	void insort(); //ordena a lista por ordem crescente usando o algoritmo de insertion sort
	
}


