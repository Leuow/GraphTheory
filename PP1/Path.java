import java.util.ArrayList;

class Path extends TrackAbstract {

	private Graph graph;

	public Path(Graph graph) {
		this.setGraph(graph);
	}

	@Override
	public boolean needPath() {

		return true;
	}

	@Override
	public boolean checkProposition(String path) {

		ArrayList<Integer> vertexes = this.getVertexes(path);
		boolean[] bitmap = new boolean[vertexes.size() + 1];

		for (int item : vertexes) {
			if (!(bitmap[item] ^= true)) { // if duplicate was found it is not a Path
				return false;
			}
		}

		return true;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
