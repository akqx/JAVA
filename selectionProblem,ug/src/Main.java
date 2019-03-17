import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("points.txt");
		List<Integer> tab = new ArrayList<Integer>();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextInt()) {

			tab.add(scanner.nextInt());
		}
	
		System.out.println(Selection.getSelection(tab,16));
		
	}
}
