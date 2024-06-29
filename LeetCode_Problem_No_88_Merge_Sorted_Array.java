class Solution 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        // Since nums1 consists of 0s after first m positions till the end of the array (which is meant to accomodate all the elements from both arrays),
        // it's ideal to fill in the elements with highest values (after comparison with elements from both arrays) from right to left.
      
        int p = m - 1;  // first index from the right (before 0s) of first array
        int q = n - 1;  // first index from the right of second array
        int r = nums1.length - 1;  // first index from the right of first array

        while(r >= 0) 
        {
            if ( q < 0 )    // nums2 gets exhausted
                break;
            if( p >= 0 && nums1[p] >= nums2[q] )  // when element from first array is comparatively greater than the element from second array and nums1 isn't exhausted  
                nums1[r--] = nums1[p--];
            else
                nums1[r--] = nums2[q--];  // when element from second array is comparatively greater than the element from first array or nums1 is exhausted
        }

        /* Solution Using Extra Space
        
        // int [] combinedArray = new int [m + n];

        // int i = 0;
        // int j = 0;
        // int k = 0;

        // while( (i < m) && (j < n) )
        // {
        //     if( nums1[i] < nums2[j] )
        //     {
        //         combinedArray[k] = nums1[i];
        //         i++;
        //     }

        //     else
        //     {
        //         combinedArray[k] = nums2[j];
        //         j++;
        //     }

        //     k++;
        // }

        // while(i < m)
        // {
        //     combinedArray[k] = nums1[i];
        //     i++;
        //     k++;
        // }

        // while(j < n)
        // {
        //     combinedArray[k] = nums2[j];
        //     j++;
        //     k++;
        // }

        // for(int index = 0; index < (m + n); index++ )
        //     nums1[index] = combinedArray[index];

        */
    }
}
