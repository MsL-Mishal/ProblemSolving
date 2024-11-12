//Topological Sorting

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int indegree[] = new int[numCourses];

        for(int dep[] : prerequisites)
        {
            int node1 = dep[0];
            int node2 = dep[1];
            adj.computeIfAbsent(node2, f -> new ArrayList<>()).add(node1);
            indegree[node1] ++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i ++)
            if(indegree[i] == 0)
                q.add(i);

        int cc = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            cc ++;

            for(int adjNode: adj.computeIfAbsent(node, f -> new ArrayList<>()))
            {
                indegree[adjNode] --;
                if(indegree[adjNode] == 0)
                    q.add(adjNode);
            }
        }

        return cc == numCourses;
    }
}
