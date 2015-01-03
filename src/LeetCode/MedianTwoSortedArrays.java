package LeetCode;

import java.util.Arrays;

public class MedianTwoSortedArrays {

	public static double findMedianSortedArrays(int A[], int B[]) {
		int lenA = A.length;
		int lenB = B.length;
		if ((lenA + lenB) % 2 == 1) {
			return getKthTwoSortedArray(A, 0, lenA - 1, B, 0, lenB - 1, (lenA + lenB) / 2 + 1);
		} else {
			int m1 = getKthTwoSortedArray(A, 0, lenA - 1, B, 0, lenB - 1, (lenA + lenB) / 2);
			int m2 = getKthTwoSortedArray(A, 0, lenA - 1, B, 0, lenB - 1, (lenA + lenB) / 2 + 1);
			return 1.0 * (m1 + m2) / 2;
		}
	}

	public static int getKthTwoSortedArray(int[] A, int al, int au, int[] B, int bl, int bu, int k) {
		if (au - al > bu - bl)
			return getKthTwoSortedArray(B, bl, bu, A, al, au, k);
		if (al > au)
			return B[bl + k - 1];
		if (k == 1)
			return Math.min(A[al], B[bl]);

		int amOffset = Math.min(k / 2, au - al + 1);
		int bmOffset = k - amOffset;
		int am = al + amOffset - 1;
		int bm = bl + bmOffset - 1;
		if (A[am] <= B[bm]) {
			return getKthTwoSortedArray(A, al + amOffset, au, B, bl, bu, k - amOffset);
		} else {
			return getKthTwoSortedArray(A, al, au, B, bl + bmOffset, bu, k - bmOffset);
		}
	}

	public static int getKthValidate(int[] A, int[] B, int k) {
		int lenA = A.length;
		int lenB = B.length;
		int[] C = new int[lenA + lenB];
		int ci = 0;
		for (int i = 0; i < lenA; ++i, ++ci) {
			C[ci] = A[i];
		}
		for (int i = 0; i < lenB; ++i, ++ci) {
			C[ci] = B[i];
		}
		Arrays.sort(C);
		return C[k - 1];
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 3, 4, 5, 6 }; // ArrayUtil.generateRandomArray(m, 1, 100);
		Arrays.sort(a);
		int[] b = new int[] { 1 }; // ArrayUtil.generateRandomArray(n, 1, 100);
		Arrays.sort(b);

		int testK = 11;
		// System.out.println(String.format("%d, %d", testK, getKthValidate(a, b, testK)));
		System.out.println(String.format("%d, %f", testK, findMedianSortedArrays(a, b)));

	}
}
