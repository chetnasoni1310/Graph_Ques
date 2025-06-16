public class Bipartite_Graph_BFS {
public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        
          int[] colors = new int[V];
        
        for(int i=0 ;i<V ;i++)
        {
            adj.add( new ArrayList<>() );
            colors[i] = -1;
        }
        
        for(int[] edge : edges)
        {
          int u = edge[0];
          int v = edge[1];
          adj.get(u).add(v);
          adj.get(v).add(u); 
        }
        
      
       
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(0);
        colors[0] = 1;
        
        while(! queue.isEmpty())
        {
            int node = queue.poll();
            int color = colors[node];
            
            for(int neighbour : adj.get(node) )
            {
                if(colors[neighbour] == -1)
                {
                   queue.offer(neighbour);
                   
                   if( colors[node] == 1)
                   colors[neighbour] = 0; 
                   else
                   colors[neighbour] = 1; 
                }
                else
                {
                  if(  colors[neighbour] == colors[node] )
                  {
                      return false;
                  }
                }
            }
        }
        return true;
    }
}
