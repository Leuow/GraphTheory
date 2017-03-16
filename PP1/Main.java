import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {

		MyReader reader = new MyReader();
		reader.readAll();

		int numberVertexes = reader.nextInt();
		int numberPropositions = reader.nextInt();
		
		Graph graph = new Graph(numberVertexes);
		graph.readGraph(reader, numberVertexes);
		
	}
}
