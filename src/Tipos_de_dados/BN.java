package Tipos_de_dados;

import java.io.Serializable;


//implementa o objecto rede de Bayes, guardando 2 atributos: o grafo pesado que define as parentalidades
//entre as várias variaveis e um tensor Theta que define as tabelas de probabilidade condicionada 
//para as várias variaveis
@SuppressWarnings("serial")
public class BN implements Serializable{
	protected Oriented_Graphs g;
	protected double[][][] Theta;
	
	public BN(Oriented_Graphs g, Sample A, double S) {
		//pensado no tensor Theta como u8m livro cujas páginas são as já referidas tabelas de probabilidade 
		//condicionada, este terá tantas paginas quantos nós tem o grafo orientado.
		//por outro lado todas as tabelas de probabilidade foram construidas de forma a manterem a bidimensionalidade 
		//independentemente do número de pais que uma dada variaável possa ter
		Theta=new double[g.dim()][][];
		this.g=g;
		//olhando para cada variavél
		for(int x=0;x<g.dim();x++) {
			//são obtidos os pais dessa variavel
			int xDomain=A.Domains(x);
			int[] Parents=g.parents(x).toArray();
			//declara-se tabela de probabilidade temporaria a incluir depois no theta
			double[][] temp;
			//se esxistirem pais
			if(Parents.length>0) {
				//obtêm-se os domínios de cada um dos pais
				int[] piDomains=new int[Parents.length];
				//prodomain representa o número de colunas que a tabela terá, já que cada uma é uma possivel 
				//comnbinação dos valores dos pais, o número total de colunas é o produtorio dos domínios dos vários pais.
				int prodomain=1;
				for(int i=0;i<piDomains.length;i++) {
					piDomains[i]=A.Domains(Parents[i]);
					prodomain*=A.Domains(Parents[i]);
				}
				//inicializa-se um vector que terá o valor atual de cada pai
				int[] piValues=new int[Parents.length];
				//define-se a dimensão da tabela de probabilidade - tanats linhas quantos valores
				//possiveis da variavel e tantas colunas quantas combinações dos valores possiveis
				//dos pais
				temp=new double[xDomain][prodomain];
				//correndo cada valor possivel da variavel
				for(int xi=0;xi<xDomain;xi++) {
					//i aponta para a coluna onde introduzir o valor calculado de theta em cada momento
					int i=0;
					while(i<prodomain) {
						//vai alterando o valor dos pais, altera só o valor do primeiro pai, que o ciclo seguinte 
						//faz a propagação do avanço deste valor para os pais seguintes (como um contador de gás)
						for(int j=0;j<piDomains[0];j++) {
							//cria os vectores que permitem ao count da amostra contar o número de
							//ocorrencias do valor atual do filho simultânea com os valores atuais dos pais
							int[] values1= new int[Parents.length+1];
							values1[0]=xi;
							int[] variables1= new int[Parents.length+1];
							variables1[0]=x;
							for(int k=1; k<values1.length;k++) {
								values1[k]=piValues[k-1];
								variables1[k]=Parents[k-1];
							}
							//calcula o logaritmo da probabilidade de observar um dado valor da variavel sabendo os valores dos seus pais
							temp[xi][i]=Math.log10(A.count(variables1, values1)+S)-Math.log10(A.count(Parents, piValues)+S*xDomain);
							i++;
							piValues[0]++;}
						//propagação do avanço do contador de gás, a primeira posição chegou ao seu máximo, por isso volta ao início
						//e faz avançar a posição seguinte, que se também estiver no seu máximo volta ao valor inicial e faz aumentar a 
						//seguinte, e assim por adiante
						piValues[0]=0;
						for(int j=1;j<Parents.length;j++) {
							if(++piValues[j]==piDomains[j]) piValues[j]=0;
							else {
								break;}
						}
					}
				}
			//quando a variavel não tem qualquer pai
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
	
	//calcula a probabilidade de observar um dado vector v tendo em conta as probabilidades definidas para a rede de bayes
	public double prob(int[] v) {
		double p=0.0;
		int x,i,j;
		//corre cada um dos valores no vector v, sendo x a sua posição, que identifica a variavel em si
		for(x=0;x<v.length;x++) {
			//vai buscar os pais da variavel
			int[] Parents=g.parents(x).toArray();
			//calcula os domínios dos vários pais (importante para a determinação da coluna a olhar da tabela de probabilidade
			int[] piDomains=new int[Parents.length];
			for(i=0;i<piDomains.length;i++) {
				piDomains[i]=Theta[Parents[i]].length;}
			//calcula a coluna a escolher a partir dos valores dos pais e dos seus domínios
			int position=0;
			for(i=0;i<Parents.length;i++) {
				int D=1;
				for(j=0;j<i;j++) {
					D*=piDomains[j];}
				position+=v[Parents[i]]*D;	
			}
			//adiciona ao logaritmo da probabilidade a parcela correspondente a esta variavel
			p+=Theta[x][v[x]][position];
		}
		//reconverte o valor encontrado de logaritmo para probabilidade de observar o vector v
		return Math.pow(10.0, p); 
	}	                       
}
