package Lab8;
import java.util.Arrays;

public class Lab8 {
    public int coinChange(int[] coins, int amount) {
        //initialize dp array with a number much larger than the max possible amount
        //this represents the minimum number of coins needed to achieve each amount
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        //base case checking for 0 coins
        dp[0] = 0;  

        //iterate for each coin
        for (int coin : coins) {
            //update the dp array for each amount that can be achieved using the current coin
            for (int x = coin; x <= amount; x++) {
                dp[x] = Math.min(dp[x], dp[x - coin] + 1);
            }
        }
        //if dp[amount] is still greater than amount, it means it's not possible to form the amount with given coins
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Lab8 solution = new Lab8();

        //test cases
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));
        System.out.println(solution.coinChange(new int[]{1}, 0));
    }
}
