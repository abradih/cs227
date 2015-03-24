package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MileageCalculator {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<FillUp> list = new ArrayList<FillUp>();
		File file = new File("mileage.txt");
		Scanner scanner = new Scanner(file);
		// while there are more lines...
		while (scanner.hasNextLine()) {
			// get the next line
			String line = scanner.nextLine();
			String[] parts = line.split(" ");
			String odometerS = parts[0];
			String gallonsS = parts[1];
			int odometer = Integer.parseInt(odometerS);
			double gallons = Double.parseDouble(gallonsS);
			FillUp a = new FillUp(odometer, gallons);
			list.add(a);
		}

		FillUp previous = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			FillUp current = list.get(i);
			int milesDriven = current.getOdometer() - previous.getOdometer();
			double mpg = milesDriven / current.getGallons();
			System.out.println("Mileage " + i + ": " + mpg); 
			previous = current;
		}

		// close the file
		scanner.close();
	}
}
