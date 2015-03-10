package lab7;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import plotter.PolylinePlotter;

public class Plotter {

	public static void main(String[] args) throws FileNotFoundException {
		PolylinePlotter plotter = new PolylinePlotter();
		File inFile = new File("hello.txt");
		Scanner in = new Scanner(inFile);
		while (in.hasNextLine()) {
			String line = in.nextLine();
			line = line.trim();
			if (!line.equals("") && line.charAt(0) != '#') {
				String[] entry = line.split(" ");
				int word = 0;
				int pixelWidth = 1;
				if (Character.isDigit(entry[word].charAt(0))) {
					pixelWidth = Integer.parseInt(entry[word]);
					word++;
				}
//				System.out.println(pixelWidth);

				String color = entry[word];
//				System.out.println(color);
				
				boolean first = true;
				for (int i = word + 1; i < entry.length; i = i + 2) {
					int x = Integer.parseInt(entry[i]);
					int y = Integer.parseInt(entry[i + 1]);
//					System.out.println(x + "," + y);
					if(first){
						first = false;
						plotter.startLine(color, new Point(x, y), pixelWidth);
					} else {
						plotter.addPoint(new Point(x, y));
					}
					

				}

			}
		}
		in.close();
	}

}
