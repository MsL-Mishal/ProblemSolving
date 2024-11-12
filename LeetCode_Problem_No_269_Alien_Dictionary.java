class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for(int i = 0; i < words.length; i ++)
        {
            String word = words[i];
            for(char ch: word.toCharArray())
                indegree.putIfAbsent(ch, 0);
        }

        for(int i = 0; i < words.length - 1; i ++)
        {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len1 = word1.length();
            int len2 = word2.length();
            
            boolean flag = false;
            for(int j = 0; j < Math.min(len1, len2); j ++)
            {
                if(word1.charAt(j) == word2.charAt(j))
                    continue;
                
                adj.putIfAbsent(word1.charAt(j), new ArrayList<>());
                adj.get(word1.charAt(j)).add(word2.charAt(j));
                indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1);
                
                flag = true;
                break;
            }

            if(!flag && len1 > len2)
                return "";
        }

        Queue<Character> q = new LinkedList<>(); 
        for(char ch: indegree.keySet())
            if(indegree.get(ch) == 0)
                q.add(ch);

        StringBuilder ans = new StringBuilder();
        int totalChars = indegree.size();

        while(!q.isEmpty())
        {
            char ch = q.poll();
            ans.append(ch);
            for(char nch : adj.getOrDefault(ch, new ArrayList<>()))
            {
                indegree.put(nch, indegree.get(nch) - 1);
                if(indegree.get(nch) == 0)
                    q.add(nch);
            }
        }

        if(ans.length() < totalChars)
            return "";

        return ans.toString();

    }
}
