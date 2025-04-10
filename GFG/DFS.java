import java.util.ArrayList;

public class DFS {
 ArrayList<Integer> result ;
    boolean[]visited;
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
       result  = new ArrayList<>();
       visited = new boolean[adj.size()];
       
      DFS(adj , 0);
      return result;
    }
    
    private void DFS(ArrayList<ArrayList<Integer>> adj, int node)
    {
       
       /*Jaise hi mai aai 
       First of all mark it as visited 
       Then add it to the result list 
       Then traverse its neighbours only if they are not visited 
       */
       
       visited[node] =true;
       result.add(node);
       
       for(int i : adj.get(node))
       {
           if( ! visited[i])
           {
               DFS(adj , i);
           }
       }
       
    }               
                   
}
