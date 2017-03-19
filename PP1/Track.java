import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Track {

	private static final String METHOD_NAME_NEED_PATH = "needPath";
	private static final String METHOD_NAME_CHECK_PROPOSITION = "checkProposition";

	private String className;
	private Method methodNeedPath;
	private Method methodCheckProposition;
	private Object instanceOfMyClass;
	private boolean toggleProposition;
	private Graph graph;

	private static final HashMap<String, String> DICTIONARY = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put("passeio", "Walk");
			put("caminho", "Path");
			put("trilha", "Trail");
			put("circuito", "Circuit");
			put("ciclo", "Cycle");
			put("hamiltoniano", "Hamiltonian");
			put("euleriano", "Eulerian");
		}
	};

	public Track(String className, Graph graph) {
		this.setGraph(graph);

		if (className.substring(0, 1).equals("!")) {
			String rightName = className.substring(1);
			String newName = DICTIONARY.get(rightName);
			this.setClassName(newName);

			this.setToggleProposition(true);

		} else {
			this.setToggleProposition(false);

			String newName = DICTIONARY.get(className);
			this.setClassName(newName);
		}

		try {

			Class<?> myClass = Class.forName(this.getClassName());
			Constructor<?> constructor = myClass.getConstructor(Graph.class);
			this.setInstanceOfMyClass(constructor.newInstance(this.getGraph()));

			setMethodNeedPath(this.getInstanceOfMyClass().getClass().getMethod(METHOD_NAME_NEED_PATH));
			setMethodCheckProposition(
					this.getInstanceOfMyClass().getClass().getMethod(METHOD_NAME_CHECK_PROPOSITION, String.class));

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public String getClassName() {
		return className;
	}

	private void setClassName(String className) {
		this.className = className;
	}

	private Method getMethodNeedPath() {
		return methodNeedPath;
	}

	private void setMethodNeedPath(Method methodNeedPath) {
		this.methodNeedPath = methodNeedPath;
	}

	private Method getMethodCheckProposition() {
		return methodCheckProposition;
	}

	private void setMethodCheckProposition(Method methodCheckProposition) {
		this.methodCheckProposition = methodCheckProposition;
	}

	public Object getInstanceOfMyClass() {
		return instanceOfMyClass;
	}

	private void setInstanceOfMyClass(Object instanceOfMyClass) {
		this.instanceOfMyClass = instanceOfMyClass;
	}

	public boolean needPath() {

		try {
			return ((boolean) this.getMethodNeedPath().invoke(this.getInstanceOfMyClass()));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean checkProposition(String path) {

		try {
			boolean value = ((boolean) this.getMethodCheckProposition().invoke(this.getInstanceOfMyClass(), path));
			
			if(this.isToggleProposition()) {
				
				return !value;
			}

			return value;
					
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean isToggleProposition() {
		return toggleProposition;
	}

	private void setToggleProposition(boolean toggleProposition) {
		this.toggleProposition = toggleProposition;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}
