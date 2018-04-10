package Tipos_de_dados;

import java.util.Arrays;

class no { //no = node mas com vetor em vez de int como entradas
	int[] vector;
	no next;
	
	public no(int[] vector, no next) {
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
	protected int[] Domains;
	protected int len;
	protected no first;

	public Amostra(int[] Domains) { //O Domains não pode ser introduzido imediatamente como um vetor
		                            //mas sim como uma variável já definida
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
// Pus esta parte aqui em cima porque é um acrescento ao que o professor pediu, mas eu preciso de conhecer os 
//domínios das coisas para calcular as distribuições, e acho que esta é a melhor forma de o fazer
// basicamente Domains é uma lista com os domínios de cada variavel, que conhecemos mesmo antes de inserir 
//qualquer vector, já que depende apenas de se estamos numa amostra de diabetes, cancro, etc.


	public void add(int[] v) {
		no n = new no (v, first);
		first = n;
		len++;
	}

	public int length() {
		return len;
	}


	public int[] element(int i) { //assumi que first = posição 0
		no n = first;
		int j = 0;
		while (j != i) {
			n = n.next;
			j++;
		}
		return n.vector;
	}
//recebe um vector de variaveis e um vector de valores e retorna o numero de
	//ocorrencias desses valores para essas variaveis na amostra
	public int count(int[] variables, int[] values) {
		int num = 0;
		no n = first;
		while (n != null) {
			int j = 0;
			boolean boo = true;
			while (j < variables.length && boo) {
				boo = n.vector[variables[j]] == values[j];
				j++;
				}
			if (boo) {
				num++;
			}
			n = n.next;
		}
		return num;
	}

	
}

