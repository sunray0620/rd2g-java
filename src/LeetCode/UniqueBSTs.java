package LeetCode;

public class UniqueBSTs {

	public static int numTrees(int n) {
		int[] numOfSlns = new int[n + 1];
		numOfSlns[0] = 1;
		numOfSlns[1] = 1;
		for (int i = 2; i <= n; ++i) {
			for (int root = 1; root <= i; ++root) {
				int leftTreeNodes = root - 1;
				int rightTreeNodes = i - root;
				numOfSlns[i] += numOfSlns[leftTreeNodes] * numOfSlns[rightTreeNodes];
			}
			System.out.println(numOfSlns[i]);
		}
		return numOfSlns[n];
	}

	public static void main(String[] args) {
		numTrees(5);
	}

}
