
public class Eulerian implements TrackInterface {

	private Graph graph;

	public Eulerian(Graph graph) {
		this.setGraph(graph);
	}

	@Override
	public boolean needPath() {
		return false;
	}

	@Override
	public boolean checkProposition(String path) {

		boolean result = true;
		for (Vertex vertex : this.getGraph().getVertexes()) {
			if (vertex.getAdjacencyList().size() % 2 == 1) {
				result = false;
				break;
			}
		}

		return result;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
