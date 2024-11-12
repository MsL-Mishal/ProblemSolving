class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        int minCoinsDp[][] = new int[n + 1][amount + 1];

        for(int i = 0; i <= n; i ++)
            for(int remAmount = 0; remAmount <= amount; remAmount ++)
            {
                if(remAmount == 0)
                minCoinsDp[i][remAmount] = 0;
                else if(i == 0)
                    minCoinsDp[i][remAmount] = amount + 1; // invalid
                else
                {
                    int dTake = minCoinsDp[i - 1][remAmount];
                    int take = Integer.MAX_VALUE;
                    if(remAmount >= coins[i - 1])
                        take = 1 + minCoinsDp[i][remAmount - coins[i - 1]];
                    minCoinsDp[i][remAmount] = Math.min(take, dTake);
                } 
            }
        
        if(minCoinsDp[n][amount] > amount)
            minCoinsDp[n][amount] = -1;
        return minCoinsDp[n][amount];
    }
}
