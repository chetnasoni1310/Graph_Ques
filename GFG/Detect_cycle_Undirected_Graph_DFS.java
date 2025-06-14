public class Detect_cycle_Undirected_Graph_DFS {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
         adj.add(new ArrayList<>());
          }
          
          
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
      
        int[]visited = new int[V] ;
      
        
         for(int i =0 ;i<V ;i++)
        {
            if(visited[i] != 1)
            {
               if( isCycle_DFS(i , visited , adj , -1) )
               return true;
            }
        }
      return false;
        
     }
       
    private boolean isCycle_DFS(int curr_node , int[]visited ,   List<List<Integer>> adj, int parent )
    { 
        visited[curr_node] =1 ;
        
        for(int neighbour : adj.get(curr_node))
        {
            if(visited[neighbour] != 1)
            {
                visited[neighbour] = 1;
                if(isCycle_DFS(neighbour , visited , adj , curr_node))
                return true;
            }
            else if( neighbour != parent)
            {
                return true;
            }
        }
        return false;
    }
    
    
    
}
