package LeetCode;

public class BestTimeBuySellStock3 {

	private int[] maxForTransaction1(int[] prices) {
		int numOfDays = prices.length;
		int maxProfit = 0;
		int[] ret = new int[numOfDays];
		int low = Integer.MAX_VALUE;
		for (int i = 0; i < numOfDays; ++i) {
			low = Math.min(low, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - low);
			ret[i] = maxProfit;
		}
		return ret;
	}

	private int[] maxForTransaction2(int[] prices) {
		int numOfDays = prices.length;
		int maxProfit = 0;
		int[] ret = new int[numOfDays];
		int high = Integer.MIN_VALUE;
		for (int i = prices.length - 1; i >= 0; --i) {
			high = Math.max(high, prices[i]);
			maxProfit = Math.max(maxProfit, high - prices[i]);
			ret[i] = maxProfit;
		}
		return ret;
	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int[] maxProfit1 = maxForTransaction1(prices);
		int[] maxProfit2 = maxForTransaction2(prices);
		for (int i = 0; i <= prices.length; ++i) {
			int profit1 = i - 1 < 0 ? 0 : maxProfit1[i - 1];
			int profit2 = i >= prices.length ? 0 : maxProfit2[i];
			maxProfit = Math.max(maxProfit, profit1 + profit2);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] tarray = new int[] { 1, 2 };
		BestTimeBuySellStock3 b3 = new BestTimeBuySellStock3();
		b3.maxProfit(tarray);
	}
}