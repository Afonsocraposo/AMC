package Tipos_de_dados;


public class Amostra_teste {
	
	static public void main (String[] args) {
		int[] dom = {1,2,2,1};
		Amostra a = new Amostra(dom);
		int[] n1 = {1,2,3,4};
		a.add(n1);
		int[] n2 = {5,6,7,8};
		a.add(n2);
		int[] n3 = {7,8,9,10};
		a.add(n3);
		
		System.out.println(a);
		int[] var = {0,1,2}; 
		int[] val = {7,8,9};
		System.out.println(a.count(var,val));
	}
}
