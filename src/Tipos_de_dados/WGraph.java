public class WGraph {
	
	private class Edge {
		
		private Node to;
		private int weight;
		private Edge next;
		
		private Edge(Node n, int w) {
			to=n;
			weight=w;
			next=null;
		}
	}
	
	private class Children {
		
		private Edge last;
		
		private Children() {
			last = null;
		}
		
		private void ins(Node n, int w) {
			Edge e=new Edge(n, w);
			e.next=last;
			last=e;
		}
	}
	
	
	class Node {
		
		private int val;
		private Node next;
		private Children children;
		
		private Node(int v){
			val=v;
			next=null;
			children = new Children();
		}	
	}
	
	
	private Node first;
	
	public WGraph(int n) {
		
		first=null;
		
		for(int i=0;i<n;i++) {
			Node no = new Node(0);
			if(i==0) {
				no.next = first;
				first=no;
			}
		}
	}
	
	public void add_edge(Node n1, Node n2, int w) {
		Node aux=first;
		while(aux!=null) {
			if(aux==n1) {
				aux.children.ins(n2,w);
			}
			aux=aux.next;
		}
	}
	
}
