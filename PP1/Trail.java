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

		return true;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
