package LeetCode;

import java.util.Arrays;
import java.util.Random;

public class MinRotatedSortedArray {

	public static int findMin(int[] num) {
		if (num.length == 1)
			return num[0];
		int l = 0;
		int u = num.length - 1;
		while (l < u - 1) {
			int m = (l + u) / 2;
			if (num[u] > num[l]) {
				// In order
				return num[l];
			} else {
				if (num[m] > num[l]) {
					l = m;
				} else {
					u = m;
				}
			}
		}
		return Math.min(num[l], num[u]);
	}

	private static void printArray(int[] arr) {
		for (int e : arr) {
			System.out.print(String.format("%d  ", e));
		}
		System.out.println();
	}

	private static void swapArrayElem(int[] arr, int p1, int p2) {
		int swapTemp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = swapTemp;
	}

	private static void reverseArrayElem(int[] arr, int l, int u) {
		for (; l < u; --u, ++l) {
			swapArrayElem(arr, l, u);
		}
	}

	private static void rotateArray(int[] arr) {
		int arrLen = arr.length;
		Random r = new Random();
		int pivotPos = r.nextInt(arrLen);

		reverseArrayElem(arr, 0, pivotPos);
		reverseArrayElem(arr, pivotPos + 1, arrLen - 1);
		reverseArrayElem(arr, 0, arrLen - 1);
	}

	public static void main(String[] args) {
		// Random rnd = new Random();
		int testSize = 20;
		int[] testArray = new int[testSize];
		for (int i = 0; i < testSize; ++i) {
			testArray[i] = i * 2 + 8;
		}
		Arrays.sort(testArray);
		rotateArray(testArray);
		printArray(testArray);

		System.out.println(String.format("%d", findMin(testArray)));
	}
}
