class Solution 
{
    public List<List<Integer>> finalAns = new ArrayList<>();

    public void helper(int[] nums, int index, List<Integer> combinationsFormedSoFar)
    {
        //base case
        if(index == nums.length)
        {
            finalAns.add(new ArrayList<>(combinationsFormedSoFar));
            return;
        }

        //do not include the current element in our combination
        helper(nums, index + 1, combinationsFormedSoFar);

        //include the current element in our combination
        combinationsFormedSoFar.add(nums[index]);
        helper(nums, index + 1, combinationsFormedSoFar);

        //Removing the last added element to avoid errors specific to the programming language. A kind of Backtracking.
        combinationsFormedSoFar.remove(combinationsFormedSoFar.size() - 1);
        return; // Just to avoid compiler error
    }

    public List<List<Integer>> subsets(int[] nums) 
    {
        helper(nums, 0, new ArrayList<>());
        return finalAns; 
    }
}
