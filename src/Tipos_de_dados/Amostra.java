package Tipos_de_dados;

// Uma class de Nodes que tem um vetor com os parâmetros do indivíduo e aponta para o Node seguinte
class no { 
	int[] vector;
	no next;
	
	public no(int[] vector, no next) {
		super();
		this.vector = vector;
		this.next = next;
	}
}	
	

//Amostra implementada como uma lista de Nodes em que cada Node tem um vetor com os parâmetros de cada indivíduo
public class Amostra implements Sample{
	protected int[] Domains;
	protected int len;
	protected no first;
	

	public Amostra(int[] Domains) {
		this.Domains = Domains;
		this.len = 0;
		this.first = null;
	}
	
// Retorna o domínio da variável x da amostra
	public int Domains(int x) {
		return Domains[x];
	}

// Adiciona o vetor v (com os parâmetros do novo indivíduo) a um novo Node no início da amostra
	public void add(int[] v) {
		no n = new no(v, first);
		first = n;
		len++;
	}

// Retorna o comprimento (numero de Nodes) da amostra
	public int length() {
		return len;
	}

// Retorna o vetor correspondente ao Node (indivíduo) i da amostra
	public int[] element(int i) { 
		no n = first;
		int j = 0;
		while (j != i) {
			n = n.next;
			j++;
		}
		return n.vector;
	}
	
// Recebe um vetor de variáveis e um vetor de valores para as correspondentes variáveis.
// Devolve o número de vezes (numero de individuos) que as variáveis recebidas têm os valores recebidos
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

