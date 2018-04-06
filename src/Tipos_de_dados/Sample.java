package Tipos_de_dados;

public interface Sample {
	public void add(int[] v);//adiciona o vetor v à amostra
	public int length();//retorna o comprimento da amostra
	public int[] element(int i);//devolve o vector na posição i da amostra
	public int count(int[] variables, int[] values);//recebe um vector de variaveis Xi e um vector de
	                                               //valores di e devolve o numero de ocorrencias dessas 
	                                              //variaveis com esses valores
}
