import java.util.ArrayDeque;
import java.util.Queue;

public class _994_Rotten_Oranges
{
     public int orangesRotting(int[][] grid) {
        /*Key Observations :
        1. Jo bhi orange same time/minute pe rot honge  voh humare current orange
           se same level pe rahe honge
        2. Jitne bhi fresh orange h unka count lelo
           agar 0 aaya toh return 0 krdena 
        3. Fir jo rotten oranges hai unko queue mai fill kro with their 
           positions(row , col) and their time , initially it was 0
        4. Fir jb tk queue empty nhi ho jati 
           rotten orange ke aaju-baaju wale fresh oranges ko rotten bnao 
           aur freshcount ko dec-- krdo 
           
        5. At the end if frehcount == 0 return the time 
           else return -1            */

        int m = grid.length;
        int n = grid[0].length;

        int freshCount = 0 ;

        Queue<int[] > queue = new ArrayDeque<>();

        for(int i=0 ; i<m ; i++)
        {
             for(int j =0;j<n ;j++)
             {
                 if(grid[i][j] == 1)
                 {
                   freshCount++ ; 
                 }
                 else if(grid[i][j]==2)
                 {
                    queue.add(new int[]{i , j , 0}) ;
                 }
             }
        }



        if(freshCount == 0)
        {
            return 0;
        }





       int time = 0;  
        while(! queue.isEmpty())
        {  
            int[] currentOrange = queue.poll();
            int row = currentOrange[0];
            int col = currentOrange[1]; 
            time = currentOrange[2]; 
            
            //Check in all directions 

            //UP
            if(row-1>=0 && grid[row-1][col] == 1 )
            {
              grid[row-1][col] = 2;
              freshCount--;
              queue.offer(new int[] { row-1 , col , time+1});
            }

            //DOWN
            if(row+1<m && grid[row+1][col] == 1 )
            {
              grid[row+1][col] = 2;
              freshCount--;
              queue.offer(new int[] { row+1 , col , time+1});
            }


           //RIGHT
            if(col+1<n && grid[row][col+1] == 1 )
            {
              grid[row][col+1] = 2;
              freshCount--;
              queue.offer(new int[] { row , col+1 , time+1});
            }



           //LEFT
            if(col-1>=0 && grid[row][col-1] == 1 )
            {
              grid[row][col-1] = 2;
              freshCount--;
              queue.offer(new int[] { row , col-1 , time+1});
            }



        }
        if(freshCount == 0)
        return time;
        else
        return -1;
    }
}