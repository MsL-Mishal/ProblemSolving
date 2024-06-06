class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer, Integer> map = new HashMap<>();    //Hashmap to store the `elements` as `key` and their `indices` as `value

        for( int i = 0; i < nums.length; i++ )
        {
            int x = nums[i];
            int y = target - nums[i];  

            if(map.containsKey(y))
                return new int[]{i, map.get(y)};    //returning the pair of indices that constitutes the solution if it exist
                                                    //map.get(y) gives the corresponding `value` of `key` `y`
            
            map.put( x, i );    //inserting map with the number value as `key` and its corresponding index as its `value`
                                //this is done for every new element while iterating the array 
        }

        return new int[]{}; //never comes to this line. It's just to please the java compiler. Otherwise, it'll show some error
    }
}
