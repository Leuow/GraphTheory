
public class Path implements TrackInterface {

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

		System.out.println("Path: " + path);

		return false;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
