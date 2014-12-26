package Array;

import java.util.Random;

public class ArrayUtil {

	public static void swap(int[] intArray, int i, int j) {
		int swapTemp = intArray[i];
		intArray[i] = intArray[j];
		intArray[j] = swapTemp;
	}

	public static void printArray(int[] intArray, int sizePerLine) {
		for (int i = 0; i < intArray.length; ++i) {
			System.out.print(String.format("%1$12s", intArray[i]));

			if ((i + 1) % sizePerLine == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void printArrayWithIndex(int[] intArray, int sizePerLine) {
		for (int i = 0; i < intArray.length; ++i) {
			String s = String.format("[%1$d]: %2$s", i, intArray[i]);
			System.out.print(String.format("%1$-15s", s));

			if ((i + 1) % sizePerLine == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	/*
	 * Generate an array of random integer in range between [minValue] and [maxValue]
	 */
	public static int[] generateRandomArray(int generateSize, int minValue, int maxValue) {
		int[] generatedArray = new int[generateSize];
		Random rand = new Random();
		int range = maxValue - minValue + 1;
		for (int i = 0; i < generatedArray.length; ++i) {
			int newValue = minValue + rand.nextInt(range);
			generatedArray[i] = newValue;
		}
		return generatedArray;
	}
}
