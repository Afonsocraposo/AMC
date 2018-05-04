package Tipos_de_dados;

class no { 
	int[] vector;
	no next;
	
	public no(int[] vector, no next) {
		super();
		this.vector = vector;
		this.next = next;
	}
}	
	


public class Amostra implements Sample{
	protected int[] Domains;
	protected int len;
	protected no first;
	

	public Amostra(int[] Domains) {
		this.Domains = Domains;
		this.len = 0;
		this.first = null;
	}
	

	public int Domains(int x) {
		return Domains[x];
	}


	public void add(int[] v) {
		no n = new no(v, first);
		first = n;
		len++;
	}

	public int length() {
		return len;
	}


	public int[] element(int i) { 
		no n = first;
		int j = 0;
		while (j != i) {
			n = n.next;
			j++;
		}
		return n.vector;
	}

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

