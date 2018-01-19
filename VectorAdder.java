import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class VectorAdder {
	Vector<Double> a, b;
	static Scanner input = new Scanner(System.in);

	public VectorAdder() {
		a = new Vector<Double>();
		b = new Vector<Double>();
		startAddition();
	}

	private void inputVectors() {
		a = stringArrayToVector();
		b = stringArrayToVector();
	}

	private void startAddition() {
		boolean isCorrect = false;
		while (!isCorrect) {
			inputVectors();
			try {
				compareStringLength(a, b);
				isCorrect = true;
			} catch (WektoryRoznejDlugosciException e) {
				System.out.println(e.getMessage());
			}
			try {
				saveResult(addVectors());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveResult(Vector result) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("result.txt");
		writer.println(result);
		writer.close();
	}
	
	private Vector addVectors () {
		Vector <Double> result = new Vector<Double>(a.size());
		for (int i = 0; i<a.size();i++) {
			result.add(a.elementAt(i) + b.elementAt(i) );
		}
		return result;
	}
	
	private static String[] stringToStringArray(String inputString) {
		String[] stringArray = inputString.split(" ");
		return stringArray;
	}

	private static Vector<Double> stringArrayToVector() {
		Vector<Double> vector = new Vector<Double>();
		System.out.println("Wprowadz wektor: ");
		boolean isCorrect = false;
		while (!isCorrect) {
			String line = input.nextLine();
			String[] stringArray = stringToStringArray(line);

			try {
				for (int i = 0; i < stringArray.length; i++) {
					vector.add(Double.parseDouble(stringArray[i]));
				}
				isCorrect = true;
			} catch (NumberFormatException e) {
				System.out.println("Niepoprawny ciag");
				vector.removeAllElements();
				isCorrect = false;
			}
		}
		
		System.out.println("Wprowadzony wektor:");
		System.out.println(vector);
		return vector;
	}

	
	private static boolean compareStringLength(Vector<Double> x, Vector<Double> y)
			throws WektoryRoznejDlugosciException {
		if (x.size() == y.size())
			return true;
		else
			throw new WektoryRoznejDlugosciException();
	}
}
