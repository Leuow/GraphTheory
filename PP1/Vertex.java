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
}
