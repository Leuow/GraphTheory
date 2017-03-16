import java.util.ArrayList;

class Vertex {
	private int label;
	private int degree;
	private ArrayList<Vertex> adjacencyList;

	public Vertex(int label){
		this.setLabel(label);
		this.setDegree(0);
		this.adjacencyList = new ArrayList<Vertex>();
	}

	public void addAdjacentVertex(Vertex vertex) {
		this.addAdjacencyList(vertex);
		this.setDegree(this.getDegree() + 1);
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public int getLabel() {
		return this.label;
	}

	private void setDegree(int degree) {
		this.degree = degree;
	}

	public int getDegree() {
		return this.degree;
	}

	private void addAdjacencyList(Vertex vertex) {
		this.adjacencyList.add(vertex);
	}

	public ArrayList<Vertex> getAdjacencyList() {
		return this.adjacencyList;
	}
}
