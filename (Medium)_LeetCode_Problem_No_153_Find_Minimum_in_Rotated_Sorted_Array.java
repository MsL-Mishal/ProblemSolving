//Binary Search Approach

class Solution 
{
    public int findMin(int[] nums) 
    {
        int n = nums.length;

        int l = 0;
        int r = n - 1;
        int mid;

        while (l <= r)
        {
            mid = l + (r - l) / 2;

            if(nums[mid] > nums[nums.length - 1])
                l = mid + 1;

            else
                r = mid - 1;
        }  
        return nums[l];
    }
}
