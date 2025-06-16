import java.util.ArrayList;
import java.util.List;

public class Bipartite__DFS {
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
        
        
        for(int i=0 ;i<V ;i++)
        {
           if (colors[i] == -1) {
                if (!DFS(adj, colors, i, 1)) {
                    return false;
                }
            }
        }
      return true;
     }
     
     private boolean DFS(List<List<Integer>> adj , int[]colors ,int node ,int nodeColor)
     {
       colors[node] = nodeColor;
       
       for(int neighbour : adj.get(node))
       {
           if( colors[neighbour] == -1)
           {
               if(nodeColor == 1)
               {
                   return DFS(adj ,colors ,neighbour ,2);
               }
               else
               return DFS(adj ,colors,neighbour,1);
           }
           else if(colors[neighbour]  == nodeColor)
           {
               return false;
           }
       }
       return true;
     }
     
     
}
