package LeetCode;

public final class ValidNumber {
	/*
	 * Validate if a given string is numeric.
	 * 
	 * Some examples:
	 * "0" => true
	 * " 0.1 " => true
	 * "abc" => false
	 * "1 a" => false
	 * "2e10" => true
	 * Note: It is intended for the problem statement to be ambiguous.
	 * You should gather all requirements up front before implementing one.
	 */

	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length() == 0)
			return false;

		if (s.indexOf('e') == -1) {
			return isReal(s);
		} else if (s.indexOf('e') != s.lastIndexOf('e')) {
			return false;
		} else {
			String[] parts = s.split("e");
			if (parts.length != 2)
				return false;
			return isReal(parts[0]) && isInt(parts[1]);
		}
	}

	private boolean isReal(String s) {
		if (s.indexOf('+') == 0 || s.indexOf('-') == 0) {
			s = s.substring(1);
		}
		if (s.length() == 0)
			return false;

		if (s.indexOf('.') == -1) {
			return isAllDigit(s);
		} else if (s.indexOf('.') != s.lastIndexOf('.')) {
			return false;
		} else {
			String[] parts = s.split("\\.");
			if (parts.length != 1 && parts.length != 2)
				return false;
			for (int i = 0; i < parts.length; ++i) {
				if (!isAllDigit(parts[i]))
					return false;
			}
		}

		return true;
	}

	private boolean isInt(String s) {
		if (s.indexOf('+') == 0 || s.indexOf('-') == 0) {
			s = s.substring(1);
		}
		if (s.length() == 0) {
			return false;
		}
		return isAllDigit(s);
	}

	private boolean isAllDigit(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (!Character.isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}
}
