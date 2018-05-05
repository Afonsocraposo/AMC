package Tipos_de_dados;

public class teste {
	
	public static void main(String[] args) {
		int[] dom = {3,2,4};
		Amostra am = new Amostra(dom);
	
		int[] values3 = {2,1,1};
		int[] values2 = {1,0,1};
		int[] values1 = {1,0,1};
		int[] values0 = {1,0,1};
		am.add(values3);
		am.add(values2);
		am.add(values1);
		am.add(values0);
	


		System.out.println(Weights.weight(0,1,am));
	}
}

