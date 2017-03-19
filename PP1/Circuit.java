import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

		ArrayList<Integer> vertexes = this.getVertexes(path);
		Set<Integer> edge = new HashSet<Integer>();

		for (int i = 0; i < vertexes.size() - 1; i++) {

			int a = vertexes.get(i);
			int b = vertexes.get(i + 1);

			if (a > b) {
				a += b;
				b = a - b;
				a -= b;
			}

			if (!edge.add(a * 10 + b)) {
				return false;
			}

		}

		return vertexes.get(0) == vertexes.get(vertexes.size() - 1);
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
