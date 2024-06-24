class Solution 
{
    // Map to Store values of subproblems already computed
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) 
    {
        //Base Cases
        if(n == 0 || n == 1)
            return 1;
        
        // Check whether the subproblem is already solved. If solved, then just use that value.
        if(cache.containsKey(n))
            return cache.get(n); 

        // Computing the value of the subproblem by calling the methods recursively
        int climbOneStair = climbStairs(n - 1);
        int climbTwoStairs = climbStairs(n - 2);

        int totalWays = climbOneStair + climbTwoStairs;

        // Storing the value of the subproblem that has been computed 
        cache.put(n, totalWays);

        return totalWays; 
    }
}
