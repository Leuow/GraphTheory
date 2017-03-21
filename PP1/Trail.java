import java.util.ArrayList;

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

		Walk walk = new Walk(this.getGraph());
		boolean isWalk = walk.checkProposition(path);

		if (isWalk) {
			int[][] matrix = new int[this.getGraph().getOrder()][this.getGraph().getOrder()];
			ArrayList<Integer> vertexes = this.getVertexes(path);

			for (int i = 0; i < vertexes.size() - 1; i++) {
				int a = vertexes.get(i);
				int b = vertexes.get(i + 1);

				if (a > b) {
					a = a + b;
					b = a - b;
					a = a - b;
				}

				if ((matrix[a - 1][b - 1] += 1) >= 2) {
					return false;
				}
			}

			return true;
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
