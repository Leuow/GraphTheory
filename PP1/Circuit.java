import java.util.ArrayList;

class Circuit extends TrackAbstract {

	private Graph graph;

	public Circuit(Graph graph) {
		this.setGraph(graph);
	}

	@Override
	public boolean needPath() {

		return true;
	}

	@Override
	public boolean checkProposition(String path) {

		Trail trail = new Trail(this.getGraph());
		boolean isTrail = trail.checkProposition(path);

		if (isTrail) {
			ArrayList<Integer> vertexes = this.getVertexes(path);

			return vertexes.get(0) == vertexes.get(vertexes.size() - 1);
		}

		return false;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
