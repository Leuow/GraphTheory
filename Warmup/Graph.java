import java.util.ArrayList;

class Graph {
	private ArrayList<Vertex> vertexes;
	private int order; // how much vertexes

	public Graph(int order) {
		this.setOrder(order);
		this.vertexes = new ArrayList<Vertex>();

		for(int i = 0; i < this.getOrder(); i++) {
			Vertex vertex = new Vertex(i);
			this.addVertex(vertex);
		}
	}

	private void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}

	private void addVertex(Vertex vertex) {
		this.vertexes.add(vertex);
	}

	public Vertex getVertex(int index) {
		return this.vertexes.get(index);
	}

	public ArrayList<Vertex> getVertexes() {
		return this.vertexes;
	}
}
