package Tipos_de_dados;

import java.io.Serializable;

public class BN implements Serializable{
	protected Oriented_Graphs g;
	protected double[][][] Theta;
	
	public BN(Oriented_Graphs g, Sample A, double S) {
		Theta=new double[g.dim()][][];
		this.g=g;
		for(int x=0;x<g.dim();x++) {
			int xDomain=A.Domains(x);
			int[] Parents=g.parents(x).toArray();
			double[][] temp;
			if(Parents.length>0) {
				int[] piDomains=new int[Parents.length];
				int prodomain=1;
				for(int i=0;i<piDomains.length;i++) {
					piDomains[i]=A.Domains(Parents[i]);
					prodomain*=A.Domains(Parents[i]);
				}
				int[] piValues=new int[Parents.length];
				temp=new double[xDomain][prodomain];
				for(int xi=0;xi<xDomain;xi++) {
					int i=0;
					while(i<prodomain) {
						for(int j=0;j<piDomains[0];j++) {
							int[] values1= new int[Parents.length+1];
							values1[0]=xi;
							int[] variables1= new int[Parents.length+1];
							variables1[0]=x;
							for(int k=1; k<values1.length;k++) {
								values1[k]=piValues[k-1];
								variables1[k]=Parents[k-1];
							}
							temp[xi][i]=Math.log10(A.count(variables1, values1)+S)-Math.log10(A.count(Parents, piValues)+S*xDomain);
							i++;
							piValues[0]++;}
						piValues[0]=0;
						for(int j=1;j<Parents.length;j++) {
							if(++piValues[j]==piDomains[j]) piValues[j]=0;
							else {
								break;}
						}
					}
				}
			} else {
				temp=new double[xDomain][1];
				for(int xi=0;xi<xDomain;xi++) {
					int[] values= {xi};
					int[] variables= {x};
					temp[xi][0]=Math.log10(A.count(variables, values)+S)-Math.log10(A.length()+S*xDomain);
				}
			}
			Theta[x]=temp;
		}
	}
	
	public double prob(int[] v) {
		double p=0.0;
		int x,i,j;
		for(x=0;x<v.length-1;x++) {
			int[] Parents=g.parents(x).toArray();
			int[] piDomains=new int[Parents.length];
			for(i=0;i<piDomains.length;i++) {
				piDomains[i]=Theta[Parents[i]].length;}
			int position=0;
			for(i=0;i<Parents.length;i++) {
				int D=1;
				for(j=0;j<i;j++) {
					D*=piDomains[j];}
				position+=v[Parents[i]]*D;	
			}
			p+=Theta[x][v[x]][position];
		}
		p+=Theta[x][v[x]][0];
		return Math.pow(10.0, p); 
	}	                       
}
