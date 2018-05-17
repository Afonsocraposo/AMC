package Tipos_de_dados;

import java.io.Serializable;

//Dgraph implementa a estrutura grafos orientados através de listas de adjacência, em que cada lista 
//contém os nós que dão origem ao nó correspondente à posição dessa lista.
@SuppressWarnings("serial")
public class DGraph implements Oriented_Graphs,Serializable{
	protected List[] ladj;
	protected int dim;
	
	//construtor que recebe o número de nós do grafo, define a sua dimensão e inicializa as varias listas de pais
	public DGraph(int dim) {
		this.dim=dim;
		ladj=new List[dim];
		for(int i=0;i<dim;i++) {
			ladj[i]=new Lista();
		}
	}
	//adiciona uma aresta que vai de o a d
	public void add_edge(int o, int d) {
		ladj[d].insert(o);		
	}

	//remove a aresta que vai de o a d
	public void remove_edge(int o, int d) {
		ladj[d].remove(o);
	}

	//retorna a lista dos nós que dão origem ao nó n
	public List parents(int n) {
		return ladj[n];
	}
	
	//retorna a dimensao do grafo, i.e., o numero de nós do grafo
	public int dim() {
		return dim;
	}
}
