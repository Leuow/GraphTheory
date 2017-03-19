import java.util.ArrayList;

public class Hamiltonian implements InterfaceGenericPath {

	private Graph graph;

	public Hamiltonian(Graph graph) {
		this.setGraph(graph);
	}

	@Override
	public boolean needPath() {

		return false;
	}

	@Override
	public boolean checkProposition(String path) {

		return isHamiltonianUtil(new ArrayList<>(), this.graph.getVertex(0));
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
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

				if (isHamiltonianUtil(new ArrayList<>(path), vertex) == true) {
					return true;
				}

				path.remove(vertex);
			}
		}

		return false;
	}

}
