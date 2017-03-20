import java.util.ArrayList;

class Walk extends TrackAbstract {

	private Graph graph;
	private int graphOrder;

	public Walk(Graph graph) {
		this.setGraph(graph);
		this.setGraphOrder(graph.getOrder());
	}

	@Override
	public boolean needPath() {

		return true;
	}

	@Override
	public boolean checkProposition(String path) {

		ArrayList<Integer> vertexes = this.getVertexes(path);

		if (vertexes.size() > 1) {
			boolean result = true;
			for (int i = 0; (i < vertexes.size() - 1) && result; i++) {
				
				if (!this.hasInGraph(vertexes, i, i + 1, graph)) {
					result = false;
					
				} else if (vertexes.get(i) == vertexes.get(i + 1)) {
					result = false;
					
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

	public int getGraphOrder() {
		return graphOrder;
	}

	public void setGraphOrder(int graphOrder) {
		this.graphOrder = graphOrder;
	}

}
