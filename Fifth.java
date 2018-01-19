import java.util.*;


public class Fifth {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Vector<Double> xVector = new Vector<Double>();
		Vector<Double> yVector = new Vector<Double>();
	
		xVector=stringArrayToVector();
		System.out.println("Vector X: ");
		System.out.println(xVector);
		
		yVector=stringArrayToVector();
		System.out.println("Vector Y: ");
		System.out.println(yVector);
		try {
			compareStringLength(yVector, xVector);
		} catch (WektoryRoznejDlugosciException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static String[] stringToStringArray(String inputString) {
		String[] stringArray = inputString.split(" ");
		return stringArray;
	}
	
	private static Vector<Double> stringArrayToVector(){
		Vector<Double> vector = new Vector<Double>();
		boolean isCorrect=false;
		while(!isCorrect) {
			String line= input.nextLine();
			String[] stringArray=stringToStringArray(line);
			
			try {
			for(int i=0; i<stringArray.length;i++) {
				vector.add(Double.parseDouble(stringArray[i]));
			}
			isCorrect=true;
			}catch(NumberFormatException e) {
				System.out.println("Niepoprawny ciag");
				vector.removeAllElements();
				isCorrect=false;
			}
		}
		return vector;
	}
	
	
	private static boolean compareStringLength(Vector<Double> x, Vector<Double> y) throws WektoryRoznejDlugosciException {
		if (x.size()==y.size()) return true;
		else throw new WektoryRoznejDlugosciException();
	}

}
