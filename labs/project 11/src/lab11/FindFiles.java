package lab11;

import java.io.File;
import java.util.ArrayList;

public class FindFiles {

	public static void main(String[] args) {
		System.out.println(findFiles(new File("C:\\Users\\Amber\\Documents\\GitHub\\cs227\\")));
	}

	public static ArrayList<String> findFiles(File file) {
		// create an empty array list...
		ArrayList<String> arr = new ArrayList<String>();

		// pass it into the recursive method
		findFiles(file, arr);

		// and return the filled-up ArrayList
		return arr;
	}

	// recursive helper method
	private static void findFiles(File file, ArrayList<String> list) {
		if (file.isFile()) {
			if(file.getName().endsWith(".java")){
				list.add(file.getName());	
			}
		} else {
			File[] a = file.listFiles();
			for (int i = 0; i < a.length; i++) {
				findFiles(a[i], list);
			}
		}
	}
}
