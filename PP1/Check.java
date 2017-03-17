import java.util.ArrayList;

public class Check {

	private Graph graph;

	public Check(Graph graph) {
		this.setGraph(graph);

	}

	private void setGraph(Graph graph) {
		this.graph = graph;
	}

	private Graph getGraph() {
		return this.graph;
	}

	public boolean isEulerian() {

		boolean result = true;
		for (Vertex vertex : this.getGraph().getVertexes()) {
			if (vertex.getAdjacencyList().size() % 2 == 1) {
				result = false;
				break;
			}
		}

		return result;
	}

	public boolean isHamiltonian() {

		return isHamiltonianUtil(new ArrayList<>(), this.graph.getVertex(0));
	}

	private boolean isHamiltonianUtil(ArrayList<Vertex> path, Vertex currentVertex) {

		if (path.size() == this.graph.getOrder()) {
			if (currentVertex.equals(this.graph.getVertex(0))) {
				return true;				
			}
			
			return false;
		}
		
		for (Vertex vertex : currentVertex.getAdjacencyList()) {
			if (!path.contains(vertex)) {
				path.add(vertex);

				if(isHamiltonianUtil(new ArrayList<>(path), vertex) == true) {
					return true;
				}

				path.remove(vertex);
			}							
		}
		
		return false;
	}

}
