package Array;

import java.util.Date;
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
	}

	public static void printArrayWithIndex(int[] intArray, int sizePerLine) {
		for (int i = 0; i < intArray.length; ++i) {
			String s = String.format("[%1$d]: %1$s", i, intArray[i]);
			System.out.print(String.format("%1$-15s", s));

			if ((i + 1) % sizePerLine == 0) {
				System.out.println();
			}
		}
	}

	public static int[] generateRandomArray(int generateSize, int minValue, int maxValue) {
		Random rand = new Random((new Date()).getTime());

		int[] generatedArray = new int[generateSize];
		for (int i = 0; i < generatedArray.length; ++i) {
			int newValue = minValue + rand.nextInt(maxValue + 1);
			generatedArray[i] = newValue;
		}
		return generatedArray;
	}
}
