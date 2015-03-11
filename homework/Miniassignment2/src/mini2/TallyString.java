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
	public static final int LINE_VALUE = 1;

	public static boolean isValidGroup(String s) {
		boolean result = false;
		String noStar = s.replace("" + STAR, "");
		String noStarLine = noStar.replace("" + LINE, "");
		if (s.equals("")) {
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
		if (givenValue < 0) {
			result = null;
		} else if (givenValue == 0) {
			result = "0";
		} else {
			int numStars = givenValue / 5;
			int numLines = givenValue % 5;
			for (int i = 0; i < numStars; i++) {
				result = result + "*";
			}
			for (int i = 0; i < numLines; i++) {
				result = result + "|";
			}
		}
		return result;
	}

	public static int evaluateGroup(String group) {
		int result = 0;
		if (isValidGroup(group)) {
			if (group.equals("0")) {
				result = 0;
			} else {
				for (int i = 0; i < group.length(); i++) {
					if (group.charAt(i) == STAR) {
						result = result + STAR_VALUE;
					} else if (group.charAt(i) == LINE) {
						result = result + LINE_VALUE;
					}
				}
			}
		} else {
			result = -1;
		}
		return result;
	}

	public static String makeNormalizedString(int givenValue) {
		String result = "";
		if (givenValue < 0) {
			result = null;
		} else {
			String s = "" + givenValue;
			for (int i = 0; i < s.length(); i++) {
				String digitString = "" + s.charAt(i);
				int digit = Integer.parseInt(digitString);
				String group = makeGroup(digit);
				result = result + group + " ";
			}
			result = result.trim();
		}
		return result;
	}

	public static int evaluateString(String s) {
		int result = 0;
		String[] groups = s.split(" ");
		int power = 1;
		for (int i = groups.length - 1; i >= 0; i--) {
			if (!isValidGroup(groups[i])) {
				return -1;
			} else {
				int groupTotal = evaluateGroup(groups[i]);
				groupTotal = groupTotal * power;
				result = result + groupTotal;
				power = power * 10;
			}
		}
		return result;
	}
}