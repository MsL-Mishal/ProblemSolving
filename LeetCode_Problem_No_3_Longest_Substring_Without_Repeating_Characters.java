class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int strLen = s.length();

        if( strLen == 0 || strLen == 1 )
            return strLen;

        // We're using `Two Pointer` approach to solve this problem. We're also using a set to store the unique characters that we add while iterating over the string (under some condition)

        /* // Map<Character, Integer> map = new HashMap<>(); */ //Solution using Hashmap. Not optimized yet. But to see the solution, uncomment the block comments and comment the code which uses sets.
        Set<Character> characterSet = new HashSet<>();

        // i & j are pointers which represents the boundaries of current substring
        int i = 0; // left pointer of substring
        int j = 0; // right pointer of substring which will iterate over the entire String
        int maxLen = 0;

        while( j < strLen )
        {
            // If the character is already present in the `characterSet`, it means we're having a repeating character.
            // Then, we'll remove all the elements from the left till the first occurance of that character is removed from the `characterSet` & incrementing left pointer `i` accordingly.
            
            if( characterSet.contains( s.charAt(j) ) )
            {
                characterSet.remove(s.charAt(i));
                i++;
            }

            // If the current character is not in the `characterSet`, it means we have a new unique character.
            // If so, we'll add that character in to the `characterSet` & increment the right pointer `j`
            // and also update the maxLength if necessary.

            else
            {
                characterSet.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen, characterSet.size()); // Since the size of `characterSet` will be equal to the size of the substring that we are computing at this point.
            }

            /* // if( map.containsKey( s.charAt(j) ) )
            // {
            //     maxLen = Math.max(maxLen, len);
            //     i++;
            //     j = i;
            //     len = 0;
            //     map.clear();
            // }

            // else
            // {
            //     map.put(s.charAt(j), len++);
            //     j++;
            // } */
        }
        return Math.max(maxLen, characterSet.size());
    }
}
