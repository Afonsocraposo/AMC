package Tipos_de_dados;

import java.util.Arrays;

class no { //no = node mas com vetor em vez de int como entradas
	int[] vector;
	no next;
	
	public no (int[] vector, no next) {
		super();
		this.vector = vector;
		this.next = next;
	}

	@Override
	public String toString() {
		return "no [vector=" + Arrays.toString(vector) + ", next=" + next + "]";
	}
	
	
	
}	
	


public class Amostra implements Sample{
	int[] Domains;
	int len;
	no first;

	public Amostra(int[] Domains) {
		this.Domains = Domains;
		this.len = 0;
		this.first = null;
	}
	
	@Override
	public String toString() {
		return "Amostra [Domains=" + Arrays.toString(Domains) + ", len=" + len + ", first=" + first + "]";
	}



	public int Domains(int x) {
		return Domains[x];
	}
// Pus esta parte aqui em cima porque � um acrescento ao que o professor pediu, mas eu preciso de conhecer os 
//dom�nios das coisas para calcular as distribui��es, e acho que esta � a melhor forma de o fazer
// basicamente Domains � uma lista com os dom�nios de cada variavel, que conhecemos mesmo antes de inserir 
//qualquer vector, j� que depende apenas de se estamos numa amostra de diabetes, cancro, etc.


	public void add(int[] v) {
		no n = new no (v, first);
		first = n;
		len++;
	}

	public int length() {
		return len;
	}


	public int[] element(int i) { //assumi que first = posi��o 0)
		//incluir msg de erro se i > len, maybe?
		no n = first;
		int j = 0;
		while (j != i) {
			n = n.next;
			j++;
		}
		return n.vector;
	}

//n�o percebi o que � suposto a fun��o count fazer
	public int count(int[] variables, int[] values) {

		return 0;
	}


}

