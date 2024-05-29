class Solution 
{
    public int removeElement(int[] nums, int val) 
    {
        // Our logic is to push all the occurances of element to be removed towards the rightmost end.
        // Then we'll return the position of rightmost pointer's index + 1 as the length of the resultant array
        // All the elements towards the right of this index will be the element that we wanted to be removed.

        int len = nums.length;
        int i = 0;  // `i` initially points to leftmost end and travels towards right
        int j = len - 1; // `j` initially points to rightmost end and travels towards left
       
        while( i <= j ) // Breaking Condition
        { 
            // If element to be removed is already present towards the right end,
            // just decrement `j` and travel that index backwards
            if ( nums[j] == val )
                j--;

            // If the element to be removed is present towards the left end
            else if ( nums[i] == val )
            {
                // If the element pointed by rightmost pointer is a different value,
                // we need to swap the values pointed by both pointers & traverse inwards
                // from both sides.
                // Otherwise, no swapping is required & we can simply traverse inwards
                // from both sides

                if( nums[j] != val )
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }

                i++;
                j--;
            }         
            
            // If element to be removed is not present at both indexes pointed by respective pointers,
            // just simply traverse the leftward pointer inwards
            else 
                i++;   
        }

        return j + 1;
    }
}
