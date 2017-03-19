import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Walk extends TrackAbstract {

	private Graph graph;

	public Walk(Graph graph) {
		this.graph = graph;
	}

	@Override
	public boolean needPath() {

		return true;
	}

	@Override
	public boolean checkProposition(String path) {

		ArrayList<Integer> vertexes = this.getVertexes(path);

		int edge = 0;
		int newEdge = 0;
		for (int i = 0; i < vertexes.size() - 1; i++) {

			int a = vertexes.get(i);
			int b = vertexes.get(i + 1);

			if (i % 2 == 0) {
				if (a > b) {
					a += b;
					b = a - b;
					a -= b;
				}
				edge = a * 10 + b;
			} else {
				if (a > b) {
					a += b;
					b = a - b;
					a -= b;
				}
				newEdge = a * 10 + b;
				if (edge == newEdge) {
					return false;
				}

			}

			if (a == b) {
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
