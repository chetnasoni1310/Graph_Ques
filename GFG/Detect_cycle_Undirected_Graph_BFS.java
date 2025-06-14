import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Detect_cycle_Undirected_Graph_BFS {
 public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        /*USING BFS 
        1. Dekho edges matrix se shuru kro 
           fir viisted mark krna shuru kro 
           fir agar already visited edge pe mai dobara aai aur source alag
           hua toh fir voh cyclic graph mana jaayega
           */
        
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
               if( isCycle_BFS(i , visited , adj) )
               return true;
            }
        }
      return false;
    }
    
    private boolean isCycle_BFS(int curr_node , int[]visited ,   List<List<Integer>> adj )
    {    
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {curr_node , -1 } );  //Vertex with its parent
        visited[curr_node] = 1;
        
        
        while(! queue.isEmpty())
        {   
            int[] vertex = queue.poll();
            int child = vertex[0];
            int parent = vertex[1];
            
            for(int element : adj.get(child))
            {
              if(visited[element] != 1)
              {
                // UN-visited
                visited[element] = 1;
                queue.offer(new int[] {element , child} );
              }
              else if(element != parent)
                  {
                      return true;
                  }
             
             
            }
            
        }
         return false;
    }
}
