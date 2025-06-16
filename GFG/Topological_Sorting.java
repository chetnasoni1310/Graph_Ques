import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Topological_Sorting {
   public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }
        
        /*Coverting to the adj list 
        Now , 
        stack bnao ek
        traverse krna shuru kro 
        vis mark kro
        jab bhi hum kisi node ko poora traverse kr chuke ho 
        tab usko stack m daal dena 
        */
        
        int[]vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i=0;i<V;i++)
        {
            if(vis[i] == 0)
            {
                dfs(adj , vis , stack , i) ;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        while(! stack.isEmpty())
        {
            result.add(stack.pop());
        }
        return result;
    }
    
    
    private static void dfs(  List<List<Integer>> adj,int[]vis, Stack<Integer> stack ,int node)
    {
        if(vis[node] == 1)
       { 
           return;
       }
        
       vis[node] = 1;
       
       for(int neighbour : adj.get(node))
       {   
           if(vis[neighbour] == 0)
          { 
              dfs(adj , vis ,stack , neighbour);
             
          }
       }
      
       stack.push(node);
    }
}
