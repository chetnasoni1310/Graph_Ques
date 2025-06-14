import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
 public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        /*We will be required 3 things
        1.Queue for further processsings storage
        2. Visited array for checking if they had travesered before or not
        3. Then a result list which will store the traversed values in order 
        
        I will put the node 0 in queue
        then check if it is being visited before or not 
           if yes - then just pop from the queue
           if no  - then 
                         mark it as visited
                         add it to result list 
                         and put its neighbour from the adjacency list to the queue
                         then pop it from queue
                         
                      
         then traverse till all the arrays has been visitd and queue becomes empty 
        */
        
        
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        
        
        //Initialize
        queue.offer(0);
        
        while(! queue.isEmpty())
        {   
            int element = queue.poll();
            if(visited[element] == 0)
            {
               visited[element]=1;
               result.add(element);
               for(int i : adj.get(element))
               {   
                   if (visited[i] == 0)
                   queue.offer(i);
               }
            }
            
        }
        return result;
    }

      public ArrayList<Integer> bfs_(ArrayList<ArrayList<Integer>> adj) {
        // code here
        /* Adjacency list hai toh 
        Visited array bnao 
        Queue bnao 
        Resultant list bnao 
        */
        
         ArrayList<Integer>  result = new ArrayList<>();
         
         int size = adj.size();
         Queue<Integer> queue = new ArrayDeque<>();
         
         int[] visited = new int[size];
         
         queue.add(0);
         visited[0] = 1;
         
         while(! queue.isEmpty())
         {
            int processor = queue.poll();
            for(int element : adj.get(processor))
            {   
                if(visited[element] == 0)
                {
                queue.add(element);
                visited[element] = 1 ;
                }
            }
            result.add(processor);
         }
         
         return result;
    }
}
