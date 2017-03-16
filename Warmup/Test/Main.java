import java.util.Scanner;
import java.util.ArrayList;

class Vertex {
	private int label;
	private int degree;
	private ArrayList<Vertex> adjacencyList;

	public Vertex(int label){
		this.setLabel(label);
		this.setDegree(0);
		this.adjacencyList = new ArrayList<Vertex>();
	}

	public void addAdjacentVertex(Vertex vertex) {
		this.addAdjacencyList(vertex);
		this.setDegree(this.getDegree() + 1);
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public int getLabel() {
		return this.label;
	}

	private void setDegree(int degree) {
		this.degree = degree;
	}

	public int getDegree() {
		return this.degree;
	}

	private void addAdjacencyList(Vertex vertex) {
		this.adjacencyList.add(vertex);
	}

	public ArrayList<Vertex> getAdjacencyList() {
		return this.adjacencyList;
	}
}

class Graph {
	private ArrayList<Vertex> vertexes;
	private int order; // how much vertexes

	public Graph(int order) {
		this.setOrder(order);
		this.vertexes = new ArrayList<Vertex>();

		for(int i = 0; i < this.getOrder(); i++) {
			Vertex vertex = new Vertex(i);
			this.addVertex(vertex);
		}
	}

	private void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}

	private void addVertex(Vertex vertex) {
		this.vertexes.add(vertex);
	}

	public Vertex getVertex(int index) {
		return this.vertexes.get(index);
	}

	public ArrayList<Vertex> getVertexes() {
		return this.vertexes;
	}
}

class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int graphOrder = scanner.nextInt();
		Graph graph = new Graph(graphOrder);

		for(int i = 0; i < graph.getOrder(); i++) {
			for(int j = 0; j < graph.getOrder(); j++) {
				int value = scanner.nextInt();

				if (value == 1) {
					Vertex vertexU = graph.getVertex(i);
					Vertex vertexV = graph.getVertex(j);
					vertexU.addAdjacentVertex(vertexV);
				}
			}
		}

		ArrayList<Vertex> vertexesList = graph.getVertexes();
		vertexesList.sort((x, y) -> x.getDegree() - y.getDegree());

		System.out.print(vertexesList.get(0).getDegree());
		for (int i = 1; i < vertexesList.size(); i++) {
				System.out.print(" " + vertexesList.get(i).getDegree());
    }
    // System.out.println();
	}
}
