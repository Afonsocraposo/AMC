package Tipos_de_dados;

public interface List {
	void insert(int x);// adiciona o n� com valor x ao in�cio da lista
	void remove(int x);// retira a primeira ocorr�ncia de x da lista
	boolean emptyQ();// verifica se a lista � vazia
	int[] toArray();// converte a lista a um vector
}
