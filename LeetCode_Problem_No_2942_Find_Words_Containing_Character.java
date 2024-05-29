class Solution 
{
    public List<Integer> findWordsContaining(String[] words, char x) 
    {
        // int [] res = new int[];
        // fixed size => array[]
        // dynamic size => arrayList (in Java), vector (in C++)
        // since, in this case we don't know the size of result initially, we go for arrayList

        List<Integer> result = new ArrayList<>();

        // System.out.println(result.size());

        for( int i = 0; i < words.length; i++ )
        {
            String word = words[i];

            for( char ch : word.toCharArray() ) 
            {
                if( ch == x )
                {
                    result.add(i);
                    break;
                } 
            }
        }
        // System.out.println(result.size());

        return result;
    }
}
