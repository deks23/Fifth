import java.util.*;
import java.io.*;
import java.lang.*;

public class Fifth {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Vector<Double> x = new Vector<Double>();
		
		String line = null;
		line=input.nextLine();
		String[] stringArray = line.split(" ");
		
		for(int i=0; i<stringArray.length;i++) {
			x.add(Double.parseDouble(stringArray[i]));
		}
		
	}
	
	
}
