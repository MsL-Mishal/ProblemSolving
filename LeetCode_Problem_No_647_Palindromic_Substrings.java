class Solution 
{
    public int countSubstrings(String s) 
    {
        int len = s.length();
        int count = 0;
        int i,j;

        // If you want to show calculated palindrome substrings, 
        // make use of StringBuilder variable `ans` by uncommenting appropriate portions

        // StringBuilder ans = new StringBuilder();

        //find the odd length palindrome substrings & append to result, increment `count` value
        for( int mid = 0; mid < len; mid++ )
        {
            i = mid - 1;
            j = mid + 1;

            count++;    //adding each individual characters to `count` value since they itself are palindromes

            // ans.append(s.charAt(mid) + ",");

            while( i >= 0 && j < len && s.charAt(i) == s.charAt(j) )
            {
                count++;
                // ans.append( s.substring( i, j + 1 ) + "," );

                i--;
                j++;
            }
        }

        //find the even length palindrome substrings & append to result, increment `count` value
        for( int mid = 0; mid < len - 1; mid++ )
        {
            i = mid;
            j = mid + 1;

            while( i >= 0 && j < len && s.charAt(i) == s.charAt(j) )
            {
                count++;
                // ans.append( s.substring( i, j + 1) + "," );

                i--;
                j++;
            }
        }
        // System.out.println(ans);

        return count;
    }
}
