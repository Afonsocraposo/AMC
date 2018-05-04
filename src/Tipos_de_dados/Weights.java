package Tipos_de_dados;

public class Weights {

	public static double weight (int var1, int var2, Amostra a) { //var1 e var2 diz a posicao da variavel
		double it = 0; 
		int[] varxyc = {var1,var2,a.element(0).length-1}; //a.element(0).length-1 = posicao da classe
		int[] varxc = {var1,a.element(0).length-1};
		int[] varyc = {var2,a.element(0).length-1};
		int[] varc = {a.element(0).length-1};
		 
		for(int i=0; i<a.Domains(var1); i++) { //percorre o dominio da var1
			for(int j=0; j<a.Domains(var2); j++) { //percorre o dominio da var2
				for(int k=0; k<a.Domains(a.element(0).length-1); k++) { //percorre o dominio da classe
					
					int[] valxyc = {i,j,k}; 
					int[] valxc = {i,k};
					int[] valyc = {j,k};
					int[] valc = {k};
					int Nxyc = a.count(varxyc,valxyc); 
					int Nxc = a.count(varxc, valxc);
					int Nyc = a.count(varyc, valyc);
					int Nc = a.count(varc, valc);
					//int N = a.length();
					if (Nxyc!=0) 
						it += Nxyc*Math.log10((Nxyc*Nc)/(Nyc*Nxc));
					}
				}
			}
		
	
		return it; 
	}
	
	
}
