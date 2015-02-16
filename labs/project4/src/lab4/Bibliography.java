package lab4;

import java.util.Scanner;

public class Bibliography {

	public static void main(String[] args) {
		String s1 = "Dijkstra, Edsger#Go To Statement Considered Harmful#Communications of the ACM#1968#11";
		String s2 = "Levoy, Marc#Display of Surfaces from Volume Data#IEEE Computer Graphics and Applications#1988#8";
		String s3 = "Dean, Jeffrey; Ghemawat, Sanjay#MapReduce: Simplified Data Processing on Large Clusters#Communications of the ACM#2008#51";
		System.out.println(convertStringToBibliography(s1));
		System.out.println(convertStringToBibliography(s2));
		System.out.println(convertStringToBibliography(s3));
	}

	private static BibItem convertStringToBibliography(String s) {
		Scanner parser = new Scanner(s);
		parser.useDelimiter("#");
		String authors = parser.next();
		String title = parser.next();
		String journal = parser.next();
		String year = parser.next();
		String volume = parser.next();

		BibItem bib = new BibItem(authors, title, journal,
				Integer.parseInt(year), Integer.parseInt(volume));

		return bib;
	

	}
}
