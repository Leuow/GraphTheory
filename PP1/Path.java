import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

		Set<Integer> check = new HashSet<Integer>();
		ArrayList<Integer> vertexes = this.getVertexes(path);

		if (vertexes.size() > 1) {
			boolean result = true;
			for (int i = 0; (i < vertexes.size() - 1) && result; i++) {
				if (!this.hasInGraph(vertexes, i, i + 1, graph)) {
					result = false;

				} else if (vertexes.get(i) == vertexes.get(i + 1)) {
					result = false;

				} else if (!check.add(vertexes.get(i))) {
					return false;

				}
			}

			if (!check.add(vertexes.get(vertexes.size() - 1))) {
				return false;

			}
			return result;
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
