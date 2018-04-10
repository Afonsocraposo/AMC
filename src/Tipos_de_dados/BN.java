package Tipos_de_dados;

public class BN {
	protected Oriented_Graphs g;
	protected double[][][] Theta;
	
	public BN(Oriented_Graphs g, Sample A, double S) {
		this.g=g;
		int x,Pi,C,xDomain,PiDomain,CDomain,di,wi,c,j;
		C=A.element(0).length-1;
		CDomain=A.Domains(C);
		for(x=0; x<A.element(0).length-1; x++) {
			List Parents=g.parents(x);
			double[][] temp;
			if(!Parents.emptyQ()) {
				Pi=Parents.getFirst();
				xDomain=A.Domains(x);
				PiDomain=A.Domains(Pi);
				temp=new double[xDomain][PiDomain*CDomain];
				for(di=0; di<xDomain;di++) {
					j=0;
					for(wi=0;wi<PiDomain;wi++) {
						for(c=0;c<CDomain;c++) {
							int[] Variables1= {x,Pi,C};
							int[] Values1= {di,wi,c};
							int[] Variables2= {Pi,C};
							int[] Values2= {wi,c};
							temp[di][j]=Math.log10(A.count(Variables1,Values1)+S)-Math.log10(A.count(Variables2,Values2)+S*xDomain);
							j++;
						}
					}
			} 
		} else {
				xDomain=A.Domains(x);
				PiDomain=1;
				temp=new double[xDomain][PiDomain*CDomain];
				for(di=0; di<xDomain;di++) {
					for(c=0;c<CDomain;c++) {
						int[] Variables1= {x,C};
						int[] Values1= {di,c};
						int[] Variables2= {C};
						int[] Values2= {c};
						temp[di][c]=Math.log10(A.count(Variables1,Values1)+S)-Math.log10(A.count(Variables2,Values2)+S*xDomain);
					}
				}
			}
			Theta[x]=temp;
		}
		Theta[x]=new double[CDomain][0];
		for(c=0;c<CDomain;c++) {
			int[] Variable= {C};
			int[] Value= {c};
			Theta[x][c][0]=Math.log10(A.count(Variable,Value)+S)-Math.log10(A.length()+S*CDomain);
		}
	}
	
	public double prob(int[] v) {
		double p=0.0;
		int c=v[v.length-1];
		int x,Pi,wi;
		for(x=0;x<v.length-1;x++) {
			List Parents=g.parents(x);
			if(!Parents.emptyQ()) {
				Pi=Parents.getFirst();
				wi=v[Pi];
				p+=Theta[x][v[x]][wi*Theta[v.length-1].length+c];
			} else {
				p+=Theta[x][v[x]][c];
			}
		}
		p+=Theta[x][v.length-1][0];
		return Math.pow(10.0, p); 
	}	                       
}
