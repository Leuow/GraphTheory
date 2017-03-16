import java.util.ArrayList;

class Graph {
	private int order;
	private ArrayList<Vertex> vertexes;
	
	public ArrayList<Vertex> getVertexes() {
		return vertexes;
	}

	public Graph(int order) {
	        this.setOrder(order);
	        this.vertexes = new ArrayList<Vertex>();
	
	        for (int i = 1; i <= order; i++) {
	                Vertex vertex = new Vertex(i);
	                this.vertexes.add(vertex);
	        }
	}
	
	private void setOrder(int order) {
	        this.order = order;
	}
	
	public int getOrder() {
	        return this.order;
	}
	
	private void connectTo(Vertex source, Vertex destiny, boolean isBidirectional) {
	        source.connectTo(destiny);
	
	        if(isBidirectional) {
	                destiny.connectTo(source);
	        }
	}
	
	public void connectTo(int source, int destiny, boolean isBidirectional) {
	        Vertex u = this.getVertex(source);
	        Vertex v = this.getVertex(destiny);
	
	        this.connectTo(u, v, isBidirectional);
	}
	
	public Vertex getVertex(int position) {
	        Vertex vertex = vertexes.get(position);
	        return vertex;
	}
	
	public void readGraph(MyReader reader, int numberVertexes) {
		for (int i = 0; i < numberVertexes; i++) {
			for (int j = 0; j < numberVertexes; j++) {
				int value = reader.nextInt();
				if(value == 1) {
					this.connectTo(i, j, false);					
				}
			}
		}
	}
}
