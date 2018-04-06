package Tipos_de_dados;

public interface List {
	void insert(int x);// adiciona o nó com valor x ao início da lista
	void remove(int x);// retira a primeira ocorrência de x da lista
	boolean emptyQ();// verifica se a lista é vazia
}
