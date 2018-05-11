package Tipos_de_dados;

public class Weights {

	public static double weight (int var1, int var2, Amostra a) { //var1 e var2 diz a posicao da variavel
		double it = 0.0; 
		int c = a.element(0).length-1;
		int[] varxyc = {var1,var2,c}; //a.element(0).length-1 = posicao da classe
		int[] varxc = {var1,c};
		int[] varyc = {var2,c};
		int[] varc = {c};
		 
		for(int i=0; i<a.Domains(var1); i++) { //percorre o dominio da var1
			for(int j=0; j<a.Domains(var2); j++) { //percorre o dominio da var2
				for(int k=0; k<a.Domains(c); k++) { //percorre o dominio da classe
					
					double r;
					double r2;
					int[] valxyc = {i,j,k}; 
					int[] valxc = {i,k};
					int[] valyc = {j,k};
					int[] valc = {k};
					int Nxyc = a.count(varxyc,valxyc); 
					int Nxc = a.count(varxc, valxc);
					int Nyc = a.count(varyc, valyc);
					int Nc = a.count(varc, valc);
					int N = a.length();
					if (Nxyc!=0) { 
						r=((double)Nxyc/N)*Math.log10((double)(Nxyc*Nc)/(double)(Nyc*Nxc));
						it += r;
					}
					}
				}
			}
		
	
		return it; 
	}
	
	
}
