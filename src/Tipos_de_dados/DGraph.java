package Tipos_de_dados;

public class DGraph implements Oriented_Graphs{
	protected int[][] madj;
	protected int dim;
	
	public DGraph(int dim) {
		this.dim=dim;
		madj=new int[dim][dim];
	}
	
	public void add_edge(int o, int d) {
		madj[o][d]=1;		
	}


	public void remove_edge(int o, int d) {
		madj[o][d]=0;
	}


	public List parents(int n) {
		List parent=new Lista();
		for(int i=0;i<dim;i++) {
			if(madj[i][n]==1) parent.insert(i);
		}
		return parent;
	}
}
