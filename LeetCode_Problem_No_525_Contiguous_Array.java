class Solution 
{
    public int findMaxLength(int[] nums) 
    {
        int sum = 0;
        int maxLen = 0;

        Map<Integer, Integer> sumTracker = new HashMap<>(); // to store `sum` values calculated till a particular index as `key` and their corresponding `index` as value (only first occurance is noted)

        sumTracker.put(0, -1);  //to avoid corner cases where the total length of the array have equal number of 1s and 0s

        for( int i = 0; i < nums.length; i++ )
        {
            sum += ( nums[i] == 0 ) ? 1 : -1; //this line is equivalent to what we're doing in if-else part commented below
            
            /* if( nums[i] == 0 )
                sum++;
            else
                sum--; */

            // Is my current sum seen before (which means that the same number of 1s and 0s exists between them)
            // If so, maxLen = Math.max(maxLen, currentIndex - index of the first time this sum was seen)   
            // Otherwise, it means that it's the first time we're encountering this `sum` value
            // and we'll push that `sum` value as `key` and its `index` as its corresponding `value` to the hashmap

            if( sumTracker.containsKey(sum) )
                maxLen = Math.max(maxLen, i - sumTracker.get(sum));

            else
                sumTracker.put(sum, i);
        }
        return maxLen;
    }
}
