package LeetCode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int newEnd = -1;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] != elem) {
				A[++newEnd] = A[i];
			}
		}
		return newEnd + 1;
	}
}
