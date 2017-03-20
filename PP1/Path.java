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

		int edge = 0, newEdge = 0;
		int a = 0, b = 0;
		for (int i = 0; i < vertexes.size() - 1; i++) {

			a = vertexes.get(i);
			b = vertexes.get(i + 1);
			
			if (a == b) {
				return false;
			}else if (a > b) {
				a = a + b;
				b = a - b;
				a = a - b;
			}
			
			if (!(bitmap[a] ^= true)) { // if duplicate was found it is not a Path
				return false;
			}else if (i % 2 == 0) {
				edge = a * 10 + b;
			} else {
				newEdge = a * 10 + b;
				if (edge == newEdge) {
					return false;
				}
			}
		}
		
		a = vertexes.get(vertexes.size() - 1);
		b = vertexes.get(vertexes.size() - 2);

		if (a == b || !(bitmap[b] ^= true)) {
			return false;
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
