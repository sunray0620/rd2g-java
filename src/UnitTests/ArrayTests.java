package UnitTests;

import Array.ArrayUtil;

public class ArrayTests {
	public static void main(String[] args) {
		int[] testArray = ArrayUtil.generateRandomArray(100, 11, 9999);

		ArrayUtil.printArray(testArray, 5);
		return;
	}
}
