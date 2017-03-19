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
	
}
