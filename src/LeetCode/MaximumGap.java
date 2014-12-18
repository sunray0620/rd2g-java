package LeetCode;

import java.util.Arrays;
import java.util.Random;

public class MaximumGap {

	/*
	 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
	 * Try to solve it in linear time/space.
	 * Return 0 if the array contains less than 2 elements.
	 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
	 */
	public static int maximumGap(int[] num) {
		int arraySize = num.length;
		if (arraySize < 2)
			return 0;
		// Get global min and global max;
		int gMin = Integer.MAX_VALUE;
		int gMax = Integer.MIN_VALUE;
		for (int i = 0; i < arraySize; ++i) {
			gMax = Math.max(gMax, num[i]);
			gMin = Math.min(gMin, num[i]);
		}

		//
		int range = gMax - gMin + 1;
		int bucketSize = Math.max(range / arraySize, 1);
		int numOfBuckets = range / bucketSize + 1;

		int[] bucketMins = new int[numOfBuckets];
		int[] bucketMaxs = new int[numOfBuckets];
		boolean[] bucketHasItem = new boolean[numOfBuckets];
		for (int i = 0; i < arraySize; ++i) {
			int bucketWillGo = (num[i] - gMin) / bucketSize;
			if (bucketHasItem[bucketWillGo]) {
				bucketMaxs[bucketWillGo] = Math.max(bucketMaxs[bucketWillGo], num[i]);
				bucketMins[bucketWillGo] = Math.min(bucketMins[bucketWillGo], num[i]);
			} else {
				bucketHasItem[bucketWillGo] = true;
				bucketMaxs[bucketWillGo] = num[i];
				bucketMins[bucketWillGo] = num[i];
			}
		}

		//
		int maxGap = 0;
		int maxInPrevBucket = bucketMaxs[0];
		for (int i = 1; i < numOfBuckets; ++i) {
			if (!bucketHasItem[i]) {
				continue;
			}
			int possibleMaxGap = bucketMins[i] - maxInPrevBucket;
			maxGap = Math.max(maxGap, possibleMaxGap);
			maxInPrevBucket = bucketMaxs[i];
		}
		return maxGap;
	}

	private static int maximumGapBySort(int[] num) {
		final int arraySize = num.length;
		int[] mockArr = new int[arraySize];
		for (int i = 0; i < arraySize; ++i) {
			mockArr[i] = num[i];
		}

		int ret = 0;
		Arrays.sort(mockArr);
		for (int i = 1; i < arraySize; ++i) {
			int diff = mockArr[i] - mockArr[i - 1];
			if (diff > ret) {
				ret = diff;
			}
		}
		return ret;
	}

	private static void printArray(int[] num) {
		final int arraySize = num.length;
		for (int i = 0; i < arraySize; ++i) {
			System.out.print(String.format("%d  ", num[i]));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		final int testArraySize = 100;
		int[] testNum = new int[testArraySize];
		for (int i = 0; i < testArraySize; ++i) {
			testNum[i] = rnd.nextInt(10000);
		}
		printArray(testNum);

		int maxGapWithSort = maximumGapBySort(testNum);
		System.out.println(String.format("Max gap with sort: %d", maxGapWithSort));

		int maxGap = maximumGap(testNum);
		System.out.println(String.format("Max gap: %d", maxGap));
		return;
	}

}
