package LeetCode;

public class PowXN {
	public double pow(double x, int n) {
		if (n == 0) {
			return 1.0;
		} else if (isEqualToOne(x, 1.0)) {
			return 1.0;
		} else if (isEqualToOne(x, -1.0)) {
			if (n % 2 == 0) {
				return 1.0;
			} else {
				return -1.0;
			}
		} else {
			return powpow(x, n);
		}
	}

	private boolean isEqualToOne(double x, double y) {
		double eps = 0.0001;
		return x >= y - eps && x <= y + eps;
	}

	private double powpow(double x, int n) {
		if (n < 0) {
			return 1.0 / pow(x, -n);
		}

		double pow2 = pow(x, n / 2);
		double ret = pow2 * pow2;
		if (n % 2 == 1) {
			ret *= x;
		}
		return ret;
	}
}
