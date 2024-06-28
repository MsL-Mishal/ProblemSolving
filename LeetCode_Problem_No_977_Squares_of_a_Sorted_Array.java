class Solution 
{
    public int[] sortedSquares(int[] nums) 
    {
        int n = nums.length;
        int res[] = new int[n];

        int l = 0;  //Leftside Pointer
        int r = n - 1;  //Rightside Pointer

        int index = n - 1;  //Highest Value will be placed from Rightmost End Onwards

        while(l <= r)
        {
            int sqOfLeft = nums[l] * nums[l];   //Negative Numbers with Highest Magnitude will be present from leftmost end
            int sqOfRight = nums[r] * nums[r];  //Positive Numbers with Highest Magnitude will be present from rightmost end

            if( sqOfLeft >= sqOfRight )
            {
                res[index] = sqOfLeft;
                l++;
            }

            else
            {
                res[index] = sqOfRight;
                r--;
            }
            index--;
        }

        return res;
        //Time Complexity => O(N)

        /* 
        // Brute Force Solution 

        for(int i = 0; i < n; i++)
            res[i] = nums[i]*nums[i];   // TC : O(N)

        Arrays.sort(res);   // TC : O(N*logN)

        return res;

        // Time Complexity => O(N) + O(N*logN) ~ O(N*logN)
        */
    }
}
