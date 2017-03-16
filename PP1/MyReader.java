import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MyReader {
	private static final InputStreamReader in = new InputStreamReader(System.in);
	private static final BufferedReader br = new BufferedReader(in);
	private ArrayList<String> buffer;
	private int lastPosition;	
	
	public MyReader() {
		this.setLastPosition(0);
		this.setResult(new ArrayList<>());
	}
	
	private ArrayList<String> getResult() {
		return buffer;
	}

	private void setResult(ArrayList<String> result) {
		this.buffer = result;
	}

	private int getLastPosition() {
		return lastPosition;
	}

	private void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}
	
	private void addElementToBuffer(String element) {
		this.buffer.add(element);
	}

	public void readAll() {
		String line;

		try {
			while ((line = br.readLine()) != null) {
				String[] strings = line.split(" ");
				for (String value : strings) {
					this.addElementToBuffer(value);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int nextInt() {
		int position = this.getLastPosition();
		String string = this.getResult().get(position);
		int value = Integer.parseInt(string);
		
		this.setLastPosition(position + 1);
		
		return value;
	}
	
	public String nextString() {
		int position = this.getLastPosition();
		String value = this.getResult().get(position);
		
		this.setLastPosition(position + 1);
		
		return value;
	}
	
}
