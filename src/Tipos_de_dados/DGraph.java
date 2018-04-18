package Tipos_de_dados;

public class DGraph implements Oriented_Graphs{
	protected List[] ladj;
	protected int dim;
	
	public DGraph(int dim) {
		this.dim=dim;
		ladj=new List[dim];
	}
	
	public void add_edge(int o, int d) {
		ladj[d].insert(o);		
	}


	public void remove_edge(int o, int d) {
		ladj[d].remove(o);
	}


	public List parents(int n) {
		return ladj[n];
	}
}
