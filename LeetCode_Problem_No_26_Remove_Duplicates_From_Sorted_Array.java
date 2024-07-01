class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
        // Two Pointer Approach
        int prev = Integer.MIN_VALUE;
        int traversalPtr = 0;  // Pointer to traverse the entire array.
        int k = 0;  // Pointer to keep track of indexes at correct positions while duplicate elements are pushed towards the rightmost end.

        // Keep in mind that this is a sorted array.
        while( traversalPtr < nums.length )
        {
            int currentElement = nums[traversalPtr];

            // If we have a duplicate element, we won't update `k` value. We'll only update `traversalPtr` value.
            // Else, we'll update `nums[k]` with `currentElement`, increment `k` and set current element as `prev` for the next iteration. We'll also update `traversalPtr` value.
          
            if( currentElement != prev )
            {
                nums[k] = currentElement;
                k++;
                prev = currentElement;
            }
            traversalPtr++;
        }
        return k;  //Now, k will be pointing to the element after which all the elements are duplicates. 
                    // One thing to note is that we're not deleting the duplicate elements, but only returning index till which no duplicates are present after rearranging the matrix
                    // such that all the duplicate elements are pushed towards the end.
    }
}
