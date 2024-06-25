class Solution 
{
    public List<List<Integer>> finalAns = new ArrayList<>();

    public void helper(int[] candidates, int index, int target, List<Integer> combinationsFormedSoFar)
    {
        // Base Cases
       
        // Base Case 1 : If sum of elements equals target
        if(target == 0)
        {
            finalAns.add(new ArrayList<>(combinationsFormedSoFar));
            return;
        }

        // Base Case 2 & 3 : If we reach the end of array or when sum of elemeents exceeds target
        if(index == candidates.length || target < 0)
            return;

        // Do not include current element into our combination
        helper(candidates, index + 1, target, combinationsFormedSoFar);

        // Include current element into our combination
        combinationsFormedSoFar.add(candidates[index]);
        helper(candidates, index, target - candidates[index], combinationsFormedSoFar); // We are not incrementing index here because the same element can be added more than once in this problem

        // Removing the last added element to avoid errors specific to the programming language; A kind of backtracking.
        combinationsFormedSoFar.remove(combinationsFormedSoFar.size() - 1);

        return; // Just to avoid compiler error
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        helper(candidates, 0, target, new ArrayList<>());
        return finalAns;
    }
}
