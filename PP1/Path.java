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

		Walk walk = new Walk(this.getGraph());		
		boolean isWalk = walk.checkProposition(path);
		
		if (isWalk) {
			Set<Integer> check = new HashSet<Integer>();
			ArrayList<Integer> vertexes = this.getVertexes(path);
			
			for (Integer vertex : vertexes) {
				if(!check.add(vertex) ){
					
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
