package Tipos_de_dados;

public class WGraph {
	
	private class Edge {
		
		private Gnode to;
		private int weight;
		private Edge next;
		
		private Edge(Gnode n, int w) {
			to=n;
			weight=w;
			next=null;
		}
		
		public Gnode get_to() {
			return to;
		}
		
		public int get_weight() {
			return weight;
		}
		
	}
	
	private class Children {
		
		private Edge last;
		private int comp;
		
		private Children() {
			last = null;
			comp = 0;
		}
		
		private void ins(Gnode n, int w) {
			Edge e = new Edge(n, w);
			e.next=last;
			last=e;
			comp++;
		}
		
		public Edge get_edge(int pos) {
			Edge aux = last;
			for(int i=comp-1;i>pos;i--) {
				aux=last.next;
			}
			return aux;
		}
		
		
	}
	
	
	class Gnode {
		
		private int val;
		private Gnode next;
		private Children children;
		
		private Gnode(int v){
			val=v;
			next=null;
			children = new Children();
		}	
		
		public int val() {
			return val;
		}
		
		public Children child() {
			return children;
		}
	}
	
	
	private Gnode first;
	private int comp;
	
	public WGraph(int n) {
		
		first=null;
		comp=n;
		
		for(int i=0;i<n;i++) {
			Gnode no = new Gnode(0);
			no.next = first;
			first=no;
		}
	}
	
	public void add_edge(Gnode n1, Gnode n2, int w) {
		Gnode aux=first;
		while(aux!=null) {
			if(aux==n1) {
				aux.children.ins(n2,w);
				return;
			}
			aux=aux.next;
		}
	}
	
	public Gnode get_Gnode(int pos) {
		Gnode aux = first;
		for(int i=comp-1;i>pos;i--) {
			aux=first.next;
		}
		return aux;
	}
	
	public static void main(String[] args) {
		WGraph g = new WGraph(3);
		Gnode n1 = g.get_Gnode(1);
		Gnode n2 = g.get_Gnode(2);
		g.add_edge(n1, n2, 3);
		Edge e = n1.child().get_edge(0);
		System.out.println(n2==e.get_to());
		System.out.println(e.get_weight());
	}
	
}
