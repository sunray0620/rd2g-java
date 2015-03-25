package LeetCode;

public class PermutationSequence {

	public String getPermutation(int n, int k) {
		char[] wt = new char[n];
		for (int i = 0; i < n; ++i) {
			wt[i] = (char) (i + 1 + '0');
		}
		for (int i = 0; i < k; ++i) {
			getNextPermutation(wt);
		}

		return new String(wt);
	}

	public void getNextPermutation(char[] ns) {
		int strlen = ns.length;

		for (int i = strlen - 2; i >= 0; --i) {
			if (ns[i] < ns[i + 1]) {
				int j = strlen - 1;
				for (j = strlen - 1; ns[i] > ns[j]; --j)
					;
				swap(ns, i, j);
				reverse(ns, i + 1, strlen - 1);
				return;
			}
		}
		reverse(ns, 0, strlen - 1);
		return;
	}

	private void reverse(char[] ns, int l, int u) {
		while (l < u) {
			swap(ns, l, u);
			++l;
			--u;
		}
	}

	private void swap(char[] ns, int i, int j) {
		char swapTemp = ns[i];
		ns[i] = ns[j];
		ns[j] = swapTemp;
	}

	private void printArrayAsNum(int[] ns) {
		for (int i = 0; i < ns.length; ++i) {
			System.out.print(String.format("%d  ", ns[i]));
		}
		System.out.println();
	}

}
