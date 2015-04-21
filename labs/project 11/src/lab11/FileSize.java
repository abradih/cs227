package lab11;

import java.io.File;

public class FileSize {

	public static void main(String[] args) {
		System.out.println(countBytes(new File("C:\\Users\\Amber\\Desktop\\HackISU2015")));
	}

	public static long countBytes(File f) {
		if (f.isFile()) {
			return f.length();
		} else {
			long result = 0;
			File[] a = f.listFiles();
			for (int i = 0; i < a.length; i++) {
				result = result + countBytes(a[i]);
			}
			return result;
		}
	}
}
