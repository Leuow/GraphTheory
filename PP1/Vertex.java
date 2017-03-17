import java.util.ArrayList;

class Vertex {
	private int label;
	private ArrayList<Vertex> adjacencyList;
	
	public ArrayList<Vertex> getAdjacencyList() {
		return adjacencyList;
	}

	public Vertex(int label) {
	        adjacencyList = new ArrayList<Vertex>();
	        this.setLabel(label);
	}
	
	private void setLabel(int label) {
	        this.label = label;
	}
	
	public int getLabel() {
	        return this.label;
	}
	
	public void connectTo(Vertex vertex) {
	        this.adjacencyList.add(vertex);
	}
	
	public boolean equals(Object o) {
		if(o == null){
			return false;
		}
		if(o == this) {
			return true;
		}
		if (!(o instanceof Vertex))return false;
		Vertex v = (Vertex) o;
		if(v.label == this.label) {
			return true;
		}
		return false;
	}
	
	public boolean hasEdgeTo(Vertex v) {
		for (Vertex vertex : this.getAdjacencyList()) {
			if(vertex.equals(v)){
				return true;
			}
		}
		return false;
	}
}
