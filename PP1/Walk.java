
public class Walk implements TrackInterface {
	
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

		System.out.println("Walk: " + path);

		return false;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
