import java.util.ArrayList;

abstract class TrackAbstract {

	abstract public boolean needPath();

	abstract public boolean checkProposition(String path);

	public ArrayList<Integer> getVertexes(String line) {

		ArrayList<Integer> vertexes = new ArrayList<>();
		String[] string = line.split("-");
		for (String vertex : string) {
			vertexes.add(Integer.parseInt(vertex));
			
		}

		return vertexes;
	}
	
	public boolean hasVertex(ArrayList<Integer> vertexes, int indexU, int indexV, Graph graph) {
		
		int position = vertexes.get(indexU) - 1;			// get vertex position in graph;					
		if(position < 0 || position >= graph.getOrder()) { 		// check if vertex from input exists
			return false;
		}
		
		position = vertexes.get(indexV) - 1;
		if(position < 0 || position >= graph.getOrder()) { 		// check if vertex from input exists
			return false;
		}
		
		return true;
	}
	
	
	public boolean hasEdge(ArrayList<Integer> vertexes, int indexU, int indexV, Graph graph) {
		
		int iU = vertexes.get(indexU) - 1;
		int iV = vertexes.get(indexV) - 1;
		Vertex u = graph.getVertex(iU);
		Vertex v = graph.getVertex(iV);
			
		return u.getAdjacencyList().contains(v);
	}
	
	public boolean hasInGraph(ArrayList<Integer> vertexes, int indexU, int indexV, Graph graph) {
		
		boolean resultHasVertex = this.hasVertex(vertexes, indexU, indexV, graph);
		
		if(resultHasVertex){
			boolean resultHasEdge = this.hasEdge(vertexes, indexU, indexV, graph);			
		
			return resultHasVertex && resultHasEdge;
		}
		
		return false;
	}
	
}
