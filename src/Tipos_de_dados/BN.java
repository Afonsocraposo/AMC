package Tipos_de_dados;

public class BN {
	protected Oriented_Graphs g;
	protected double[][][] Theta;
	
	public BN(Oriented_Graphs g, Sample A, double S) {
		this.g=g;
		for(int x=0; x<A.element(0).length; x++) {
			int Pi=g.parents(x).getFirst();
			int xDomain=A.Domains(x);
			int PiDomain=A.Domains(Pi);
			double[][] temp=new double[xDomain][PiDomain];
			for(int di=0; di<xDomain;di++) {
				for(int wi=0;wi<PiDomain;wi++) {
					int[] Variables1= {x,Pi};
					int[] Values1= {di,wi};
					int[] Variables2= {Pi};
					int[] Values2= {wi};
					temp[di][wi]=Math.log10(A.count(Variables1,Values1)+S)-Math.log10(A.count(Variables2,Values2)+S*xDomain);
				}
			}
			Theta[x]=temp;
		}
	}
	
	public double prob(int[] v) {
		double p=0.0;
		for(int x=0;x<v.length;x++) {
			int Pi=g.parents(x).getFirst();
			p+=Theta[x][v[x]][v[Pi]];
		}
		return p; 
	}	                       
}
