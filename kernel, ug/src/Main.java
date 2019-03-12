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
		List<Point> points = new ArrayList<Point>();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextInt()) {

			points.add(new Point(scanner.nextInt(), scanner.nextInt()));
		}

		Extrema a = new Extrema();
		System.out.println((a.getKernel(points).isExist()));
		
	}

}
