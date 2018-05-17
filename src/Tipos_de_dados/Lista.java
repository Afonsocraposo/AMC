package Tipos_de_dados;

import java.io.Serializable;

//implementa os nós utilizados pela lista, guardando um inteiro e apontando para o próximo nó
@SuppressWarnings("serial")
class Node implements Serializable{
	//os dois atributos já descritos
	public int value;
	public Node next;
	
	//Construtor, recebe à partida tanto o valor inteiro a receber como um próximo nó
	public Node(int value,Node next) {
		this.value=value;
		this.next=next;
	}
}

//implementa o objecto definido na interface List, que é uma lista ligada
@SuppressWarnings("serial")
public class Lista implements List,Serializable {
	protected Node first;
	protected int length;
	
	//constroi uma lista vazia, onde o primeiro nó ainda é vazio, e o comprimento da mesma é zero.
	public Lista() {
		first=null;
		length=0;
	}
	
	//converte a lista ligada num array
	public int[] toArray() {
		int[] res=new int[length];
		Node aux=first;
		for(int i=0;i<length;i++) {
			res[i]=aux.value;
			aux=aux.next;
		}
		return res;
	}
	
	//insere um  novo elemento no início da lista
	public void insert(int x) {
		Node aux=new Node(x,first);
		first=aux;
		length++;
	}
	//remove a primeira ocorrência de x
	public void remove(int x) {
		Node runner=first;
		if(runner.value==x) {
			first=runner.next;
			length--;
			return;}
		while(runner.next!=null&&runner.next.value!=x)runner=runner.next;
		if(runner.next!=null) {
			runner.next=runner.next.next;
			length--;
		}
	}
	//vê se a lista está vazia
	public boolean emptyQ() {
		return first==null;
	}
	//vê se o elemento x ocorre na lista
	public boolean isIn(int x) {
		Node runner=first;
		if(runner.value==x) {
			return true;}
		while(runner.next!=null&&runner.next.value!=x)runner=runner.next;
		if(runner.next!=null) {
			return true;
		}
		return false;
	}
	
	//devolve o elemento na posição x da lista
	public int pos(int x) {
		Node runner=first;
		if(x==0) {
			return runner.value;}
		for(int i=0;i<x;i++) {
			runner=runner.next;
		}
		return runner.value;
	}
	
	//imprime a lista na consola
	public void disp() {
		Node runner=first;
		while(runner!=null) {
	         System.out.print(runner.value + " ");
	         runner=runner.next;
	      }
		System.out.println(" ");
	}

}
