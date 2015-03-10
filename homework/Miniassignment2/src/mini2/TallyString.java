package mini2;

/**
 * Makes a class that tally's up the total.
 * 
 * @author Amber
 *
 */
public class TallyString {
	public static final char STAR = '*';
	public static final char LINE = '|';
	public static final int STAR_VALUE = 5;

	public static boolean isValidGroup(String s) {
		boolean result = false;
		String noStar = s.replace("" + STAR, "");
		String noStarLine = noStar.replace("" + LINE, "");
		if(s.equals("")){
			result = false;
		} else if (s.equals("0")) {
			result = true;
		} else if (s.contains(" ")) {
			result = false;
		} else if (noStarLine.isEmpty()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public static String makeGroup(int givenValue) {
		String result = "";
		int numStars = givenValue/5;
		int numLines = givenValue % 5;
		for(int i = 0; i<numStars; i++){
			result = result + "*";
		}
		for(int i = 0; i<numLines; i++){
			result = result + "|";
		}
		return result;
	}

	public static int evaluateGroup(String group) {
		int result = 0;
		return result;
	}

	public static String makeNormalizedString(int givenValue) {
		String result = "";
		return result;
	}

	public static int evaluateString(String s) {
		int result = 0;
		return result;
	}
}