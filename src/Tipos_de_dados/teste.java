package Tipos_de_dados;

public class teste {
	
	public static void main(String[] args) {
		int[] dom = {3,2,4};
		Amostra am = new Amostra(dom);
	
		int[] values3 = {0,1,2};
		int[] values2 = {0,1,3};
		int[] values1 = {1,2,0};
		int[] values0 = {0,0,1};
		am.add(values3);
		am.add(values2);
		am.add(values1);
		am.add(values0);
	
		System.out.println(Weights.Weight(0,1,am));
	}
}

