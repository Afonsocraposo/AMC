package Tipos_de_dados;

public class Amostra implements Sample{
	protected int[] Domains;
	
	public Amostra(int[] Domains) {
		this.Domains=Domains;
	}
	public int Domains(int x) {
		return Domains[x];
	}
// Pus esta parte aqui em cima porque � um acrescento ao que o professor pediu, mas eu preciso de conhecer os 
//dom�nios das coisas para calcular as distribui��es, e acho que esta � a melhor forma de o fazer
// basicamente Domains � uma lista com os dom�nios de cada variavel, que conhecemos mesmo antes de inserir 
//qualquer vector, j� que depende apenas de se estamos numa amostra de diabetes, cancro, etc.

	public void add(int[] v) {

		
	}


	public int length() {

		return 0;
	}


	public int[] element(int i) {

		return null;
	}


	public int count(int[] variables, int[] values) {

		return 0;
	}

}
