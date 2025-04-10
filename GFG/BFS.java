import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
 public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        /*We will be required 3 things
        1.Queue for further processsings storage
        2. Visitd array for checking if they had travesered before or not
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
}
