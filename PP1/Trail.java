import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Trail extends TrackAbstract {

	private Graph graph;

	public Trail(Graph graph) {
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

				} else {
					int a = vertexes.get(i);
					int b = vertexes.get(i + 1);

					if (a > b) {
						a = a + b;
						b = a - b;
						a = a - b;
					}

					if (!check.add(a * 10 + b)){
						return false;
						
					}
				}
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
