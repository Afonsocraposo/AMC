package Tipos_de_dados;

import java.io.Serializable;

@SuppressWarnings("serial")
class Node implements Serializable{
	public int value;
	public Node next;
	
	public Node(int value,Node next) {
		this.value=value;
		this.next=next;
	}
}

@SuppressWarnings("serial")
public class Lista implements List,Serializable {
	protected Node first;
	protected int length;
	
	public Lista() {
		first=null;
		length=0;
	}
	public int[] toArray() {
		int[] res=new int[length];
		Node aux=first;
		for(int i=0;i<length;i++) {
			res[i]=aux.value;
			aux=aux.next;
		}
		return res;
	}
	public void insert(int x) {
		Node aux=new Node(x,first);
		first=aux;
		length++;
	}

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

	public boolean emptyQ() {
		return first==null;
	}
	
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
	
	public int pos(int x) {
		Node runner=first;
		if(x==0) {
			return runner.value;}
		for(int i=0;i<x;i++) {
			runner=runner.next;
		}
		return runner.value;
	}
	
	public void disp() {
		Node runner=first;
		while(runner!=null) {
	         System.out.print(runner.value + " ");
	         runner=runner.next;
	      }
		System.out.println(" ");
	}

}
