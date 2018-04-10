package Tipos_de_dados;

public class ListaE {
	
	private Node2 last;
	private Node2 first;
	private int comp;
	
	protected class Node2 {
		protected int weight;
		protected int nodea;
		protected int nodeb;
		
		Node2 next;
		Node2 prev;
		
		Node2(int node1, int node2, int v){
			weight=v;
			
			nodea=node1;
			nodeb=node2;
			
			next=null;
			prev=null;
		}
		
	}
	
	public ListaE() {
		last=null;
		first=null;
		comp=0;
	}

	public void append(int node1, int node2, int x) {
		Node2 n=new Node2(node1,node2,x);
		n.next=last;
		n.prev=null;
		if(comp==0) {
			first=n;
		} else {
			last.prev=n;
		}
		last=n;
		comp++;
	}
	
	public void ins(int node1, int node2, int x, int pos) {
		
		if((pos>comp)||(pos<0)) {
			System.out.println("Error: segmentation fault");
			return;
		}else{
			
			Node2 n=new Node2(node1,node2,x);	
			if(pos==0) {
				n.next=null;
				n.prev=first;
				if(comp==0) {
					last=n;
				} else {
					first.next=n;
				}
				first=n;
				comp++;
			}else if(pos==comp) {
				n.next=last;
				n.prev=null;
				if(comp==0) {
					first=n;
				} else {
					last.prev=n;
				}
				last=n;
				comp++;
			} else {
				Node2 aux;
				if(pos>comp/2) {
					aux=last;
					for(int i=0;i<comp-pos;i++) {
						aux=aux.next;
					}
				} else {
					aux=first;
					for(int i=0;i<pos;i++) {
						aux=aux.prev;
					}
				}
				
				n.next=aux.next;
				n.prev=aux;
				aux.next.prev=n;
				aux.next=n;
				comp++;
			}
		}
	}
	
	public boolean vazQ() {
		return last==null;
	}
	
	public boolean pert(int nodea, int nodeb) {
		Node2 aux=last;
		while(aux!=null) {
			if((aux.nodea==nodea && aux.nodeb==nodeb) || (aux.nodea==nodeb && aux.nodeb==nodea)) {
				return true;
			}
			aux=aux.next;
		}
		return false;
	}
	
	public void ret(int x) {
		Node2 aux=last.next;
		Node2 ant=last;
		if(ant.weight==x) {
			last=ant.next;
			last.prev=null;
			comp--;
			return;
		}
		while(aux!=null) {
			if(aux.weight==x) {
				ant.next=aux.next;
				aux.next.prev = ant;
				comp--;
				return;
			}
			ant=ant.next;
			aux=aux.next;
		}
	}
	
	public void apaga(int x) {
		Node2 aux=last.next;
		Node2 ant=last;
		if(ant.weight==x) {
			last=ant.next;
			last.prev=null;
			comp--;
		}
		while(aux!=null) {
			if(aux.weight==x) {
				ant.next=aux.next;
				aux.next.prev = ant;
				comp--;
			}else {
			ant=ant.next;
			}
			aux=aux.next;
		}
	}
	
	public Node2 pos(int n) {
		if((n>=comp)||(n<0)) {
			System.out.println("Error: segmentation fault");
			return new Node2(-1,-1,-1);
		}
		Node2 aux;
		if(n>comp/2) {
			aux=last;
			for(int i=1;i<comp-n;i++) {
				aux=aux.next;
			}
		} else {
			aux=first;
			for(int i=0;i<n;i++) {
				aux=aux.prev;
			}
		}
		return aux;
	}
	
	public void del(int n) {
		if((n>=comp)||(n<0)) {
			System.out.println("Error: segmentation fault");
			return;
		}
		Node2 aux;
		if(n>comp/2) {
			aux=last;
			for(int i=1;i<comp-n;i++) {
				aux=aux.next;
			}
		} else {
			aux=first;
			for(int i=0;i<n;i++) {
				aux=aux.prev;
			}
		}
		if(aux.prev!=null) {
		aux.prev.next=aux.next;
		}
		if(aux.next!=null) {
			aux.next.prev=aux.prev;
		}
		if(n==0) {
			first=first.prev;
		}else if(n==comp-1) {
			last=last.next;
		}
		comp--;
	}
	
	public void disp() {
		Node2 aux=first;
		System.out.print("[");
		while(aux!=null) {
			if(aux.prev==null) {
				System.out.print("[" + aux.nodea + ", " + aux.nodeb + ", " + aux.weight + "]");
				aux=aux.prev;
			} else {
	         System.out.print("[" + aux.nodea + ", " + aux.nodeb + ", " + aux.weight +  "], ");
	         aux=aux.prev;
			}
	      }
		System.out.print("]");
		System.out.println(" ");
	}
	
	public int find(int x) {
		Node2 aux=first;
		for(int i=0;i<comp;i++) {
			if(aux.weight==x) {
				return i;
			}
			aux=aux.prev;
		}
		return -1;
	}
	
	public int len() {
		return comp;
	}
	
	public ListaE insort() {

		int i=1, j, n=this.len();
		Node2 aux;
		
		while(i < n){
			aux=this.pos(i);
			j=i-1;
			while(j>=0 && this.pos(j).weight > aux.weight) {
		       this.ins(this.pos(j).nodea, this.pos(j).nodeb, this.pos(j).weight, j+1);
		       this.del(j+2);
		       j--;}
			this.ins(aux.nodea, aux.nodeb, aux.weight, j+1);
			this.del(j+2);
		    i++;
		}
		return this;
	}
	
}



