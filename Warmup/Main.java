import java.util.Scanner;
import java.util.ArrayList;

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
