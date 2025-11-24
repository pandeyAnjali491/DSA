package greedy;

import java.util.*;

public class fractionalKnapsack {

    public static double fracKnapsack(int[] val, int[] wt, int cap) {
        int n = val.length;

        // Create item array: {value, weight, ratio}
        double[][] items = new double[n][3];
        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];
            items[i][1] = wt[i];
            items[i][2] = (double) val[i] / wt[i];
        }

        // Sort by ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));
        double profit = 0;
        int full = 0;
        int i = 0;
        while (i < n && full < cap) {
            if (items[i][1] + full <= cap) {
                profit += items[i][0];
                full += items[i][1];
            } else {
                double frac = (cap - full) / items[i][1];
                profit += items[i][0] * frac;
                full += items[i][1] * frac;
            }
            i++;
        }
        return profit;
    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int cap = 50;
        System.out.println(fracKnapsack(val, wt, cap));
    }
}