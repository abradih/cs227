package lab7;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LineNumberer {
	public static void main(String[] args) throws FileNotFoundException {
		File inFile = new File("src\\lab7\\LineNumberer.java");
		Scanner in = new Scanner(inFile);
		File outFile = new File("LineNumberer2.txt");
		PrintWriter out = new PrintWriter(outFile);
		System.out.println(outFile.exists()); // true if the file exists
		System.out.println(outFile.getName()); // name of the file
		System.out.println(outFile.getAbsolutePath()); // absolute path to the
														// file
		System.out.println(outFile.length()); // size of the file
		int lineCount = 1;

		while (in.hasNextLine()) {
			String line = in.nextLine();
			out.print(lineCount + " ");
			out.println(line);
			lineCount += 1;
		}
		in.close();
		out.close();

		System.out.println("Done");
	}
}