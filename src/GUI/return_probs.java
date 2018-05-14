package GUI;

import Tipos_de_dados.BN;

public class return_probs {
	public static void main(String[] args) {
	
		//Depending on Tab selected

		/////////////////////////////////////////////
		int[] patientdata;//vector resultante dos dados introduzidos pelo médico, com toda a informação exceto a classe
		int[] testdata=new int[patientdata.length+1];
		int i;
		for(i=0;i<patientdata.length;i++) {
			testdata[i]=patientdata[i];
		}
		
		//For Breast cancer
		BN bcancerBN;
		testdata[i]=0;
		double Benign=bcancerBN.prob(testdata);
		testdata[i]=1;
		double Malign=bcancerBN.prob(testdata);
		
		//For Breast cancer
		BN bcancerBN;
		testdata[i]=0;
		double Benign=bcancerBN.prob(testdata);
		testdata[i]=1;
		double Malign=bcancerBN.prob(testdata);
		
		//For Breast cancer
		BN bcancerBN;
		testdata[i]=0;
		double Benign=bcancerBN.prob(testdata);
		testdata[i]=1;
		double Malign=bcancerBN.prob(testdata);

		//For Breast cancer
		BN bcancerBN;
		testdata[i]=0;
		double Benign=bcancerBN.prob(testdata);
		testdata[i]=1;
		double Malign=bcancerBN.prob(testdata);

				
	}
}
