package Array;

import java.util.Arrays;
import java.util.Random;

public class ArrayMedian {

	public static int getKthBySort(int[] a, int k) {
		int[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		return b[k];
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static int partition(int[] a, int startPos, int endPos) {
		int pivotPos = startPos;
		for (int i = startPos + 1; i <= endPos; ++i) {
			if (a[i] < a[startPos]) {
				++pivotPos;
				swap(a, pivotPos, i);
			}
		}
		swap(a, startPos, pivotPos);
		return pivotPos;
	}

	public static int getKth(int[] a, int l, int u, int k) {

		while (true) {
			int q = partition(a, l, u);
			int offset = q - l;

			if (offset == k) {
				return a[q];
			} else if (offset < k) {
				l = q + 1;
				k = k - offset - 1;
			} else {
				u = q - 1;
			}
		}

	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			System.out.print(String.format("%d, ", a[i]));
		}
		System.out.println();
	}

	private static int[] generateRandomArray(int n, int min, int max) {
		Random rnd = new Random();
		int range = max - min + 1;
		int[] array = new int[n];
		for (int i = 0; i < n; ++i) {
			array[i] = rnd.nextInt(range) + min;
		}
		return array;
	}

	public static void main(String[] args) {
		int testSize = 100;
		int[] testArray = generateRandomArray(testSize, 0, 10000);
		printArray(testArray);

		System.out.println(String.format("5th: %d", getKthBySort(testArray, 45)));

		System.out.println(String.format("5th: %d", getKth(testArray, 0, testSize - 1, 45)));
	}
}
