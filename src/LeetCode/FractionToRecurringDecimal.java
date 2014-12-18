package LeetCode;

import java.util.HashMap;

public class FractionToRecurringDecimal {

	public static long getGCD(long a, long b) {
		long c = a % b;
		while (c > 0) {
			a = b;
			b = c;
			c = a % b;
		}
		return b;
	}

	public static String fractionToDecimal(long numerator, long denominator) {
		// Corner case;
		if (numerator == 0)
			return "0";

		// Compute result sign;
		int sign = 1;
		if (numerator < 0) {
			sign = -sign;
			numerator = -numerator;
		}
		if (denominator < 0) {
			sign = -sign;
			denominator = -denominator;
		}

		// Prepare numerator and denominator
		long gcd = getGCD(numerator, denominator);
		long a = numerator / gcd;
		long b = denominator /= gcd;

		// Print sign;
		StringBuilder retSB = new StringBuilder();
		if (sign == -1) {
			retSB.append('-');
		}

		// Print integer part.
		retSB.append(a / b);
		a = a % b;

		// Print decimal point.
		if (a > 0) {
			retSB.append('.');
		}

		// Print decimal part.
		HashMap<Long, Integer> modNums = new HashMap<Long, Integer>();
		while (a > 0) {
			// Look up the table.
			// If exists, then decimal part repeats, then '()' is added and return;
			if (modNums.containsKey(a)) {
				retSB.insert(modNums.get(a) - 1, '(');
				retSB.append(')');
				return retSB.toString();
			}
			// Calculate quotient, add it to dictionary.
			long m = a * 10 / b;
			retSB.append(m);
			modNums.put(a, retSB.length());
			// Prepare for next iteration.
			a = a * 10 % b;
		}
		return retSB.toString();
	}

	public static void main(String[] args) {
		int testNum1 = -1;
		int testNum2 = -2147483648;
		System.out.println(String.format("%s", fractionToDecimal(testNum1, testNum2)));
		System.out.println(String.format("%.20f", 1.0 * testNum1 / testNum2));
		return;
	}
}
