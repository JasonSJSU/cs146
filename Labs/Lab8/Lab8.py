from typing import List

class Lab8:
    # initialize dp array with a number much larger than the max possible amount
    # this represents the minimum number of coins needed to achieve each amount
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)

        #base case checking for 0 coins
        dp[0] = 0 

        # iterate for each coin
        for coin in coins:
            # update the dp array for each amount that can be achieved using the current coin
            for x in range(coin, amount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)

        
        # if dp[amount] is still greater than amount, it means it's not possible to form the amount with given coins
        return dp[amount] if dp[amount] != float('inf') else -1

Lab8 = Lab8()

# test cases
print(Lab8.coinChange([1, 2, 5], 11))
print(Lab8.coinChange([2], 3))
print(Lab8.coinChange([1], 0))
