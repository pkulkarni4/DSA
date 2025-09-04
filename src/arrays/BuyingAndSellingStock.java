package arrays;

public class BuyingAndSellingStock {
    public static void main(String[] args) {

        int[] stocks = {200, 500, 1000, 700, 30, 400, 900, 400, 550};
        StockBuying s = new BuyingAndSellingStockOnlyOnce();
        int maxProfit = s.getMaxProfit(stocks);
        System.out.println(maxProfit);

        StockBuying s2 = new BuyingAndSellingStockOnlyTwice();
        int maxProft2 = s2.getMaxProfit(stocks);
        System.out.println(maxProft2);

        StockBuying s3 = new BuyingAndSellingStockUnlimited();
        int maxProfit3 = s3.getMaxProfit(stocks);
        System.out.println(maxProfit3);

        BuyingAndSellingStockKTransactions s4 = new BuyingAndSellingStockKTransactions();
        int maxProfit4 = s4.getMaxProfit(stocks, 3);
        System.out.println(maxProfit4);

         maxProfit4 = s4.getMaxProfit(new int[] {3,3,5,0,0,3,1,4}, 2);
        System.out.println(maxProfit4);
        maxProfit4 = s4.getMaxProfit(new int[] {1,2,3,4,5}, 2);
        System.out.println(maxProfit4);
        maxProfit4 = s4.getMaxProfit(new int[] {7,6,4,3,1}, 2);
        System.out.println(maxProfit4);
    }
}

interface StockBuying {
    int getMaxProfit(int[] arr);
}

/*
Allowed to buy and sell stock only once.
prices={200, 500, 1000, 700, 30, 400, 900, 400, 550}.
 */
class BuyingAndSellingStockOnlyOnce implements StockBuying {
    public int getMaxProfit(int[] arr) {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i : arr) {
            min = Math.min(min, i);
            maxProfit = Math.max(i - min, maxProfit);
        }
        return maxProfit;
    }
}

/*
Allowed to buy and sell stock only twice.
prices={200, 500, 1000, 700, 30, 400, 900, 400, 550}.

// first time, buy at 200 and sell at 1000, profit: 800
// second time, buy at 30 and sell at 900, profit: 870
// total profit is 1670
 */
class BuyingAndSellingStockOnlyTwice implements StockBuying {
    public int getMaxProfit(int[] arr) {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 0;
        int min = arr[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, arr[i]);
            left[i] = Math.max(left[i - 1], arr[i] - min);
        }
        right[len - 1] = 0;
        int max = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = Math.max(right[i + 1], max - arr[i]);
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, left[i] + right[i]);
        }
        return result;
    }
}

class BuyingAndSellingStockUnlimited implements StockBuying {
    @Override
    public int getMaxProfit(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            profit += Math.max(arr[i] - arr[i - 1], 0);
        }
        return profit;
    }
}

class BuyingAndSellingStockKTransactions {

    public int getMaxProfit(int[] arr, int k) {
        int[] temp = new int[k + 1];
        int[] result = new int[k + 1];
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            for (int j = k; j >= 1; j--) {
                temp[j] = Math.max(result[j - 1] + Math.max(diff, 0), temp[j] + diff);
                result[j] = Math.max(temp[j], result[j]);
            }
        }
        return result[k];
    }
}