import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

class Main {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		MyReader reader = new MyReader();
		reader.readAll();

		int numberVertexes = reader.nextInt();
		int numberPropositions = reader.nextInt();

		Graph graph = new Graph(numberVertexes);
		graph.readGraph(reader, numberVertexes);

		for (int i = 0; i < numberPropositions; i++) {
			GenericPath proposition1 = new GenericPath(reader.nextString(), graph);
			GenericPath proposition2 = new GenericPath(reader.nextString(), graph);

			boolean truthProposition1;
			boolean truthProposition2;
			if (proposition1.needPath() || proposition2.needPath()) {
				String path = reader.nextString();
				truthProposition1 = proposition1.checkProposition(path);
				truthProposition2 = proposition2.checkProposition(path);
				
			} else {
				truthProposition1 = proposition1.checkProposition("");
				truthProposition2 = proposition2.checkProposition("");
			}

			boolean value = truthProposition1 && truthProposition2;
			
			System.out.println(value ? "yes" : "no");
		}
	}
}
