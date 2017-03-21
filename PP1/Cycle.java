import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Cycle extends TrackAbstract {

	private Graph graph;

	public Cycle(Graph graph) {
		this.setGraph(graph);
	}

	@Override
	public boolean needPath() {

		return true;
	}

	@Override
	public boolean checkProposition(String path) {

		Circuit circuit = new Circuit(this.getGraph());
		boolean isCircuit = circuit.checkProposition(path);
		
		if (isCircuit) {
			ArrayList<Integer> vertexes = this.getVertexes(path);
			Set<Integer> check = new HashSet<Integer>();
			
			for (int i = 0; i < vertexes.size() - 1; i++) {
				if(!check.add(vertexes.get(i)) ){
					
					return false;
				}
			}
						
			return vertexes.get(0) == vertexes.get(vertexes.size() - 1);
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
