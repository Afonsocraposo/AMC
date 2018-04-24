package Tipos_de_dados;

public class ListaE implements List_Edges {
	
	private Edge last;
	private Edge first;
	private int comp;
	
	protected class Edge {
		protected double weight;
		protected int nodea;
		protected int nodeb;
		
		Edge next;
		Edge prev;
		
		Edge(int node1, int Edge, double v){
			weight=v;
			
			nodea=node1;
			nodeb=Edge;
			
			next=null;
			prev=null;
		}
		
	}
	
	public ListaE() {
		last=null;
		first=null;
		comp=0;
	}

	public void append(int node1, int Edge, double x) {
		Edge n=new Edge(node1,Edge,x);
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
	
	public void ins(int node1, int Edge, double x, int pos) {
		
		if((pos>comp)||(pos<0)) {
			System.out.println("Error: segmentation fault");
			return;
		}else{
			
			Edge n=new Edge(node1,Edge,x);	
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
				Edge aux;
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
		Edge aux=last;
		while(aux!=null) {
			if((aux.nodea==nodea && aux.nodeb==nodeb) || (aux.nodea==nodeb && aux.nodeb==nodea)) {
				return true;
			}
			aux=aux.next;
		}
		return false;
	}
	
	public Edge pos(int n) {
		if((n>=comp)||(n<0)) {
			System.out.println("Error: segmentation fault");
			return new Edge(-1,-1,-1);
		}
		Edge aux;
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
		Edge aux;
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
		Edge aux=first;
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
	
	public int len() {
		return comp;
	}
	
	public void insort() {

		int i=1, j, n=this.len();
		Edge aux;
		
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
		return;
	}
	
}



