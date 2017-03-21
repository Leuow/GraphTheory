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

		Walk walk = new Walk(this.getGraph());		
		boolean isWalk = walk.checkProposition(path);
		
		if (isWalk) {
			Set<Integer> check = new HashSet<Integer>();
			ArrayList<Integer> vertexes = this.getVertexes(path);
			
			for (int i = 0; i < vertexes.size() - 1; i++) {
				int a = vertexes.get(i);
				int b = vertexes.get(i+1);
				
				if(a > b){
					a = a + b;
					b = a - b;
					a = a - b;
				}
				
				if(!check.add(a*1000 + b)){
			
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
