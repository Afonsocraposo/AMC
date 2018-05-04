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
	
		 
		int[] valt1 = {0,1,3};
		int[] valt2 = {0,0,1};
		int[] valt3 = {1,2,0};
		int[] valt4 = {0,1,2};
		int[] vart = {0,1,2};
		
		//System.out.println(am.count(vart,valt1));
		//System.out.println(am.count(vart,valt2));
		//System.out.println(am.count(vart,valt3));
		//System.out.println(am.count(vart,valt4));
		System.out.println(Weights.weight(0,1,am));
	}
}

