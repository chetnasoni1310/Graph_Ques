import java.util.ArrayList;
import java.util.List;

public class Directed_Graph_Cycle_Detection_DFS {
public boolean isCyclic(int V, int[][] edges) {
        // code here
        /* See with DFS 
        
        adj list bnaani hi h 
        
        sabse pehle toh 2 array bnaayenge 
        visited and pathVisited to check ki voh cycle same path se hai ki nahi
        
        fir hum shuru krenge not visited nodes se fir jidhr voh directed h udhr deep mai 
        jaate jayenge fir vis and pathvis ko mark true krenge 
        backtrack krte time pe pathvis ko unmark krdenge
        
        agar voh same node dobara aaya aur vis true h and pathvis false h 
        toh usko hum dobara traverse nhi krenge kyunki uss raaste pe kuch nhi h 
        
        
        */
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add( new ArrayList<>() );
        }
        
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int[]vis = new int[V];
        int[] pathvis = new int[V];
        
        
        
        
      for(int i=0;i<V;i++)
      {
          if(vis[i] == 0)
          {
              if( dfs(adj , vis , pathvis , i ) )
              {
                  return true;
              }
          }
      }
      
      return false;
    }
    
    
    private boolean dfs( List<List<Integer>> adj ,  int[]vis, int[] pathvis ,int node )
    {
    //   FALTU KI SAMASYA
    // if(vis[node] == 1 && pathvis[node] ==0 )
    //   {
    //     return false;   
    //   }
    //   else if(vis[node] == 1 && pathvis[node] ==1)
    //   return true;
       
       
        vis[node]= 1;
        pathvis[node]=1; 
        
        
         //   FALTU KI SAMASYA
    //   if(adj.get(node) ==null)
    //   {  pathvis[node] = 0;
    //     return false;
          
    //   }
        
        for(int neighbour : adj.get(node))
        {
         if(vis[neighbour] == 0)
         {
             if( dfs(adj , vis ,pathvis , neighbour))
             {
                 return true;
             }
         }
         
         else if( pathvis[neighbour] == 1)
         {
            return true;
         }
        }
        
     pathvis[node] = 0;
     return false;   
    }
}
